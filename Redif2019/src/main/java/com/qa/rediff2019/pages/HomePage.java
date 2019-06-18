package com.qa.rediff2019.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff2019.basepage.BasePage;
import com.qa.rediff2019.util.Constants;



public class HomePage extends BasePage {
			
			@FindBy(xpath = Constants.SIGNIN_LNK)
			public WebElement signInLnk;
			
			
			public HomePage(WebDriver driver){
				super(driver);
				
			}
			
			public LoginPage goToLoginPage(){

				//test.log(Status.INFO, "Clicking on Sign In Link-: " +Constants.SIGNIN_LNK);
				signInLnk.click();
				//test.log(Status.PASS, "Successfully clicked on Sign In Link-: " +Constants.SIGNIN_LNK);
				LoginPage loginPage = new LoginPage(driver);
				PageFactory.initElements(driver, loginPage);
				return loginPage;
			} 
		 


}
