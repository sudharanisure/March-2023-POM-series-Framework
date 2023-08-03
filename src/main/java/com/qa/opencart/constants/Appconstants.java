package com.qa.opencart.constants;

import java.util.Arrays;

import java.util.List;

public class Appconstants {
	public static final String LONG_PAGE_TITLE="Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION="route=account/login";
	public static final String ACCOUNT_PAGE_TITLE="My Account";
	
	public static final int ACCOUNT_PAGE_HEADERS_COUNT=4;
	public static final List<String> EXPECTED_ACC_PAGE_HEADERS_COUNT=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
//	/********Default time out value**************/  								My Account, My Orders, My Affiliate Account, Newsletter
	
	public static final int SHORT_TIMEOUT_OUT=5;
	public static final int MEDIUM_TIMEOUT_OUT=10;

	public static final int LONG_TIMEOUT_OUT=15;
	public static final String USER_REGISTER_SUCCESS_MESSG ="Your Account Has Been Created";
	
}

			
