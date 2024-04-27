package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchPage {

    @FindBy ( id = "batch") WebElement batch;

    @FindBy (id = "new")  WebElement newBatch;

    @FindBy (id = "edit")  WebElement editBatch;

    @FindBy (id = "filterGlobal") WebElement filterGlobal;

    /*
    Below elements will be used for New Batch creation
    and also for updating batch information
     */
    @FindBy (id = "batchName") WebElement batchName;

    @FindBy (id = "batchDescription") WebElement batchDescription;

    @FindBy (id = "programName") WebElement programName;

    @FindBy (id = "batchStatus") WebElement batchStatus;

    @FindBy (id = "batchNoOfClasses") WebElement batchNoOfClasses;

    //TODO
    //SAVE and CANCEL buttons
    By Cancelbutton =By.xpath("//*[text()='Cancel']");

    By saveButton =By.xpath("//*[text()='Save']");

    By popUpClose = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c132-8 pi pi-times']");

    By manageBatchHeader = By.xpath("//*[@class='mat-card-title']");
    WebDriver driver;


    public BatchPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void validSearch(String searchString){
        filterGlobal.sendKeys(searchString);
    }

    public void createNewBatch(){
        this.newBatch.click();
    }

    public String getGridTitle() {
        return this.driver.findElement(manageBatchHeader).getText();
    }

    public void addNewBatch(String batchName, String batchDescription, String programName, boolean active, String batchNoOfClasses){
        this.batchName.sendKeys("batchName");
        this.batchDescription.sendKeys("batchDescription");
        this.programName.sendKeys("programName");
        this.batchStatus.sendKeys("active");
        this.batchNoOfClasses.sendKeys("batchNoOfClasses");

    }

    public void navigateToBatch(){
        this.batch.click();
    }

    public void addNewBatchClick(){
        //this.addNewBatch.click();
    }

    public void editBatchClick(){
        //this.editBatch.click();
    }

}
