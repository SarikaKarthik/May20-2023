package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver launchChrome() {
		
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserFiles\\chromeriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
	public static WebDriver launchFirefox() {

		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\BrowserFiles\\geckodriver.exe");

		WebDriver driver  = new FirefoxDriver();
		

		return driver ;
	}

	public static WebDriver launchEdge() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\BrowserFiles\\operadriver.exe");
		WebDriver driver  = new EdgeDriver();	
		return driver ;
	}

	public static WebDriver launchSafari() {
		System.setProperty("webdriver.safari.driver", "src\\test\\resources\\BrowserFiles\\safari.exe");
		WebDriver driver  = new SafariDriver();	
		return driver ;
	}
}
