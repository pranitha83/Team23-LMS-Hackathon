package stepDefinitions_LMS;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.SetupDriver;
import io.cucumber.java.en.*;
import pageObjects.EditUser;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;

public class EditUser_SD {

	public WebDriver driver;
	public EditUser edituser;
	TestContextSetup context;
	Excel_Reader excelreader;

	public EditUser_SD(TestContextSetup context) {
		this.context = context;
		edituser = context.getpageobjectmanager().getEditUserPage();
		excelreader = context.getexcelreader();
		driver = SetupDriver.Driver();
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		edituser.clickEditBtn();
	}

	@When("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
		Assert.assertEquals(edituser.verifyUserDtailsPopUp(), true);
	}

	@When("Update the user that created from the given sheetname {string} and rownumber {int}")
	public void update_the_user_that_created_from_the_given_sheetname_and_rownumber_and_click_submit(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		edituser.getDataFrmExcel(fName);
		edituser.updateFields();

	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String msg) throws InterruptedException {
		Assert.assertEquals(edituser.verifySuccessMsg(msg), true);
	}

	@When("Update the user from the given sheetname {string} and rownumber {int} with invalid values")
	public void update_the_user_from_the_given_sheetname_and_rownumber_with_invalid_values(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		edituser.getDataFrmExcel(fName);
		edituser.updateFieldsWithInvalidValues();
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() throws InterruptedException {
		Assert.assertEquals(edituser.verifyErrMsg(), true);
	}

	@When("Update the mandatory fields of the user from the given sheetname {string} and rownumber {int}")
	public void update_the_mandatory_fields_of_the_user_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		edituser.getDataFrmExcel(fName);
		edituser.updateMandFields();

	}

//	@Then("Admin gets message {String} and see the updated values of mandatory fields")
//	public void admin_gets_message_user_updated_successfully_and_see_the_updated_values_of_mandatory_fields(String msg) throws InterruptedException {
//		Assert.assertEquals(edituser.verifySuccessMsg(msg),true);
//	}
	@Then("Admin gets message {string} in the user manage page")
	public void admin_gets_message_in_the_user_manage_page(String msg) throws InterruptedException {
		Assert.assertEquals(edituser.verifySuccessMsg(msg), true);
	}

	@Then("Admin can see the updated values of user from the given sheetname {string} and rownumber {int}")
	public void admin_can_see_the_updated_values_of_user_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String lName = testData.get(RowNum).get("LastName");
		// String fullname = fName+" "+"Mony";
		Assert.assertEquals(edituser.checkFielsUpdatd(fName, lName), true);
	}

	@When("Update the optional fields of the user from the given sheetname {string} and rownumber {int}")
	public void update_the_optional_fields_of_the_user_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		edituser.getDataFrmExcel(fName);
		edituser.updateOptinalFields();
	}

	@When("Admin gives only numbers or special char in the text fields of the user from given sheetname {string} and rownumber {int}")
	public void admin_gives_only_numbers_or_special_char_in_the_text_fields_of_the_user_from_given_sheetname_and_rownumber(
			String SheetName, Integer RowNum) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		edituser.getDataFrmExcel(fName);
		edituser.updateWithNumAndChars();
	}

	@When("Admin clicks edit button of the user from the given sheetname {string} and rownumber {int}")
	public void admin_clicks_edit_button_of_the_user_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String lName = testData.get(RowNum).get("LastName");
		edituser.getDataFrmExcel(fName);
		// String fullName = fName+" "+lName;
		// edituser.clickEdtBtnOfTheUsr(fullName);
	}

	@When("Admin clicks cancel button")
	public void admin_clicks_cancel_button() throws InterruptedException {
		edituser.clickCancelBtn();
	}

	@Then("Admin can see the User details popup disappears")
	public void admin_can_see_the_user_details_popup_disappears() throws InterruptedException {
		Assert.assertEquals(edituser.verifyNoPopUp(), true);
	}

	@Then("User can see nothing changed for User from the given sheetname {string} and rownumber {int}")
	public void user_can_see_nothing_changed_for_user_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String lName = testData.get(RowNum).get("LastName");
		String locatn = testData.get(RowNum).get("Location");
		String phNum = testData.get(RowNum).get("PhoneNum");
		edituser.getDataFrmExcel(fName);
		Assert.assertEquals(edituser.chkUsrNtChanged(fName, lName, locatn, phNum), true);
	}

}
