package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	@FindBy (xpath = "(//form[@class='oxd-form']//input)[1]")
	private WebElement userName ;
	
	@FindBy (xpath = "(//form[@class='oxd-form']//input)[2]")
	private WebElement employeeName ;
	
	@FindBy (xpath = "(//div[@class='oxd-select-text-input'])[1]")
	private WebElement role ;
	
	@FindBy (xpath = "(//div[@class='oxd-select-text-input'])[2]")
	private WebElement status ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//div[2]/div")
	private WebElement resultUserName ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//div[3]/div")
	private WebElement resultUserRole ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//div[4]/div")
	private WebElement resultEmployeeName ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//div[5]/div")
	private WebElement resultEmployeeStatus ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//button[1]")
	private WebElement deleteButton ;
	
	@FindBy (xpath = "(//div[@class='oxd-table']//div[@role='row'])[2]//button[2]")
	private WebElement editButton ;
	
	@FindBy (xpath = "//button[text()=' Search ']")
	private WebElement searchButton ;
	
	@FindBy (xpath = "//button[text()=' Yes, Delete ']")
	private WebElement confirmDelete ;
	
	
	
	public AdminPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void confirmToDelete() {
		confirmDelete.click();
	}
	
	public void enterUserNameForSearch(String userNameForSearch) {
		userName.sendKeys(userNameForSearch);;
	}
	
	public void enterEmployeeNameForSearch(String name) {
		employeeName.sendKeys(name);
	}
	
	public void selectRole() {
		role.sendKeys("Admin");
	}
	
	public void selectStatus() {
		status.sendKeys("Enabled");
	}
	
	public String getUseNameFromResult() {
		return resultUserName.getText();
	}
	
	public String getUserRoleFomResult() {
		return resultUserRole.getText();
	}
	
	public void deleteTheRecord() {
		deleteButton.click();
	}
}
