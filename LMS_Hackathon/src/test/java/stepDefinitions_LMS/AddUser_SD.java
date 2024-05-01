package stepDefinitions_LMS;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.AddUser;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;
//import org.testng.Assert;

import driverFactory.SetupDriver;

public class AddUser_SD {

	public WebDriver driver;
	public AddUser usermodule;
	TestContextSetup context;
	Excel_Reader excelreader;

	public AddUser_SD(TestContextSetup context) {
		this.context = context;
		usermodule = context.getpageobjectmanager().getUserpage();
		excelreader = context.getexcelreader();
		driver = SetupDriver.Driver();
	}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		SetupDriver.Driver().get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com");
		usermodule.clickUser();
	}

	@When("Admin clicks + A New User button")
	public void admin_clicks_a_new_user_button() {
		usermodule.clickAddUser();
	}

	@Then("Admin should see pop up window for user details")
	public void admin_should_see_pop_up_window_for_user_details() {
		Assert.assertEquals(usermodule.verifyPopupWindowWithUsrDetails(), true);
	}

	@Then("Admin should see text boxes for the fields")
	public void admin_should_see_text_boxes_for_the_fields() throws InterruptedException {
		Assert.assertEquals(usermodule.isTextBoxesDisplayed(), true);
	}

	@Then("Admin should see drop downs for the fields User Role, Role status, Visa status")
	public void admin_should_see_drop_downs_for_the_fields_user_role_role_status_visa_status() {
		Assert.assertEquals(usermodule.isDropdownsDisplayed(), true);
	}

	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {

	}

	@When("Admin fills mandatory fields in the form from the given sheetname {string} and rownumber {int}")
	public void admin_fills_mandatory_fields_in_the_form_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws IOException, InvalidFormatException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String mName = testData.get(RowNum).get("MiddleName");
		String lName = testData.get(RowNum).get("LastName");
		String locatn = testData.get(RowNum).get("Location");
		String phNum = testData.get(RowNum).get("PhoneNum");
		String linkdUrl = testData.get(RowNum).get("LinkedUrl");
		String usrRol = testData.get(RowNum).get("UserRole");
		String rolStats = testData.get(RowNum).get("RoleStatus");
		String visaStats = testData.get(RowNum).get("VisaStatus");
		String emailadress = testData.get(RowNum).get("Email");
		String undrGrad = testData.get(RowNum).get("UnderGrad");
		String postGrad = testData.get(RowNum).get("PostGrad");
		String timeZne = testData.get(RowNum).get("TimeZone");
		String usrComnts = testData.get(RowNum).get("UserComments");
		usermodule.fillUserDetails(fName, mName, lName, locatn, phNum, linkdUrl, usrRol, rolStats, visaStats, undrGrad,
				emailadress, postGrad, timeZne, usrComnts);

		// usermodule.fillMandFieldsOnly();

	}

	@When("Admin clicks submit")
	public void admin_clicks_submit() {
		usermodule.clickSubmit();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String expectdMsg) {
		Assert.assertEquals(usermodule.verifyMsg(expectdMsg), true);
	}

	@When("Admin fills optional fields in the form from the given sheetname {string} and rownumber {int}")
	public void admin_fills_optional_fields_in_the_form_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws IOException, InvalidFormatException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String mName = testData.get(RowNum).get("MiddleName");
		String linkdUrl = testData.get(RowNum).get("LinkedUrl");
		String emailadress = testData.get(RowNum).get("Email");
		String undrGrad = testData.get(RowNum).get("UnderGrad");
		String postGrad = testData.get(RowNum).get("PostGrad");
		String timeZne = testData.get(RowNum).get("TimeZone");
		String usrComnts = testData.get(RowNum).get("UserComments");
		usermodule.fillOptionalFields(mName, linkdUrl, emailadress, undrGrad, postGrad, timeZne, usrComnts);

	}

	@Then("Admin should see error message below the mandatory fields and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_mandatory_fields_and_the_field_will_be_highlighed_in_red_color()
			throws InterruptedException {
		Assert.assertEquals(usermodule.verifyErrMsgInMandFields(), true);
		Assert.assertEquals(usermodule.verifyTextColor(), true);
	}

	@When("Admin fills invalid data in all of the fields from the given sheetname {string} and rownumber {int}")
	public void admin_fills_invalid_data_in_all_of_the_fields_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws IOException, InvalidFormatException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String mName = testData.get(RowNum).get("MiddleName");
		String lName = testData.get(RowNum).get("LastName");
		String locatn = testData.get(RowNum).get("Location");
		String phNum = testData.get(RowNum).get("PhoneNum");
		String linkdUrl = testData.get(RowNum).get("LinkedUrl");
		String emailadress = testData.get(RowNum).get("Email");
		String undrGrad = testData.get(RowNum).get("UnderGrad");
		String postGrad = testData.get(RowNum).get("PostGrad");
		String timeZne = testData.get(RowNum).get("TimeZone");
		String usrComnts = testData.get(RowNum).get("UserComments");
		usermodule.fillInvalidDatasInAllFields(fName, mName, lName, locatn, phNum, linkdUrl, undrGrad, postGrad,
				emailadress, timeZne, usrComnts);
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
		usermodule.verifyErrMsg();
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
		usermodule.clickSubmit();
	}

	@Then("user will not be created and Admin gets error message below all the fields")
	public void user_will_not_be_created_and_admin_gets_error_message_below_all_the_fields()
			throws InterruptedException {
		Assert.assertEquals(usermodule.verifyErrMsgsInAllFields(), true);
	}

	@When("Admin clicks Cancel Icon on User Details form")
	public void admin_clicks_cancel_icon_on_user_details_form() {
		usermodule.clickCancel();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() throws InterruptedException {
		Assert.assertEquals(usermodule.verifyPopUpWindowClosed(), true);
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() throws InterruptedException {
		Assert.assertEquals(usermodule.verifyNoPopUp(), true);
	}

	@When("Fill in all the fields with valid datas from the given sheetname {string} and rownumber {int}")
	public void fill_in_all_the_fields_with_valid_datas_from_the_given_sheetname_and_rownumber(String SheetName,
			Integer RowNum) throws IOException, InvalidFormatException, InterruptedException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		String mName = testData.get(RowNum).get("MiddleName");
		String lName = testData.get(RowNum).get("LastName");
		String locatn = testData.get(RowNum).get("Location");
		String phNum = testData.get(RowNum).get("PhoneNum");
		String linkdUrl = testData.get(RowNum).get("LinkedUrl");
		String usrRol = testData.get(RowNum).get("UserRole");
		String rolStats = testData.get(RowNum).get("RoleStatus");
		String visaStats = testData.get(RowNum).get("VisaStatus");
		String emailadress = testData.get(RowNum).get("Email");
		String undrGrad = testData.get(RowNum).get("UnderGrad");
		String postGrad = testData.get(RowNum).get("PostGrad");
		String timeZne = testData.get(RowNum).get("TimeZone");
		String usrComnts = testData.get(RowNum).get("UserComments");
		usermodule.fillUserDetails(fName, mName, lName, locatn, phNum, linkdUrl, usrRol, rolStats, visaStats, undrGrad,
				postGrad, emailadress, timeZne, usrComnts);

		// usermodule.fillAllFields();

	}

	@Then("The newly added user from the excel with sheetname {string} and rownumber {int} should be present in the User page")
	public void the_newly_added_user_from_the_excel_with_sheetname_and_rownumber_should_be_present_in_the_user_page(
			String SheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelreader.getData(PropertyFileReader.getexcelfilepath(), "AddUser");
		String fName = testData.get(RowNum).get("FirstName");
		Assert.assertEquals(usermodule.verifyUserCreated(fName), true);
	}

}
