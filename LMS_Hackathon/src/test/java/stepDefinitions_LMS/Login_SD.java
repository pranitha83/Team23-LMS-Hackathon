package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class Login_SD {
	LoginPage loginpage;
	 TestContextSetup context;
	public Login_SD(TestContextSetup context) {
		this.context=context;
		loginpage = context.loginpage;
	}

	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	    LoggerLoad.info("Launch the browser");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    TestContextSetup.openPage("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com");
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	    
	}
}
