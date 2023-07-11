package com.tutorialsninja.testsuite;


import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccount myAccount = new MyAccount();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterFirstname("Hono" + getAlphaNumericString(4));
        myAccount.enterLastname("Lulu" + getAlphaNumericString(4));
        myAccount.enterEmail("Royal" + getAlphaNumericString(4) + "@gmail.com");
        myAccount.enterTelephone("07987654321");
        myAccount.enterPassword("abc123");
        myAccount.enterConfirmPassword("abc123");
        myAccount.selectRadioButton();
        myAccount.clickONPrivacyCheck();
        myAccount.clickOnContineButton();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(myAccount.getRegistrationConfirmMessage(), expectedMessage, "Message not displyed");
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage1 = "Account Logout";

        Assert.assertEquals(myAccount.getLogoutMessage(), expectedMessage1, "Not Logout");


    }

    private String getAlphaNumericString(int i) {
        return null;
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        loginPage.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        loginPage.enterEmail("patel1238@gmail.com");
        loginPage.enterPassword("abc123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getMyAccountText(), "My Account", "Login Not Successfull");
        loginPage.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage1 = "Account Logout";
        Assert.assertEquals(myAccount.getLogoutMessage(), expectedMessage1, "Not Logout");
        loginPage.clickOnContinueButton();
    }
}