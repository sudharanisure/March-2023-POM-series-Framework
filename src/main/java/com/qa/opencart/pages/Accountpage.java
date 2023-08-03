package com.qa.opencart.pages;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Appconstants;
import com.qa.opencart.utils.ElementUtil;

public class Accountpage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	public Accountpage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIs(Appconstants.ACCOUNT_PAGE_TITLE, Appconstants.SHORT_TIMEOUT_OUT);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementPresence(logoutLink, Appconstants.MEDIUM_TIMEOUT_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageHeader() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(accHeaders, Appconstants.MEDIUM_TIMEOUT_OUT);
		List<String> headersValueList = new ArrayList<String>();
		for(WebElement e : headersList) {
			String header = e.getText();
			headersValueList.add(header);
		}
		System.out.println("Actual headers are ===> " + headersValueList);
		return headersValueList;
	}
	
	public int getAccountsPageHeaderCount() {
		return eleUtil.waitForElementsVisible(accHeaders, Appconstants.MEDIUM_TIMEOUT_OUT).size();
	}
	
	public SearchResultsPage doSearch(String searchKey) {
		WebElement search1=eleUtil.waitForElementVisible(search, Appconstants.SHORT_TIMEOUT_OUT);
		search1.clear();
		search1.sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);//TDD
	}
}
