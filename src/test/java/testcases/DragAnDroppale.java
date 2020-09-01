package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAnDroppale {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/*
		 * DRAG AND DROP ELEMENT OVER ANOTHER ELEMENT OR ANY PLACE IT ON PAAGE
		 * 
		 */

		// driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * WebElement draggable = driver.findElement(By.id("draggable")); //WebElement
		 * droppable = driver.findElement(By.id("droppable"));
		 * 
		 * //new Actions(driver).dragAndDrop(draggable, droppable).perform(); new
		 * Actions(driver).dragAndDropBy(draggable, 1000, 500).perform();
		 */

		/*
		 * RIGHT CLICK ON SUBMENU LINK:https://deluxe-menu.com/popup-mode-sample.html
		 * 
		 * 
		 */

		WebElement img = driver
				.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));

		Actions a = new Actions(driver);
		a.contextClick(img).perform();
		WebElement prodctinfo = driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]"));

		a.moveToElement(prodctinfo).perform();

		WebElement installations = driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]"));
		a.moveToElement(installations).perform();

		WebElement setup = driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"));
		a.moveToElement(setup).click().perform();

	}

}
