package com.hm.MaterialsV2.MaterialsV2.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.Util.Constants;
import com.hm.MaterialsV2.MaterialsV2.Util.ExtentManager;
import com.hm.MaterialsV2.MaterialsV2.Util.Xls_Reader;


public class baseTest 
{
	public WebDriver driver;
	public ExtentReports rep = ExtentManager.getInstance(Constants.reportPath);   //rep is the ref var of the type extentreport;getInstance is a static methd called using its classname ExtentManager
	public ExtentTest test;  //test is the ref var of the type extenttest
	public Xls_Reader xls=new Xls_Reader(Constants.DATAPATH);

	public void init(String bType) {
	
		   if(bType.equals("Mozilla"))
		   {
		       	
	              System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	              System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	              driver = new FirefoxDriver();
	                
	        }
	        else if(bType.equals("Chrome")){
	              System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	              driver = new ChromeDriver();
	        }
	              
	        else if(bType.equals("IE")){
	              System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
	              driver = new InternetExplorerDriver();
	        }
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
	}
	
	public void Wait(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e)
		{
		
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
