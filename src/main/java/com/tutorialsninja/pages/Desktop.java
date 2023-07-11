package com.tutorialsninja.pages;


    /*
1.1 Mouse hover on Desktops Tab.and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Mouse hover on Desktops Tab. and click
2.2 Click on “Show All Desktops”
2.3 Select Sort By position "Name: A to Z"
2.4 Select product “HP LP3065”
2.5 Verify the Text "HP LP3065"
2.6 Select Delivery Date "2022-11-30"
2.7.Enter Qty "1” using Select class.
2.8 Click on “Add to Cart” button
2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
2.10 Click on link “shopping cart” display into success message
2.11 Verify the text "Shopping Cart"
2.12 Verify the Product name "HP LP3065"
2.13 Verify the Delivery Date "2022-11-30"
2.14 Verify the Model "Product21"
2.15 Verify the Todat "£74.73"
 */

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktop extends Utility {
        By desktop = By.linkText("Desktops");
        By showallDesktop = By.linkText("Show All Desktops");
        By sortZtoA = By.id("input-sort");
        By products = By.xpath("//h4/a");

        By currencyTab = By.xpath("//span[contains(text(),'Currency')]");
        By currencylist1 = By.xpath("//ul[@class = 'dropdown-menu']/li");





        public void clickOnDesktop() {
            mouseHoverToElement(desktop);

        }

        public void clickOnShowAllDesktopMenu() {
            mouseHoverToElementAndClick(showallDesktop);
        }

        // public void getAllProductsNameAndFilterProductByZtoA() {
        public void selectSortByZToAFromDropDownMenu(String option) {
            selectByVisibleTextFromDropDown(By.id("input-sort"), option);
        }

        public void verifyProductsArrangedInAlphabeticallyDescendingOrder() {

            List<WebElement> products1 = driver.findElements(products);
            ArrayList<String> originalProductsName = new ArrayList<>();
            for (WebElement e : products1) {
                originalProductsName.add(e.getText());
            }
            System.out.println(originalProductsName);
            Collections.reverse(originalProductsName);
            System.out.println(originalProductsName);
            // Select sort by Name Z - A
            selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
            // After filter Z -A Get all the products name and stored into array list
            products1 = driver.findElements(products);
            ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
            for (WebElement e : products1) {
                afterSortByZToAProductsName.add(e.getText());
            }
            System.out.println(afterSortByZToAProductsName);
        }

        public void selectCurrency() {
            clickOnElement(currencyTab);
            List<WebElement> currencyList = driver.findElements(currencylist1);
            for (WebElement e : currencyList) {
                if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                    e.click();
                    break;
                }

            }
        }

        public void arrangeProductAtoZ() {
            List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
            ArrayList<String> originalProductsName = new ArrayList<>();
            for (WebElement e : products) {
                originalProductsName.add(e.getText());
            }
            System.out.println(originalProductsName);
            // Sort By Reverse order
            Collections.sort(originalProductsName);
            System.out.println(originalProductsName);
            // Select sort by Name Z - A
            selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
            // After filter Z -A Get all the products name and stored into array list
            products = driver.findElements(By.xpath("//h4/a"));
            ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
            for (WebElement e : products) {
                afterSortByZToAProductsName.add(e.getText());
            }
            System.out.println(afterSortByZToAProductsName);
            //Assert.assertEquals(originalProductsName, afterSortByZToAProductsName,"Product not sorted into Z to A order");


        }
    }

