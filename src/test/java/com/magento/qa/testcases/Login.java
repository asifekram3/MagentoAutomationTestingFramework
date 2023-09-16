package com.magento.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void verifyLoinWithValidCredentials() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//ul/li/a[contains(.,'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys("asif.cs123@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("Abcd@1234");
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\"action switch\"]")).isDisplayed(),"Login Not Successful");
		
		driver.quit();
		
	}

}
