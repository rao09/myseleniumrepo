package com.hm.MaterialsV2.MaterialsV2.Util;

import org.openqa.selenium.By;

public class Constants {
//all the locators are stored here
//copy all locator info in this class
	
	public static final String URL= "https://webtest.hermanmiller.com/hmi/materials/com";
	public static final String reportPath = "C:\\Users\\SNBSUK\\Desktop\\Materials\\Reports\\";  //this is the path where reports are generated
	public static final String MAINTENANCE ="//div[@id='bs-navbar-collapse']/ul/li/a[text() = 'Maintenance']";
	public static final String CHEMICALNAMESTAB = "//a[@href='/hmi/materials/com/Chemical']";
	public static final String CHEMICALTITLE = "//div/h1[@class='page-title']";
	public static final String ADDCHEMICALBTN = "//div/a[@href='/hmi/materials/com/Chemical/Add']";
	public static final String CHEMNAMETXT = "//div[@class='modal-content']//input[@id='ChemicalName']";
	
	public static final String REPHARMBTN_YES = "//div[@class='form-group']//div[2]/div[1]/label/span";
	public static final String REPHARMBTN_NO = "//div[@class='form-group']//div[2]/div[2]/label/span";
	
	public static final String CANCERBTN_YES = "//div[@class='form-group']//div[3]/div[1]/label/span";
	public static final String CANCERBTN_NO = "//div[@class='form-group']//div[3]/div[2]/label/span";
	
	public static final String NOTESTXT = "//div[@class='form-group']//div[4]/textarea";
	public static final String SUBMITBTN ="//button[@id='btn-submit']";
	public static final String FINDCHEMNAMETXT ="//table[@id='chemicalTable']/thead/tr[@id='filterrow']/th[1]/input";
	public static final String CHEMTABLE = "//table[@id='chemicalTable']/tbody";
	//public static final String ERROR="//*[@id='errorDialog']//h2";
	public static final String ERRORMSG="//div[@class='modal-dialog modal-lg alert alert-danger']/div/div[2]/div/h3[@id='errorMsg']";
	public static final String ERR_CLOSE="//div[@class='modal-dialog modal-lg alert alert-danger']/div/div[3]/button[@id='btnErrorClose']";
	public static final String ERRMSG2="//div[@class='modal-dialog modal-lg alert alert-danger']/div/div[2]/div/h3[@id='errorMsg']";
	
	public static final String DATAPATH = "C:\\Users\\SNBSUK\\Desktop\\Materials\\MaterialsV2.xlsx";
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String RUNMODE_COL = "Runmode";
	public static final String TCID_COL = "TCID";
	public static final String DATA_SHEET = "DataSheet";
	public static final String BROWSER_COL = "Browser"; 
	public static final String REPHARM_COL="Reproductive Harm";
	public static final String CANCAUSE_COL="Cancer Causing";
	public static final String NOTES_COL="Notes";
	public static final String CHEMNAME_COL="Chemical Name";
	public static final String DELCHEMBTN="//table[@id='chemicalTable']/tbody/tr[1]/td[5]/button[@name='btnRemoveChemical']";
	
	
	}
