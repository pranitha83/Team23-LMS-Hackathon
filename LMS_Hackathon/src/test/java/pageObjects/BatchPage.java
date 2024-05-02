package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerLoad;

import java.time.Duration;
import java.util.List;

public class BatchPage {

    @FindBy(id = "batch")
    WebElement batch;

    @FindBy(id = "new")
    WebElement newBatch;

    @FindBy(id = "edit")
    WebElement editBatch;

    @FindBy(id = "filterGlobal")
    WebElement filterGlobal;

    /*
    Below elements will be used for New Batch creation
    and also for updating batch information
     */
    @FindBy(id = "batchName")
    WebElement batchName;

    @FindBy(id = "batchDescription")
    WebElement batchDescription;

    @FindBy(id = "programName")
    WebElement programName;

    @FindBy(id = "batchStatus")
    WebElement batchStatus;

    By deleteMessage = By.xpath("//*[@class='p-confirm-dialog-message ng-tns-c133-4']");
    By deletePopupClose = By.xpath("//*[@class='pi pi-times ng-tns-c133-4']");


    /*@FindBy(id = "ACTIVE")
    WebElement active;


    @FindBy(id = "INACTIVE")
    WebElement inactive;*/
    By active = By.className("p-radiobutton-box");
    By inActive = By.xpath("//*[@id='category' and @class='ng-untouched ng-pristine ng-valid']/div[1]/div[2]");


    @FindBy(id = "batchNoOfClasses")
    WebElement batchNoOfClasses;
    //TODO
    //SAVE and CANCEL buttons
    By Cancelbutton = By.xpath("//*[text()='Cancel']");
    By saveButton = By.xpath("//*[text()='Save']");

    By submitBtn = By.xpath("//button[@label='Save']");
    By popUpClose = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c132-8 pi pi-times']");
    By manageBatchHeader = By.xpath("//*[@class='mat-card-title']");
    By paginator = By.xpath("//*[@class='p-paginator-current ng-star-inserted']");
    By gridHeaders = By.xpath("//*[@class='p-datatable-wrapper ng-star-inserted']");
    By checkbox = By.xpath("//*[@role='checkbox']");

    By programButton = By.xpath("//*[@role='button']");
    By editIcon = By.xpath("//*[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']");

    By programDropDown = By.id("programName");


    By programOptionsDropdown = By.xpath("//li[@role='option']");


    By pencilIcon = By.xpath("//*[@class='p-button-icon pi pi-pencil']");

    Alert alert;


    //Delete batch


