package com.qa.rediff2019.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.rediff2019.util.Constants;

public class TopMenu {
	
	//  ExtentTest test;
		WebDriver driver;

		@FindBy(xpath = Constants.SIGNOUT_LNK)
		WebElement signOutLnk;
		
		public TopMenu(WebDriver driver){
			this.driver=driver;
			//this.test=test;
		}
		
		public void signOut(){
			
		//	test.log(Status.INFO, "Clicking on SignOut Link-:" +Constants.SIGNOUT_LNK);
			signOutLnk.click();	
		} 

}
