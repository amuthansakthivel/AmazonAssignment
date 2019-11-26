package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	WebElement lnk_signin;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement lnk_hamburger;
	
	public LoginPage clickSignOnHomePage() {
		
		click(lnk_signin);
		return new LoginPage();
		
	}

	public HamburgerMenuPage clickHamburgerMenu() {
		click(lnk_hamburger);
		return new HamburgerMenuPage();
	}

}
