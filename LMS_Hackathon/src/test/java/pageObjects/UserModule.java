package pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;

public class UserModule {
	By userName = By.id("username");
	By pswd = By.id("password");
	By login = By.id("login");
	By user = By.id("user");
	By addNewUser = By.id("new");
	By popUpWindow = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted']");
	By firstName = By.xpath("//input[@data-placeholder='First name']");
	By middleName = By.xpath("//input[@data-placeholder='Middle name']");
	By lastName = By.xpath("//input[@data-placeholder='Last name']");
	By locatn = By.xpath("//input[@data-placeholder='Location']");
	By phoneNum = By.xpath("//input[@data-placeholder='Phone no']");
	By linkedUrl = By.xpath("//input[@data-placeholder='LinkedIn Url']");
	By emailAddress = By.xpath("//input[@type='email']");
	By underGrad = By.xpath("//input[@data-placeholder='Under Graduate']");
	By postGrad = By.xpath("//input[@data-placeholder='Post Graduate']");
	By timeZone = By.xpath("//input[@data-placeholder='Time Zone']");
	By userComments = By.xpath("//input[@data-placeholder='User Comments']");
	By cancelBtn = By.xpath("//mat-card-actions//button[1]");
	By submitBtn = By.xpath("//button[@type='submit']");
	By roleDrpdwn = By.id("roleId");
	By roleStatusDrpdwn = By.id("userRoleStatus");
	By visaStatusDrpdwn = By.id("userVisaStatus");
	By roleOptnsDrpdwn = By.xpath("//li[@role='option']");
	By roleStatsOptnsDrpdwn = By.xpath("//li[@role='option']");
	By visaStatsOptnsDrpdwn = By.xpath("//li[@role='option']");
	
	public WebDriver driver;

	public UserModule(WebDriver driver) {
		this.driver = driver;
		this.driver = SetupDriver.Driver();
	}

	public void clickUser() {
		driver.findElement(userName).sendKeys("sdetorganizers@gmail.com");
		driver.findElement(pswd).sendKeys("UIHackathon@02");
		driver.findElement(login).click();
		driver.findElement(user).click();
	}

	public void clickAddUser() {
		driver.findElement(addNewUser).click();
	}

	public boolean verifyPopupWindowWithUsrDetails() {
		String[] expctdText = { "First name", "Middle name", "Last name", "Location", "Phone no", "LinkedIn Url",
				"User Role", "Select Role", "User Role Status", "Select Role Status", "User Visa Status",
				"Select Visa Status", " ", "Under Graduate", "Post Graduate", "Time Zone", "User Comments", "Cancel",
				"Submit" };
		String elements = driver.findElement(popUpWindow).getText();
		for (int i = 0; i < expctdText.length; i++) {

			if (!elements.contains(expctdText[i]) || !driver.findElement(popUpWindow).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean isTextBoxesDisplayed() {
		return driver.findElement(firstName).isDisplayed() && driver.findElement(lastName).isDisplayed()
				&& driver.findElement(middleName).isDisplayed() && driver.findElement(locatn).isDisplayed()
				&& driver.findElement(phoneNum).isDisplayed() && driver.findElement(linkedUrl).isDisplayed()
				&& driver.findElement(emailAddress).isDisplayed() && driver.findElement(postGrad).isDisplayed()
				&& driver.findElement(underGrad).isDisplayed() && driver.findElement(timeZone).isDisplayed()
				&& driver.findElement(userComments).isDisplayed() && driver.findElement(cancelBtn).isDisplayed()
				&& driver.findElement(submitBtn).isDisplayed();

	}

	public boolean isDropdownsDisplayed() {
		return driver.findElement(roleDrpdwn).isDisplayed() && driver.findElement(roleStatusDrpdwn).isDisplayed()
				&& driver.findElement(visaStatusDrpdwn).isDisplayed();

	}

	public void fillUserDetails(String firstname, String midname, String lastname, String location, String phoneno,
			String linkdurl, String userrole, String rolestatus, String visastatus, String undergrad, String postgrad,
			String email, String timezone, String usercomments) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(middleName).sendKeys(midname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(locatn).sendKeys(location);
		driver.findElement(phoneNum).sendKeys(phoneno);
		driver.findElement(linkedUrl).sendKeys(linkdurl);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(roleDrpdwn));
		ele.click();
		List<WebElement> roleOptions = driver.findElements(roleOptnsDrpdwn);
		for (WebElement role : roleOptions) {
			Thread.sleep(1000);
			if (role.getText().equalsIgnoreCase(userrole)) {
				role.click();
				break;
			}
		}
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(roleStatusDrpdwn));
		ele1.click();
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				if (roleStatus.getText().equalsIgnoreCase(rolestatus)) {
					roleStatus.click();
					break;
				}
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				if (roleStatus.getText().equalsIgnoreCase(rolestatus)) {
					roleStatus.click();
					break;
				}
			}

		}

