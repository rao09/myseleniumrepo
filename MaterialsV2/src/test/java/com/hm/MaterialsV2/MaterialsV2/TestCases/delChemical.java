package com.hm.MaterialsV2.MaterialsV2.TestCases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.BaseTest.baseTest;
import com.hm.MaterialsV2.MaterialsV2.Util.Constants;
import com.hm.MaterialsV2.MaterialsV2.Util.DataUtil;
import com.hm.MaterialsV2.MaterialsV2.pages.ChemicalPage;
import com.hm.MaterialsV2.MaterialsV2.pages.HomePage;
import com.hm.MaterialsV2.MaterialsV2.pages.LaunchPage;

public class delChemical extends baseTest
{
	public String TestCaseName;
	@Test (dataProvider="getData")
	
	public void delChem(Hashtable<String,String>data) throws InterruptedException 
	{
		test=rep.createTest("delChemicalTest");
		
		 if(!DataUtil.isRunnable(TestCaseName,xls)|| data.get(Constants.RUNMODE_COL).equals("N"))
	     {
			 test.log(Status.SKIP, "Skipping "+TestCaseName+ " as runmode is set to NO");
				throw new SkipException("Skipping the test as runmode is N");
	     }
		 
		 test.log(Status.INFO, "Opening browser: ");     //logs the opening browser step
			
		 init(data.get(Constants.BROWSER_COL));			 //opening the browser
		 LaunchPage launchPage=new LaunchPage(driver,test); //object creation for launchpage 
		 PageFactory.initElements(driver, launchPage); 	 //initializing launchpage
			
		 test.log(Status.INFO, "Opening URL");		     //logs of opening url step
		 HomePage homePage=launchPage.navigate();  		 //as navigate() returns homepage ,we are pointing to homepage object
			
		 ChemicalPage chemicalPage=homePage.getMenu().clickChemNamesTab();
			 
		 test.log(Status.INFO, "Verifying the title of the Chemical Page");	
		 chemicalPage.verifyPage(data.get("ExpectedTitle"));
		 
		 test.log(Status.INFO, "Deletion of chemical name");
		 chemicalPage.delChemName(data.get(Constants.CHEMNAME_COL),data.get("ExpectedErrMsg"));
		 
		
	}
	
	
	
	@AfterMethod   
	public void quit()
	{	
		if(rep!=null)    //to generate reports flush method is used
			rep.flush();
	if(driver!=null)
		driver.quit();
	} 
 
	@DataProvider
	public Object[][] getData(Method method)  
	{
		TestCaseName=method.getName();
		System.out.println("TestCaseName");
		return DataUtil.getTestData(TestCaseName,xls);     //getTestData() method returns 2D Obj Array, so return type of getData method is Object[][].
			
	
	
}
}
