package com.qa.rediff2019.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.rediff2019.BaseTest.BaseTest;
import com.qa.rediff2019.pages.HomePage;
import com.qa.rediff2019.pages.LaunchPage;
import com.qa.rediff2019.pages.LoginPage;
import com.qa.rediff2019.util.Constants;
import com.qa.rediff2019.util.DataUtil;

public class LoginTest extends BaseTest {
	 
	public String testCaseName; 
		
	@Test(dataProvider = "getData")
	public void loginTest(Hashtable<String,String> data) throws Exception
	{
			
		//test = rep.createTest("LoginTest");
			
	    if(!DataUtil.isRunnable(testCaseName,xls)|| data.get(Constants.RUNMODE_COL).equals("N"))
	    {
				
			//	test.log(Status.SKIP, "Skipping "+testCaseName+ " as runmode is set to NO");
				throw new SkipException("Skipping the test as runmode is N");
		} 
		
		init(data.get(Constants.BROWSER_COL));
		LaunchPage launchPage = new LaunchPage(driver);
		PageFactory.initElements(driver, launchPage);
		HomePage homePage = launchPage.navigate();
		LoginPage loginPage = homePage.goToLoginPage();
		homePage = loginPage.signIn(data.get(Constants.USERNAME_COL),data.get(Constants.PASSWORD_COL));
		homePage.getMenu().signOut();
		
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(Method method){
		
		testCaseName = method.getName();
		System.out.println(testCaseName);
	    return DataUtil.getTestData(testCaseName,xls);
	
	} 
	
}
