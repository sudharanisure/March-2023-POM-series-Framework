package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.Accountpage;

import com.qa.opencart.pages.Loginpage;
import com.qa.opencart.pages.ProductInfoPage;

import com.qa.opencart.pages.Registrationpage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	protected WebDriver driver;
	protected Properties prop;
	protected Loginpage loginPage;
	protected Accountpage accPage;
	protected SearchResultsPage searchResPage;
	protected ProductInfoPage productInfoPage;
	protected Registrationpage regPage;
	DriverFactory df;
	
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new Loginpage(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}