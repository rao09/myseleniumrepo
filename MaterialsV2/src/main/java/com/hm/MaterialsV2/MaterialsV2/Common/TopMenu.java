package com.hm.MaterialsV2.MaterialsV2.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.Util.Constants;
import com.hm.MaterialsV2.MaterialsV2.pages.ChemicalPage;

public class TopMenu {

	public WebDriver driver;
	public ExtentTest test;
	
	@FindBy (xpath=Constants.MAINTENANCE)
	WebElement maintainanceTab;
	
	@FindBy (xpath=Constants.CHEMICALNAMESTAB)
	WebElement chemicalNameTab;
	
	public TopMenu(WebDriver driver,ExtentTest test)  //constructor for topmenu class
	{
		this.driver=driver;
		this.test=test;
	}
	public ChemicalPage clickChemNamesTab() 
	{								//hovering over maintainance and click on chemical names 
		  test.log(Status.INFO, "Hovering over maintainance tab and clicking on ChemicalName link");	
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maintainanceTab);
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chemicalNameTab); 
    	 test.log(Status.INFO, "Successfully clicked on ChemicalName link ");	
    	 ChemicalPage chemicalPage=new ChemicalPage(driver,test);  //creating obj for chemical page, initiazling chem page objects
    	 PageFactory.initElements(driver,chemicalPage);
    	 return chemicalPage;
    	 
     }
}
