package com.qa.opencart.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstants;
import com.qa.opencart.utils.ElementUtil;

public class Loginpage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
//	private By locators = page locators
	private By emailId = By.xpath("//input[@name='email']");
	private By pwdId = By.id("input-password");
	private By forgotpwd = By.linkText("Forgotten Password");
	private By loginbtn =By.xpath("//input[@type='submit']");
	private By registerLnk=By.linkText("Register");
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
//	3. page actions
	public String getLoginPageTitle() {
		String title=eleUtil.waitForTitleIs(Appconstants.LONG_PAGE_TITLE, Appconstants.SHORT_TIMEOUT_OUT);
//		String title= driver.getTitle();
		System.out.println("loginPagetitle is"+ title);
		return title;
	}
	
	public String getLoginPageUrl() {
		String url=eleUtil.waitForURLContains(Appconstants.LOGIN_PAGE_URL_FRACTION, Appconstants.SHORT_TIMEOUT_OUT);
		System.out.println("LoginPageUrl is"+ url);
		return url;
		
	}
	public boolean isForgotPasswordlink() {
		
		return eleUtil.waitForElementVisible(forgotpwd,10).isDisplayed();
	}
	public Accountpage doLogin(String userName,String password) {
		eleUtil.waitForElementVisible(emailId,10).sendKeys(userName);
		eleUtil.doSendKeys(pwdId,password);
	
		eleUtil.doClick(loginbtn);
//		Thread.sleep(5000);
//		return eleUtil.waitForTitleIs(Appconstants.ACCOUNT_PAGE_TITLE, Appconstants.MEDIUM_TIMEOUT_OUT);
		return new Accountpage(driver);
	}
	public Registrationpage navigateToRegisterPage() {
		eleUtil.waitForElementVisible(registerLnk, Appconstants.SHORT_TIMEOUT_OUT).click();
		return new Registrationpage(driver);
	}

}
