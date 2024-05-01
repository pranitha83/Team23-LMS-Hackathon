#Author: Saranya
@UserSort
Feature: Sort user

  Background: The Admin is logged in to LMS portal
 		Given Admin is in Home Page
 		 When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    And Admin should land on dashboard page
    And Admin clicks User button
   Then Admin should see a pop up open for user details
  
 
#Scenario: Admin is on Manage User Page after clicks User on the navigation bar
  Given Admin is in manage user page
  When Admin clicks on ID sort icon
  Then Admin should see User details are sorted by id
  
 #Scenario: Admin is on Manage User Page after clicks User on the navigation bar
  #Given Admin is in manage user page
  #When Admin clicks on name sort icon
  #Then Admin should see User details are sorted by name
  
 #Scenario: Admin is on Manage User Page after clicks User on the navigation bar
  #Given Admin is in manage user page
  #When Admin clicks on Location sort icon
  #Then Admin should see User details are sorted by Location
  
 #cenario: Admin is on Manage User Page after clicks User on the navigation bar
  #Given Admin is in manage user page
  #When Admin clicks on Phone number sort icon
  #Then Admin should see User details are sorted by Phone number
  
 