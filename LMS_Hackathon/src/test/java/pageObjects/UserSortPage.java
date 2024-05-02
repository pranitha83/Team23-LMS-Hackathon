package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GenericUtils;
import utilities.LoggerLoad;
public class UserSortPage {
	
	@FindBy(id = "user")
	WebElement userHeader;

	@FindBy(xpath = "//p-sorticon[@field='userId']")
	WebElement sortByuserId;

	@FindBy(xpath = "//p-sorticon[@field='userFirstName']")
	WebElement sortByuserName;

	@FindBy(xpath = "//p-sorticon[@field='userLocation']")
	WebElement sortByuserLocation;

	@FindBy(xpath = "//p-sorticon[@field='userPhoneNumber']")
	WebElement sortByuserPhone;

	@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
	WebElement nextPagemoveBtn;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement nextPageMove;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[2]")
	List<WebElement> setOfUserIds;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[3]")
	List<WebElement> setOfUserNames;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[4]")
	List<WebElement> setOfUserLocation;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[5]")
	List<WebElement> setOfUserPhone;

	WebDriver driver;

	public UserSortPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickUserBtn() {
		userHeader.click();
	}

	public void clicksortIconById() {
		sortByuserId.click();
	}

	public void clicksortIconByName() {
		sortByuserName.click();
	}

	public void clicksortIconByLocation() {
		sortByuserLocation.click();
	}

	public void clicksortIconByPhoneNumber() {
		sortByuserPhone.click();
	}

	public void validatesortResultsByUserIdAscMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByAscendingOrder(setOfUserIds);
				Assert.assertTrue("Sorted by user Id Ascending order successfully", isSorted);
			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserIdDescMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages ");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByDescendingOrder(setOfUserIds);
				Assert.assertTrue("Sorted by user Id Descending order successfully", isSorted);
			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserNameAscMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByAscendingOrderStrings(setOfUserNames, setOfUserNames.size());
				if (isSorted) {
					// LoggerLoad.info("Sorted successfully");
					Assert.assertTrue("Sorted by user Name Ascending order successfully", isSorted);
				} else {
					// LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserNameDescMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByDescendingOrderStrings(setOfUserNames, setOfUserNames.size());
				if (isSorted) {
					// LoggerLoad.info("Sorted successfully");
					Assert.assertTrue("Sorted by user Name Descending order successfully", isSorted);
				} else {
					// LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserLocationsAscMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByAscendingOrderStrings(setOfUserLocation,
						setOfUserLocation.size());
				if (isSorted) {
					Assert.assertTrue("Sorted by user Location Ascending order successfully", isSorted);
				} else {
					 LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserLocationsDescMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByDescendingOrderStrings(setOfUserLocation,
						setOfUserLocation.size());
				if (isSorted) {
					Assert.assertTrue("Sorted by user Location Descending order successfully", isSorted);
				} else {
					 LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserPhoneNumberAscMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByAscendingOrder(setOfUserPhone);
				if (isSorted) {
					Assert.assertTrue("Sorted by user phone number Ascending order successfully", isSorted);
				} else {
					LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}

	public void validatesortResultsByUserPhoneNumberDescMultiplePages() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean isSorted = false;
			while (true) {
				if (!nextPageMove.isEnabled()) {
					LoggerLoad.info("Not able to move to next pages ");
					break;
				}

				wait.until(ExpectedConditions.visibilityOf(nextPagemoveBtn));
				nextPagemoveBtn.click();
				isSorted = GenericUtils.assertSortedByDescendingOrder(setOfUserPhone);
				if (isSorted) {
					Assert.assertTrue("Sorted by user Phone number Descending order successfully", isSorted);
				} else {
					LoggerLoad.info("Some are not Sorted successfully");
				}

			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerLoad.info("Next Element enabled is not found" + e.getMessage());
		}
	}
	
	}

