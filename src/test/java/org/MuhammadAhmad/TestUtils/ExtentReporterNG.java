package org.MuhammadAhmad.TestUtils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNG {
	ExtentReports extent;
	
	@BeforeTest
	public  static ExtentReports getReporterObject()
	{
		//ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Zindigi Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Muhammad Ahmad");
		return extent;
	}

}
