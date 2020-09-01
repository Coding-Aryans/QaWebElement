package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

	public static void main(String[] args) {

		
		WebDriverManager.firefoxdriver().setup();

		FirefoxDriver driver = new FirefoxDriver();

		driver.get("https://qa.way2automation.com");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[3]/input")).sendKeys("op@hotmail.com");
		driver.findElement(By.xpath("//div[@id='load_box']/form/fieldset[1]/input")).sendKeys("dhai");
		driver.findElement(By.xpath("//div[@id='load_box']/form/fieldset[2]/input")).sendKeys("48383234200");

		// driver.findElement(By.xpath("//div[@id='load_box']/fieldset[4]/input"))
		Select contry = new Select(driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
		contry.selectByVisibleText("Germany");
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[5]/input")).sendKeys("delhi");
		WebElement user = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input"));
		user.sendKeys("sidhahah");

		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).sendKeys("sybusjnw");
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		/*
		 * Explicit wait ************************when element is present but not
		 * interceptable WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//div[@id='load_box']//input[@class='button']")));
		 */

		driver.findElement(By.xpath("//*[@id='load_box']/form/div/div[2]/input")).click();
		// (//div[@id='load_box']//input[@class='button'])
		// driver.close();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"alert\"]")).getText());

	}

}
