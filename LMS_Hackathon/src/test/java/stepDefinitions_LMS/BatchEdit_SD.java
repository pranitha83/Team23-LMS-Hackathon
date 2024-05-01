package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BatchPage;
import utilities.TestContextSetup;

public class BatchEdit_SD {


    TestContextSetup context;
    public WebDriver driver;

    public BatchPage batchpage;

    public BatchEdit_SD(TestContextSetup context) {
        this.context = context;
        batchpage = context.getpageobjectmanager().getbatchpage();
        this.driver = SetupDriver.Driver();
    }
    @Given("The edit icon on row level in data table is enabled")
    public void the_edit_icon_on_row_level_in_data_table_is_enabled() {

    }

    @When("Admin clicks the edit icon")
    public void admin_clicks_the_edit_icon() {
        batchpage.searchDNDBatch();


    }

    @When("Update the fields with valid values and click save")
    public void update_the_fields_with_valid_values_and_click_save() throws InterruptedException {
        batchpage.editBatchClick();
    }

    @Then("The updated batch details should appear on the data table")
    public void the_updated_batch_details_should_appear_on_the_data_table() {
        batchpage.popUpDNDValidation();
       
    }

    @When("Update the fields with invalid values and click save")
    public void update_the_fields_with_invalid_values_and_click_save() throws InterruptedException {
        batchpage.editBatchClickAndClear();
       
    }

    @When("Erase data from mandatory field")
    public void erase_data_from_mandatory_field() {
        
       
    }

}
