package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver launchChrome() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		return driver ;
	}
	
	public static WebDriver launchFirefox() {

		System.setProperty("webdriver.gecko1234.driver", "src\\test\\resources\\BrowserFiles\\geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		System.setProperty("webdriver.gecko1234.driver", "src\\test\\resources\\BrowserFiles\\geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		System.setProperty("webdriver.gecko1234.driver", "src\\test\\resources\\BrowserFiles\\geckodriver.exe");
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
