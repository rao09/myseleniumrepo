package com.qa.rediff2019.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff2019.basepage.BasePage;
import com.qa.rediff2019.util.Constants;

public class LaunchPage extends BasePage{
	
	public LaunchPage(WebDriver driver) {
		
		super(driver);
		
	}
	
 
		public HomePage navigate(){
					
				    driver.get(Constants.URL);
					HomePage homePage = new HomePage(driver);
					PageFactory.initElements(driver, homePage);
					return homePage;
				} 
		 


}
