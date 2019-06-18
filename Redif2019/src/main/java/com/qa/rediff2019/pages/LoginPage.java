package com.qa.rediff2019.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff2019.basepage.BasePage;
import com.qa.rediff2019.util.Constants;

public class LoginPage extends BasePage {
	
	
		 @FindBy(xpath=Constants.EMAIL_TXT)
		    public WebElement emailText;
		    
		    @FindBy(xpath=Constants.PASSWORD_TXT)
		    public WebElement passwordText;
		    
		    @FindBy(xpath=Constants.LOGIN_BTN)
		    public WebElement loginBtn;
			
		    
			public LoginPage(WebDriver driver){
				super(driver);

			}
			
			public HomePage signIn(String uname, String pwd){
				
				//test.log(Status.INFO, "Entering Username in Username Text Field-: " +Constants.EMAIL_TXT);
				emailText.sendKeys(uname);
				//test.log(Status.INFO, "Entering Password in Password Text Field-: " +Constants.PASSWORD_TXT);
				passwordText.sendKeys(pwd);
				//test.log(Status.INFO, "Clicking Login Button -: " +Constants.LOGIN_BTN);
				loginBtn.click(); 
				HomePage homePage = new HomePage(driver);
				PageFactory.initElements(driver, homePage);
				return homePage;
			}


}
