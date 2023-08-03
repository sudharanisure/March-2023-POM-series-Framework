package com.qa.opencart.tests;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstants;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test
	public void accPageTitleTest() {
		String actAccPageTitle=accPage.getAccPageTitle();
		Assert.assertEquals(actAccPageTitle,Appconstants.ACCOUNT_PAGE_TITLE);
		
	}
	@Test
	public void logoutLinkExist() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test
	public void accPageHeadersCountTest() {
		int accAccPageHeadersCount= accPage.getAccountsPageHeaderCount();
		System.out.println("Actual Acc page header count"+accAccPageHeadersCount);
		Assert.assertEquals(accAccPageHeadersCount, Appconstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	@Test
	public void accPageHeadersList() {
		List<String> accPageHeadersList= accPage.getAccountsPageHeader();
		Assert.assertEquals(accPageHeadersList,Appconstants.EXPECTED_ACC_PAGE_HEADERS_COUNT);
	}
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook",3},
//		{"svmsung",0},
		{"imac",1}
	};
	}
	@Test(dataProvider="getSearchKey")
	public void searchTest(String searchKey, int productCount) {
	
		
		searchResPage  = accPage.doSearch(searchKey);
		int actResultsCount=searchResPage.getSearchProductResultsPageCount();
		Assert.assertEquals(actResultsCount, productCount);
	}
}
