package Frameworkdesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationForm {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(RegistrationForm.class.getSimpleName());

	public static void type(String locator, String value) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			log.info("type keyword is" + ":" + value);
		}
	}

	public static void select(String locator, String value) {
		if(locator.endsWith("_XPATH")) {
			  Select sel= new Select(driver.findElement(By.xpath(OR.getProperty(locator))));
		      sel.selectByVisibleText(value);
			log.info("type keyword is" + ":" + value);
		
	}}

	public static void click(String locator) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			log.info("successfully clcked....");
		}
	}

	public static void launchbrowser() {
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		if (Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome browser successfully launched....");
		}
		if (Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox successfully launched....");
		}
	}

	public static void testurl() {
		driver.get(Config.getProperty("testsiteurl"));
		log.info("site url" + ":" + Config.getProperty("testsiteurl"));
	}

	public static void testdown() {
		driver.quit();
		log.info("browser successfully closed... ");
	}

	public static void main(String[] args) throws IOException {
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		launchbrowser();
		testurl();
		type("email_XPATH", "akaha@gmail.com");
		type("name_XPATH", "akahay");
		select("select_XPATH", "Germany");
		click("signbutton_XPATH");
		testdown();

	}

}
