#Author: Saranya
@AssignStaff123	
Feature: User Assign Staff Page

 
  Background: The Admin is logged in to LMS portal
 		Given Admin is in Home Page
 		When  Admin gives the correct LMS portal URL
    And   Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
    Then  Admin clicks User button
  
    
  Scenario: Validate Assign Staff Popup window
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
	
	Scenario:  Validate input fields and their text boxes in Assign Staff form 
		Given Admin is in manage user page 
		When Admin clicks "Assign Staff" button
		Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes

	Scenario:  Validate input fields and their text boxes in Assign Staff form 
		Given Admin is in manage user page 
		When Admin clicks "Assign Staff" button
		Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
		
		Scenario:  Validate radio button in Assign Staff Form
		Given Admin is in manage user page 
		When Admin clicks "Assign Staff" button
	  Then Admin should see two radio button for Status 
	
	Scenario:Empty Form Submission
	Given Admin is in manage user page 
	When Admin clicks "Assign Staff" button 
	Then Admin gets a Error message alert for staff 
	
	Scenario:Validate the Assign Staff form page without giving Student Email id
	Given Admin is in Assign Staff details pop up page 
	When Admin clicks "Save" button without entering Student Email id for staff 
	Then Admin gets a Error message alert as "Student Email id is required" for staff
	
	Scenario:Validate the Assign Staff form page without giving Skill
	Given Admin is in Assign Staff details pop up page
	When Admin clicks "Save" button without entering Skill
	Then Admin gets a Error messages alert as "Skill is required" for staff
	
	Scenario:Validate the Assign Staff form page without selecting Program
	Given Admin is in Assign Staff details pop up page
	When Admin clicks "Save" button without selecting program for staff
	Then Admin gets a Error messaged alert as "Program is required" for staff	

	Scenario:Validate the Assign Staff form page without selecting batch
	Given Admin is in Assign Staff details pop up page
	When Admin clicks "Save" button without selecting batch for staff
	Then Admin gets a Error messageq alert as "Batch is required" for staff
		#doing
	Scenario:Validate the Assign Staff form page without giving Status
	Given Admin is in Assign Staff details pop up page
	When Admin clicks "Save" button without giving status for staff
	Then Admin gets a Error messagew alert as "Status is required"
	
	Scenario:Validate Cancel/Close(X) icon on Assign Staff form
	Given Admin is in Assign Staff details pop up page
	When Admin clicks Cancel/Close(X) Icon on Assign Staff form
	Then Assign Staff popup window should be closed without saving
	
	Scenario:Validate Save button on Assign Staff form
	Given Admin is in Assign Staff details pop up page
	When Enter all the required fields with valid values and click Save button for staff
	Then Admin gets a messager "Successfully Staff Assigned" alert 
	
	Scenario:Validate Cancel button on Assign Staff form
	Given Admin is in Assign Staff details pop up page
	When Admin clicks <Cancel>button for staff
	Then Admin can see the Assign Staff popup disappears without assigning for staff 
	
	
	
	
	
	
	
	