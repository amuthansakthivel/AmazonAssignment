package com.amazon.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.browser.DriverManager;
import com.amazon.constants.Constants;
import com.amazon.reports.LogStatus;
import com.amazon.utils.TestUtils;




public class BasePage {
	
	protected BasePage(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	
	public static void click(WebElement element)  {
		explicitlyWait(element);
		element.click();
		LogStatus.pass("Clicking is successfull on "+ element);
		
	}
	
	public static void switchToNewWindow() {
		String parentWinHandle = DriverManager.getDriver().getWindowHandle();
		Set<String> winHandles = DriverManager.getDriver().getWindowHandles();
		for(String temp:winHandles) {
			if(!temp.equalsIgnoreCase(parentWinHandle)) {
				DriverManager.getDriver().switchTo().window(temp);
			}
		}
	}
	
	public static void selectByValue(WebElement element,String text) {
		new Select(element).selectByValue(text);
	}
	
	public static void click(By by)  {
		click(DriverManager.getDriver().findElement(by));
	}


	private static void explicitlyWait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void sendkeys(WebElement element, String text)  {
		element.sendKeys(text);
		LogStatus.pass(text + " is entered in to the "+ element);
	}
	
	public static void sendkeys(By by, String text)  {
		sendkeys(DriverManager.getDriver().findElement(by), text);
	}
	
	public static void moveToElement(WebElement element) {
		Actions actions= new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
	}
	
	public static void moveToElement(By by) {
		moveToElement(DriverManager.getDriver().findElement(by));
	}
	
	
}
