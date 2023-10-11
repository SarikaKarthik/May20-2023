package tests;

	import java.time.Duration;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	import pages.AdminPage;
	import pages.HomeWindow;
	import pages.LoginPage;

	public class TestClass2 {
		
		@BeforeSuite
		public void beforeSuite() {
			System.out.println("Before Suite TestClass222");
		}
		
		@BeforeTest
		public void beforeTest() {
			System.out.println("Before Test TestClass222");
		}
		@BeforeClass
		public void beforeClass () {
			System.out.println("Before Class TestClass222");
		}
		
		@BeforeMethod
		public void beforeMethod()  {
			System.out.println("Before Method TestClass222");
		}
		
		@Test (groups = {"High Priority", "Sanity"})
		public void test1() {
			System.out.println("Test A TestClass222");
				
		}
		
		@Test (groups = {"Low Priority", "Sanity"})
		public void test3() throws InterruptedException {
			System.out.println("Test C TestClass222");
			//Assert.fail();
		}
		
		@Test (groups = {"Sanity"})
		public void test2() {
			System.out.println("Test B TestClass222");
			//Assert.fail();
				
		}
		
		@Test 
		public void test4() throws InterruptedException {
			System.out.println("Test D TestClass222");
		}

		@AfterMethod
		public void afterMethod() {
			System.out.println("After Method TestClass222");
		}
		
		@AfterClass
		public void afterClass() {
			System.out.println("After Class TestClass222");
		}

		@AfterTest
		public void afterTest() {
			System.out.println("After Test TestClass222");
		}
		
		@AfterSuite
		public void afterSuite() {
			System.out.println("After Suite TestClass222");
		}
	}