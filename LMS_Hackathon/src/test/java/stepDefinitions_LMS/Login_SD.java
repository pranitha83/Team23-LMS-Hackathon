package stepDefinitions_LMS;

import org.junit.Assert;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class Login_SD {
	 LoginPage loginpage;
	 TestContextSetup context;
	 SetupDriver setupdriver;
	 
	public Login_SD(TestContextSetup context) {
		this.context=context;
		loginpage = context.getloginpage();
		setupdriver = context.getsetupdriver();
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
	
	//login
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
	   
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
	   loginpage.enterUserNPassword("sdetorganizers@gmail.com", "UIHackathon@02");
	   loginpage.loginBtnClk();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    
	}


}
