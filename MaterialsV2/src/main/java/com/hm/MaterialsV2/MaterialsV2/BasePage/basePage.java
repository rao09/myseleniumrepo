package com.hm.MaterialsV2.MaterialsV2.BasePage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.Common.TopMenu;
import com.hm.MaterialsV2.MaterialsV2.Util.ExtentManager;

public class basePage {

	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;    //declaring ref var test of the type ExtentTest
	
	public basePage(WebDriver driver,ExtentTest test) //constructor for basepage, initializing webdriver,topmenu
	{
		this.driver=driver;
		this.test=test;      
		menu=new TopMenu(driver,test);  //whenever we create objects of any page , by default top menu class obj is created
		PageFactory.initElements(driver, menu);
		
	}
	public TopMenu getMenu() {  //method to return menu object
		return menu;
	}
	
	public void verifyTitle(String expectedTitle)
	{
	
	test.log(Status.INFO, "Returning the name of the title");	
	driver.getTitle();
	
	}
	public void Wait(int time)
	{
		try
		{
			Thread.sleep(time*1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void reportFailure(String failureMsg)
    {
        //fail the test
        test.log(Status.FAIL, failureMsg);
        takeScreenShot();
    }

    public void takeScreenShot()
    {
  
  // fileName of the screenshot
  Date d=new Date();
  String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
  // take screenshot
  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  try 
  {
        // get the dynamic folder name
        FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
        //put screenshot file in reports
        test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
  } catch (IOException e)
{
        e.printStackTrace();
  }

}

}

