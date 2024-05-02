package stepDefinitions_LMS;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.SetupDriver;
import io.cucumber.java.en.*;
import pageObjects.DeleteMultiUsers;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class DeleteMultiUser_SD {

	public WebDriver driver;
	public DeleteMultiUsers dltmultiuser;
	TestContextSetup context;
	Excel_Reader excelreader;

	public DeleteMultiUser_SD(TestContextSetup context) {
		this.context = context;
		dltmultiuser = context.getpageobjectmanager().getDeleteMultiUsers();
		excelreader = context.getexcelreader();
		driver = SetupDriver.Driver();
	}

	@When("Admin clicks any checkbox in the data table of the users")
	public void admin_clicks_any_checkbox_in_the_data_table_of_the_users() {
		dltmultiuser.selectAnyChkBox();
	}

	@Then("Admin should see common delete option enabled under header Manage User")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_user() {
		Assert.assertEquals(dltmultiuser.commonDltOptnEnabld(), true);
	}

	@When("Admin select the check box of the user from the given {string} and rownumber {int}")
	public void admin_select_the_check_box_of_the_user_from_the_given_and_rownumber(String SheetName, Integer RowNum)
			throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		dltmultiuser.getChkBoxOfTheUsrFrmExcl(fName);
	}

	@When("Admin click common delete button of the manage user page")
	public void admin_click_common_delete_button_of_the_manage_user_page() {
		dltmultiuser.clickCmnDltOptn();
	}

	@Then("Admin can see the selected user is deleted from the data table")
	public void admin_can_see_the_selected_user_is_deleted_from_the_data_table()
			throws InterruptedException {
		Assert.assertEquals(dltmultiuser.verifySucssDelMsg(), true);
	}

	@Then("Admin can see the selected user is from the given {string} and rownumber {int} not deleted from the data table")
	public void admin_can_see_the_selected_user_is_from_the_given_and_rownumber_not_deleted_from_the_data_table(
			String SheetName, Integer RowNum) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String lName = testData.get(RowNum).get("LastName");
		Assert.assertEquals(dltmultiuser.chkUsrIsNtDltd(fName, lName), true);
    }
	
	@When("Admin selects the multiple checkboxes on the manage user page")
	public void admin_selects_the_multiple_checkboxes_on_the_manage_user_page() {
		String fname1 = "Raymond";
		String fname2 = "Nike";
	    dltmultiuser.clickMultiChkBoxs(fname1, fname2);
	}

	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() throws InterruptedException {
		Assert.assertEquals(dltmultiuser.verifySucssDelMsg(), true);
	}
	
	@When("Admin selects any multiple checkboxes on the manage user page")
	public void admin_selects_any_multiple_checkboxes_on_the_manage_user_page() {
		dltmultiuser.clikAnyMultiChkBoxs();
	}

	@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_table() {
	   Assert.assertEquals (dltmultiuser.verifyUsrsAreNtDeletd(),true);
	}

}
