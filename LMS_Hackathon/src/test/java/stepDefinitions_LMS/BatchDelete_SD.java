package stepDefinitions_LMS;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverFactory.SetupDriver;
import org.openqa.selenium.WebDriver;
import pageObjects.BatchPage;
import utilities.TestContextSetup;

public class BatchDelete_SD {

    TestContextSetup context;
    public WebDriver driver;

    public BatchPage batchpage;

    public BatchDelete_SD(TestContextSetup context) {
        this.context = context;
        batchpage = context.getpageobjectmanager().getbatchpage();
        this.driver = SetupDriver.Driver();
    }


//    @Given("The delete icon on row level in data table is enabled")
//    public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
//
//
//    }

    @Then("Alert appears with yes and No option")
    public void alert_appears_with_yes_and_no_option() {
        //batchpage.DeleteClick();
        
    }

    @Given("Admin clicks the delete icon")
    public void admin_clicks_the_delete_icon() {

        batchpage.DeleteClick();
    }

    @When("You click yes option")
    public void you_click_yes_option() {
        
        
    }

    @Then("Batch deleted alert pops and batch is no more available in data table")
    public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
        
        
    }

    @When("you click No option")
    public void you_click_no_option() {
        
        
    }

    @Then("Batch is still listed in data table")
    public void batch_is_still_listed_in_data_table() {
        
        
    }

    @Given("None of the checkboxes in data table are selected")
    public void none_of_the_checkboxes_in_data_table_are_selected() {
        
        
    }

    @When("Click delete icon below Manage Batch header")
    public void click_delete_icon_below_manage_batch_header() {
        
        
    }

    @Then("The delete icon under the Manage Batch header should be disabled")
    public void the_delete_icon_under_the_manage_batch_header_should_be_disabled() {
        
        
    }

    @Given("One of the checkbox\\/ row is selected")
    public void one_of_the_checkbox_row_is_selected() {
        
        
    }

    @Then("The respective row in the data table is deleted")
    public void the_respective_row_in_the_data_table_is_deleted() {
        
        
    }

    @Given("Two or more checkboxes\\/row is selected")
    public void two_or_more_checkboxes_row_is_selected() {
        
        
    }
}
