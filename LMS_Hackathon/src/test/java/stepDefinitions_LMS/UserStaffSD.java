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
	System.out.println("Hi!!!");
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
	System.out.println("LLLLLLLLLLLL");
	usp.save();
	usp.cancelBtnDisplayed();
	System.out.println("Ddddd");
	
}

@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() throws InterruptedException {
	System.out.println("***************************");
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


@Then("Admin gets a Error message alert")
public void admin_gets_a_error_message_alert() throws InterruptedException {
	usp.save();
	usp.emptyFormErrorMessage1();
	usp.noEmailId();
}





}
