package stepDefinitions_LMS;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driverFactory.SetupDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import utilities.TestContextSetup;


public class Program_SD {
	
	 TestContextSetup context;
	 SetupDriver setupdriver;
	// ProgramPage programpage;
	
	public WebDriver driver;
//	TestContextSetup testcontextsetup;
   public ProgramPage programpage;
	
 public Program_SD(TestContextSetup context) {
		
//		this.testcontextsetup=testcontextsetup;
//		programpage=testcontextsetup.pageobjectmanager.getprogrampage();
		
		this.context=context;
		programpage=context.getpageobjectmanager().getprogrampage();
		//setupdriver = context.getsetupdriver();
		this.driver=SetupDriver.Driver();
	}
	

	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\shanj\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		testcontextsetup.driver=new ChromeDriver();
		testcontextsetup.driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		testcontextsetup.driver.findElement(By.id("username")).sendKeys("sdetorganizers@gmail.com");
		testcontextsetup.driver.findElement(By.id("password")).sendKeys("UIHackathon@02");
		testcontextsetup.driver.findElement(By.id("login")).click();*/
		
	//	programpage.Username();
	//	programpage.Password();
		//programpage.ClickLogin();
	
	    
	}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
		//testcontextsetup.driver.findElement(By.xpath("//*[text()='A New Program']")).click();
		programpage.NewProgram();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		String Cancelbutton=programpage.Cancelbutton();
		System.out.println("Cancelbutton :"  + Cancelbutton);
		
		String Savebutton=programpage.Savebuttongettext();
		System.out.println("Savebutton :"  + Savebutton);
		
		
		//Assert.assertTrue(programpage.PopupClose());//Need to check
	}
	
	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(programpage.proNamedisplay());
		Assert.assertTrue(programpage.proDesdisplay());
		
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(programpage.Statusdisplay());
	}


}
