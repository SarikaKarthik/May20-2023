package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWindow {

	@FindBy (xpath = "//ul[@class=\"oxd-main-menu\"]//li[1]//a")
	private WebElement adminButton ;
	
	@FindBy (xpath = "//ul[@class=\"oxd-main-menu\"]//li[2]//a")
	private WebElement pimButton ;
	
	@FindBy (xpath = "//div[@class='oxd-topbar-header']//li//i")
	private WebElement profile ;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logoutOption ;
	
	private WebDriver driver ;
	
	public HomeWindow(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnAdminButton() {
		adminButton.click();
	}
	
	public void clickOnPIMButton() {
		pimButton.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(profile).moveToElement(logoutOption).click().build().perform();
	}
}
