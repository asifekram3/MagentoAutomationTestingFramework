package com.magento.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.magento.qa.utils.Utilities;

public class Base {
	
	public Properties testProp;
	
	public Base() {
		
		testProp = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\magento\\qa\\config\\\\testdata.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(propFile);
			testProp.load(dataFis);
		} catch(Throwable e ) {
			e.printStackTrace();
		}
	}
	
	
	
	WebDriver driver;
	
	public WebDriver initializeBrowserAndOpenUrl(String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))	{
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge"))	{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(testProp.getProperty("url"));
		
		return driver;
	}

}
