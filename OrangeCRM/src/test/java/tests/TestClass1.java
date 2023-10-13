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

public class TestClass1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite TestClass");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test TestClass");
	}
			
	@BeforeClass
	public void beforeClass () {
		System.out.println("Before Class TestClass");
		System.out.println("Before Class TestClass123");
	}
	
	@BeforeMethod
	public void beforeMethod()  {
		System.out.println("Before Method TestClass");
	}
	
	@Test (groups = {"High Priority", "Sanity"})
	public void test2() {
		System.out.println("Test 2 TestClass");
		//Assert.fail();
			
	}
	
	@Test (groups = "High Priority")
	public void test3() throws InterruptedException {
		System.out.println("Test 3 TestClass");
	}
	
	@Test (groups = "Low Priority")
	public void test1() throws InterruptedException {
		System.out.println("Test 1 TestClass");
	}
	
	@Test (groups = "Low Priority")
	public void test4() throws InterruptedException {
		System.out.println("Test 4 TestClass");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method TestClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class TestClass");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test TestClass");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite TestClass");
	}

}
