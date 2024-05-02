package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {

	public LoginPage loginpage;
	public WebDriver driver;
	public ProgramPage programpage;
	public DashboardPage dashboardpage;
	public BatchPage batchpage;

	
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
		
	}
	 
//	public LoginPage getLoginpage() {
//		
//		 loginpage=new LoginPage(driver);
//		 return  loginpage;
//	}
	
	public LoginPage getloginpage() {
		if (loginpage==null)
		{
			loginpage=new LoginPage(driver);
		}
		return loginpage;
	}
	public ProgramPage getprogrampage() {
		
		 programpage=new ProgramPage(driver);
		 return   programpage;
	}

	public BatchPage getbatchpage() {
		batchpage=new BatchPage(driver);
		return   batchpage;
	}

	public DashboardPage getdashboardpage() {
		dashboardpage=new DashboardPage(driver);
		return dashboardpage;
	}

}
