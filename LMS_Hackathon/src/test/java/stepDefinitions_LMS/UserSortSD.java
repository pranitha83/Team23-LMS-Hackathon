package stepDefinitions_LMS;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UserSortPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class UserSortSD {
	
	UserSortPage userSortpage;
	TestContextSetup context;
	SetupDriver setupdriver;

	public UserSortSD(TestContextSetup context) {
		this.context = context;
		userSortpage = context.getpageobjectmanager().getUserSortpage();
		setupdriver = context.getsetupdriver();

	}

	@Given("Admin is on the Manage User Page")
	public void admin_is_on_the_manage_user_page() {
		userSortpage.clickUserBtn();
			LoggerLoad.info("Admin is on manage user page");
	}

	@When("Admin clicks on the ID sort icon")
	public void admin_clicks_on_the_id_sort_icon() {
		userSortpage.clicksortIconById();
	}

	@Then("Admin should see User details are sorted by id Ascending Order")
	public void admin_should_see_user_details_are_sorted_by_id_ascending_order() {
		userSortpage.validatesortResultsByUserIdAscMultiplePages();
	}

	@When("Admin clicks on ID sort icon button twice")
	public void admin_clicks_on_id_sort_icon_button_twice() {
		userSortpage.clicksortIconById();
		userSortpage.clicksortIconById();
	}

	@Then("Admin should see User details are sorted by id Descending Order")
	public void admin_should_see_user_details_are_sorted_by_id_descending_order() {
		userSortpage.validatesortResultsByUserIdDescMultiplePages();
	}
	
	@When("Admin clicks on name sort icon")
	public void admin_clicks_on_name_sort_icon() {
	   userSortpage.clicksortIconByName();
	}

	
	@Then("Admin should see User details are sorted by name Ascending Order")
	public void admin_should_see_user_details_are_sorted_by_name_ascending_order() {
		userSortpage.validatesortResultsByUserNameAscMultiplePages();
	}

	@When("Admin clicks on name sort icon button twice")
	public void admin_clicks_on_name_sort_icon_button_twice() {
	   userSortpage.clicksortIconByName();
	   userSortpage.clicksortIconByName();
	   
	}

	@Then("Admin should see User details are sorted by name Descending Order")
	public void admin_should_see_user_details_are_sorted_by_name_descending_order() {
		userSortpage.validatesortResultsByUserNameDescMultiplePages();
	}

	@When("Admin clicks on Location sort icon")
	public void admin_clicks_on_location_sort_icon() {
	   userSortpage.clicksortIconByLocation();
	}

	@Then("Admin should see User details are sorted by Location Ascending Order")
	public void admin_should_see_user_details_are_sorted_by_location_ascending_order() {
	    userSortpage.validatesortResultsByUserLocationsAscMultiplePages();
	}
	
	@When("Admin clicks on Location sort icon twice")
	public void admin_clicks_on_location_sort_icon_twice() {
		userSortpage.clicksortIconByLocation();
		userSortpage.clicksortIconByLocation();
	}

	@Then("Admin should see User details are sorted by Location Descending Order")
	public void admin_should_see_user_details_are_sorted_by_location_descending_order() {
	   userSortpage.validatesortResultsByUserLocationsDescMultiplePages();
	}
	
	@When("Admin clicks on Phone number sort icon")
	public void admin_clicks_on_phone_number_sort_icon() {
	   userSortpage.clicksortIconByPhoneNumber();
	}

	@Then("Admin should see User details are sorted by Phone number Ascending Order")
	public void admin_should_see_user_details_are_sorted_by_phone_number_ascending_order() {
	    userSortpage.validatesortResultsByUserPhoneNumberAscMultiplePages();
	}

	@When("Admin clicks on Phone number sort icon twice")
	public void admin_clicks_on_phone_number_sort_icon_twice() {
		   userSortpage.clicksortIconByPhoneNumber();
		   userSortpage.clicksortIconByPhoneNumber();
	}

	@Then("Admin should see User details are sorted by Phone number Descending Order")
	public void admin_should_see_user_details_are_sorted_by_phone_number_descending_order() {
	   userSortpage.validatesortResultsByUserPhoneNumberDescMultiplePages();
	}


}
