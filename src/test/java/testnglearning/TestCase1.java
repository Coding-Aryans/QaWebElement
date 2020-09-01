package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	
	public static WebDriver driver;
@Test
	public void AA() {
		System.out.println("start");
	}
	@Test
	public void BB() {
		System.out.println("Beginging");
	//	String actual="gmail.com";
	//	String expected="yahoo.com";
		/*if(actual.equals(expected)) {
			System.out.println("Test pass");
		}
		else {
			System.out.println("Test fail");
		}*/
		//Assert.assertEquals(actual, expected);
		//Assert.fail();
		//Assert.assertTrue(false, "not presernt");
	/*	SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actual, expected);
		
		System.out.println("ending");
		softassert.assertAll();*/
	}
	@Test
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("www.facebook.com");
	}
	
	@Test
	
	public void ZZ() {
		System.out.println("zzEndng");
	}

}
