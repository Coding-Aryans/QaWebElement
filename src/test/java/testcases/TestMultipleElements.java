package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMultipleElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("Eesti");

		/*
		 * Select dropdown=new Select(driver.findElement(By.xpath("//select")));
		 * dropdown.selectByVisibleText("Cheese"); dropdown.selectByValue("Cheese");
		 */

		System.out.println("----TOTAL VALUES IN DROPDOWN AND ALL VALUES-------");
		List<WebElement> dropdown = driver.findElements(By.tagName("option"));
		System.out.println(dropdown.size());
		for (WebElement dropvales : dropdown) {
			System.out.println(dropvales.getText());
		}

		// System.out.println(dropdown.get(1).get);

		System.out.println("----Total Links on Page-------");

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		for (WebElement Link : Links)
			System.out.println(Link.getText());

		System.out.println("----Count one section elements Only on Page-------");

		WebElement mainblock = driver.findElement(By.xpath("//div[11]/div[3]"));
		List<WebElement> alLinks = mainblock.findElements(By.xpath("//div[11]//div[3]//span[1]"));
		System.out.println(alLinks.size());

		for (WebElement allLink : alLinks) {

			System.out.println(allLink.getText());

		}
		// System.out.println(cont);
		driver.close();

	}
	// *[@id="searchLanguage"]
}
