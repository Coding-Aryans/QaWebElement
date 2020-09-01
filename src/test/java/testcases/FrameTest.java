package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/jsref/dom_obj_submit.asp");

		Set<String> winids = driver.getWindowHandles();
		Iterator<String> itrate = winids.iterator();

		String first_window = itrate.next();

		System.out.println(first_window);
		// String secoondWin=winval.next();
		// System.out.println(secoondWin);

		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/a")).click();

		winids = driver.getWindowHandles();
		itrate = winids.iterator();

		System.out.println(itrate.next()); // first
		String second_window = itrate.next(); // second
		System.out.println(second_window);

		driver.switchTo().window(second_window);
		System.out.println(driver.getCurrentUrl());

		
		driver.switchTo().frame("iframeResult");

		//driver.findElement(By.xpath("/html/body/button")).click();
		
		driver.switchTo().defaultContent();
		
		List<WebElement>frameVal=driver.findElements(By.tagName("iframe"));
		System.out.println(frameVal.size());
		for(WebElement TotalFrame:frameVal) {
			System.out.println(TotalFrame.getAttribute("id"));	
		}
	
	
		

	}

}
