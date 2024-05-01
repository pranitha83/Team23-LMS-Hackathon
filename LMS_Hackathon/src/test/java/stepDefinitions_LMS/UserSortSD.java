package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UserStudentPage;
import pageObjects.UserSortPage;
import utilities.Excel_Reader;
import utilities.TestContextSetup;

public class UserSortSD {
	
  	public UserSortPage usp;
  	TestContextSetup context;
  	SetupDriver setupdriver;
  	Excel_Reader excelreader;
  	
  	 public UserSortSD(TestContextSetup context) {
  		 
  	       this.context = context;
  	       usp = context.getpageobjectmanager().getUserSortpage();
  			setupdriver = context.getsetupdriver();
  			excelreader = context.getexcelreader();
  		
  	    }
  	

	@Given("Admin is in manage user page")
	public void admin_is_in_manage_user_page() {
	    System.out.println("Hello!!");
	    usp.manageUser();
	}

	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() {
		System.out.println("Hey!!");
		usp.sortById();
	}

	@Then("Admin should see User details are sorted by id")
	public void admin_should_see_user_details_are_sorted_by_id() {
		System.out.println("Hii!!");
	}



}
