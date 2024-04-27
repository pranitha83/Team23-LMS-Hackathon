package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import utilities.PropertyFileReader;
import utilities.TestContextSetup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import driverFactory.SetupDriver;


import pageObjects.BatchPage;


public class Batch_SD {

    protected static String MANAGE_BATCH = "Manage Batch";

    protected static String BATCH ="/batch";

    TestContextSetup context;
    SetupDriver setupdriver;


    public WebDriver driver;

    public BatchPage batchpage;

    public Batch_SD(TestContextSetup context) {
        this.context=context;
        batchpage=context.getpageobjectmanager().getbatchpage();
        this.driver=SetupDriver.Driver();
    }

    @Given("Admin is on dashboard page after Login")
    public void admin_is_on_dashboard_page_after_login() {

    }

    @When("Admin clicks Batch from navigation bar")
    public void admin_clicks_batch_from_navigation_bar() {
        batchpage.navigateToBatch();
    }

    @Then("Admin should see the Manage Batch in the URL")
    public void admin_should_see_the_manage_batch_in_the_url() throws Throwable {
        String currentURL = this.driver.getCurrentUrl();
        Assert.assertEquals(PropertyFileReader.getUrl()+BATCH, currentURL);
    }

    @Then("Admin should see the Manage Batch in the header")
    public void admin_should_see_the_manage_batch_in_the_header() {
        String gridTitle = this.batchpage.getGridTitle();
        Assert.assertTrue(gridTitle.contains(MANAGE_BATCH));
    }

    @Then("Admin should see the pagination controls under the data table")
    public void admin_should_see_the_pagination_controls_under_the_data_table() {

    }

    @Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
    public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {

    }

    @Then("Admin should be able to see the delete icon button that is disabled")
    public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
    }

    @Then("Admin should be able to see the A New batch button")
    public void admin_should_be_able_to_see_the_a_new_batch_button() {

    }

    @Then("Each row in the data table should have a checkbox")
    public void each_row_in_the_data_table_should_have_a_checkbox() {

    }

    @Then("Each row in the data table should have a edit icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {

    }

    @When("Admin clicks A New Batch button")
    public void admin_clicks_a_new_batch_button() {

    }

    @Then("A new pop up with Batch details appears")
    public void a_new_pop_up_with_batch_details_appears() {

    }

}
