package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    //Delete Program


    By Deletebutton= By.xpath("//*[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
    By DeleteYes = By.xpath("//*[text()='Yes']");
    By DeleteNo = By.xpath("//*[text()='No']");
    By Deletemessage = By.xpath("//*[@class='p-confirm-dialog-message ng-tns-c133-4']");
    By DeletePopupClose = By.xpath("//*[@class='pi pi-times ng-tns-c133-4']");

    By programNameText = By.xpath("//*[@class='p-dropdown-label p-inputtext ng-tns-c101-30 ng-star-inserted']");

    /*
    validation items
     */
    By batchNameRequired = By.xpath("//*[text()='Batch Name is required. ']");
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
        LoggerLoad.info(this.getClass().getName() + " Entering validSearch Method" );
        filterGlobal.sendKeys(searchString);
    }

    public void createNewBatch() {
        LoggerLoad.info(this.getClass().getName() + " Entering createNewBatch Method" );
        this.newBatch.click();
    }


    public String getGridTitle() {
        LoggerLoad.info(this.getClass().getName() + " Entering getGridTitle Method" );
        return this.driver.findElement(manageBatchHeader).getText();
    }

    public String getPaginatorTitle() {
        LoggerLoad.info(this.getClass().getName() + " Entering getPaginatorTitle Method" );
        return this.driver.findElement(paginator).getText();
    }

    public String getGridHeaders() {
        LoggerLoad.info(this.getClass().getName() + " Entering getGridHeaders Method" );
        return this.driver.findElement(gridHeaders).getText();
    }

    public String getNewLabel() {
        LoggerLoad.info(this.getClass().getName() + " Entering getNewLabel Method" );
        return this.newBatch.getText();
    }

    public boolean checkBoxStatus() {
        LoggerLoad.info(this.getClass().getName() + " Entering checkBoxStatus Method" );
        return this.driver.findElement(checkbox).isEnabled();
    }

    public boolean editIconStatus() {
        LoggerLoad.info(this.getClass().getName() + " Entering editIconStatus Method" );
        return this.driver.findElement(editIcon).isEnabled();
    }

    public boolean popUpValidation() {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpValidation Method" );
        boolean status = (batchName.isDisplayed() && batchDescription.isDisplayed() && programName.isDisplayed()
                && batchStatus.isDisplayed() && batchNoOfClasses.isDisplayed()) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }





    public void addNewBatch(String name, String description, String pName, String stats, String noc) throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering addNewBatch Method" );
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
        if(stats.equalsIgnoreCase("true")) {
            driver.findElement(active).click();
        } else{
            driver.findElement(inActive).click();
        }
        batchNoOfClasses.sendKeys(noc);
        this.driver.findElement(saveButton).click();

    }

    public void save(){
        LoggerLoad.info(this.getClass().getName() + " Entering save Method" );
        this.driver.findElement(submitBtn).click();
    }

    public void navigateToBatch() {
        LoggerLoad.info(this.getClass().getName() + " Entering navigateToBatch Method" );
        batch.click();
    }

    public void addNewBatchClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering addNewBatchClick Method" );
        newBatch.click();
    }

    public void searchDNDBatch(){
        LoggerLoad.info(this.getClass().getName() + " Entering searchDNDBatch Method" );
        filterGlobal.sendKeys("DND");
        filterGlobal.click();
    }

    public void searchBatch(String batchName){
        LoggerLoad.info(this.getClass().getName() + " Entering searchBatch Method" );
        filterGlobal.sendKeys(batchName);
        filterGlobal.click();
    }

    public boolean popUpBatchValidation(String strBatchName, String strBatchDescription, String strNoOfClasses) {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpBatchValidation Method" );
        searchBatch(strBatchName);
        this.driver.findElement(pencilIcon).click();
        LoggerLoad.info(this.getClass().getName() + " - " +  strBatchName + " - " +batchDescription.getText());
        LoggerLoad.info(this.getClass().getName() + " - " + strBatchDescription+ " - " + batchName.getText());
        LoggerLoad.info(this.getClass().getName() + " - " + strNoOfClasses+ " - " +batchNoOfClasses.getText());

        boolean status = (batchName.getText().equalsIgnoreCase(strBatchName)  && batchDescription.getText().equalsIgnoreCase(strBatchDescription) && batchNoOfClasses.getText().equalsIgnoreCase(strNoOfClasses) ) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }

    public void editBatchClick(String strBatchDescription, String noOfClasses) throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering editBatchClick Method" );
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchNoOfClasses.clear();
        Thread.sleep(500);
        batchDescription.sendKeys(strBatchDescription);
        batchNoOfClasses.sendKeys(noOfClasses);
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
    }

    public void editBatchClickAndClear() throws InterruptedException {
        LoggerLoad.info(this.getClass().getName() + " Entering editBatchClickAndClear Method" );
        this.driver.findElement(pencilIcon).click();
        batchDescription.clear();
        batchNoOfClasses.clear();
        Thread.sleep(1000);
        this.driver.findElement(saveButton).click();
        Thread.sleep(500);
    }

    public boolean popUpDNDValidation() {
        LoggerLoad.info(this.getClass().getName() + " Entering popUpDNDValidation Method" );
        boolean status = (batchDescription.getText()=="Sample Batch Updated" && batchNoOfClasses.getText()=="20" ) ? Boolean.TRUE : Boolean.FALSE;
        return status;
    }

    public String validateBatchNameRequired(){
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchNameRequired Method" );
        return this.driver.findElement(batchNameRequired).getText();
    }

    public String validateBatchDescriptionRequired(){
        LoggerLoad.info(this.getClass().getName() + " Entering validateBatchDescriptionRequired Method" );
        return this.driver.findElement(batchDescriptionRequired).getText();
    }

    public String validateProgramNameRequired(){
        LoggerLoad.info(this.getClass().getName() + " Entering validateProgramNameRequired Method" );
        return this.driver.findElement(programNameRequired).getText();
    }

    public String validateStatusRequired(){
        LoggerLoad.info(this.getClass().getName() + " Entering validateStatusRequired Method" );
        return this.driver.findElement(statusRequired).getText();
    }
    public String validateNoOfClassesRequired(){
        LoggerLoad.info(this.getClass().getName() + " Entering validateNoOfClassesRequired Method" );
        return this.driver.findElement(noOfClassesRequired).getText();
    }
    public void DeleteClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteClick Method" );
        driver.findElement(Deletebutton).click();
    }
    public boolean DeleteYes() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteYes Method" );
        return driver.findElement( DeleteYes).isDisplayed();
    }

    public boolean DeleteNo() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteNo Method" );
        return driver.findElement(DeleteNo).isDisplayed();
    }
    public  boolean Deletemessage() {
        LoggerLoad.info(this.getClass().getName() + " Entering Deletemessage Method" );
        return driver.findElement(Deletemessage).isDisplayed();
    }
    public void DeleteYesClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteYesClick Method" );
        driver.findElement( DeleteYes).click();
    }
    public void DeleteNoClick() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeleteNoClick Method" );
        driver.findElement(DeleteNo).click();
    }
    public void DeletePopupClose() {
        LoggerLoad.info(this.getClass().getName() + " Entering DeletePopupClose Method" );
        driver.findElement(DeletePopupClose).click();
    }


}
