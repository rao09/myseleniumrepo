package com.qa.rediff2019.util;

public class Constants {
	
	public static final String SIGNIN_LNK = "//*[@id='sigin_info']/a[1]";
	public static final String EMAIL_TXT = "//input[@name='logid']";
	public static final String PASSWORD_TXT = "//input[@name='pswd']";
	public static final String LOGIN_BTN = "//input[@value='Login' and @type='submit']";
	public static final String SIGNOUT_LNK = "//span[@id='sigin_info']/a";
	public static final String URL = "http://books.rediff.com/";
	 
	public static final String DATA_SHEET = "Data";
	public static final String DATA_PATH = "C:\\Users\\SNBSUK\\Documents\\Book_Sheet.xlsx";
					//System.getProperty("user.dir")+"\\data\\data.xlsx";
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String TCID_COL = "TCID";
	public static final String RUNMODE_COL = "Runmode";
	public static final Object USERNAME_COL = "Username";
	public static final Object PASSWORD_COL = "Password";
	public static final Object BROWSER_COL = "Browser"; 
		 


}
