package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath = "//input[@name='username']")
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[text()=' Login ']")
	private WebElement loginButton ;
	
	@FindBy (xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPasswordLink ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String userId)
	{
		userName.sendKeys(userId);	
	}
	
	public void enterPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}
}
