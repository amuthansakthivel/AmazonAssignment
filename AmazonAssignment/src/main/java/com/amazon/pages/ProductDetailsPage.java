package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.browser.DriverManager;

public class ProductDetailsPage extends BasePage{
	
	
	@FindBy(xpath="//span[text()='Show More']")
	WebElement lnk_showmore;
	
	@FindBy(id="add-to-cart-button")
	WebElement btn_addtocart;
	
	@FindBy(xpath="//select[@name='quantity']")
	WebElement drpdwn_quantity;
	
	public String productinfo= "//ul[@class='a-unordered-list a-vertical a-spacing-none']//li/span";
	
	
	public ProductDetailsPage readProductInfo() {
		click(lnk_showmore);
		List<WebElement> webelements = DriverManager.getDriver().findElements(By.xpath(productinfo));
		for(int i=0;i<webelements.size();i++) {
			System.out.println(webelements.get(i).getText());
		}
		return this;
	}
	
	public ProductDetailsPage chooseQty(String qty) {
		selectByValue(drpdwn_quantity, qty);
		return this;
		
	}

	public CartPage clickAddToCart() {
		click(btn_addtocart);
		return new CartPage();
	}
	
}
