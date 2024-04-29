package stepDefinitions_LMS;

import org.junit.Assert;
import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class Dashboard_SD {

	DashboardPage dashboardpage;
	TestContextSetup context;
	SetupDriver setupdriver;

	public Dashboard_SD(TestContextSetup context) {
		this.context = context;
		dashboardpage = context.getpageobjectmanager().getdashboardpage();
		setupdriver = context.getsetupdriver();

	}

	@Then("Admin should see manage program as {string} header")
	public void admin_should_see_manage_program_as_header(String header) throws InterruptedException {

		Thread.sleep(3000);
		LoggerLoad.info("Validate admin sees manage program as header");
		String dashboardHeader = dashboardpage.verifyHeaderText();
		Assert.assertEquals(dashboardHeader, header);

	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) throws InterruptedException {
		LoggerLoad.info("Validate navigation time");
		dashboardpage.navigationTime();
	}

	@Then("HTTP response >= {int}. The link is broken")
	public void http_response_the_link_is_broken(Integer int1) throws Throwable {
		LoggerLoad.info("Verify URL Link");
		dashboardpage.verifyLink();
	}

	@Then("Admin should see {string}  as title")
	public void admin_should_see_as_title(String title) {
		LoggerLoad.info("Validate admin sees LMS Title");
		String LMSHeader = dashboardpage.verifyLMSTitle();
		Assert.assertEquals(LMSHeader, title);
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		LoggerLoad.info("Validate LMS Title");
		dashboardpage.lmsTitleAlignment();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		LoggerLoad.info("Validate admin sees correct spellings");
		dashboardpage.navigationBarSpellCheck();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		LoggerLoad.info("Validate LMS Title Spelling and Space");
		dashboardpage.title_SpellcheckAndSpacecheck();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		LoggerLoad.info("Validate navigation bar");
		dashboardpage.lmsNavigationBarValidation();
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		LoggerLoad.info("Validate admin sees program in first place");
		dashboardpage.titleHeadersProgramPosition();
	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		LoggerLoad.info("Validate admin sees batch in second place");
		dashboardpage.titleHeadersBatchPosition();
	}

	@Then("Admin should see user in the 3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		LoggerLoad.info("Validate admin sees user in third place");
		dashboardpage.titleHeadersUserPosition();
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		LoggerLoad.info("Validate admin sees logout in fourth place");
		dashboardpage.titleHeadersLogoutPosition();
	}

	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() throws Throwable {
		LoggerLoad.info("Validate admin is on dashboard page");
		Thread.sleep(2000);
		Assert.assertEquals(PropertyFileReader.getGlobalValue("dashboardurl"), setupdriver.url());
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		LoggerLoad.info("Admin clicks logout button");
		dashboardpage.clickLogout();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() throws Throwable {
		LoggerLoad.info("Validate admin is on login page");
		Assert.assertEquals(PropertyFileReader.getGlobalValue("loginpageurl"), setupdriver.url());
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
		dashboardpage.verifyCoulmnHeaders();
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		dashboardpage.sortIconsValidation();
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		dashboardpage.checkboxesValidation();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		dashboardpage.editDeleteButtonsValidation();
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String search) {
		dashboardpage.validateSearchTextBox(search);
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(
			Integer totalrows) {
		dashboardpage.validateTotalRowsDisplayed(totalrows);
	}

	@Then("Admin should see a {string} button with plus icon on the program page above the data table")
	public void admin_should_see_a_button_with_plus_icon_on_the_program_page_above_the_data_table(
			String newProgramIcon) {
		dashboardpage.validateNewProgramButton(newProgramIcon);
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		dashboardpage.validateMultipleProgramDeleteBtnDisabled();
	}
}
