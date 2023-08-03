package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstants;



public class LoginPageTests extends BaseTest{
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		 Assert.assertEquals(actTitle, Appconstants.LONG_PAGE_TITLE);
		
	}
	@Test (priority=2)
	public void getLoginPageUrl() {
		String actUrl=loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(Appconstants.LOGIN_PAGE_URL_FRACTION));
		
		
	}
	@Test(priority=3)
	public void isForgotPasswordlink() {
		 Assert.assertTrue(loginPage.isForgotPasswordlink());
	}
	@Test(priority=4)
	public void loginTest() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(accPage.isLogoutLinkExist(),true);
	}
}
