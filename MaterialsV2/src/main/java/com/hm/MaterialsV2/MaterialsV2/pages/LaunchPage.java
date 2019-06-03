package com.hm.MaterialsV2.MaterialsV2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.BasePage.basePage;
import com.hm.MaterialsV2.MaterialsV2.Util.Constants;

public class LaunchPage extends basePage {

	public LaunchPage(WebDriver driver,ExtentTest test)  //constructor 
	{
		super(driver,test);  //call super class drivr instance
	}
	
	public HomePage navigate() 
	{

	driver.get(Constants.URL);
	
	test.log(Status.PASS, "URL opened successfully");    //once the url is opened,logs are stored
	
    HomePage homePage=new HomePage(driver,test);  //obj creation for homepage
    PageFactory.initElements(driver, homePage);  //initializing home page elements
    return homePage;
	}
}
