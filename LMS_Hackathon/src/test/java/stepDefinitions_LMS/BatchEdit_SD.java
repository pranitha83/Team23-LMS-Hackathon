package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BatchPage;
import utilities.Excel_Reader;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BatchEdit_SD {


    TestContextSetup context;
    public WebDriver driver;

    public BatchPage batchpage;
    protected Excel_Reader excelReader;


    public BatchEdit_SD(TestContextSetup context) {
        this.context = context;
        batchpage = context.getpageobjectmanager().getbatchpage();
        this.driver = SetupDriver.Driver();
        excelReader = context.getexcelreader();
    }
    @Given("The edit icon on row level in data table is enabled")
    public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
        LoggerLoad.info(this.getClass().getName() + " Entering the_edit_icon_on_row_level_in_data_table_is_enabled Method" );
        Assert.assertTrue(batchpage.editIconStatus());
    }

    @When("Admin clicks the edit icon {string} {int}")
    public void admin_clicks_the_edit_icon(String string, Integer int1) throws Exception{
        LoggerLoad.info(this.getClass().getName() + " Entering admin_clicks_the_edit_icon Method" );
        batchpage.editBatchClick();
    }






    @When("Update the fields with invalid values and click save")
    public void update_the_fields_with_invalid_values_and_click_save() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering update_the_fields_with_invalid_values_and_click_save Method" );
        batchpage.editBatchClickAndClear();

    }

    @When("Erase data from mandatory field")
    public void erase_data_from_mandatory_field() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering erase_data_from_mandatory_field Method" );
        batchpage.editBatchClickAndClear();
    }




    @When("Erase data from mandatory field noc")
    public void erase_data_from_mandatory_field_noc() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering erase_data_from_mandatory_field_noc Method" );

    }

    @Then("Error message should appear edit field")
    public void error_message_should_appear_edit_field() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering erase_data_from_mandatory_field_noc Method" );


    }

    @When("Update the fields with valid values and click save {string} {int}")
    public void update_the_fields_with_valid_values_and_click_save(String string, Integer int1) throws InterruptedException,Exception {
        batchpage.editBatchClickAndClear();
    }
    @Then("Error message should appear edit")
    public void error_message_should_appear_edit() throws InterruptedException {
        Assert.assertEquals("This field should start with an alphabet and min 2 character.", batchpage.validateBatchDescriptionMinRequired());
        batchpage.cancelClick();

    }
    @Then("The updated batch details should appear on the data table {string} {int}")
    public void the_updated_batch_details_should_appear_on_the_data_table(String string, Integer int1) throws Exception{
        LoggerLoad.info(this.getClass().getName() + " Entering the_updated_batch_details_should_appear_on_the_data_table Method" );
        Assert.assertEquals("This field should start with an alphabet and min 2 character.", batchpage.validateBatchDescriptionMinRequired());
        batchpage.cancelClick();
    }

}
