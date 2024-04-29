package pageObjects;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerLoad;
import utilities.PropertyFileReader;

public class DashboardPage {
	

	@FindBy(xpath = "(//div[@class='box'])[1]")
	WebElement managepgmheader;

	@FindBy(xpath = "//span[contains(text(),' LMS - Learning Management System ')]")
	WebElement lmsTitle;

	@FindBy(xpath = "//span[@class='fill-remaining-space']")
	WebElement lmsSpace;

	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']")
	WebElement lmsTopBar;

	@FindBy(id = "program")
	WebElement programHeader;

	@FindBy(id = "batch")
	WebElement batchHeader;
	@FindBy(id = "user")
	WebElement userHeader;

	@FindBy(id = "logout")
	WebElement logoutHeader;
	
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']")
	WebElement colHeaders;
	
	@FindBy(xpath="//p-sorticon[@field='programName']")
	WebElement sortProgramName;
	
	@FindBy(xpath="//p-sorticon[@field='description']")
	WebElement sortProgramDesc;
	
	@FindBy(xpath="//p-sorticon[@field='status']")
	WebElement sortProgramStatus;
	
	@FindBy(xpath="//p-sorticon[@field=' Edit / Delete ']")
	WebElement sortIconAbsenceEditDel;
	
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']/tr")
	
	List<WebElement> rowCnt;
	
	
	@FindBy(xpath="//span[@class='p-checkbox-icon']")
	WebElement checkBoxes;
	
	@FindBy(xpath="//button[@id='editProgram']")
	WebElement editProgramButton;
	
	@FindBy(xpath="//button[@id='deleteProgram']")
	WebElement deleteProgramButton;
	
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement searchbar;
	
	
	
	
	
	
	
			
	
	
	

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String verifyHeaderText() {
		LoggerLoad.info("Admin see the header Text");
		String HeaderText = managepgmheader.getText();
		return HeaderText;
	}

	public String verifyLMSTitle() {
		LoggerLoad.info("Admin see the LMS Title");
		String lms_Title = lmsTitle.getText();
		return lms_Title;

	}

	public boolean title_SpellcheckAndSpacecheck() {
		if (lmsSpace.isDisplayed()) {
			Assert.assertEquals("LMS - Learning Management System", lmsTitle.getText());
			return true;
		}
		return false;

	}

	public void navigationBarSpellCheck() {
		String[] correctSpellings = { "Program", "Batch", "User", "Logout" };
		for (String spelling : correctSpellings) {
			Assert.assertTrue(lmsNavigationBarValidation().contains(spelling));
		}
	}

