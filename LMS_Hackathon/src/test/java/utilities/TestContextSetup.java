package utilities;

import driverFactory.SetupDriver;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;

public class TestContextSetup  {
	private SetupDriver setupdriver;
	


	private PageObjectManager pageobjectmanager; 
	private LoginPage loginpage;
	private GenericUtils genericutils;
	
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
	public LoginPage getloginpage() {
		if (loginpage==null)
		{
			loginpage=new LoginPage(SetupDriver.Driver());
		}
		return loginpage;
	}
}


