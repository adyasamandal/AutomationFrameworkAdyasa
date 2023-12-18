package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
public LoginPage(WebDriver rdriver){
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
@FindBy(xpath="//div[text()='Delhi']")
@CacheLookup
WebElement cityselect;

@FindBy(xpath="(//*[@class='text-center ng-star-inserted'])")
@CacheLookup
WebElement btnLogindropdown;


@FindBy(xpath="//*[text()='Login']")
@CacheLookup
WebElement btnLogin;

@FindBy(xpath="(//input[@name='identifier'])[1]")
@CacheLookup
WebElement textMobilenum;

@FindBy(xpath="(//*[@name='identifier'])[1]")
@CacheLookup
WebElement txtboxMobileNumber;

@FindBy(xpath="//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']")
@CacheLookup
WebElement btnGetOtp;

@FindBy(xpath="(//input[@type='number'])[1]")
@CacheLookup
WebElement otp1;

@FindBy(xpath="(//input[@type='number'])[2]")
@CacheLookup
WebElement otp2;
@FindBy(xpath="(//input[@type='number'])[3]")
@CacheLookup
WebElement otp3;
@FindBy(xpath="(//input[@type='number'])[4]")
@CacheLookup
WebElement otp4;
@FindBy(xpath="(//input[@type='number'])[5]")
@CacheLookup
WebElement otp5;
@FindBy(xpath="(//input[@type='number'])[6]")
@CacheLookup
WebElement otp6;

@FindBy(xpath="//*[text()=' Find Cars ']")
@CacheLookup
WebElement btnFindCar;








public void Clickcityselect() {
	cityselect.click();
}
	
public void clickbtnLogindropdown() {
	btnLogindropdown.click();
	}

	
public void clickbtnLogin() {
		btnLogin.click();
	}
public void clicktextMobilenum() {
	textMobilenum.click();
}
	
public void settxtboxMobileNumber(String mobile) {
	txtboxMobileNumber.sendKeys(mobile);
}

public void clickbtnGetOtp() {
	btnGetOtp.click();
}
public void setotp1(String f1otp) {
	otp1.sendKeys(f1otp);
}

public void setotp2(String f2otp) {
	otp2.sendKeys(f2otp);
}
public void setotp3(String f3otp) {
	otp3.sendKeys(f3otp);
}
public void setotp4(String f4otp) {
	otp4.sendKeys(f4otp);
}
public void setotp5(String f5otp) {
	otp5.sendKeys(f5otp);
}
public void setotp6(String f6otp) {
	otp6.sendKeys(f6otp);
}


public void clickbtnFIndCar() {
	btnFindCar.click();
}


}

