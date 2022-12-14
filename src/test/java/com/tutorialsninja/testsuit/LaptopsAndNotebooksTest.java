package com.tutorialsninja.testsuit;

import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebooks;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    Desktops desktops;
    LaptopAndNotebooks laptopsAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktops= new Desktops();
        laptopsAndNotebooks= new LaptopAndNotebooks();

    }


    @Test (groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully () {

        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }
    @Test (groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully () throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();

        Thread.sleep(2000);
        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), " ");
        laptopsAndNotebooks.clickOnUpdateCart();
        Thread.sleep(2000);
       Assert.assertEquals(laptopsAndNotebooks.getVerifyCartText(), "Success: You have added MacBook to your shopping cart!" +
                "×", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        laptopsAndNotebooks.enterName("Vimal");
        laptopsAndNotebooks.enterLastName("Pankhaniya");
        laptopsAndNotebooks.enterEmail("test123@gmail.com");
        laptopsAndNotebooks.enterTelephone("test134");
        laptopsAndNotebooks.enterAddress("56 HighField");
        laptopsAndNotebooks.enterCity("London");
        laptopsAndNotebooks.enterPostcode("NW9 0PY");
        laptopsAndNotebooks.enterCountry("London");
        laptopsAndNotebooks.enterState("London");

        laptopsAndNotebooks.clickOnCheckout();
        laptopsAndNotebooks.enterText("Please Update Delivery date.");

        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }

    public void changeCurrency() {

    }
}



