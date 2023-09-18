package com.magento.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.Base;
import com.magento.qa.utils.Utilities;


public class Login extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenUrl(testProp.getProperty("browserName"));
		driver.findElement(By.xpath("//ul/li/a[contains(.,'Sign In')]")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(priority = 1)
	public void verifyLoinWithValidCredentials() {
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys(testProp.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys(testProp.getProperty("validPassword"));
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\"action switch\"]")).isDisplayed(),"Login Not Successful");

	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidEmail() {
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys(testProp.getProperty("validPassword"));
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();

		String actualWarningText = driver.findElement(By.xpath("//div[contains(text(),\"The account sign-in was incorrect\")]")).getText();
		
		Assert.assertEquals(actualWarningText,"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", "Incorrect Login Message Not Found");
	}

}
