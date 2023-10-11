package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utlis.Utility;
import base.Browser;
import pages.AdminPage;
import pages.HomeWindow;
import pages.LoginPage;

public class  VerifyAdminPage extends Browser{

	private WebDriver driver ;
	
	private LoginPage loginPage ;
	private HomeWindow homeWindow ;
	private AdminPage adminPage ;
	private String testID ;
	
	@Parameters("browser")
	@BeforeTest
	public void lauchBrowser (String browserName) {
		
		
		if(browserName.equals("Chrome"))
		{
			driver = launchChrome() ;
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = launchFirefox();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = launchEdge();	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
	}
	
	@BeforeClass
	public void creatingPOMObject() {
		loginPage = new LoginPage(driver);
		homeWindow = new HomeWindow(driver);
		adminPage = new AdminPage(driver);
	}
	
	@BeforeMethod
	public void openAdminPage() throws InterruptedException {
		driver.get("www.lolipo-WhatsApp.com");
		//Thread.sleep(3000);
		
		String userName = Utility.getDataFromExcelSheet("src\\test\\resources\\DataResource\\ProjectTestData.xlsx", "Credentials", 2, 0) ;
		loginPage.enterUserName(userName);
		
		String pasword = Utility.getDataFromExcelSheet("src\\test\\resources\\DataResource\\ProjectTestData.xlsx", "Credentials", 2, 1) ;
		
		loginPage.enterPassword(pasword);
		
		loginPage.clickOnLoginButton();
		
		//driver.switchTo().alert().accept();
		homeWindow.clickOnAdminButton();
		
			
		Thread.sleep(3000);
	}

	@Test (groups = {"High Priority"})
	public void toVerifySearchOnAdminPage_1101() {
		testID = "T101";
		
		adminPage.enterUserNameForSearch("Admin");
		adminPage.selectRole();
		adminPage.enterEmployeeNameForSearch("Collings");
		adminPage.selectStatus();
		adminPage.clickOnSearchButton();
		String verify = "" ;
		
		
		// Positive scnerio verify
		if(verify.equals("Positive")) {
			// Home page verify
		}
		// Negative scneario 
		if(verify.equals("Negative")) {
			// Error message
		}
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
		
		testID = "T102"; 
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
	
	@Test
	public void toVerifyDeleteFunctionalityOnAdminPage_12003() {
		testID = "T201";
		
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
	// How to capture the screenshot of failed test method/case
	// Ans - using testng listner 
	//       We have use ITestResult
	@AfterMethod
	public void logoutFromApplication(ITestResult result) {
		homeWindow.logout();	
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScrenshot(testID);
		}
	}
	// TestNg Listeners -> Used to maintain the status of test method
	// ITestResult
	// IReporter
	// ITestListener
	
	// Ex. ->
	// Number -> 100 200 300 -> Pass Fail Skip
	// Text ->  Pass Fail Skip
	
	@AfterClass
	public void clearObject() {
		loginPage = null;
		homeWindow = null;
		adminPage = null ;
	}
	
	@AfterTest
	public void closeBrower() {
		driver.quit();
		driver = null ;
		System.gc(); // Garbed collector 
	}
	
}
