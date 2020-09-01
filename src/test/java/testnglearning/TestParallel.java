package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParallel {

	public static WebDriver driver;
	
	
	@BeforeMethod
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(dataProvider = "getdata")
	public void dologin(String username, String password) {
		//Date d = new Date();
		//System.out.println("username :" + username + " and " + "password:" + password);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@DataProvider
	public Object[][] getdata() {

		String sheetName = "logintest";
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		int row = excel.getRowCount(sheetName);//3
		int col = excel.getColumnCount(sheetName);//2
		Object[][] data = new Object[row-1][col]; //2 2
		//System.out.println(row);
		for(int r=2;r<=row;r++) {
			for(int c=0;c<col;c++) {
				data[r-2][c]=excel.getCellData(sheetName, c, r); 
			}
		}
		
		return data;
	}
}
	
//	@Parameters({"browser","url"})
	
	
	
