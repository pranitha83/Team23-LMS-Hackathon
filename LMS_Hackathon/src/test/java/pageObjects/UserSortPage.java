package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSortPage {
	WebDriver driver;
	
//	@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i
	@FindBy(xpath ="//div[@class='box']") WebElement manageUserText;
	//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
	//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
	//@FindBy(xpath ="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']") WebElement sortById;
	public UserSortPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void manageUser() {
		
		String actualManageUserText=manageUserText.getText();
		System.out.println("Manage User:"+actualManageUserText);
	}
public void sortById() {
		
	//sortById.click();
	}
}
