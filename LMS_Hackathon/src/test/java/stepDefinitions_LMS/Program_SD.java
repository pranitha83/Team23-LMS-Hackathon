package stepDefinitions_LMS;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import utilities.Excel_Reader;
import utilities.PropertyFileReader;
import utilities.TestContextSetup;


public class Program_SD {
	
	 TestContextSetup context;
	 SetupDriver setupdriver;
	  public WebDriver driver;
      public ProgramPage programpage;
      Excel_Reader excelreader;
	
 public Program_SD(TestContextSetup context) {
			
		this.context=context;
		programpage=context.getpageobjectmanager().getprogrampage();
		this.driver=SetupDriver.Driver();
		excelreader = context.getexcelreader();
	}
	

	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\shanj\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		testcontextsetup.driver=new ChromeDriver();
		testcontextsetup.driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		testcontextsetup.driver.findElement(By.id("username")).sendKeys("sdetorganizers@gmail.com");
		testcontextsetup.driver.findElement(By.id("password")).sendKeys("UIHackathon@02");
		testcontextsetup.driver.findElement(By.id("login")).click();*/
		
	//	programpage.Username();
	//	programpage.Password();
		//programpage.ClickLogin();
	
	    
	}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
		//testcontextsetup.driver.findElement(By.xpath("//*[text()='A New Program']")).click();
		programpage.NewProgram();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		String Cancelbutton=programpage.Cancelbutton();
		System.out.println("Cancelbutton :"  + Cancelbutton);
		
		String Savebutton=programpage.Savebuttongettext();
		System.out.println("Savebutton :"  + Savebutton);
		
		
		//Assert.assertTrue(programpage.PopupClose());//Need to check
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
			System.out.println("ProNameRequired :"  + ProNameRequired);
			
			String ProDescRequired=programpage.ProDescRequired();
			System.out.println("ProDescRequired :"  + ProDescRequired);
			
			String statusrequied=programpage.statusrequied();
			System.out.println("statusrequied :"  + statusrequied);
		    
		}
		
		// Enter only Program Name
		
		@Then("Admin enters only<Program Name> in text box and clicks Save button")
		public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
			programpage.onlyenterproname();
			programpage.Savebuttonclick();
		}
		
		@Then("Admin gets a message alert Description is required")
		public void Admin_gets_a_message_alert_Description_is_required() {
			
			String ProDescRequired=programpage.ProDescRequired();
			System.out.println("ProDescRequiredn :"  + ProDescRequired);
		}
		
		//Enter only Program Description
		
		@Then("Admin enters only<Program description> in text box and clicks Save button")
		public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
			programpage.onlyenterproDes();
			programpage.Savebuttonclick();
		    
		}
		
		@Then("Admin gets a message alert Name is required")
		public void Admin_gets_a_message_alert_Name_is_required() {
			
			String ProNameRequired=programpage.ProNameRequired();
			System.out.println("ProNameRequiredv :"  + ProNameRequired);
		}
		
		
		//Select Status only
		
		@Then("Admin selects only Status and clicks Save button")
		public void admin_selects_only_status_and_clicks_save_button() {
			programpage.onlyclickstatus();
			programpage.Savebuttonclick();
		}
		
		@Then("Admin gets a message alert Name and Description required")
		public void Admin_gets_a_message_alert_Name_and_Description_required() {
			
			String ProNameRequired=programpage.ProNameRequired();
			System.out.println("ProNameRequiredv :"  + ProNameRequired);
			
			String ProDescRequired=programpage.ProDescRequired();
			System.out.println("ProDescRequiredn :"  + ProDescRequired);
		}
		
		//Validate invalid values on the name text column
		
		@Then("Admin enters only numbers or special char in name  column")
		public void admin_enters_only_numbers_or_special_char_in_name_column() {
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
			System.out.println("CapturingfooterentryBeforeAdd :"  +  CapturingfooterentryBeforeAdd);
		}
		
	     //Validate Save button on Program Details form
		@Then("Enter all the required fields with valid values in given sheetname {string} and rowNumber {int} and then click Save button")
		public void enter_all_the_required_fields_with_valid_values_in_given_sheetname_and_row_number_and_then_click_save_button(String string, Integer int1) throws IOException {
		   
		
			List<Map<String, String>> programData=excelreader.getData(PropertyFileReader.getexcelfilepath(), "ProgramModule");
			System.out.println(programData);
			
			String programname = programData.get(int1).get("programName");
			String programdesc = programData.get(int1).get("programDescription");
			
			programpage.EnterProNameandDesc(programname, programdesc);
			programpage.onlyclickstatus();
			programpage.Savebuttonclick();
		    
		}
		
//		@Then("Enter all the required fields with valid values in {string} and  {int} and then click Save button")
//		public void enter_all_the_required_fields_with_valid_values_in_sheet_name_and_row_no_and_then_click_save_button(String SheetName,Integer rowno) throws IOException {
//		   
//			List<Map<String, String>> programData=excelreader.getData(PropertyFileReader.getexcelfilepath(), "ProgramModule");
//			System.out.println(programData);
//			
//			
//			
//			String programname = programData.get(rowno).get("programName");
//			String programdesc = programData.get(rowno).get("programDescription");
//			
//			programpage.EnterProNameandDesc(programname, programdesc);
//			programpage.onlyclickstatus();
//			programpage.Savebuttonclick();
//			
	//
//		}

		@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
		public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		    
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
			System.out.println("CapturingfooterentryAfteradd :"  + CapturingfooterentryAfteradd);
		}

		
		
		


}
