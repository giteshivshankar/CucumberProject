package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = { "D:\\Softwares\\Softwares\\workspace2\\cucumberProject\\src\\test\\resources\\features"}
		,glue={"stepDefinition"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {
	
}