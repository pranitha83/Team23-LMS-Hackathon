package utilities;

import driverFactory.SetupDriver;
import pageObjects.UserStudentPage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import pageObjects.UserSortPage;
import pageObjects.UserStaffPage;

public class TestContextSetup  {
	private SetupDriver setupdriver;
	


	private PageObjectManager pageobjectmanager; 
	private UserStudentPage assignStaffpage;
	private UserStaffPage userStaffpage;
	private UserSortPage userSortpage;
	private GenericUtils genericutils;
	private Excel_Reader excelreader;
	public TestContextSetup()
	{
		setupdriver = new SetupDriver();
		pageobjectmanager = new PageObjectManager(SetupDriver.Driver());
		//scenarioContext = new ScenarioContext();
		excelreader = new Excel_Reader();
	}
	
	public SetupDriver getsetupdriver() {
		return setupdriver;
	}
	
	public PageObjectManager getpageobjectmanager() {
		return pageobjectmanager;
	}
	
	public Excel_Reader getexcelreader() {
	return excelreader;
	}
}


