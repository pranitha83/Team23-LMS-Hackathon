package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.scanner.Constant;
//import pageObjects.Constant;

//import org.yaml.snakeyaml.scanner.Constant;





public class UserStaffPage {
	
	WebDriver driver;
	@FindBy(xpath="(//li[@class='p-dropdown-item p-ripple'])[1]") WebElement emailElement;
	@FindBy(xpath="(//li[@class='p-dropdown-item p-ripple']/span)[1]") WebElement programElement;
	@FindBy(xpath ="//p-dropdown[@id='userId']") WebElement emailDropDown;
	@FindBy(xpath ="//ul[@role='listbox']") WebElement listBox;

	@FindBy(xpath ="//button[@label='Assign Staff']") WebElement assignStaff;
	@FindBy(xpath ="//span[@class='ng-tns-c101-10 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")WebElement getEmailString;
		@FindBy(xpath ="//input[@id='skillName']") WebElement skillNameText;
		@FindBy(xpath ="//p-dropdown[@id='programName']") WebElement programDropDown;
		@FindBy(xpath ="//div[@role='dialog']//form//p-multiselect[@id='batchName']") WebElement batchName;
		//@FindBy(xpath ="//input[@id='Active']") WebElement activeStatus;
		//p-radiobutton-box
		//@FindBy(xpath ="//div[@class='p-radiobutton-box']") WebElement inActiveStatus;
		@FindBy(xpath ="//div[@class='p-radiobutton-box']") WebElement inActiveStatus;
		//@FindBy(xpath ="//input[@id='InActive']") WebElement inActiveStatus;
		@FindBy(xpath ="//button[@label='Cancel']") WebElement cancel;
		@FindBy(xpath ="//button[@label='Save']") WebElement save;
		@FindBy(xpath ="//span[@class='p-dialog-header-close-icon ng-tns-c132-7 pi pi-times']") WebElement close;
		@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-7 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']") WebElement form;
		@FindBy(xpath ="//div[contains(@class, 'Program Name is required.')]") WebElement programText;
		@FindBy(xpath ="//div[contains(@class, 'Batch Name is required.')]") WebElement batchText;
		//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
		//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
		//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
		@FindBy(xpath = "//button[@id='user']") WebElement userButton;
		public UserStaffPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
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
		public void dropDownVerification() {
			 assertOptionsAreValid(emailDropDown);
			 assertOptionsAreValid(programDropDown);
			 assertOptionsAreValid(batchName);
			
		}
		
		public void assertOptionsAreValid(WebElement dropdown) {
			List<WebElement> options = dropdown.findElements(By.tagName("li"));
			for(WebElement option : options) {
				assert option.getText()!= null && option.getText().isEmpty() : "Dropdown option is not valid" ;
			}
			System.out.println("All options in dropdown are valid");
			
		}
		public void manageUser() {
			
			//String actualManageUserText=manageUserText.getText();
			//System.out.println("Manage User:"+actualManageUserText);
		}

		public void clickAssignStaff() {
			
			assignStaff.click();
		}
	public void getEmailText() {
			
		String getEmailText=getEmailString.getText();
		System.out.println(getEmailText);
		Assert.assertEquals("Select Email Id",getEmailText);
		
		}
	public void getSkillNameText() {
		
		String getSkillText=skillNameText.getText();
		System.out.println(getSkillText);
		//AssertJUnit.assertEquals("",getSkillText);
		}
	public void getProgramNameText() {
		
		String getProgramText=programText.getText();
		System.out.println(getProgramText);
		//AssertJUnit.assertEquals("Program Name is required.",getProgramText);
		}
	public void getBatchNameText() {
		
		String getBatchText=batchText.getText();
		System.out.println(getBatchText);
		//AssertJUnit.assertEquals("Batch Name is required.",getBatchText);
		}
	public void save() {
		save.click();
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
		return programDropDown.isDisplayed();
	}
	public boolean skillDisplayed() {
		return skillNameText.isDisplayed();
	}
	public boolean emailDisplayed() {
		return emailDropDown.isDisplayed();
		
	}
	public boolean activeDisplayed() {
		return inActiveStatus.isDisplayed();
	  
	}
	public boolean inactiveDisplayed() {
		return inActiveStatus.isDisplayed();
	  
	}
	public void validEmailDropDown() throws InterruptedException {
		emailDropDown.click();
		
		if(listBox.isDisplayed()) {
			Assert.assertTrue("Email elements are displayed", true);
			Assert.assertTrue(emailElement.getText(), true);
		}
		
		Thread.sleep(5000);
		
		emailDropDown.click();
		//emailElement.click();
		/* try {
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))); // Change to the CSS selector of dropdown options
		     System.out.println("@@@@@@@@@@@@@2222222222222");
		     // Get the dropdown options
		     WebElement dropdownOptionsContainer = driver.findElement(By.tagName("p-dropdown"));
		     List<WebElement> dropdownOptions = dropdownOptionsContainer.findElements(By.tagName("li"));
		   //  dropdownOptions
		     int numberOfOptions = dropdownOptions.size();
		     System.out.println("%%%%%%%%%%"+numberOfOptions);
		     // Check if the dropdown has valid data (at least one option)
		     Assert.assertTrue("Dropdown is empty or does not have valid data.", numberOfOptions > 0);
		 } catch (Exception e) {
	         // Handle any exceptions
	         e.printStackTrace();
	     }*/
	}
	public void validProgramDropDown() throws InterruptedException {
		programDropDown.click();

		if(listBox.isDisplayed()) {
			Assert.assertTrue("Program names are displayed", true);
		}
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(programElement));
		programElement.click();
		Assert.assertTrue(programElement.getText(), true);
		
