package stepDefinition;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.interview.pageObjects.AmazonHomepage;
import com.interview.pageObjects.GoogleSearchPage;
import com.interview.utility.DriverManagement;
import com.interview.utility.TestDataHandling;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefAmazonTest {

	WebDriver driver;
	@Given("^Open chrome browser and launch google site$")
	public void open_chrome_browser_and_launch_google_site(){
	    System.out.println("Chrome browser opened");
	    TestDataHandling data = new TestDataHandling();
	    DriverManagement driverManagement = new DriverManagement();
	    driver=driverManagement.getDriver("chrome", data.getProperty("url"));
	}

	@Given("^search for amazon on google$")
	public void search_for_amazon_on_google(){
		System.out.println("Searched goole for amazon and clicked");
		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		googleSearchPage.searchWithText("Amazon");
		googleSearchPage.clickOnAmazonLink(driver);
	}

	@When("^I enter product on amazon search box$")
	public void i_enter_product_on_amazon_search_box(){
		System.out.println("Entered product name on amazon");
		AmazonHomepage amazonHomepage = new AmazonHomepage(driver);
		amazonHomepage.searchQuery("Laptops");
	}

	@When("^click on search button$")
	public void click_on_search_button(){
		System.out.println("Clicked on search button");
	}

	@Then("^I validate that products are listed$")
	public void i_validate_that_products_are_listed(){
		System.out.println("Product list is displayed");
	}
	
	
	////Scenario outline
	@Given("^I want to write a step with name(\\d+)$")
	public void i_want_to_write_a_step_with_name(int name){
	}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int value){
		System.out.println("Value = "+value);
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step(){
		System.out.println("Success ");
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() {
		System.out.println("Failed ");
	}
	

	@Then("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable arg1) {
		List<List<String>> data = arg1.asLists();
		String user = data.get(0).get(0);
		String pass = data.get(0).get(1);
		System.out.println("Username = "+user+"\nPassword = "+pass);
	}
	
	public void getScreenshot(Scenario scenario) {
		TakesScreenshot ts= (TakesScreenshot) driver;
		scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", "WWWWW");
	}
}
