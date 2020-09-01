package Frameworkdesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyDrivenApproach {

	/*log4j.jar Api  download from maven
	 * Logger initilize
	 * Log4j.prorerties include in our project
	 * prorperties configrator
	 */
	
	public static WebDriver driver;
	public static Properties OR;
	public static Properties Config;
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger(KeyDrivenApproach.class.getName());

	public static void type(String locator, String value) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			
		} else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			
		}
		log.info("typing element"+locator+"enter value as"+value);
	}

	public static void click(String locator) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		log.info("click element"+locator);
	}

	public static void launchbrowser() {
             
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		if (Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome lanched successfully");
		} else if (Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox lanched successfully");
		}
		//driver.get(Config.getProperty("testsiteurl"));
		url();		
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("Implicit.wait")),
				//TimeUnit.SECONDS);
				Timeout();
	}
	public static void url() {
		driver.get(Config.getProperty("testsiteurl"));	
		log.info("test url is"+Config.getProperty("testsiteurl"));
	}
	public static void Timeout() {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("Implicit.wait")),
				TimeUnit.SECONDS);
	}
	public static void main(String[] args) throws IOException {
		 OR=new Properties();
		 Config=new Properties();
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		launchbrowser();
		type("username_CSS", "akshaykatoch008@gmail.com");
		click("signbutton_CSS");
		

	}

}
