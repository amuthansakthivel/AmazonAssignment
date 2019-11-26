package com.amazon.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.amazon.constants.Constants;
import com.amazon.utils.JsonParser;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public WebDriver driver=null;
	public DesiredCapabilities capability;


	private Driver() {

		try {
			String browser=JsonParser.getValue("config.global.browser");

			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVERPATH);
				driver= new FirefoxDriver();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
		try {
			driver.get(JsonParser.getValue("config.global.url"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		DriverManager.setWebDriver(driver);

	}



	public static void initialize() {
		if(DriverManager.getDriver()==null)
			try 
		{
				new Driver();
		}
		catch(Exception e) 
		{

		}

	}

}
