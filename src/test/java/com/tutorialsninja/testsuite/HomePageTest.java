package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    Desktop desktop=new Desktop();
    MyAccount myAccount=new MyAccount();
    YourStorePage yourStorePage=new YourStorePage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();


    @Test
    public void verifyUserShouldNavigatetoDesktopSuccessfully() {
        homePage.clickOnDesktopTab();
        homePage.selectMenu("Show All Desktops");
        Assert.assertEquals(homePage.getdesktopText(),"Desktops","Message not displyed");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopAndNotebookPageSuccessfully(){

        homePage.clickOnlatopAndNotesbooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(homePage.getLaptopAndNotebooksText(),"Laptops & Notebooks","Message not displyed");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        homePage.clickOnComponentsTab();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(homePage.getComponentsText(),"Components","Message not displyed");
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        desktop.clickOnDesktop();
        desktop.clickOnShowAllDesktopMenu();
        desktop.verifyProductsArrangedInAlphabeticallyDescendingOrder();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        desktop.selectCurrency();
        desktop.clickOnDesktop();
        desktop.clickOnShowAllDesktopMenu();
        desktop.arrangeProductAtoZ();
        yourStorePage.selectProductHPLP3065();
        Assert.assertEquals(yourStorePage.verifyTextHPLP3065(), "HP LP3065", "HP LP3065 Product not display");
        yourStorePage.selectDeliveryDate();
        //delete qty from qty tab
        WebElement qty = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]"));
        qty.sendKeys(Keys.CONTROL + "a");
        qty.sendKeys(Keys.DELETE);
        yourStorePage.enterQuantity("1");
        yourStorePage.addToCart();
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals(yourStorePage.shoppingCartMessage(), expectedMessage, "Product not added to cart");
        shoppingCartPage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(shoppingCartPage.verifyProductNameHPLP3065(), "HP LP3065", "Product name not matched");
        Assert.assertEquals("Delivery Date: 2022-11-30", shoppingCartPage.verifyDeliveryDate(), "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.verifyProductModel(), "Product 21", "Model not matched");
        Assert.assertEquals(shoppingCartPage.verifyTotal(), "£74.73", "Total not matched");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterFirstname("");
    }
}
