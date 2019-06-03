package com.hm.MaterialsV2.MaterialsV2.Util;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	    private static ExtentReports extent;   //2 variables declared 
	    public static String screenshotFolderPath;
	    
	    public static ExtentReports getInstance(String reportPath)
	    { 
	      if (extent == null)
	      {
	            String fileName="Report.html";
	            Date d = new Date();
	            String folderName=d.toString().replace(":", "_").replace(" ", "_");
	            
	            new File(reportPath+folderName+"//screenshots").mkdirs(); // directory of the report folder
	            reportPath=reportPath+folderName+"//";
	            screenshotFolderPath=reportPath+"screenshots//";
	      //    System.out.println(reportPath+fileName);
	            
	            createInstance(reportPath+fileName); //calling createInstance method
	      }
	      
	      return extent;
	    }
	    
	    public static ExtentReports createInstance(String fileName)
	    {     //create instance method 
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Reports");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Reports - Automation Testing");
	        
	        extent = new ExtentReports();    //initialize extentreports object after the settings
	        extent.attachReporter(htmlReporter);  //attaches htmlreporter
	       // test.log(Status.INFO, "reports are created with settings defined ");   //can we call extent test here in this clasS?
	        
	        return extent;
	    }
	}

