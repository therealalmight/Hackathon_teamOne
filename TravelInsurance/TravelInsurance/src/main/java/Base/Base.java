package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public void driverSetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Config/config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			driver = new ChromeDriver(); // Initializing the new chrome driver
		}
		if (prop.getProperty("browserName").matches("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"geckodriver.exe");
			driver = new FirefoxDriver(); // Initializing the new firefox driver
		}
		driver.manage().window().maximize(); // To maximize the window
		driver.manage().timeouts().getPageLoadTimeout();  // Waiting time to page the load completely
		driver.manage().timeouts().getImplicitWaitTimeout(); 
	    // Adding driver waits to timeouts

	}

	public void openUrl() // Method to open URL for smoke test
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}

	// Function to Put Wait
	public void wait(Duration sec, By locator) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void closeBrowser() // method to close the browser
	{
		driver.quit(); // To close the browser
		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
		} catch (Exception e) {
		} 
	}

}
