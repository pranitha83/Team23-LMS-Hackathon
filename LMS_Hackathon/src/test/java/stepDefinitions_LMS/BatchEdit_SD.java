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


    @When("Update the fields with valid values and click save {string} {int}")
    public void update_the_fields_with_valid_values_and_click_save(String string, Integer int1) throws InterruptedException,Exception {
        LoggerLoad.info(this.getClass().getName() + " Entering update_the_fields_with_valid_values_and_click_save Method" );
        List<Map<String, String>> data = excelReader.getData(PropertyFileReader.getexcelfilepath(), string);
        batchpage.editBatchClick(data.get(int1).get("description"),data.get(int1).get("noc"));
    }

    @Then("The updated batch details should appear on the data table {string} {int}")
    public void the_updated_batch_details_should_appear_on_the_data_table(String string, Integer int1) throws Exception{
        LoggerLoad.info(this.getClass().getName() + " Entering the_updated_batch_details_should_appear_on_the_data_table Method" );
        batchpage.editBatchClick();
        batchpage.popUpValidation();
    }

    @When("Update the fields with invalid values and click save")
    public void update_the_fields_with_invalid_values_and_click_save() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering update_the_fields_with_invalid_values_and_click_save Method" );
        batchpage.editBatchClickAndClear();

    }

    @When("Erase data from mandatory field")
    public void erase_data_from_mandatory_field() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering erase_data_from_mandatory_field Method" );
        batchpage.editBatchName();
    }

    @Then("The updated batch details should appear on the data table")
    public void the_updated_batch_details_should_appear_on_the_data_table() {

    }

}
