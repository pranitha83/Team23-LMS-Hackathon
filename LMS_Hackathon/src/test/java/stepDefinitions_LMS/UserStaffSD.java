package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UserSortPage;
import pageObjects.UserStaffPage;
import pageObjects.UserStudentPage;
import utilities.Excel_Reader;
import utilities.TestContextSetup;

public class UserStaffSD {
	
	public UserStaffPage usp;
  	TestContextSetup context;
  	SetupDriver setupdriver;
  	Excel_Reader excelreader;
  	
  	 public UserStaffSD(TestContextSetup context) {
  		 
  	       this.context = context;
  	       usp = context.getpageobjectmanager().getUserStaffpage();
  			setupdriver = context.getsetupdriver();
  			excelreader = context.getexcelreader();
  		
  	    }



@Given("Admin is in manage user page for Staff")
public void admin_is_in_manage_user_page_for_staff() {
	System.out.println("Manage USer");
}

@When("Admin clicks {string} button")
public void admin_clicks_button(String string) {
	usp.clickAssignStaff();
}

@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {
 usp.formValidation();
}
@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes")
public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
	
	usp.emailDisplayed();
	usp.prgramDisplayed();
	usp.batchDisplayed();
	usp.save();
	usp.cancelBtnDisplayed();
	
	
}

@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() throws InterruptedException {
	
	usp.validEmailDropDown();
	//usp.validBatchDropDown();
	usp.validProgramDropDown();
	usp.getPrgramName();
}
@Then("Admin should see two radio button for Status")
public void admin_should_see_two_radio_button_for_status() {
   usp.activeDisplayed();
   usp.inactiveDisplayed();
}


@Then("Admin gets a Error message alert for staff")
public void admin_gets_a_error_message_alert() throws InterruptedException {
	usp.save();
	usp.emptyFormErrorMessage1();
	usp.noEmailId();
}
@Given("Admin is in Assign Staff details pop up page")
public void admin_is_in_assign_staff_details_pop_up_page() {
   usp.clickAssignStaff();
}

@When("Admin clicks {string} button without entering Student Email id for staff")
public void admin_clicks_button_without_entering_student_email_id_for_staff(String string) throws InterruptedException {
	usp.getPrgramName();
   	usp.getBatchName();
   	usp.clickActiveStatus();
   	usp.save();
}

@Then("Admin gets a Error message alert as {string} for staff")
public void admin_gets_a_error_message_alert_as_for_staff(String string) throws InterruptedException {
    
    usp.getSkillText();
    usp.noEmailId();
   	usp.getEmailText();
   	
}
@When("Admin clicks {string} button without entering Skill")
public void admin_clicks_button_without_entering_skill(String string) {
	usp.getPrgramName();
	usp.getBatchName();
	usp.clickActiveStatus();
	usp.save();
	
	}

@Then("Admin gets a Error messages alert as {string} for staff")
public void admin_gets_a_error_messages_alert_as_for_staff(String string) {
	usp.getSkillText();
}

@When("Admin clicks {string} button without selecting program for staff")
public void admin_clicks_button_without_selecting_program_for_staff(String string) {
   usp.getBatchName();
   usp.clickActiveStatus();
	usp.save();
}

@Then("Admin gets a Error messaged alert as {string} for staff")
public void admin_gets_a_error_messaged_alert_as_for_staff(String string) {
  usp.getProgramNameText();
}


@When("Admin clicks {string} button without selecting batch for staff")
public void admin_clicks_button_without_selecting_batch_for_staff(String string) {
	usp.getPrgramName();
	
	usp.clickActiveStatus();
	usp.save();
}

@Then("Admin gets a Error messageq alert as {string} for staff")
public void admin_gets_a_error_messageq_alert_as_for_staff(String string) {
    usp.getProgramNameText();
}

@When("Admin clicks {string} button without giving status for staff")
public void admin_clicks_button_without_giving_status_for_staff(String string) {
usp.getPrgramName();
usp.getBatchName();
	usp.getSkillNameText();
}

@Then("Admin gets a Error messagew alert as {string}")
public void admin_gets_a_error_messagew_alert_as(String string) {
   usp.getStatusRequire();
}



@When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Staff form")
public void admin_clicks_cancel_close_x_icon_on_assign_staff_form() {
   usp.cancel();
}

@Then("Assign Staff popup window should be closed without saving")
public void assign_staff_popup_window_should_be_closed_without_saving() {
	usp.cancel();
	System.out.println("Closed");
}

@When("Enter all the required fields with valid values and click Save button for staff")
public void enter_all_the_required_fields_with_valid_values_and_click_save_button_for_staff() {
   usp.getSkillNameText();
   usp.getPrgramName();
   usp.getBatchName();
   usp.clickActiveStatus();
   usp.save();
}

@Then("Admin gets a messager {string} alert")
public void admin_gets_a_messager_alert(String string) {
   System.out.println("UnSuccess");
}

@When("Admin clicks <Cancel>button for staff")
public void admin_clicks_cancel_button_for_staff() {
   usp.cancel();
}

@Then("Admin can see the Assign Staff popup disappears without assigning for staff")
public void admin_can_see_the_assign_staff_popup_disappears_without_assigning_for_staff() {
    System.out.println("Popup closed");
}








}
