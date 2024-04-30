package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    @FindBy(id = "ACTIVE")
    WebElement active;


    @FindBy(id = "INACTIVE")
    WebElement inactive;

    @FindBy(id = "batchNoOfClasses")
    WebElement batchNoOfClasses;
    //TODO
    //SAVE and CANCEL buttons
    By Cancelbutton = By.xpath("//*[text()='Cancel']");
    By saveButton = By.xpath("//*[text()='Save']");
    By popUpClose = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c132-8 pi pi-times']");
    By manageBatchHeader = By.xpath("//*[@class='mat-card-title']");
    By paginator = By.xpath("//*[@class='p-paginator-current ng-star-inserted']");
    By gridHeaders = By.xpath("//*[@class='p-datatable-wrapper ng-star-inserted']");
    By checkbox = By.xpath("//*[@role='checkbox']");
    By editIcon = By.xpath("//*[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']");

    By programDropDown = By.id("programName");

    By programOptionsDropdown = By.xpath("//li[@role='option']");



    By pencilIcon = By.xpath("//*[@class='p-button-icon pi pi-pencil']");


    //Delete Program
    By Deletebutton= By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr[1]/td[5]/div/span/button[2]/span[1]");
    By DeleteYes = By.xpath("//*[text()='Yes']");
    By DeleteNo = By.xpath("//*[text()='No']");
    By Deletemessage = By.xpath("//*[@class='p-confirm-dialog-message ng-tns-c133-4']");
    By DeletePopupClose = By.xpath("//*[@class='pi pi-times ng-tns-c133-4']");

    By programNameText = By.xpath("//*[@class='p-dropdown-label p-inputtext ng-tns-c101-30 ng-star-inserted']");

    /*
    validation items
     */
    By batchNameRequired = By.xpath("//*[text()='Batch Name is required.']");
    By batchDescriptionRequired = By.xpath("//*[text()='Batch Description is required.']");
    By programNameRequired = By.xpath("//*[text()='Program Name is required.']");
    By statusRequired = By.xpath("//*[text()='Status is required.']");
    By noOfClassesRequired = By.xpath("//*[text()='Number of classes is required.']");

    //
    //
    //p-button-rounded p-button-success p-button p-component p-button-icon-only
    //By deleteIcon = By.xpath("//*[text()='disabled']");

    //By delete = By.xpath("//*button[contains(@disabled p-button-danger p-button p-component p-button-icon-only)]");


    WebDriver driver;


    public BatchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void validSearch(String searchString) {
        filterGlobal.sendKeys(searchString);
    }

    public void createNewBatch() {
        this.newBatch.click();
    }


    public String getGridTitle() {
        return this.driver.findElement(manageBatchHeader).getText();
    }

    public String getPaginatorTitle() {
        return this.driver.findElement(paginator).getText();
    }

    public String getGridHeaders() {
        return this.driver.findElement(gridHeaders).getText();
    }

    public String getNewLabel() {
        return this.newBatch.getText();
    }

    public boolean checkBoxStatus() {
        return this.driver.findElement(checkbox).isEnabled();
    }

    public boolean editIconStatus() {
        return this.driver.findElement(editIcon).isEnabled();
    }

    public boolean popUpValidation() {
        boolean status = (batchName.isDisplayed() && batchDescription.isDisplayed() && programName.isDisplayed()
                && batchStatus.isDisplayed() && batchNoOfClasses.isDisplayed()) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }





    public void addNewBatch(String name, String description, String pName, String stats, String noc) throws InterruptedException {
        batchName.sendKeys(name);
        batchDescription.sendKeys(description);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(programDropDown));
        ele1.click();
    /*    try {
            List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
            roleStatusOptions = driver.findElements((By.xpath()//div[@role="button"])));
            for (WebElement roleStatus : roleStatusOptions) {
                if (roleStatus.getText().equalsIgnoreCase(pName)) {
                    roleStatus.click();
                    break;
                }
            }

        } catch (StaleElementReferenceException e) {
            List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
            for (WebElement roleStatus : roleStatusOptions) {
                if (roleStatus.getText().equalsIgnoreCase(pName)) {
                    roleStatus.click();
                    break;
                }
            }

        }*/

        if(stats=="TRUE") {
            active.click();
        } else{
            inactive.click();
        }
        batchNoOfClasses.sendKeys(noc);

    }

    public void save(){

        this.driver.findElement(saveButton).click();
    }

    public void navigateToBatch() {
        batch.click();
    }

    public void addNewBatchClick() {
        newBatch.click();
    }

    public void searchDNDBatch(){
        filterGlobal.sendKeys("DND");
        filterGlobal.click();
    }

    public void editBatchClick() throws InterruptedException {
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchNoOfClasses.clear();
        Thread.sleep(500);
        batchDescription.sendKeys("Sample Batch Updated 1");
        batchNoOfClasses.sendKeys("200");
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
    }

    public void editBatchClickAndClear() throws InterruptedException {
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchNoOfClasses.clear();
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
        Thread.sleep(500);
    }

    public boolean popUpDNDValidation() {
        boolean status = (batchDescription.getText()=="Sample Batch Updated" && batchNoOfClasses.getText()=="20" ) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }

    public String validateBatchNameRequired(){
        return batchName.getText();
    }

    public String validateBatchDescriptionRequired(){
        return this.driver.findElement(batchDescriptionRequired).getText();
    }

    public String validateProgramNameRequired(){
        return this.driver.findElement(programNameRequired).getText();
    }

    public String validateStatusRequired(){
        return this.driver.findElement(statusRequired).getText();
    }
    public String validateNoOfClassesRequired(){
        return this.driver.findElement(noOfClassesRequired).getText();
    }
    public void DeleteClick() {
        driver.findElement(Deletebutton).click();
    }
    public boolean DeleteYes() {
        return driver.findElement( DeleteYes).isDisplayed();
    }

    public boolean DeleteNo() {
        return driver.findElement(DeleteNo).isDisplayed();
    }
    public  boolean Deletemessage() {
        return driver.findElement(Deletemessage).isDisplayed();
    }
    public void DeleteYesClick() {
        driver.findElement( DeleteYes).click();
    }
    public void DeleteNoClick() {
        driver.findElement(DeleteNo).click();
    }
    public void DeletePopupClose() {
        driver.findElement(DeletePopupClose).click();
    }

}