		WebElement ele2 = wait.until(ExpectedConditions.visibilityOfElementLocated(visaStatusDrpdwn));
		ele2.click();
		try {
			List<WebElement> visaStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			visaStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement visaStatus : visaStatusOptions) {
				Thread.sleep(1000);
				if (visaStatus.getText().equals(visastatus)) {
					visaStatus.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> visaStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement visaStatus : visaStatusOptions) {
				Thread.sleep(1000);
				if (visaStatus.getText().equals(visastatus)) {
					visaStatus.click();
					break;
				}
			}
		}
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(underGrad).sendKeys(undergrad);
		driver.findElement(postGrad).sendKeys(postgrad);
		driver.findElement(timeZone).sendKeys(timezone);
		driver.findElement(userComments).sendKeys(usercomments);

	}

	public void clickSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		ele.click();
		// driver.findElement(submitBtn).click();
	}

	public void fillOptionalFields(String midname, String linkdurl, String email, String undergrad, String postgrad,
			String timezone, String usercomments) {
		driver.findElement(middleName).sendKeys(midname);
		driver.findElement(linkedUrl).sendKeys(linkdurl);
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(underGrad).sendKeys(undergrad);
		driver.findElement(postGrad).sendKeys(postgrad);
		driver.findElement(timeZone).sendKeys(timezone);
		driver.findElement(userComments).sendKeys(usercomments);
	}

	public void fillInvalidDatasInAllFields(String firstname, String midname, String lastname, String location,
			String phoneno, String linkdurl, String undergrad, String postgrad, String email, String timezone,
			String usercomments) {
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(middleName).sendKeys(midname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(locatn).sendKeys(location);
		driver.findElement(phoneNum).sendKeys(phoneno);
		driver.findElement(linkedUrl).sendKeys(linkdurl);
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(underGrad).sendKeys(undergrad);
		driver.findElement(postGrad).sendKeys(postgrad);
		driver.findElement(timeZone).sendKeys(timezone);
		driver.findElement(userComments).sendKeys(usercomments);

	}

	public boolean verifySuccessMsg(String expcdMsg) {
		return driver.getPageSource().contains(expcdMsg);
	}

	public boolean verifyErrMsgInMandFields() throws InterruptedException {
		String expFstNameErr = "First name is required";
		String expLastNameErr = "Last name is required";
		String expLocatnErr = "Location is required";
		String expPhoneNumErr = "Phone number is required";
		List<String> ExpctdErrs = Arrays.asList(expFstNameErr, expLastNameErr, expLocatnErr, expPhoneNumErr);
		Thread.sleep(2000);
		List<WebElement> errMsgsList = driver.findElements(By.xpath("//mat-error[@role='alert']"));
		for (WebElement errMsg : errMsgsList) {
			if (!ExpctdErrs.contains(errMsg.getText()))
				return false;
		}
		return true;
	}

	// Verifying Color of the Text
	public boolean verifyTextColor() {
		String backColor = driver.findElement(By.xpath("//mat-error[@role='alert']")).getCssValue("color");
		String hexBackColor = Color.fromString(backColor).asHex();
		return hexBackColor.equals("#f44336");
	}

	public boolean verifyErrMsg() {
		String errMsg = "Please enter a valid email address";
		return driver.findElement(By.xpath("//mat-error[@role='alert']")).getText().equalsIgnoreCase(errMsg);
	}

	public boolean verifyErrMsgsInAllFields() throws InterruptedException {
		String expFstNameErr = "First name is required";
		String expMidNameErr = "Middle name is required";
		String expLastNameErr = "Last name is required";
		String expLocatnErr = "Location is required";
		String expPhoneNumErr = "Phone number is required";
		String expLinkdUrlErr = "LinkedIn Url is required";
		String expEmailErr = "Email address is required";
		String expUnderGradErr = "Under Graduate is required";
		String expPostGradErr = "Post Graduate is required";
		String expTimeZneErr = "Time Zone is required";
		String expUsrComntsErr = "User Comments is required";
		List<String> ExpctdErrs = Arrays.asList(expFstNameErr, expMidNameErr, expLastNameErr, expLocatnErr,
				expPhoneNumErr, expLinkdUrlErr, expEmailErr, expUnderGradErr, expPostGradErr, expTimeZneErr,
				expUsrComntsErr);
		Thread.sleep(2000);
		List<WebElement> errMsgsList = driver.findElements(By.xpath("//mat-error[@role='alert']"));
		for (WebElement errMsg : errMsgsList) {
			if (!ExpctdErrs.contains(errMsg.getText()))
				return false;
		}
		return true;
	}

	public void clickCancel() {
		WebElement ele = driver.findElement(cancelBtn);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", ele);
	}

	public boolean verifyNoPopUp() throws InterruptedException {
		Thread.sleep(1000);
		boolean displayStatus;
		try {
			driver.findElement(popUpWindow).isDisplayed();
			displayStatus = false;
		} catch (NoSuchElementException e) {
			displayStatus = true;
		}
		return displayStatus;

	}

	public boolean verifyPopUpWindowClosed() throws InterruptedException {
		Thread.sleep(1000);
		boolean verifyTextSize = true;
		try {
			int textSize = driver.findElement(popUpWindow).getText().length();
			if (textSize > 1) {
				verifyTextSize = false;
			}
		} catch (NoSuchElementException e) {
			verifyTextSize = true;
		}
		return verifyTextSize;
	}

	public boolean verifyUserCreated(String fname) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().refresh();
		driver.findElement(userName).sendKeys("sdetorganizers@gmail.com");
		driver.findElement(pswd).sendKeys("UIHackathon@02");
		driver.findElement(login).click();
		driver.findElement(user).click();
		// Thread.sleep(1000);
		WebElement goToNxtPage = driver.findElement(By.xpath("//p-paginator/div/button[3]"));
		boolean flag = false;
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();

		while (flag == false) {
			for (int r = 1; r <= rows; r++) {
				String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[3]")).getText();
				if (name.contains(fname)) {
					flag = true;
					break;
				}
			}
			if (!goToNxtPage.isEnabled()) {
				break;
			}
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(goToNxtPage));
			ele.click();

		}
		return flag;
	}
}
