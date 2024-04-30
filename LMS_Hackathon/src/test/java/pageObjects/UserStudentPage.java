
	
	package pageObjects;


	import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class UserStudentPage {
		//WebDriver driver;
		@FindBy(xpath = "//*[@id='userId']") WebElement SelectEmail;
		@FindBy(xpath = "//*[@id='programName']") WebElement programName;
		@FindBy(xpath = "//*[@id='batchName']") WebElement batchName;
		 @FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[1]/div/button/span") 
	 WebElement close;
		
		//*[@id="batchName"]/div/span
		 @FindBy(xpath = "//*[@id='userStatus']") WebElement inActiveStatus;
		@FindBy(xpath = "//*[@id='userStatus']") WebElement activeStatus;
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[3]/button[1]") WebElement cancel;
		@FindBy(xpath = "//button[@label='Save']") WebElement save;
			
	@FindBy(xpath = "//*[@id=\'userId\']") WebElement assignEmail;
		//@FindBy(xpath = "//button[@id='user']") WebElement userButton;
		@FindBy(xpath = "//button[@id='user']") WebElement userButton;
		@FindBy(xpath = "//*[@id='Assign']") WebElement assignStudent;
		@FindBy(xpath = "//button[contains(@class, 'p-button') and contains(@class, 'p-button-success') and contains(@class, 'p-button-rounded') and contains(., 'Assign Staff')]")WebElement assignStaff;
		@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-title/div[1]") WebElement textManageUser;
		@FindBy(xpath = "//*[@id='pr_id_15-label']") WebElement textAssignStudent;
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[5]/div[1]/label") WebElement textStatus;
		
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[2]/div\r\n") WebElement textErrorEmail;
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[3]/div") WebElement textErrorProgram;
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[4]/div") WebElement textErrorBatch;
		@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[6]") WebElement textErrorStatus;
		//@FindBy(xpath ="//span[@class='p-dropdown-trigger-icon ng-tns-c101-12 pi pi-chevron-down']") WebElement dropDown;
		//@FindBy(className = "p-dropdown-trigger-icon.ng-tns-c101-10.pi.pi-chevron-down") WebElement dropdown;
		@FindBy(css = ".p-dropdown-trigger-icon.ng-tns-c101-14.pi.pi-chevron-down") WebElement newDropDown;
		@FindBy(xpath = "//ul[@role='listbox']") List<WebElement> listEmail;
		@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c101-15") WebElement sendEmail;
		@FindBy(xpath = "//*[@id='userId']/div/div[3]/div[2]/ul/p-dropdownitem/li") WebElement finalClick;
		
		@FindBy(xpath = "/html/body/div/div/ul/p-dropdownitem[3]/li") WebElement selectProgram;
		
		@FindBy(xpath ="//*[@id='userId']/div/div[3]/div[1]/div/input") WebElement ssss;
		@FindBy(xpath="/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form") WebElement form;
		///html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[2]/div
//		public WebDriver driver = new ChromeDriver();
//		public WebDriverWait driver1;
//		public AssignStaffPage(WebDriver driver) {
//			this.driver=driver;
//			PageFactory.initElements(driver,this);
//			
//		}
//		
		WebDriver driver;
		
		public UserStudentPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		//By user=By.xpath("//span[@class='mat-button-wrapper']");
		//By assignStudent=By.xpath("//*[@id='Assign']");
		//By assignStaff=By.xpath("//button[contains(@class, 'p-button') and contains(@class, 'p-button-success') and contains(@class, 'p-button-rounded') and contains(., 'Assign Staff')]\r\n");
		//@FindBy (id="username") WebElement username;
		//@FindBy (id = "password") WebElement password;
		//@FindBy (id = "login") WebElement loginButton;
		//By user=By.xpath("//span[@class='mat-button-wrapper']");
		//By assignStudent=By.xpath("//*[@id='Assign']");
		//By assignStaff=By.xpath("//button[contains(@class, 'p-button') and contains(@class, 'p-button-success') and contains(@class, 'p-button-rounded') and contains(., 'Assign Staff')]\r\n");
		
		/*public void clickDropdown() {
			dropdown.click();
		}
		
		
		public void listEmails() {
			
			System.out.println(listEmail.size());
		
			
		}*/
		public boolean emailDisplayed() {
			return SelectEmail.isDisplayed();
			
		}
		public boolean cancelBtnDisplayed() {
			return cancel.isDisplayed();
		}
		public boolean saveBtnDisplayed() {
			return save.isDisplayed();
		}
		public boolean batchDisplayed() {
			return batchName.isDisplayed();
		}
		public boolean prgramDisplayed() {
			return programName.isDisplayed();
		}
		
		
		public boolean activeDisplayed() {
			return inActiveStatus.isDisplayed();
		  
		}
		public void formValidation() throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(form));
			List<WebElement> inputfields = form.findElements(By.tagName("input"));
			
			List<WebElement> dropdowns = form.findElements(By.tagName("p-dropdown"));
			boolean isEmpty = true;
			// Check input fields
	        for (WebElement inputField : inputfields) {
	            String fieldValue = inputField.getAttribute("value");
	            if (fieldValue != null && !fieldValue.trim().isEmpty()) {
	                isEmpty = false;
	                break;
	            }
	        }
		}
		
		
		
		 public void userClick() throws InterruptedException {
			 System.out.println("##################");
			 Thread.sleep(5000);
		        userButton.click();
		    }
		public void assignStudent() {
			 assignStudent.click();
			}

		public void assignStaff() {
			assignStaff.click();
			}
		public void assignStudentEmail() {
			assignEmail.click();
			
			}
		public void dropdown() throws InterruptedException {
			/*WebElement dd=driver.findElement(By.xpath("//"));
			 Actions actions = new Actions(driver);
			 actions.moveToElement(dd).click().build().perform();*/
			
			Thread.sleep(2500);
			SelectEmail.click();
			System.out.println("$$$$$$$$$$$$$$$$");
			Thread.sleep(2500);
			ssss.sendKeys("neehasri@gmailcom");  
			//newDropDown.click();
			System.out.println("$$$$$$$$$$$$$$$$");
			Thread.sleep(2500);
			finalClick.click();
			Thread.sleep(3000);
			programName.click();
			
			
			//Select select = new Select(sendEmail);
			//.activeStatu//.sendKeys("neehasri@gmailcom");
		//	select.selectByVisibleText();
			//WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
			//WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(SelectEmail));
			//ele.click();
		System.out.println("User role dropdown clicked");  

			List<WebElement> roleOptions = driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c101-10 ng-star-inserted']"));
	//	List<WebElement> dropd
			System.out.println("User role dropdown clicked!!!!!!!!");
			String desiredRole = "neehasri@gmailcom"; // The text you want to select
			System.out.println("User role dropdown clicked!!!!!!!!" +roleOptions.size());
			for (WebElement role : roleOptions) {
			    String roleText = role.getText();
			    System.out.println("User role is " + roleText);
			    
			    if (roleText.equalsIgnoreCase(desiredRole)) {
			        System.out.println("Found the desired role: " + desiredRole);
			        role.click();
			        System.out.println(desiredRole + " is clicked");
			        break;
			    }
			}
			
			//WebElement identifier = )
			//WebElement dropdownElement = driver.findElement(By.id("your_dropdown_id"));

			// Create a Select object with the dropdown element
			//Select select = new Select(SelectEmail);
			//sendEmail.sendKeys("neehasri@gmailcom");
		//	select.selectByVisibleText();
			//select.selectByVisibleText("Last 52 Weeks"); 
			/*java.util.List<WebElement> options = sendEmail.findElements(By.tagName("li"));

			for (WebElement option : options) {
			    if (option.getText().equals("neehasri@gmail.com")) { // Adjust the email address as per your requirement
			        option.click();
			        break;
			    }
			}
			//*[@id="userId"]/div/div[3]/div[2]/ul/p-dropdownitem/li
			// WebElement option = driver.findElement(By.xpath("//span[contains(text(), 'neeha@gmail.com')]"));
			//sendEmail.sendKeys("neehasri@gmailcom");
			//System.out.println();
		    Thread.sleep(2500);
			programName.click();
			Thread.sleep(2500);
			batchName.click();
			Thread.sleep(2500);
			
			
			
	//option.click();*/
			//sendEmail.sendKeys(neehasri@gmailcom);
		//	Select fruits = new Select(sendEmail);
			
		//	fruits.selectByVisibleText("neehasri@gmailcom");
		//	fruits.selectByIndex(1);

			
		}

		public void cancel() throws InterruptedException {
			cancel.click();
		}
		public void save() throws InterruptedException {
			save.click();
		}
		public void close() throws InterruptedException {
			close.click();
		}
		public void manageUser() throws InterruptedException {
			String actualManageUserText=textManageUser.getText();
			System.out.println("Manage User:"+actualManageUserText);
		}
		public void textAssignStudent() throws InterruptedException {
			String actualAssignStudentText=textAssignStudent.getText();
			System.out.println("Manage User:"+actualAssignStudentText);
		}
		public void textStatus() throws InterruptedException {
			String actualTextStatus=textStatus.getText();
			System.out.println("Manage User:"+actualTextStatus);
		}
		public void clickActiveStatus() throws InterruptedException {
			activeStatus.click();
		}
		public void clickInActiveStatus() throws InterruptedException {
			inActiveStatus.click();
		}
		public void getEmailErrorAlert() throws InterruptedException {
			String actualTextEmail=textErrorEmail.getText();
			System.out.println("Manage User:"+actualTextEmail);
		
		}
		public void getProgramErrorAlert() throws InterruptedException {
			String actualTextProgram=textErrorProgram.getText();
			System.out.println("Manage User:"+actualTextProgram);
		
		}
		public void getBatchErrorAlert() throws InterruptedException {
			String actualTextBatch=textErrorBatch.getText();
			System.out.println("Manage User:"+actualTextBatch);
		
		}
		public void getStatusErrorAlert() throws InterruptedException {
			String actualTextStatus=textErrorStatus.getText();
			System.out.println("Manage User:"+actualTextStatus);
		
		}
		public void validEmailDropDown() {
			SelectEmail.click();
			 try {
				 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))); // Change to the CSS selector of dropdown options
			     System.out.println("@@@@@@@@@@@@@2222222222222");
			     // Get the dropdown options
			     WebElement dropdownOptionsContainer = driver.findElement(By.tagName("p-dropdown"));
			     List<WebElement> dropdownOptions = dropdownOptionsContainer.findElements(By.tagName("li"));
			     int numberOfOptions = dropdownOptions.size();
			     System.out.println("%%%%%%%%%%"+numberOfOptions);
			     // Check if the dropdown has valid data (at least one option)
			     Assert.assertTrue("Dropdown is empty or does not have valid data.", numberOfOptions > 0);
			 } catch (Exception e) {
		         // Handle any exceptions
		         e.printStackTrace();
		     }
		}
	}





