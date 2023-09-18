package com.magento.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//object
	
	@FindBy(xpath = "//ul/li/a[contains(.,'Sign In')]")
	WebElement singInButton;
	
	@FindBy(xpath = "//ul/li/a[contains(.,'Create an Account')]")
	WebElement registerButton;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//action
	
	public RegisterPage navigateToRegisterPage() {
		registerButton.click();
		return new RegisterPage(driver);
	}
	
}
