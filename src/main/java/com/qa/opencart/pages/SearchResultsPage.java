package com.qa.opencart.pages;

import javax.swing.text.Element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstants;
import com.qa.opencart.utils.ElementUtil;


public class SearchResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productResults= By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");
	
	

	public SearchResultsPage(WebDriver driver) {
	this.driver= driver;
	eleUtil=new ElementUtil(driver);
	}
    public int getSearchProductResultsPageCount() {
    	 return eleUtil.waitForElementsVisible(productResults, Appconstants.MEDIUM_TIMEOUT_OUT).size();
    }
    public ProductInfoPage selectProduct(String productName) {
    	eleUtil.clickElementWhenReady(By.linkText(productName),Appconstants.MEDIUM_TIMEOUT_OUT);
    	return new ProductInfoPage(driver);
    }
    
	
}
