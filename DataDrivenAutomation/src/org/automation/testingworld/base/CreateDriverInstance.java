package org.automation.testingworld.base;

import java.io.IOException;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateDriverInstance {
	public WebDriver driver;
	@BeforeMethod
	public void InstantiateDriver() throws IOException
 {

		if (Utility.fetchProperty("browser").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("web.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Utility.fetchProperty("browser").toString().equalsIgnoreCase("firefox")) {
			System.setProperty("web.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("web.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(Utility.fetchProperty("url").toString());
	}
	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}
}
