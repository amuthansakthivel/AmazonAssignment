package com.amazon.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.browser.Driver;
import com.amazon.browser.DriverManager;
import com.amazon.reports.ExtentReport;



public class BaseTest {
	
	@BeforeMethod
	public void setUp() {
		try {
			Driver.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	@AfterMethod
	public void wrapUp() {
	//	DriverManager.getDriver().close();
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		ExtentReport.initialize();
		
	}

	@AfterSuite
	public void afterSuite() throws Exception {

		ExtentReport.report.flush();
		
		
	}

}
