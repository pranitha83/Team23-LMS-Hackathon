package stepDefinitions_LMS;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.SetupDriver;
import io.cucumber.java.en.*;
import pageObjects.DeleteUser;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class DeleteUser_SD {

	public WebDriver driver;
	public DeleteUser deleteuser;
	TestContextSetup context;
	Excel_Reader excelreader;

	public DeleteUser_SD(TestContextSetup context) {
		this.context = context;
		deleteuser = context.getpageobjectmanager().getDeleteUser();
		excelreader = context.getexcelreader();
		driver = SetupDriver.Driver();
	}

//	@When("Admin clicks the delete icon")
//	public void admin_clicks_the_delete_icon() {
//		deleteuser.clickDeleteBtn();
//	}

	@Then("Admin should see a alert open with heading Confirm along with YES and NO button for deletion")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion()
			throws InterruptedException {
		Assert.assertEquals(deleteuser.isAlertBoxPresent(), true);
	}

	@When("Admin clicks the delete icon of the user from the given {string} and rownumber {int}")
	public void admin_clicks_the_delete_icon_of_the_user_from_the_given_and_rownumber(String SheetName, Integer RowNum)
			throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "User");
		String fName = testData.get(RowNum).get("FirstName");
		deleteuser.getUserFrmExcel(fName);
	}

	@When("Admin clicks yes option on the alert box")
	public void admin_clicks_yes_option_on_the_alert_box() {
		deleteuser.clickYesOptn();
	}

	@Then("Admin gets a message {string} alert on userpage")
	public void admin_gets_a_message_alert_on_userpage(String msg) throws InterruptedException {
		Assert.assertEquals(deleteuser.verifySucssDelMsg(msg), true);
	}

	@Then("Admin do not see the user from the given {string} and rownumber {int}")
	public void admin_do_not_see_the_user_from_the_given_and_rownumber(String SheetName, Integer RowNum)
			throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "User");
		String fName = testData.get(RowNum).get("FirstName");
		String lName = testData.get(RowNum).get("LastName");
		Assert.assertEquals(deleteuser.chkUsrAftrDeletn(fName, lName), true);
	}

	@When("Admin clicks the delete icon of the user")
	public void admin_clicks_the_delete_icon_of_the_user() {
		deleteuser.clickDeleteBtn();
	}

	@When("Admin clicks No option on the alert box")
	public void admin_clicks_no_option_on_the_alert_box() {
		deleteuser.clickNoOptn();
	}

	@Then("Admin can see the deletion alert disappears without deleting the user")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_the_user() throws InterruptedException {
		Assert.assertEquals(deleteuser.isAlertBoxDisappear(), true);
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		deleteuser.clickClseBtn();
	}

	@Then("Admin can see the deletion alert disappears without any changes in the user")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_in_the_user() throws InterruptedException {
		Assert.assertEquals(deleteuser.isAlertBoxDisappear(), true);
	}

}
