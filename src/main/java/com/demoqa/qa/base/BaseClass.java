package com.demoqa.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demoqa.qa.utils.Utilities;


public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		try {
			prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/demoqa/qa/config/config.properties");
		prop.load(fis);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			
		} else if (browser.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();
			
		} else {
			System.err.println("Enter valid browser name from Chrome, Edge or Firefox");
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		
		
	}
}
