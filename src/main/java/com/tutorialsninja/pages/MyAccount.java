package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccount extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;

    public void clickOnMyAccount() {
        Reporter.log("clickOnMyAccount" + myAccount.toString());
        clickOnElement(myAccount);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement verifyRegister;

    public String getVerifyRegister() {
        Reporter.log("getVerifyRegister" + verifyRegister.toString());
        return getTextFromElement(verifyRegister);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement verifyReturning;

    public String getVerifyReturning() {
        Reporter.log("getVerifyReturning" + verifyReturning.toString());
        return getTextFromElement(verifyReturning);

    }
    @CacheLookup
            @FindBy(id ="input-firstname" )
            WebElement firstName;
    public void enterFirstName(String name) {
        Reporter.log("enterFirstName" + firstName.toString());
        sendTextToElement(firstName, name);
    }

    @CacheLookup
            @FindBy(id = "input-lastname")
    WebElement lastName;
    public void enterLastName(String lastname) {
        Reporter.log("enterLastName" + lastName.toString());
        sendTextToElement(lastName, lastname);
    }

    By enterEmail = By.id("input-email");

    public void enterEmailAdd(String email) {
        sendTextToElement(enterEmail, email);
    }

    By enterPhone = By.id("input-telephone");

    public void enterPhone(String phone) {
        sendTextToElement(enterPhone, phone);
    }

    By enterPass = By.id("input-password");

    public void enterPassword(String phone) {
        sendTextToElement(enterPass, phone);
    }

    By confirmPass = By.id("input-confirm");

    public void enterConfirmPass(String phone) {
        sendTextToElement(confirmPass, phone);
    }

    By newsLetter = By.xpath("//input[@name='newsletter']");

    public void clickYesonNewsLetter() {
        clickOnElement(newsLetter);
    }

    By privacyPolicy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");

    public void clickOnPrivacy() {
        clickOnElement(privacyPolicy);
    }

    By clickOnContinue = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    public void clickFinalContinue() {
        clickOnElement(clickOnContinue);
    }

    By verifyMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    public String getVerifyMessage() {
        return getTextFromElement(verifyMessage);

    }

    By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    By myAccountTab = By.xpath("//span[contains(text(),'My Account')]");

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }

    By verifyLogout = By.xpath("//h1[contains(text(),'Account Logout')]");

    public String getVerifyLogout() {
        return getTextFromElement(verifyLogout);

    }

    By continueButtonTab = By.xpath("//a[contains(text(),'Continue')]");

    public void clickOnContinueTab() {
        clickOnElement(continueButton);
    }

    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public void clickOnLogin() {
        clickOnElement(loginButton);

    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
}

