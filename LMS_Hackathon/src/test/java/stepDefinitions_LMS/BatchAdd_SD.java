package stepDefinitions_LMS;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import driverFactory.SetupDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BatchPage;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BatchAdd_SD {


    TestContextSetup context;
    public WebDriver driver;

    public BatchPage batchpage;

    protected Excel_Reader excelReader;

    public BatchAdd_SD(TestContextSetup context) {
        this.context = context;
        batchpage = context.getpageobjectmanager().getbatchpage();
        this.driver = SetupDriver.Driver();
        excelReader = context.getexcelreader();
    }

    @Given("A new pop up with Batch details appears for add")
    public void a_new_pop_up_with_batch_details_appears_for_add() {

    }

    @When("Admin clicks + A New Batch button")
    public void admin_clicks_a_new_batch_button() throws InterruptedException {
        batchpage.addNewBatchClick();
    }

    @Then("The pop up should include the fields Name, Number of classes and Description")
    public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description() {
        Assert.assertTrue(batchpage.popUpValidation());
        
    }

    @When("Fill in all the fields except description with valid values and click save for given {string} and rowNumber {int}")
    public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save_for_given_and_row_number(String string,Integer int1) {
        batchpage.addNewBatchClick();
        List<Map<String, String>> data = null;
        try {
            data = excelReader.getData(PropertyFileReader.getexcelfilepath(), string);
            batchpage.addNewBatch(data.get(int1).get("name"), "",
                    data.get(int1).get("pName"), data.get(int1).get("stats"), data.get(int1).get("noc"));
            batchpage.cancelClick();

        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Error message should appear for description")
    public void error_message_should_appear_for_description() throws InterruptedException {
        Assert.assertEquals("Batch Description is required.", batchpage.validateBatchDescriptionRequired());
    }

    @Then("The newly added batch should be present in the data table {string} in Manage Batch page {int}")
    public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page(String string, Integer int1) {
        List<Map<String, String>> data = null;
        try {
            data = excelReader.getData(PropertyFileReader.getexcelfilepath(), string);
            Assert.assertTrue(batchpage.popUpValidation());

        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    @When("Fill in all the fields with valid values {string} and click save {int}")
    public void fill_in_all_the_fields_with_valid_values_and_click_save(String string, Integer int1) {
        batchpage.addNewBatchClick();
        List<Map<String, String>> data = null;
        try {
            data = excelReader.getData(PropertyFileReader.getexcelfilepath(), string);
            batchpage.addNewBatch(data.get(int1).get("name"), data.get(int1).get("description"),
                    data.get(int1).get("pName"), data.get(int1).get("stats"), data.get(int1).get("noc"));

        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        batchpage.cancelClick();

    }

    @When("Any of the fields have invalid values {string} {int}")
    public void any_of_the_fields_have_invalid_values(String string, Integer int1) {
        batchpage.addNewBatchClick();
        List<Map<String, String>> data = null;
        try {
            data = excelReader.getData(PropertyFileReader.getexcelfilepath(), string);
            batchpage.addNewBatch(data.get(int1).get("name"), data.get(int1).get("description"),
                    data.get(int1).get("pName"), data.get(int1).get("stats"), data.get(int1).get("noc"));
            batchpage.cancelClick();


        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


        
    }

    @Then("Error message should appear")
    public void error_message_should_appear() throws InterruptedException {
        batchpage.addNewBatchClick();
        batchpage.save();
        Assert.assertEquals("Batch Name is required.", batchpage.validateBatchNameRequired());
        Assert.assertEquals("Batch Description is required.", batchpage.validateBatchDescriptionRequired());
        Assert.assertEquals("Program Name is required.", batchpage.validateProgramNameRequired());
        Assert.assertEquals("Status is required.", batchpage.validateStatusRequired());
        Assert.assertEquals("Number of classes is required.", batchpage.validateNoOfClassesRequired());
        batchpage.cancelClick();

    }

    @When("Any of the mandatory fields are blank")
    public void any_of_the_mandatory_fields_are_blank() {
        batchpage.addNewBatchClick();
        batchpage.save();
        Assert.assertEquals("Batch Name is required.", batchpage.validateBatchNameRequired());
        Assert.assertEquals("Batch Description is required.", batchpage.validateBatchDescriptionRequired());
        batchpage.cancelClick();


    }


}
