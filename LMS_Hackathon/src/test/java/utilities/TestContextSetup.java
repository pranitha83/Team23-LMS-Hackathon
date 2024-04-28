package utilities;

import driverFactory.SetupDriver;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;

public class TestContextSetup  {
	private SetupDriver setupdriver;
	


	private PageObjectManager pageobjectmanager; 
	
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