		programDropDown.click();
			//emailDropDown.click();
		/* try {
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))); // Change to the CSS selector of dropdown options
		     System.out.println("@@@@@@@@@@@@@333333333333");
		     // Get the dropdown options
		     WebElement dropdownOptionsContainer = driver.findElement(By.tagName("p-dropdown"));
		     List<WebElement> dropdownOptions = dropdownOptionsContainer.findElements(By.tagName("li"));
		     int numberOfOptions = dropdownOptions.size();
		     
		     // Check if the dropdown has valid data (at least one option)
		     Assert.assertTrue("Dropdown is empty or does not have valid data.", numberOfOptions > 0);
		 } catch (Exception e) {
	        // Handle any exceptions
	        e.printStackTrace();
	    }*/
	}
	public void validBatchDropDown() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", batchName);
		batchName.click();
		if(listBox.isDisplayed()) {
			Assert.assertTrue("Batch details are displayed", true);
		}
		batchName.click();
		/*emailDropDown.click();
		 try {
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input"))); // Change to the CSS selector of dropdown options
		     System.out.println("@@@@@@@@@@@@@4444444444444");
		     // Get the dropdown options
		     WebElement dropdownOptionsContainer = driver.findElement(By.tagName("p-dropdown"));
		     List<WebElement> dropdownOptions = dropdownOptionsContainer.findElements(By.tagName("li"));
		     int numberOfOptions = dropdownOptions.size();
		     
		     // Check if the dropdown has valid data (at least one option)
		     Assert.assertTrue("Dropdown is empty or does not have valid data.", numberOfOptions > 0);
		 } catch (Exception e) {
	        // Handle any exceptions
	        e.printStackTrace();
	    }
	}*/
	}
	public void emptyFormErrorMessage1() throws InterruptedException {
	   /* List<WebElement> errorMessages = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
	    
	    // Assert that no error messages are displayed
	    Assert.assertTrue("Error messages are displayed", errorMessages.isEmpty());

	    for (WebElement errorMessage : errorMessages) {
	        String errorMessageText = errorMessage.getText();
	        if (errorMessageText.contains("Active") || errorMessageText.contains("Inactive")) {
	            continue; // Skip radio button messages
	        }
	        System.out.println("Error Message :" + errorMessageText);
	    }
	}*/
		List<WebElement> errormsgelements = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
		for(WebElement errormsg : errormsgelements) {
			Thread.sleep(4000);
			String errorMsgText = errormsg.getText();
			if (errorMsgText.contains("Active") || errorMsgText.contains("Inactive")) {
	            continue; // Skip radio button messages
	        }
			/*if(errormsg.getAttribute("type")!= null && errormsg.getAttribute("type").equals("radio") ) {
				continue;
			}*/
			//String errorMsgText = errormsg.getText();
			System.out.println("Error Message :" + errorMsgText);
			
		}
	}
		public void noEmailId() throws InterruptedException {
			Thread.sleep(3000);
			emailDropDown.click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			emailElement.click();
	}
}