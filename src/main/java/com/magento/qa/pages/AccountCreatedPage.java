package com.magento.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Thank you for registering with Main Website Store.')]")
	WebElement accountCreatedSuccessMessage;
	
	//constructor
	public AccountCreatedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String retrieveAccountCreatedSuccessMessage() {
		return accountCreatedSuccessMessage.getText();
	}
	

}
