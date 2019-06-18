package com.qa.rediff2019.BaseTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.rediff2019.util.Constants;
import com.qa.rediff2019.util.Xls_Reader;


public class BaseTest {
	
	public WebDriver driver;
	public static Xls_Reader xls = new Xls_Reader(Constants.DATA_PATH);
	
	public void init(String bType) throws Exception{
        
        if(bType.equals("Mozilla")){
       	
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


}
