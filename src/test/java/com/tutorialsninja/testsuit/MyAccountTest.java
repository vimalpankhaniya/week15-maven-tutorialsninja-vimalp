package com.tutorialsninja.testsuit;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccount myAccount;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccount=new MyAccount();
    }


    @Test (groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test  (groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");

        myAccount.enterFirstName("Vimal");
        myAccount.enterLastName("Pankhaniya");
        myAccount.enterEmailAdd("test122@gmail.com");
        myAccount.enterPhone("Prime65");
        myAccount.enterPassword("3656856585");
        myAccount.enterConfirmPass("3656856585");

        myAccount.clickYesonNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();

        Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }

    @Test  (groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");

        myAccount.enterEmailAdd("test123@gmail.com");
        myAccount.enterPassword("London12");


        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        myAccount.clickOnContinueTab();
    }
}


