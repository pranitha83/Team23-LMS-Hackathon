package stepDefinitions_LMS;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.Excel_Reader;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class Login_SD {
	 LoginPage loginpage;
	 TestContextSetup context;
	 SetupDriver setupdriver;
	 Excel_Reader excelreader;
	public Login_SD(TestContextSetup context) {
		this.context=context;
		loginpage = context.getpageobjectmanager().getloginpage();
		setupdriver = context.getsetupdriver();
		excelreader = context.getexcelreader();
	}

	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	    LoggerLoad.info("Launch the browser");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() throws Throwable {
	    setupdriver.openPage(PropertyFileReader.getUrl());
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	    String actualTitle = setupdriver.getTitle();
	    Assert.assertEquals("LMS", actualTitle);
	}
	//open with Invalid Url
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() throws Throwable {
		setupdriver.openPage(PropertyFileReader.getInvalidUrl());
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
	 // WebElement Title = setupdriver.Driver().findElement(By.id("error-information-popup-container"));
	  assert(setupdriver.getTitle().contains("404"));
	   //LoggerLoad.error(Title.getText());
	}
	
	// Checking broken links
	
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
	    loginpage.brokenLnks();
	}
	
	//login
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
	   
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws InterruptedException {
	   loginpage.enterUserNPassword("sdetorganizers@gmail.com", "UIHackathon@02");
	   loginpage.loginBtnClk();
	   Thread.sleep(3000);
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    Assert.assertEquals("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/", SetupDriver.url());
		System.out.println(SetupDriver.url());
	}
//login credentials from excel

	@When("Admin enter valid credentials fromgiven sheetname {string} and rowNumber {int} and clicks login button")
	public void admin_enter_valid_credentials_fromgiven_sheetname_and_row_number_and_clicks_login_button(String string, Integer int1) throws InvalidFormatException, IOException, InterruptedException {
	   
	
	   List<Map<String, String>>Data=excelreader.getData(PropertyFileReader.getexcelfilepath(), "Login");
	System.out.println(Data);
	String userName = Data.get(int1).get("username");
	String passWord = Data.get(int1).get("password");
	
	System.out.println(userName);
	loginpage.enterUserNPassword(userName, passWord);
	loginpage.loginBtnClk();
	Thread.sleep(2000);
	
	}
}
