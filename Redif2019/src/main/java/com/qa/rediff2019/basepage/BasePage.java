package com.qa.rediff2019.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff2019.common.TopMenu;

public class BasePage {
	
	public WebDriver driver;
	public TopMenu menu;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		//this.test = test;
		menu = new TopMenu(driver);
		PageFactory.initElements(driver, menu);
	} 
	
	public TopMenu getMenu() {
		
		return menu;
	}

}
