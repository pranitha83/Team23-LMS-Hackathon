package pageObjects;

import org.openqa.selenium.By;
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

    By dropdown = By.xpath("//*[@class='p-dropdown-trigger-icon ng-tns-c101-9 pi pi-chevron-down']");

    By pencilIcon = By.xpath("//*[@class='p-button-icon pi pi-pencil']");
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
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dropdown)));
        driver.findElement(dropdown).click();

//        public void selectDropDownUsingText(WebElement eleDropDown, String value) {
//            new Select(eleDropDown).selectByVisibleText(value);
//        }


        // Find the options within the dropdown
        List<WebElement> options = driver.findElements( By.xpath("//*[@role='option']"));


        // Iterate through the options and select the desired one by text
        for (WebElement option : options) {
            System.out.println("option.getText()---> " + option.getText());
            if (option.getText().equals(pName)) {
                option.click();
                break;
            }
        }
        if(stats=="TRUE") {
            active.click();
        } else{
            inactive.click();
        }
        batchNoOfClasses.sendKeys(noc);

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

}
