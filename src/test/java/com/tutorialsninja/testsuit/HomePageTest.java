package com.tutorialsninja.testsuit;


import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebooks;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    Desktops desktops;
    LaptopAndNotebooks laptopsAndNotebooks;
    MyAccount myAccount;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktops= new Desktops();
        laptopsAndNotebooks= new LaptopAndNotebooks();
        myAccount = new MyAccount();
    }

    @Test (groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnDesktopLink();
        homePage.selectMenu("Show All Desktops");
        // String expectedMessage = "Desktops";
        Assert.assertEquals(homePage.getVerifyText(), "Desktops", "Error Message not displayed");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.clickOnLaptopNotebooksLink();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(homePage.getVerifyText1(), expectedMessage, "Error Message not displayed");
    }

    @Test (groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.clickOnComponentsLink();
        homePage.selectMenu("Show All Components");
        String expectedMessage = "Components";
        Assert.assertEquals(homePage.getVerifyText2(), expectedMessage, "Error Message not displayed");

    }

}





