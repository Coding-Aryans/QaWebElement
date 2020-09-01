package testcases;


import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowResize {

	public static WebDriver driver;

	public static void WinResize(int width, int height) {
		for (; width < 1024; width++) {
			Dimension d = new Dimension(width, height);
			driver.manage().window().setSize(d);
			height++;
		}
	}

	public static void PixelManage(int x,int y) {
		
		Point p=new Point(x,y);
		//System.out.println("x:"+x+" "+"y:"+y);
		driver.manage().window().setPosition(p);
	}
	
	
	public static void WinMove() {
		int lastXPint=0;
		int lastYPint=0;
		Dimension d = new Dimension(200, 0);
		driver.manage().window().setSize(d);
		for(int x=0,y=0;x<380;x=x+5,y=y+5) {
			PixelManage(x,y);
		 lastXPint=x;
		lastYPint=y;
	}
	
		
		for(int y=375;y>0;y=y-5) {
			PixelManage(lastXPint,y);
			lastYPint=y;
		}
		for(int x=375;x>0;x=x-5) {
			PixelManage(x,lastYPint);
		}
		if ( lastYPint==5 ) {
			WinMove();
		}
		
		
	}
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	WinResize(500, 180);
	//	WinMove();	
	}

}
