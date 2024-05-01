package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {

	public LoginPage loginpage;
	public UserStudentPage userStudentpage;
	public UserStaffPage userStaffpage;
	public UserSortPage userSortpage;
	public WebDriver driver;
	public ProgramPage programpage;
	public DashboardPage dashboardpage;
	public BatchPage batchpage;
	public AddUser usermodule;
	public EditUser edituser;
	public DeleteUser deleteuser;
	public DeleteMultiUsers dltmultiuser;

	
	
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


	public UserStudentPage getUserStudentpage() {
		if (userStudentpage==null)
		{
			userStudentpage=new UserStudentPage(driver);
		}
		return userStudentpage;
	}
	public UserStaffPage getUserStaffpage() {
		if (userStaffpage==null)
		{
			userStaffpage=new UserStaffPage(driver);
		}
		return userStaffpage;
	}
	public UserSortPage getUserSortpage() {
		if (userSortpage==null)
		{
			userSortpage=new UserSortPage(driver);
		}
		return userSortpage;
	}


	public BatchPage getbatchpage() {
		batchpage=new BatchPage(driver);
		return   batchpage;
	}

	public DashboardPage getdashboardpage() {
		dashboardpage=new DashboardPage(driver);
		return dashboardpage;
	}
	public AddUser getUserpage() {
		usermodule=new AddUser(driver);
		return usermodule;
	}
	
	public EditUser getEditUserPage() {
		edituser = new EditUser(driver);
		return edituser;
	}
	
	public DeleteUser getDeleteUser() {
		deleteuser = new DeleteUser(driver);
		return deleteuser;
	}
	
	public DeleteMultiUsers getDeleteMultiUsers() {
		dltmultiuser = new DeleteMultiUsers(driver);
		return dltmultiuser;
	}


}
