package com.hm.MaterialsV2.MaterialsV2.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hm.MaterialsV2.MaterialsV2.BasePage.basePage;
import com.hm.MaterialsV2.MaterialsV2.Util.Constants;


public class ChemicalPage extends basePage
{
	@FindBy (xpath=Constants.CHEMICALTITLE)
	WebElement chemicalTitle;
	
	@FindBy (xpath=Constants.ADDCHEMICALBTN)
	WebElement addChemicalBtn;
	
	@FindBy (xpath=Constants.CHEMNAMETXT)
	WebElement chemNameTxt;
	
	@FindBy (xpath=Constants.REPHARMBTN_YES)
	WebElement repHarmBtn_YES;
	
	@FindBy (xpath=Constants.CANCERBTN_YES)
	WebElement cancerBtn_YES;
	
	@FindBy (xpath=Constants.REPHARMBTN_NO)
	WebElement repHarmBtn_NO;
	
	@FindBy (xpath=Constants.CANCERBTN_NO)
	WebElement cancerBtn_NO;
	
	@FindBy (xpath=Constants.NOTESTXT)
	WebElement notesTxt;
	
	@FindBy (xpath=Constants.SUBMITBTN)
	WebElement submitBtn;
	
	@FindBy (xpath=Constants.FINDCHEMNAMETXT)
	WebElement findChemNameTxt;
	
	@FindBy (xpath=Constants.CHEMTABLE)
	WebElement chemTable;
	
	@FindBy (xpath=Constants.ERRORMSG)
	WebElement errMsg;
	
	@FindBy (xpath=Constants.ERR_CLOSE)
	WebElement closeErrBtn;
	
	@FindBy (xpath=Constants.DELCHEMBTN)
	WebElement delChemBtn;
	
	@FindBy (xpath=Constants.ERRMSG2)
	WebElement errMsg2;
	
	
	public ChemicalPage(WebDriver driver,ExtentTest test) //constructor for chemical page
	{
		super(driver,test);
	}
	
	public void verifyPage(String expTitle)  // verifying if it is the chemical page 
	{
	        String actTitle = chemicalTitle.getText();
	      
	        if(actTitle.equals(expTitle))
	        {
	             test.log(Status.PASS, "Entered into Chemical Page");
	        } else
	             reportFailure("Not in the Chemical Page");
	        
	}
	public void addChemical(String chemName,String Notes, String repHarm, String canCause, String expErrMsg) 
	{
		 test.log(Status.INFO, "Clicking on Add New Chemical Button");
		 addChemicalBtn.click();  // clicking on add chemical button
		 Wait(5);  //to wait upto new page is loaded
		
		 //enter chemical name
		 test.log(Status.INFO, "Providing name to the Chemical to be added");
		 chemNameTxt.sendKeys(chemName);
		 
		 // selection of Yes/No radio button for RepHarm and CancerCause 
		 if(repHarm.equals("Yes"))
		 {
			 test.log(Status.INFO, "Selecting YES radio button for reproductive harm");
		     repHarmBtn_YES.click();
		 }else 
		 {
			 test.log(Status.INFO, "Selecting NO radio button for reproductive harm");
		     repHarmBtn_NO.click();
		 }
		 
		 if(canCause.equals("Yes")) 
		 {
			 test.log(Status.INFO, "Selecting YES radio button for reproductive harm");
			 cancerBtn_YES.click();
		 }else 
		 {
			 test.log(Status.INFO, "Selecting NO radio button for reproductive harm");
			 cancerBtn_NO.click();
		 }
			 
	     //to enter notes
	     test.log(Status.INFO, "Adding notes");
	     notesTxt.sendKeys(Notes);
	    
	     //to click on submit button
	     test.log(Status.INFO, "clicking on the submit button");
	     submitBtn.click();
	     Wait(5);
	     test.log(Status.INFO, "Validating whether Chemical Name which is added already exist or not");
	     
	    // String expMsg = "Error - The chemical specified already exists.";
	     
	     verifyExistingChemical(expErrMsg);
	     test.log(Status.INFO, "Validating whether Chemical Name added exist in Chemical Table");
	     verifyChemicalAdded(chemName);
	    
	      
	}
	public void verifyExistingChemical(String expMsg) {
		 
			 
			 String actMsg = errMsg.getText();
				 
				 
				 if(actMsg.equals(expMsg)){
					 test.log(Status.INFO, "The chemical cant be added as already exists");
					 reportFailure("The chemical cant be added as already exists");
				 }else
					 test.log(Status.INFO, "The chemical added successfully");
			 
				 
				//Clicking on Close button present in Error dialog box
				 closeErrBtn.click(); 
			 
	}
	
	public void verifyChemicalAdded(String chemName1) {
	
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(findChemNameTxt)).sendKeys(chemName1);
		 //Entering XYZ in the chemical table
		//findChemNameTxt.sendKeys(chemName);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//"arguments[0].click();", maintainanceTab
//		js.executeScript("arguments[0].value='"+chemName+"';", findChemNameTxt);

		
	    Wait(5);
	    
	    //find total tr (rows) in chemical table tbody
	      List<WebElement> totalRows = chemTable.findElements(By.tagName("tr"));
	      int totalRowcnt = totalRows.size();
	      
	      for(int i=1;i<=totalRowcnt; i++)
	      {              
	         String chemNameinRow = driver.findElement(By.xpath("//table[@id='chemicalTable']/tbody/tr["+i+"]/td[1]")).getText();
	            if(chemNameinRow.equals(chemName1))
	            {
	             
	             test.log(Status.PASS, "Chemical table contains the rows having the chemical name =  " + chemName1);
	            
	            }
	            else
	              
	            reportFailure("Chemical table doesn not contain the rows having the chemical name="+ chemName1);
	      }	
		
	}
	
	//test case#2:delChemical
	public void delChemName(String chemName2,String ExpectedErrMsg) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(findChemNameTxt)).sendKeys(chemName2);
		Wait(5);
		 List<WebElement> totalRows = chemTable.findElements(By.tagName("tr"));
		 int totalRowcnt=totalRows.size();
		 for(int i=1;i<=totalRowcnt;i++)
		 {
			
			 String chemNameinRow=driver.findElement(By.xpath("//table[@id='chemicalTable']/tbody/tr["+i+"]/td[1]")).getText();
			 if(chemNameinRow.equals(chemName2))
			 {
				driver.findElement(By.xpath("//table[@id='chemicalTable']/tbody/tr[1]/td[5]/button[@name='btnRemoveChemical']")).click();
				// delChemBtn.click();
				Wait(5);
				verifyDeleteError(ExpectedErrMsg);
				
			 }
			 
			 else
				 
				 test.log(Status.INFO,"Chemical name "+chemName2+"is not present in the chemical table"); 
		 }
	
		 
		 
	}
	
	public void verifyDeleteError(String expMsg) 
	{
		 
		 
		 String actMsg = errMsg2.getText();
		
			 if(actMsg.equals(expMsg)){
				 test.log(Status.PASS, "The chemical name cannot be deleted");
				
			 }else
				 test.log(Status.INFO, "The chemical name deleted successfully");
		 
			 closeErrBtn.click(); 
	}
}
