package stepDefinitions_LMS;


import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.BatchPage;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;


public class Batch_SD {

    protected static String MANAGE_BATCH = "Manage Batch";

    protected static String BATCH = "/batch";

    protected static String PAGINATION = "Showing 1 to 5 of ";

    TestContextSetup context;
    public WebDriver driver;

    public BatchPage batchpage;

    public Batch_SD(TestContextSetup context) {
        this.context = context;
        batchpage = context.getpageobjectmanager().getbatchpage();
        this.driver = SetupDriver.Driver();
    }

    @Given("Admin is on dashboard page after Login")
    public void admin_is_on_dashboard_page_after_login() {
        LoggerLoad.info(this.getClass().getName()  + " Admin is on dashboard page after Login " );
    }

    @When("Admin clicks Batch from navigation bar")
    public void admin_clicks_batch_from_navigation_bar() {

        batchpage.navigateToBatch();
    }

    @Then("Admin should see the Manage Batch in the URL")
    public void admin_should_see_the_manage_batch_in_the_url() throws Throwable {
        String currentURL = this.driver.getCurrentUrl();
        Assert.assertEquals(PropertyFileReader.getUrl() + BATCH, currentURL);
    }

    @Then("Admin should see the Manage Batch in the header")
    public void admin_should_see_the_manage_batch_in_the_header() {
        Assert.assertTrue(batchpage.getGridTitle().contains(MANAGE_BATCH));
    }

    @Then("Admin should see the pagination controls under the data table")
    public void admin_should_see_the_pagination_controls_under_the_data_table() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(batchpage.getPaginatorTitle().contains(PAGINATION));

    }

    @Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
    public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
        Assert.assertTrue(batchpage.getGridHeaders().contains("Batch Name"));
        Assert.assertTrue(batchpage.getGridHeaders().contains("Batch Description"));
        Assert.assertTrue(batchpage.getGridHeaders().contains("Batch Status"));
        Assert.assertTrue(batchpage.getGridHeaders().contains("No Of Classes"));
        Assert.assertTrue(batchpage.getGridHeaders().contains("Program Name"));
        Assert.assertTrue(batchpage.getGridHeaders().contains("Edit / Delete"));

    }

    @Then("Admin should be able to see the delete icon button that is disabled")
    public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
        try{
            Assert.assertFalse(batchpage.isGlobalDeleteEnabled());
        }catch (Exception e){

        }
    }

    @Then("Admin should be able to see the A New batch button")
    public void admin_should_be_able_to_see_the_a_new_batch_button() {
        Assert.assertEquals("A New Batch", batchpage.getNewLabel());
    }

    @Then("Each row in the data table should have a checkbox")
    public void each_row_in_the_data_table_should_have_a_checkbox() {
        Assert.assertTrue(batchpage.checkBoxStatus());
    }

    @Then("Each row in the data table should have a edit icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
        Assert.assertTrue(batchpage.editIconStatus());
    }

    @When("Admin clicks A New Batch button")
    public void admin_clicks_a_new_batch_button() {
        batchpage.createNewBatch();
    }

    @Then("A new pop up with Batch details appears")
    public void a_new_pop_up_with_batch_details_appears() {
        Assert.assertTrue(batchpage.popUpValidation());
    }



//Navigation to other pages.
@When("Admin clicks on Program link on Manage Batch page")
public void admin_clicks_on_program_link_on_manage_batch_page() {
batchpage.navigateToProgram();
}

@Then("Admin is re-directed to Program page")
public void admin_is_re_directed_to_program_page() {

}

@When("Admin clicks on User link on Manage Batch page")
public void admin_clicks_on_user_link_on_manage_batch_page() {
batchpage.navigateToUser();
}

@Then("Admin is re-directed to User page")
public void admin_is_re_directed_to_user_page() {

}

@When("Admin clicks on logout link on Manage Batch page")
public void admin_clicks_on_logout_link_on_manage_batch_page() {
    batchpage.navigateToLogout();
}

@Then("Admin is re-directed to logout page")
public void admin_is_re_directed_to_logout_page() {

}
}


