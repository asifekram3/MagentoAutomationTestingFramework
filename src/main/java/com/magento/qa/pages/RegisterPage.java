package com.magento.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	//objects
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "email_address")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password-confirmation")
	private WebElement passwordConfirmation;
	
	@FindBy(xpath = "//button[@class='action submit primary']")
	private WebElement createAnAccountButton;
	
	@FindBy(xpath = "//a[contains(text(), 'click here')]")
	private WebElement existingEmailAlert;
	
	
	
	
	//constructor
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//actions
	
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	} 
	
	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmation.sendKeys(confirmPasswordText);
	}
	
	public AccountCreatedPage clickOnCreateAnAccountButton() {
		createAnAccountButton.click();
		return new AccountCreatedPage(driver);
	}
	
	public boolean getExisitingEmailWarning() {
		return existingEmailAlert.isDisplayed();
	}
	
	
}