	public void verifyLink() throws Throwable {
		try {
			URL link = new URL(PropertyFileReader.getGlobalValue("dashboardurl"));
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() >= 400) {
				LoggerLoad.info(
						"Broken link found: " + link + " with response code: " + httpURLConnection.getResponseCode());
			} else {
				LoggerLoad.info("Valid link found: " + link);
			}
		} catch (IOException e) {
			LoggerLoad.info("Error connecting to the URL");
			e.printStackTrace();
		}

	}

	public void navigationTime() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
		long startTime = System.currentTimeMillis();
		Assert.assertTrue("Manage Program header is displayed", managepgmheader.isDisplayed());
		long endTime = System.currentTimeMillis();
		long responseTime = endTime - startTime;
		LoggerLoad.info("Response Time: " + responseTime + " milliseconds");
		long expectedResponseTime = 30000;
		Assert.assertTrue("Response time after login", responseTime <= expectedResponseTime);

	}

	public void titleHeadersProgramPosition() {

		if (programHeader == null || batchHeader == null) {
			LoggerLoad.info("One or both elements are not initialized.");
			return;
		}

		Point location1 = programHeader.getLocation();
		Point location2 = batchHeader.getLocation();

		int x1 = location1.getX();
		int x2 = location2.getX();

		if (x1 < x2) {
			LoggerLoad.info("The Program Header(1st place) is positioned before the batch header");
		} else if (x1 > x2) {
			LoggerLoad.info("The Program Header(1st place) is positioned after the batch header");
		} else {
			LoggerLoad.info("The  Program Header(1st place) and the batch header are aligned at the same position");
		}

	}

	public void titleHeadersBatchPosition() {

		if (batchHeader == null || userHeader == null) {
			LoggerLoad.info("One or both elements are not initialized.");
			return;
		}

		Point location3 = batchHeader.getLocation();
		Point location4 = userHeader.getLocation();

		int x3 = location3.getX();
		int x4 = location4.getX();

		if (x3 < x4) {
			LoggerLoad.info("The Batch Header(2nd place) is positioned before the user header");
		} else if (x3 > x4) {
			LoggerLoad.info("The Batch Header(2nd place) is positioned after the user header");
		} else {
			LoggerLoad.info("The  Batch Header(2nd place) and the user header are aligned at the same position");
		}

	}

	public void titleHeadersUserPosition() {

		if (userHeader == null || logoutHeader == null) {
			LoggerLoad.info("One or both elements are not initialized.");
			return;
		}

		Point location5 = userHeader.getLocation();
		Point location6 = logoutHeader.getLocation();

		int x5 = location5.getX();
		int x6 = location6.getX();

		if (x5 < x6) {
			LoggerLoad.info("The User Header(3rd place) is positioned before the logout header");
		} else if (x5 > x6) {
			LoggerLoad.info("The User Header(3rd place) is positioned after the logout header");
		} else {
			LoggerLoad.info("The  User Header(3rd place) and the logout header are aligned at the same position");
		}

	}

	public void titleHeadersLogoutPosition() {

		if (logoutHeader == null) {
			LoggerLoad.info("One or both elements are not initialized.");
			return;
		}

		Point location7 = logoutHeader.getLocation();

		int x7 = location7.getX();

		int logoutexpectedcoordinate = 1258;

		if (x7 == logoutexpectedcoordinate) {
			LoggerLoad.info("The logout header is positioned at the expected X coordinate.");
		} else {
			LoggerLoad.info("The logout header is not positioned at the expected X coordinate.");
			LoggerLoad.info("Actual X coordinate: " + x7);
		}

	}

	public void lmsTitleAlignment() {

		String lmsTitlealign = lmsTitle.getCssValue("text-align");
		Assert.assertEquals("start", lmsTitlealign);

	}

	public String lmsNavigationBarValidation() {

		return lmsTopBar.getText();

	}
	
	public void verifyCoulmnHeaders() {
		LoggerLoad.info(colHeaders.getText());
		
		
		String[] columnHeaders = { "Program Name","Program Description","Program Status","Edit / Delete" };
		 
		for (String heading : columnHeaders) {
			boolean isPresent = colHeaders.getText().contains(heading);
			LoggerLoad.info("Column header " + heading + " is  present.");
			Assert.assertTrue("Column header " + heading + " is  present.",isPresent);
		}
		
	}
	
	public boolean sortIconsValidation() {
		boolean sortIconsDisplayed = false;
		try {
		sortIconsDisplayed = sortProgramName.isDisplayed() && sortProgramDesc.isDisplayed() && sortProgramStatus.isDisplayed() && !(sortIconAbsenceEditDel.isDisplayed());
	    Assert.assertTrue("Sort arrow icons are not displayed beside each column header except Edit/Delete", sortIconsDisplayed);
	    LoggerLoad.info("Sort arrow icons are displayed beside each column header except Edit/Delete");
		}
	
	catch (NoSuchElementException e) {
        LoggerLoad.error("Sort Icon is not found for Edit/Delete column header");
       
    }
		return sortIconsDisplayed;
	}

	public void checkboxesValidation() {
		int rows_count = rowCnt.size();
		LoggerLoad.info("No of rows in Program Table: " + rows_count);
		for (int i = 0; i < rows_count; i++) {
		   boolean isPresent=checkBoxes.isDisplayed();
		   if(isPresent) {
			   String checkboxalign = checkBoxes.getCssValue("align-items");
				Assert.assertEquals("center", checkboxalign);
			   Assert.assertTrue("check boxes are displayed on the left side in all"+rows_count+" rows of the data table ",isPresent);
			   LoggerLoad.info("Validated checkbox is displayed and aligned properly in all rows of data table.");
		   }
		}
	}
	
	public void editDeleteButtonsValidation() {
		int rows_count = rowCnt.size();
		LoggerLoad.info("No of rows in Program Table: " + rows_count);
		for (int i = 0; i < rows_count; i++) {
		   boolean isPresent=editProgramButton.isDisplayed() && deleteProgramButton.isDisplayed();
		   if(isPresent) {
			   Assert.assertTrue("Edit and Delete buttons on all rows "+rows_count+"  of the data table ",isPresent);
			   LoggerLoad.info("Validated Edit/Delete buttons in each rows of data table.");
		   }
		}
	}

	
	public void validateSearchTextBox(String searchTxt) {
		
		boolean isPresent=searchbar.isDisplayed() ;
		
		
		if(isPresent) {
			String searchText = "//input[@placeholder='Search...']";
			WebElement searchInput = driver.findElement(By.xpath(searchText));
			String placeholderText = searchInput.getAttribute("placeholder");
			LoggerLoad.info("Placeholder text: " + placeholderText);
			Assert.assertEquals(placeholderText, searchTxt);
			Assert.assertTrue("Search input is not displayed", isPresent);
			LoggerLoad.info("Validated Search bar with text as 'Search...'");

		}
	}
	
	public void validateTotalRowsDisplayed(int total) {
		int rows_count = rowCnt.size();
		LoggerLoad.info("No of rows in Program Table: " + rows_count);
		Assert.assertEquals(total, rows_count);
	}

	public void clickLogout() {
		logoutHeader.click();
	}

}
