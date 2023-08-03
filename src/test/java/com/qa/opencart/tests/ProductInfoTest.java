package com.qa.opencart.tests;

import java.util.Map;


import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
//import com.qa.opencart.utils.ElementUtil;

public class ProductInfoTest extends BaseTest{
	@BeforeClass
	public void prodInfoSetup() {
		accPage=loginPage.doLogin("janautomation@gmail.com", "Selenium@12345");
	}
	@DataProvider
	public Object[][] productTestData() {
		return new Object[][] {
			{"macbook","MacBook Pro"},
		{"macbook","MacBook Air"},
		{"iMac","iMac"},
//		{"samsung","Samsang SyncMaster 941BW"},
	};
	} 
	@Test(dataProvider="productTestData")
	public void productHeaderTest(String searchKey,String productName) {
		searchResPage=accPage.doSearch(searchKey);
		productInfoPage=searchResPage.selectProduct(productName);
		String actProductHeader=productInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeader,productName);
	}
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"macbook","MacBook Pro",4},
		{"macbook","MacBook Air",4},
		{"iMac","iMac",3},
//		{"samsung","Samsang SyncMaster 941BW",1},
	};
	}
	@Test(dataProvider="productData")
	public void productImagesCountTest(String searchKey,String productName,int expProductImagesCount) {
		searchResPage=accPage.doSearch(searchKey);
		productInfoPage=searchResPage.selectProduct(productName);
		int actProductImageCount =productInfoPage.getproductImages();
		Assert.assertEquals(actProductImageCount, expProductImagesCount);
	}
	
	@Test
	public void productInfoTest() {
		searchResPage = accPage.doSearch("macbook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		Map<String, String> productActualData = productInfoPage.getProductData();
		System.out.println(productActualData);
		softAssert.assertEquals(productActualData.get("Brand"), "Apple");
		softAssert.assertEquals(productActualData.get("Availability"), "In Stock");
		softAssert.assertEquals(productActualData.get("productheader"), "MacBook Pro");
		softAssert.assertEquals(productActualData.get("price"), "$2,000.00");
		softAssert.assertEquals(productActualData.get("Reward Points"), "800");
		softAssert.assertAll();
	}
	
}
