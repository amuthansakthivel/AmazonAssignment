package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuPage extends BasePage {
	
	
	
	@FindBy(xpath="//a/div[contains(text(),'Mobiles, Computers')]")
	WebElement lnk_mobilescomputers;
	
	@FindBy(xpath="//div[contains(text(),'Laptops')]/..")
	WebElement lnk_laptops;
	
	
	
	public HamburgerMenuPage clickOnMobileComputers() {
		click(lnk_mobilescomputers);
		return this;
	}
	
	public LaptopPage clickOnLaptops() {
		click(lnk_laptops);
		return new LaptopPage();
	}

}
