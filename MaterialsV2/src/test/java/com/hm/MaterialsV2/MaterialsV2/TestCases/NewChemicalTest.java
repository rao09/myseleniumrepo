package com.hm.MaterialsV2.MaterialsV2.TestCases;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.SpringLayout.Constraints;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class NewChemicalTest extends baseTest
{
	public String TestCaseName;
	@Test (dataProvider="getData")  //executable part 
	
	public void addNewChemicalTest(Hashtable<String,String> data) 
	{  
		
		test=rep.createTest("AddNewChemicalTest");
		
     if(!DataUtil.isRunnable(TestCaseName,xls)|| data.get(Constants.RUNMODE_COL).equals("N"))
     {
			
			test.log(Status.SKIP, "Skipping "+TestCaseName+ " as runmode is set to NO");
			throw new SkipException("Skipping the test as runmode is N");
		} 
			
				
			            //creating testcase in the report with the name Chemicaltest
			test.log(Status.INFO, "Opening browser: ");     //logs the opening browser step
			
			init(data.get(Constants.BROWSER_COL));			 //opening the browser
			LaunchPage launchPage=new LaunchPage(driver,test); //object creation for launchpage 
			PageFactory.initElements(driver, launchPage); 	 //initializing launchpage
			
			test.log(Status.INFO, "Opening URL");		     //logs of opening url step
			HomePage homePage=launchPage.navigate();  		 //as navigate() returns homepage ,we are pointing to homepage object
			
			ChemicalPage chemicalPage=homePage.getMenu().clickChemNamesTab();    //accessing topmenu options
			
			test.log(Status.INFO, "Verifying the title of the Chemical Page");	
			chemicalPage.verifyPage(data.get("ExpectedTitle"));  //verifying the page title
		
			test.log(Status.INFO, "Adding the new Chemical");	
			chemicalPage.addChemical(data.get(Constants.CHEMNAME_COL), data.get(Constants.NOTES_COL), data.get(Constants.REPHARM_COL), data.get(Constants.CANCAUSE_COL), data.get("ExpectedErrMsg"));		   //adding chemical name (chemname,notes)
			
	
			
//       if(driver.findElement(By.xpath("//input[@id ='username']")).isDisplayed()){
//                        test.log(Status.INFO, "Entering username and password for one login");
//                                  driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("snbsuk");
//                                  driver.findElement(By.xpath("//button[@type='submit']")).click();
//                                  driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("");
//                                 driver.findElement(By.xpath("//button[@type='submit']")).click();
//                                 }
   //     Wait(10);
	}	

		@AfterMethod   
		public void quit()
		{	
			if(rep!=null)    //to generate reports flush method is used
				rep.flush();
//			if(driver!=null)
//				driver.quit();
		} 
	 
		@DataProvider
		public Object[][] getData(Method method)  
		{
			TestCaseName=method.getName();
			System.out.println("TestCaseName");
			return DataUtil.getTestData(TestCaseName,xls);     //getTestData() method returns 2D Obj Array, so return type of getData method is Object[][].
				

		}
}
