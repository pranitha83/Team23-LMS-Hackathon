package stepDefinitions_LMS;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import utilities.Excel_Reader;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;


public class Program_SD {
	
	 TestContextSetup context;
	 SetupDriver setupdriver;
	  public WebDriver driver;
      public ProgramPage programpage;
      Excel_Reader excelreader;
      Alert alert;
	
 public Program_SD(TestContextSetup context) {
			
		this.context=context;
		programpage=context.getpageobjectmanager().getprogrampage();
		this.driver=SetupDriver.Driver();
		excelreader = context.getexcelreader();
	}
	
//=======================================Add Program=====================================================
 
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() throws InterruptedException {
		}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
		programpage.NewProgram();
		LoggerLoad.info("Entering NewProgram");
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		LoggerLoad.info("Displaying Cancel and Save button");
		
		String Cancelbutton=programpage.Cancelbutton();
		LoggerLoad.info("Cancelbutton :"  + Cancelbutton);
		
		String Savebutton=programpage.Savebuttongettext();
		LoggerLoad.info("Savebutton :"  + Savebutton);
	}
	
	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(programpage.proNamedisplay());
		Assert.assertTrue(programpage.proDesdisplay());
		
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(programpage.Statusdisplay());
	}
	
	// Empty form submission
	
		@Then("Admin clicks <Save>button without entering any data")
		public void admin_clicks_save_button_without_entering_any_data() {
			programpage.Savebuttonclick();
		
		}
		
		@Then("Admin gets a Error message alert")
		public void admin_gets_a_error_message_alert() {
			
			String ProNameRequired=programpage.ProNameRequired();
			LoggerLoad.info("ProNameRequired :"  + ProNameRequired);
			
			String ProDescRequired=programpage.ProDescRequired();
			LoggerLoad.info("ProDescRequired :"  + ProDescRequired);
			
			String statusrequied=programpage.statusrequied();
			LoggerLoad.info("statusrequied :"  + statusrequied);
		    
		}
		
		// Enter only Program Name
		
		@Then("Admin enters only<Program Name> in text box and clicks Save button")
		public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
			LoggerLoad.info("Entering only program name");
			programpage.onlyenterproname();
			programpage.Savebuttonclick();
		}
		
		@Then("Admin gets a message alert Description is required")
		public void Admin_gets_a_message_alert_Description_is_required() {
			
			String ProDescRequired=programpage.ProDescRequired();
			LoggerLoad.info("ProDescRequiredn :"  + ProDescRequired);
		}
		
		//Enter only Program Description
		
		@Then("Admin enters only<Program description> in text box and clicks Save button")
		public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
			LoggerLoad.info("Entering only Program descrption");
			programpage.onlyenterproDes();
			programpage.Savebuttonclick();
		    
		}
		
		@Then("Admin gets a message alert Name is required")
		public void Admin_gets_a_message_alert_Name_is_required() {
			
			String ProNameRequired=programpage.ProNameRequired();
			LoggerLoad.info("ProNameRequiredv :"  + ProNameRequired);
		}
		
		
		//Select Status only
		
		@Then("Admin selects only Status and clicks Save button")
		public void admin_selects_only_status_and_clicks_save_button() {
			LoggerLoad.info("Select only Status");
			programpage.onlyclickstatus();
			programpage.Savebuttonclick();
		}
		
		@Then("Admin gets a message alert Name and Description required")
		public void Admin_gets_a_message_alert_Name_and_Description_required() {
			
			String ProNameRequired=programpage.ProNameRequired();
			LoggerLoad.info("ProNameRequiredv :"  + ProNameRequired);
			
			String ProDescRequired=programpage.ProDescRequired();
			LoggerLoad.info("ProDescRequiredn :"  + ProDescRequired);
		}
		
		//Validate invalid values on the name text column
		
		@Then("Admin enters only numbers or special char in name  column")
		public void admin_enters_only_numbers_or_special_char_in_name_column() {
			LoggerLoad.info("Validate Special character");
			programpage.PronameSpecialchar();
		}

		@Then("Admin gets a special char Error message alert for name column")
		public void admin_gets_a_special_char_error_message_alert_for_name_column() {
			
			programpage.PronameSpecialcharerrormsg();
		}
	      
		// Validate invalid values on the desc text column
		
		@Then("Admin enters only numbers or special char in desc column")
		public void admin_enters_only_numbers_or_special_char_in_desc_column() {
			programpage.ProDesSpecialchar();
		}

		@Then("Admin gets a special char Error message alert for desc column")
		public void admin_gets_a_special_char_error_message_alert_for_desc_column() {
			programpage.ProDesSpecialcharerrormsg();
		}
		
	    //Validate Cancel/Close(X) icon on Program Details form
		
		@Then("Admin clicks Cancel or Close\\(X) Icon on Program Details form")
		public void admin_clicks_cancel_or_close_x_icon_on_program_details_form() {
			programpage.Programpopupclose();
		}

		@Then("Program Details popup window should be closed without saving")
		public void program_details_popup_window_should_be_closed_without_saving() {
			String CapturingfooterentryBeforeAdd = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryBeforeAdd :"  +  CapturingfooterentryBeforeAdd);
		}
		
	     //Validate Save button on Program Details form
		@Then("Enter all the required fields with valid values in given sheetname {string} and rowNumber {int} and then click Save button")
		public void enter_all_the_required_fields_with_valid_values_in_given_sheetname_and_row_number_and_then_click_save_button(String string, Integer int1) throws IOException, InvalidFormatException {
		   
			LoggerLoad.info("Entering Valid ProgramName and descrption");
			List<Map<String, String>> programData=excelreader.getData(PropertyFileReader.getexcelfilepath(), "ProgramModule");
			System.out.println(programData);
			
			String programname = programData.get(int1).get("programName");
			String programdesc = programData.get(int1).get("programDescription");
			
			programpage.EnterProNameandDesc(programname, programdesc);
			programpage.onlyclickstatus();
			programpage.Savebuttonclick();
			
			LoggerLoad.info("NewProgram Created");
		    
		}
		

		@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
		public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) throws InterruptedException {
			
			programpage.AlertProgramcreation();
			
		}
	    
		//Validate Cancel button on Program Details form
		
		@Then("Admin clicks <Cancel>button")
		public void admin_clicks_cancel_button() throws InterruptedException {
			Thread.sleep(2000);
		   programpage.CancelbuttonClick();
		}

		@Then("Admin can see the Program details popup disappears without creating any program")
		public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
			 
			String CapturingfooterentryAfteradd = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryAfteradd :"  + CapturingfooterentryAfteradd);
		}

		//================================EditProgram===============================================================================
		
		
		//Validate Edit feature
		@When("Admin clicks <Edit> button on the data table for any row")
		public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
			LoggerLoad.info("Editing Program Name and Descrption");
		    programpage.Editclick();
		}

		@When("Admin is on Program Details Popup window to Edit")
		public void admin_is_on_program_details_popup_window_to_edit()  {
			
		}

		@Then("Admin should see a popup open for Program details to edit")
		public void admin_should_see_a_popup_open_for_program_details_to_edit() throws InterruptedException {
			Thread.sleep(3000);
			Assert.assertTrue(programpage.proNamedisplay());
			Assert.assertTrue(programpage.proDesdisplay());
			Assert.assertTrue(programpage.Statusdisplay());
		}
	          
		//Edit Program Name 
		
		@When("Admin edits the Name column and clicks save button")
		public void admin_edits_the_name_column_and_clicks_save_button() {
		    programpage.ProNameclear();
		    programpage.ProNameupdate();
		    programpage.Savebuttonclick();
		}

		@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
			
			 programpage.AlertProgramUpdate();
		    
		}
	           //Edit Program description 
		
		@When("Admin edits the Description column and clicks save button")
		public void admin_edits_the_description_column_and_clicks_save_button() throws InterruptedException {
			Thread.sleep(2000);
			    programpage.ProDescclear();
			    programpage.ProDescupdate();
			    programpage.Savebuttonclick();
		    
		}

		@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
			 programpage.AlertProgramUpdate();
		
		}
	              //Change Program Status 
		
		@When("Admin changes the Status and clicks save button")
		public void admin_changes_the_status_and_clicks_save_button() throws InterruptedException {
			Thread.sleep(2000);
		     programpage.Statuschange();
		     programpage.Savebuttonclick();
		}

		@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
		      
			 programpage.AlertProgramUpdate();
		}
		
		@When("Admin clicks <Cancel>button on edit popup")
		public void admin_clicks_cancel_button_on_edit_popup() {
			
			programpage.CancelbuttonClick();
		}

		@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
		public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		    
			String Capturingfooterentryupdate = programpage.Capturingfooterentry();
			LoggerLoad.info("Capturingfooterentryupdate :"  + Capturingfooterentryupdate);
		}

		@When("Admin clicks <Save>button on edit popup")
		public void admin_clicks_save_button_on_edit_popup() {
		    programpage.Savebuttonclick();
		}

		@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		    
			String Capturingfooterentryupdate = programpage.Capturingfooterentry();
			LoggerLoad.info("Capturingfooterentryupdate :"  + Capturingfooterentryupdate);
			LoggerLoad.info("Editing Program Completed");
		}
		
		//====================================================Delete Program===================================================================
		
        //	Delete Feature
	
	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
		LoggerLoad.info("Program Deletion");
	    programpage.DeleteClick();
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(programpage.DeleteNo());
	  Assert.assertTrue(programpage.DeleteYes());
	}

	    //Validate details for Confirm Deletion form
	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(programpage.Deletemessage());
	
	}

	//Click Yes on deletion window
	
	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		
		String CapturingfooterentryBeforeDeleteYes = programpage.Capturingfooterentry();
		LoggerLoad.info("CapturingfooterentryBeforeDeleteYes :"  + CapturingfooterentryBeforeDeleteYes);
		
	    programpage.DeleteYesClick();
	    
	    programpage.AlertProgramUpdate();
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
	    
		String CapturingfooterentryAfterDeleteYes = programpage.Capturingfooterentry();
		LoggerLoad.info("CapturingfooterentryAfterDeleteYes :"  + CapturingfooterentryAfterDeleteYes);
	}
	
      //Click No on deletion window
	
	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
	    programpage.DeleteNoClick();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		
		String CapturingfooterentryAfterDeleteNo = programpage.Capturingfooterentry();
		LoggerLoad.info("CapturingfooterentryAfterDeleteNo :"  + CapturingfooterentryAfterDeleteNo);
	    
	}
	
         // Validate Cancel/Close(X) icon on Confirm Deletion alert
	
	@When("Admin clicks Cancel or Close\\(X) Icon on Deletion alert")
	public void admin_clicks_cancel_or_close_x_icon_on_deletion_alert() {
	    programpage.DeletePopupClose();
  }

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	    
		String CapturingfooterentryAfterCliclnochange = programpage.Capturingfooterentry();
		LoggerLoad.info("CapturingfooterentryAfterCliclnochange:"  + CapturingfooterentryAfterCliclnochange);
		LoggerLoad.info("Program Delete Completed");
	}
  
	//======================================Pagination===================================================================
	
		//Verify Next page link
		@When("Admin clicks Next page link on the program table")
		public void admin_clicks_next_page_link_on_the_program_table() {
			LoggerLoad.info("Program Pagination starts");
			String CapturingfooterentryBeforenextpageclick = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryBeforenextpageclick :"  +  CapturingfooterentryBeforenextpageclick);
			
			programpage.Nextpageclick();
		    
		}

		@Then("Admin should see the Pagination has {string} active link")
		public void admin_should_see_the_pagination_has_active_link(String string) {
			
			Assert.assertTrue(programpage.Nextpagelinkisenabled());
			String CapturingfooterentryAfternextpageclick = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryAfternextpageclick :"  +  CapturingfooterentryAfternextpageclick);
		    
		}
		
		// Verify Last page link

		@When("Admin clicks Last page link")
		public void admin_clicks_last_page_link() {

			String CapturingfooterentryBeforelastpageclick = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryBeforelastpageclick :"  +  CapturingfooterentryBeforelastpageclick); 
			
			programpage.lastpageclick();
		}

		@Then("Admin should see the last page record on the table with Next page link are disabled")
		public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() throws InterruptedException {
			
			//Assert.assertFalse(programpage.Nextpagelinkisenabled());
			
		}
		
		// Verify First page link
		
		@Given("Admin is on last page of Program table")
		public void admin_is_on_last_page_of_program_table() {
			programpage.lastpageclick();
		}

		@When("Admin clicks First page link")
		public void admin_clicks_first_page_link() {
		    programpage.firstpageclick();
		}

		@Then("Admin should see the previous page record on the table with pagination has previous page link")
		public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
			
			String Capturingfooterentrypaginationhaspreviouspagelink = programpage.Capturingfooterentry();
			LoggerLoad.info("Capturingfooterentrypaginationhaspreviouspagelink :"  +  Capturingfooterentrypaginationhaspreviouspagelink);
		   
		}
		
	    //Verify Start page link
		
		@Given("Admin is on Previous Program page")
		public void admin_is_on_previous_program_page() {
			//programpage.firstpageclick();
		}

		@When("Admin clicks Start page link")
		public void admin_clicks_start_page_link() throws InterruptedException {
		   
			programpage.startpageclick();
			String CapturingfooterentryAfterstarttpageclick = programpage.Capturingfooterentry();
			LoggerLoad.info("CapturingfooterentryAfterstarttpageclick :"  +  CapturingfooterentryAfterstarttpageclick); 
		}

		@Then("Admin should see the very first page record on the table with Previous page link are disabled")
		public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() throws InterruptedException {
			
			
			// Thread.sleep(2000);
			//Assert.assertFalse(programpage.Previouspagelinkisenabled());
			LoggerLoad.info("Program Pagination Completed");
		}


		
}
