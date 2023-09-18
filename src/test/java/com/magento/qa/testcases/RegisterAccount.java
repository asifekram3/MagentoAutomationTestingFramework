package com.magento.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.Base;
import com.magento.qa.pages.AccountCreatedPage;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.RegisterPage;
import com.magento.qa.utils.Utilities;

public class RegisterAccount extends Base{

	RegisterPage registerPage;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenUrl(testProp.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyRegistering() {
		
		registerPage.enterFirstName(testProp.getProperty("firstName"));
		registerPage.enterLastName(testProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterPassword(testProp.getProperty("validPassword"));
		registerPage.enterConfirmPassword(testProp.getProperty("validPassword"));
		
		AccountCreatedPage accountCreatedPage = registerPage.clickOnCreateAnAccountButton();
		
		String accountCreationSuccessMessage = accountCreatedPage.retrieveAccountCreatedSuccessMessage();
		Assert.assertEquals(accountCreationSuccessMessage,testProp.getProperty("actualAccountCreationSuccessMessage"),"Registration Not Successful");
		
	}
	
	@Test(priority = 2)
	public void verifyRegisteringWithExistingEmail() {
		registerPage.enterFirstName(testProp.getProperty("firstName"));
		registerPage.enterLastName(testProp.getProperty("lastName"));
		registerPage.enterEmail(testProp.getProperty("validEmail"));
		registerPage.enterPassword(testProp.getProperty("validPassword"));
		registerPage.enterConfirmPassword(testProp.getProperty("validPassword"));
		registerPage.clickOnCreateAnAccountButton();
		
		Assert.assertTrue(registerPage.getExisitingEmailWarning(), "Existing Email Warning Not Displayed");
	}

}
