package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	WebElement lnk_signin;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement lnk_hamburger;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']/span[1]")
	WebElement label_useraccountname;
	
	private static String username;
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		HomePage.username = username;
	}

	public LoginPage clickSignOnHomePage() {
		
		click(lnk_signin);
		return new LoginPage();
		
	}

	public HamburgerMenuPage clickHamburgerMenu() {
		username=label_useraccountname.getText();
		click(lnk_hamburger);
		return new HamburgerMenuPage();
	}

}
