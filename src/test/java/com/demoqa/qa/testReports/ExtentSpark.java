package com.demoqa.qa.testReports;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Reporter;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoqa.qa.base.BaseClass;
import com.demoqa.qa.utils.Utilities;

public class ExtentSpark extends BaseClass {

	protected ExtentReports report;
	ExtentTest test;
	Utilities util;
	String methodName;

	public ExtentSpark() {
		
		String time = new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new Date());
		util = new Utilities();
		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/extent/SparkReport" + time + ".html");
		spark.config().setTheme(Theme.STANDARD);
		report.attachReporter(spark);

		test = report.createTest("Verify the details displayed in popup",
				"Test to verify the details visible after submitting the form");
		test.assignAuthor("Kishan Loriya");
		test.assignCategory("Sanity");
		
	}
	
	public void testSuccess(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "<i>Result dispalyed in " + methodName + " is as expected</i>");
	}

	public void testFailure(ITestResult result, String expected, String actual) {
			
			methodName = result.getMethod().getMethodName();
			util.takeScreenShot(methodName);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "/screenShot/" + methodName + ".png", "Expected \"" + expected + "\" but found \"" + actual +"\"").build());
		
	}

	public void testSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped");
	}

	public void extentFlush() {
		report.flush();
	}

}
