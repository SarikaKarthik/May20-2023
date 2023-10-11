package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.HomeWindow;
import pages.LoginPage;

public class VerifyForgotPassword {


	private WebDriver driver ;
	
	
	@Parameters("browser")
	@BeforeTest
	public void lauchBrowser (String browserName) {
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);	
		}
		
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		
		if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver-win64\\chromedriver-win64\\operadriver.exe");
			driver = new EdgeDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@BeforeMethod
	public void openAdminPage() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLoginButton();
		
		//driver.switchTo().alert().accept();
		
		HomeWindow homeWindow = new HomeWindow(driver);
		homeWindow.clickOnAdminButton();
		Thread.sleep(3000);
	}
	
	@Test
	public void toVerifySearchOnAdminPage_1101() {
		AdminPage adminPage = new AdminPage(driver);
		adminPage.enterUserNameForSearch("Admin");
		adminPage.selectRole();
		adminPage.enterEmployeeNameForSearch("Collings");
		adminPage.selectStatus();
		adminPage.clickOnSearchButton();
		
		
		// Validate username
		// Validate role
		// Validate Name
		
		String userName = adminPage.getUseNameFromResult();
		String role = adminPage.getUserRoleFomResult();
		
		
		Assert.assertEquals(userName, "Admin");
		Assert.assertEquals(role, "Admin");
		
	}
	
	@Test
	public void toVerifyDeleteFunctionalityOnAdminPage_12002() {
		AdminPage adminPage = new AdminPage(driver);
		adminPage.deleteTheRecord();
		adminPage.confirmToDelete();
		String userName = adminPage.getUseNameFromResult();
		
		if(userName.equals("Admin") )
		{
			System.out.println("Fail");
		}
		else
		{
			System.out.println("PASS");
		}
	}
	
	@AfterMethod
	public void logoutFromApplication() {
		HomeWindow homeWindow = new HomeWindow(driver);
		homeWindow.logout();	
	}
	
	@AfterTest
	public void closeBrower() {
		driver.quit();
	}
	
}
