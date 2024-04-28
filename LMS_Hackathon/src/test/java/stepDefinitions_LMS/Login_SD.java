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
		this.context = context;
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
	// open with Invalid Url

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() throws Throwable {
		setupdriver.openPage(PropertyFileReader.getInvalidUrl());
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
		// WebElement Title =
		// setupdriver.Driver().findElement(By.id("error-information-popup-container"));
		assert (setupdriver.getTitle().contains("404"));
		// LoggerLoad.error(Title.getText());
	}

	// Checking broken links

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		loginpage.brokenLnks();
	}

	// login
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
	public void admin_enter_valid_credentials_fromgiven_sheetname_and_row_number_and_clicks_login_button(String string,
			Integer int1) throws InvalidFormatException, IOException, InterruptedException {

		List<Map<String, String>> Data = excelreader.getData(PropertyFileReader.getexcelfilepath(), "Test");
		System.out.println(Data);
		String userName = Data.get(int1).get("username");
		String passWord = Data.get(int1).get("password");

		System.out.println(userName);
		loginpage.enterUserNPassword(userName, passWord);
		loginpage.loginBtnClk();
		Thread.sleep(2000);

	}

	// Spell check

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		try {
			loginpage.spellCheck();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Checking logo
	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {
		loginpage.checkImageAlignment();
	}

	// Cheking Application Name

	@Then("Admin should see  {string}")
	public void admin_should_see(String string) {
		loginpage.logoText();

	}

	// Company name
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {

	}

//Signin content
	@Then("Admin should see Please login to LMS application")
	public void admin_should_see_please_login_to_lms_application() {
		String Text = loginpage.signinContentText();
		LoggerLoad.info(Text);
		Assert.assertEquals(Text, "Please login to LMS application");
	}

//Text fields
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		int size = loginpage.checkTxtFields();
		LoggerLoad.info("no of text fields are" + "--->" + size);

		Assert.assertEquals(size, 2);

	}

	// user text field

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

//user* symbol
	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

//password text field
	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

//password* symbol
	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
