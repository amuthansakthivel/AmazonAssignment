package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
	
	@FindBy(xpath="//a[contains(text(),'Proceed to Buy')]")
	WebElement btn_proceedtobuy;
	
	public PaymentPage clickProceedToPay() {
		click(btn_proceedtobuy);
		return new PaymentPage();
	}

}
