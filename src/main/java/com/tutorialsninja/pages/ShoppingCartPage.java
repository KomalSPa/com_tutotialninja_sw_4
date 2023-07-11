package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

/*
2.11 Verify the text "Shopping Cart"
2.12 Verify the Product name "HP LP3065"
2.13 Verify the Delivery Date "2022-11-30"
2.14 Verify the Model "Product21"
2.15 Verify the Todat "£74.73
 */
public class ShoppingCartPage extends Utility {
    By shoppingcartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By getShoppingCartMsg = By.xpath("//div[@id='content']//h1");
    By modelProduct21 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By HPLP3065verification = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By total = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]");

    public String verifyProductModel() {
        return getTextFromElement(modelProduct21);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingcartLink);
    }

    public String verifyShoppingCartText() {
        return getTextFromElement(getShoppingCartMsg);
    }

    public String verifyProductNameHPLP3065() {
        return getTextFromElement(HPLP3065verification);
    }

    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDateText);
    }
}