package com.tutorialsninja.pages;

/*
name verifyThatUserShouldLoginAndLogoutSuccessfully()
4.1 Clickr on My Account Link.
4.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Login”
4.3 Enter Email address
4.4 Enter Last Name
4.5 Enter Password
4.6 Click on Login button
4.7 Verify text “My Account”
4.8 Click on My Account Link.
4.9 Call the method “selectMyAccountOptions” method and pass the parameter
“Logout”
4.10 Verify the text “Account Logout”
4.11 Click on Continue button
 */

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By myAccount = By.xpath(" //span[contains(text(),'My Account')]");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = (By.xpath("//form[contains(@action,'login')]//input[@type='submit']"));
    By accountText = By.xpath("//div[@class='col-sm-9']/h2[contains(text(),'My Account')]");
    By myAccountText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton = By.xpath("//div[@class='pull-right']//a");


    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }
    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
    public String getMyAccountLogoutText() {
        return getTextFromElement(myAccountText);
    }
    public String getMyAccountText() {
        return getTextFromElement(accountText);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
