package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By desktop = By.xpath("//a[normalize-space()='Desktops']");
    By laptopsAndNotebooks = By.xpath("//a[text() = 'Laptops & Notebooks']");
    By components = (By.linkText("Components"));
    By tablets = By.xpath("//a[text() = 'Tablets']");
    By software = By.xpath("//a[text() = 'Software']");
    By phonesAndPdas = By.xpath("//a[text() = 'Phones & PDAs']");
    By cameras = By.xpath("//a[text() = 'Cameras']");
    By mp3Players = By.xpath(" //body/div[1]/nav[1]/div[2]/ul[1]/li[8]/a[1]");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }


    public void clickOnDesktopTab() {
        mouseHoverToElementAndClick(desktop);
    }

    public String getdesktopText() {
        return getTextFromElement(desktopText);

    }

    public void clickOnlatopAndNotesbooksTab() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public String getLaptopAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);

    }

    public void clickOnComponentsTab() {
        mouseHoverToElementAndClick(components);
    }

    public String getComponentsText() {
        return getTextFromElement(componentsText);

    }
}