    By Deletebutton = By.xpath("//*[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
    By GlobalDelete = By.xpath("//*[@class='p-button-danger p-button p-component p-button-icon-only']");
    //p-button-danger p-button p-component p-button-icon-only
    By deleteYes = By.xpath("//*[text()='Yes']");
    By deleteNo = By.xpath("//*[text()='No']");
    By Deletemessage = By.xpath("//*[@class='p-toast-summary ng-tns-c90-10']");
    By DeletePopupClose = By.xpath("//*[@class='pi pi-times ng-tns-c133-4']");

    By programNameText = By.xpath("//*[@class='p-dropdown-label p-inputtext ng-tns-c101-30 ng-star-inserted']");

    /*
    validation items
     */
    By batchNameRequired = By.xpath("//*[text()='Batch Name is required. ']");

    By batchNameExists = By.xpath("//*[text()='Batch already exists with given Batch Name. ']");

    By batchDescriptionMinRequired = By.xpath("//*[text()='This field should start with an alphabet and min 2 character.']");
    By batchDescriptionRequired = By.xpath("//*[text()='Batch Description is required.']");
    By programNameRequired = By.xpath("//*[text()='Program Name is required.']");
    By statusRequired = By.xpath("//*[text()='Status is required.']");
    By noOfClassesRequired = By.xpath("//*[text()='Number of classes is required.']");

    @FindBy(id = "program")
    WebElement programLink;
    @FindBy(id = "user")
    WebElement userLink;
    @FindBy(id = "logout")
    WebElement logoutLink;
    WebDriver driver;
    List<WebElement> rowCnt;

    public BatchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void validSearch(String searchString) {
        LoggerLoad.info(this.getClass().getName() + " Entering validSearch Method");
        filterGlobal.sendKeys(searchString);
    }

    public void createNewBatch() {
        LoggerLoad.info(this.getClass().getName() + " Entering createNewBatch Method");
        this.newBatch.click();
    }


    public String getGridTitle() {
        LoggerLoad.info(this.getClass().getName() + " Entering getGridTitle Method");
        return this.driver.findElement(manageBatchHeader).getText();
    }

    public String getPaginatorTitle() {
        LoggerLoad.info(this.getClass().getName() + " Entering getPaginatorTitle Method");
        return this.driver.findElement(paginator).getText();
    }

    public String getGridHeaders() {
        LoggerLoad.info(this.getClass().getName() + " Entering getGridHeaders Method");
        return this.driver.findElement(gridHeaders).getText();
    }

    public void deleteBatchAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            alert.accept();
            Assert.assertTrue(alert.getText().contains("deleted"));
        } catch (Exception e) {
            //exception handling
        }
    }

    public String getNewLabel() {
        LoggerLoad.info(this.getClass().getName() + " Entering getNewLabel Method");
        return this.newBatch.getText();
    }

    public boolean checkBoxStatus() {
        LoggerLoad.info(this.getClass().getName() + " Entering checkBoxStatus Method");
        return this.driver.findElement(checkbox).isEnabled();
    }

    public boolean editIconStatus() {
        LoggerLoad.info(this.getClass().getName() + " Entering editIconStatus Method");
        return this.driver.findElement(editIcon).isEnabled();
    }

    public boolean popUpValidation() {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpValidation Method");
        boolean status = (batchName.isDisplayed() && batchDescription.isDisplayed() && programName.isDisplayed()
                && batchStatus.isDisplayed() && batchNoOfClasses.isDisplayed()) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }


    public void addNewBatch(String name, String description, String pName, String stats, String noc) throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering addNewBatch Method");
        batchName.sendKeys(name);
        batchDescription.sendKeys(description);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(programButton));
        ele1.click();
        try {
            List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
            //roleStatusOptions = driver.findElements((By.xpath(//div[@role="button"])));
            for (WebElement roleStatus : roleStatusOptions) {
                //if (roleStatus.getText().equalsIgnoreCase(pName)) {
                roleStatus.click();
                break;
                //}
            }

        } catch (StaleElementReferenceException e) {
            List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
            for (WebElement roleStatus : roleStatusOptions) {
                if (roleStatus.getText().equalsIgnoreCase(pName)) {
                    roleStatus.click();
                    break;
                }
            }

        }
        LoggerLoad.info("status #### " + stats);
        if (stats.equalsIgnoreCase("true")) {
            driver.findElement(active).click();
        } else {
            driver.findElement(inActive).click();
        }
        batchNoOfClasses.sendKeys(noc);
        save();

    }

    public void save() {
        LoggerLoad.info(this.getClass().getName() + " Entering save Method");
        this.driver.findElement(submitBtn).click();
    }

    public void navigateToBatch() {
        LoggerLoad.info(this.getClass().getName() + " Entering navigateToBatch Method");
        batch.click();
    }

    public void cancelClick() {
        LoggerLoad.info("Cancelling the operation");
        this.driver.findElement(Cancelbutton).click();
    }

    public void addNewBatchClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering addNewBatchClick Method");
        newBatch.click();
    }

    public void searchDNDBatch() {
        LoggerLoad.info(this.getClass().getName() + " Entering searchDNDBatch Method");
        filterGlobal.sendKeys("DND");
        filterGlobal.click();
    }

    public void searchBatch(String batchName) throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering searchBatch Method");
        Thread.sleep(2000);
        filterGlobal.sendKeys(batchName);
    }

    public boolean popUpBatchValidation(String strBatchName, String strBatchDescription, String strNoOfClasses) throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpBatchValidation Method");
        searchBatch(strBatchName);
        this.driver.findElement(pencilIcon).click();
        Thread.sleep(1000);
        LoggerLoad.info(this.getClass().getName() + " - " + strBatchName + " - " + batchName.getText());
        LoggerLoad.info(this.getClass().getName() + " - " + strBatchDescription + " - " + batchName.getText());
        LoggerLoad.info(this.getClass().getName() + " - " + strNoOfClasses + " - " + batchNoOfClasses.getText());

        boolean status = (batchName.getText().equalsIgnoreCase(strBatchName) && batchDescription.getText().equalsIgnoreCase(strBatchDescription) && batchNoOfClasses.getText().equalsIgnoreCase(strNoOfClasses)) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }

    public void editBatchClick(String strBatchDescription, String noOfClasses) throws InterruptedException {
        Thread.sleep(1500);
        LoggerLoad.info(this.getClass().getName() + " Entering editBatchClick Method");
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchDescription.sendKeys("updated");
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
        Assert.assertEquals(strBatchDescription, batchDescription);
    }

    public void editBatchClick() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering editBatchClick Method");
        this.driver.findElement(pencilIcon).click();
    }

    public void editBatchClickAndClear() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering editBatchClickAndClear Method");
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchDescription.sendKeys("a");
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
        Thread.sleep(500);

    }


    public void editNoC() {
        this.driver.findElement(pencilIcon).click();
        batchNoOfClasses.sendKeys("");
        Assert.assertEquals("Number of classes is required.", validateNoOfClassesRequired());
        cancelClick();

    }

    public boolean popUpDNDValidation() {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpDNDValidation Method");
        boolean status = (batchDescription.getText() == "Sample Batch Updated" && batchNoOfClasses.getText() == "20") ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }

    public String validateBatchNameRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchNameRequired Method");
        return this.driver.findElement(batchNameRequired).getText();
    }

    public String validateBatchNameExists() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchNameExists Method");
        return this.driver.findElement(batchNameExists).getText();
    }

    public String validateBatchDescriptionMinRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchDescriptionMinRequired Method");
        return this.driver.findElement(batchDescriptionMinRequired).getText();
    }

    public String validateBatchDescriptionRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchDescriptionRequired Method");
        return this.driver.findElement(batchDescriptionRequired).getText();
    }

    public String validateProgramNameRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateProgramNameRequired Method");
        return this.driver.findElement(programNameRequired).getText();
    }

    public String validateStatusRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateStatusRequired Method");
        return this.driver.findElement(statusRequired).getText();
    }

    public String validateNoOfClassesRequired() {
        LoggerLoad.info(this.getClass().getName() + " Entering validateNoOfClassesRequired Method");
        return this.driver.findElement(noOfClassesRequired).getText();
    }

    public void DeleteClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteClick Method");
        driver.findElement(Deletebutton).click();
    }

    public boolean deleteYes() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteYes Method");
        return driver.findElement(deleteYes).isDisplayed();
    }

    public boolean deleteNo() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteNo Method");
        return driver.findElement(deleteNo).isDisplayed();
    }

    public boolean Deletemessage() {
        LoggerLoad.info(this.getClass().getName() + " Entering Deletemessage Method");
        return driver.findElement(Deletemessage).isDisplayed();
    }

    public void DeleteYesClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteYesClick Method");
        driver.findElement(deleteYes).click();
    }

    public void DeleteNoClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteNoClick Method");
        driver.findElement(deleteNo).click();
    }

    public void DeletePopupClose() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeletePopupClose Method");
        driver.findElement(DeletePopupClose).click();
    }

    public void selectAnyChkBox() {
        driver.findElement(By.xpath("//table//tbody/tr[1]/td[1]//p-tablecheckbox//div//div[2]")).click();
    }

    public void selectGlobalDeleteButton() {
        driver.findElement(By.xpath("//table//thead//tr//td//p-tablecheckbox//div//div[2]")).click();
    }

    public boolean isGlobalDeleteEnabled() {
        return driver.findElement(GlobalDelete).isEnabled();
    }

    public void globalDeleteClick() {
        driver.findElement(GlobalDelete).click();
        deleteYes();
    }

//Navigation to other page

    public void navigateToProgram() {
        LoggerLoad.info(this.getClass().getName() + " Entering navigateToProgram Method");
        programLink.click();
    }

    public void navigateToUser() {
        LoggerLoad.info(this.getClass().getName() + " Entering navigateToUser Method");
        userLink.click();
    }

    public void navigateToLogout() {
        LoggerLoad.info(this.getClass().getName() + " Entering navigateToLogout Method");
        logoutLink.click();
    }
}
