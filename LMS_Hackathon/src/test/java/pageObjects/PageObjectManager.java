package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {

	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
		
	}
	 
	
	public LoginPage getloginpage() {
		if (loginpage==null)
		{
			loginpage=new LoginPage(driver);
		}
		return loginpage;
	}
	
	public DashboardPage getdashboardpage() {
		dashboardpage=new DashboardPage(driver);
		return dashboardpage;
	}


}
