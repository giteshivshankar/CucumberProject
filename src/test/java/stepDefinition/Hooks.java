package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	@Before
	public void setTestEnv() {
		htmlReporter = new ExtentHtmlReporter("/Reports/extentHTMLReport.html");
		report = new ExtentReports();
		test = report.createTest("Reporting...");
	}
	
	@AfterStep
	public void report() {
		System.out.println("------------------");
		test.log(Status.INFO, "Logging");
		test.addScreenCaptureFromPath("/Reports/ScreenshotBasic/screen.png");
	}
	
	@After
	public void end() {
		report.flush();
	}
	
}
