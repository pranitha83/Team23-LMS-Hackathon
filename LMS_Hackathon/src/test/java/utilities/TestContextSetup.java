package utilities;

import driverFactory.SetupDriver;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;

public class TestContextSetup  {
	private SetupDriver setupdriver;
	


	private PageObjectManager pageobjectmanager; 
	private LoginPage loginpage;
	private GenericUtils genericutils;
	private DashboardPage dashboardpage;
	
	public TestContextSetup()
	{
		setupdriver = new SetupDriver();
		pageobjectmanager = new PageObjectManager(SetupDriver.Driver());
		//scenarioContext = new ScenarioContext();
	}
	
	public SetupDriver getsetupdriver() {
		return setupdriver;
	}
	
	public PageObjectManager getpageobjectmanager() {
		return pageobjectmanager;
	}
	
}


