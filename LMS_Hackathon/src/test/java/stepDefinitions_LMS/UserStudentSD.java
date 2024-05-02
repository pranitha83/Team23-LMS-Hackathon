
	  package stepDefinitions_LMS;

	  import io.cucumber.java.en.Given;
	  import io.cucumber.java.en.Then;
	  import io.cucumber.java.en.When;
	  import pageObjects.UserStudentPage;
	  import utilities.Excel_Reader;
	  import utilities.TestContextSetup;
	  import driverFactory.SetupDriver;
	  public class UserStudentSD {
	  	
	  	public UserStudentPage usp;
	  	TestContextSetup context;
	  	SetupDriver setupdriver;
	  	Excel_Reader excelreader;
	  	
	  	 public UserStudentSD(TestContextSetup context) {
	  		 
	  	       this.context = context;
	  	       usp = context.getpageobjectmanager().getUserStudentpage();
	  			setupdriver = context.getsetupdriver();
	  			excelreader = context.getexcelreader();
	  		
	  	    }
	  	

		  	@When("Admin clicks User button")
		  	public void admin_clicks_user_button() throws InterruptedException {
		  		Thread.sleep(3000);
		  	    usp.userClick();
		  	    
		  	}  
		  	@Given("Admin is in manage user page")
		  	public void admin_is_in_manage_user_page() {
		  	   
		  	}
		  	@When("Admin clicks Assign student button")
		  	public void admin_clicks_assign_student_button() {
		  		usp.assignStudent();
		  	}
		  	  @Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
			  public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {
			     usp.formValidation();
			     }
		  	@When("Admin clicks Assign Student Program Name")
		  	public void admin_clicks_assign_student_program_name() {
		  	   usp.assignStudent();
		  	}
		  	@Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
		  	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() throws InterruptedException {
		  		usp.validEmailDropDown();
		  		usp.prgramDisplayed();
		  		usp.batchDisplayed();
		  		usp.activeDisplayed();
		  		usp.save();
		  		usp.cancelBtnDisplayed();
		  		
		  	}
		  	@When("Admin see Assign Student Email Id \\(no need i guess)")
		  	public void admin_see_assign_student_email_id_no_need_i_guess() {
		  	   usp.validEmailDropDown();
		  	 usp.prgramDisplayed();
		  		usp.batchDisplayed();
		  		
		  	}
		  	@Then("Admin should see a pop up open for user details")
		  	public void admin_should_see_a_pop_up_open_for_user_details() throws InterruptedException {
		  	 	System.out.println("Diplayed");
		  	}

//		  	@When("Admin clicks Assign Student button")
//		  	public void admin_clicks_assign_student_button() {
//		  		usp.assignStudent();
//		  	 
//		  	}

		  	@Then("Admin should see a pop up open for assign student details")
		  	public void admin_should_see_a_pop_up_open_for_assign_student_details() throws InterruptedException {
		  		System.out.println("I am in the Assign Student Page");
		  		//usp.textAssignStudent();
		  	}

		  	@When("Admin should see a radio button for status")
		  	public void admin_should_see_a_radio_button_for_status() throws InterruptedException {
		      usp.textStatus();
		  	System.out.println("I am status here");
		  	}

		  @Then("Admin clicks active radio button")
		  public void admin_clicks_active_radio_button() throws InterruptedException {
		      usp.clickActiveStatus();
		  }

		  @Then("Admin clicks inactive radio button")
		  public void admin_clicks_inactive_radio_button() throws InterruptedException {
		      usp.clickInActiveStatus();
		  	
		  }

		  @When("Admin clicks save button without entering any details")
		  public void admin_clicks_save_button_without_entering_any_details() throws InterruptedException {
		      usp.save();
		  }

		  @Then("Admin clicks gets alert Error message")
		  public void admin_clicks_gets_alert_error_message() {
		   //assertion
		  	System.out.println("No info alert");
		  }


		  @When("Admin clicks {string} button without entering Student Email id")
		  public void admin_clicks_button_without_entering_student_email_id(String string) throws InterruptedException {
		    usp.clickProgram();
		    usp.clickBatch();
		    usp.clickActiveStatus();
		  	usp.save();
		  }

		  @Then("Admin gets a Error message alert as {string}")
		  public void admin_gets_a_error_message_alert_as(String string) throws InterruptedException {
		  	usp.getBatchErrorAlert();
		  }

		  @When("Admin clicks {string} button without selecting program")
		  public void admin_clicks_button_without_selecting_program(String string) throws InterruptedException {
		  	usp.clickEmail();;
		  	usp.clickBatch();
		  	usp.save();
		  	System.out.println("No Program");
		  }
		  @Then("Admin gets a Error message alert for program as {string}")
		  public void admin_gets_a_error_message_alert_for_program_as(String string) throws InterruptedException {
		      //assertion
		  	System.out.println("No Program");
		  	usp.getProgramErrorAlert();
		  }

		  @When("Admin clicks {string} button without selecting batch")
		  public void admin_clicks_button_without_selecting_batch(String string) throws InterruptedException {
		  	usp.clickEmail();;
		  	usp.clickProgram();
		  	usp.clickBatch();
		  	usp.clickActiveStatus();
		  	usp.save();
		  }
		  @Then("Admin gets a Error message alert for batch  as {string}")
		  public void admin_gets_a_error_message_alert_for_batch_as(String string) throws Exception {
		    usp.getBatchErrorAlert();
		  }

		  @When("Admin clicks {string} button without giving status")
		  public void admin_clicks_button_without_giving_status(String string) throws InterruptedException {
		  	usp.clickEmail();;
		  	usp.clickProgram();
		  	usp.clickBatch();
		  	usp.save();
		  }

		  @Then("Admin gets a Error message alert  for as {string}")
		  public void admin_gets_a_error_message_alert_for_as(String string) throws InterruptedException {
		     //assertion for save
		  	//usp.getStatusErrorAlert();
		  }


		  @When("Admin clicks close Icon on Assign Student form")
		  public void admin_clicks_cancel_close_x_icon_on_assign_student_form() throws InterruptedException {
		    usp.cancel();
		  }

		  @Then("Assign Student popup window should be closed without saving")
		  public void assign_student_popup_window_should_be_closed_without_saving() {
		  	System.out.println("Its closed ");
		  }
		  @Given("When Admin clicks Assign Student button")
		  public void when_admin_clicks_assign_student_button() {
		      usp.assignStudent();
		      }
		  @When("Enter all the required fields with valid values and click Save button")
		  public void enter_all_the_required_fields_with_valid_values_and_click_save_button() throws InterruptedException {
		    
		    usp.validEmailDropDown();
		    usp.clickProgram();
		    usp.getProgramElement();
		    usp.clickBatch();
		    usp.getbatchElement();
		    usp.clickActiveStatus();
		    usp.save();
		    
		  }

		  @Then("Admin gets a message {string} alert")
		  public void admin_gets_a_message_alert(String string) {
		  	System.out.println("*****");
		  	System.out.println("Successfully saved");
		  	
		  }


		
		  @When("Admin clicks Cancel button")
		  public void admin_clicks_cancel_button() throws InterruptedException {
		     usp.cancel();
		     }

		  @Then("Admin can see the Assign Student popup disappears without assigning")
		  public void admin_can_see_the_assign_student_popup_disappears_without_assigning() {
		      System.out.println("Assigned staff");
		  }

		  @Given("Admin is in Assign Student details pop up page")
		  public void admin_is_in_assign_student_details_pop_up_page() throws InterruptedException {
	   usp.formValidation();
	}

		  @When("Admin clicks {string} button with entering any data")
		  public void admin_clicks_button_with_entering_any_data(String string) throws InterruptedException {
			usp.save();
	}

	  }






