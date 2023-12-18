package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLPPage {
	WebDriver ldriver;
	public PLPPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath="//div[text()='Delhi']")
	@CacheLookup
	WebElement cityselect;
	@FindBy(xpath="//*[text()=' Find Cars ']")
	@CacheLookup
	WebElement btnFindCar;
	
	public void Clickcityselect() {
		cityselect.click();
	}
	public void clickbtnFIndCar() {
		btnFindCar.click();
	}
	
	
	
}
