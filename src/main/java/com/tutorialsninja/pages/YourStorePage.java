package com.tutorialsninja.pages;

/*

2.4 Select product “HP LP3065”
2.5 Verify the Text "HP LP3065"
2.6 Select Delivery Date "2022-11-30"
2.7.Enter Qty "1” using Select class.
2.8 Click on “Add to Cart” button
2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 */


import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourStorePage extends Utility {


    By productHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By HPLP3065productText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By quantity = By.name("quantity");
    By cartButton = By.xpath("//button[@id='button-cart']");
    By shoppingCartMsg = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");


    public void selectProductHPLP3065() {
        clickOnElement(productHPLP3065);
    }

    public String verifyTextHPLP3065() {

        return getTextFromElement(HPLP3065productText);

    }


    public void selectDeliveryDate() {
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {

                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
                break;
            } else
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
        }


        //Select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']//td"));
        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equalsIgnoreCase(date)) {
                ele.click();
                break;


            }

        }
    }


    public void enterQuantity(String qty) {
        sendTextToElement(quantity, qty);
    }

    public void addToCart() {
        clickOnElement(cartButton);
    }

    public String shoppingCartMessage() {
        return getTextFromElement(shoppingCartMsg);
    }


}