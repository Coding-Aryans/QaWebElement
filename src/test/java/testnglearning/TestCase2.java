package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase2 {

	@Test
	public void dologin() {
		//System.out.println("user login test");
	Assert.fail("user login fail");
		
	}
	/*@Test(priority = 2)
	public void doXyz() {
		System.out.println("user login test");
		Assert.fail("user login fail");
	}

	@Test(priority = 3,dependsOnMethods = "doXyz")
	public void doreg() {
		System.out.println("user registration test");
	}
	@Test(priority = 4)
	public void isskip() {
		 throw new SkipException("Condition not meeting so its is skipping");
	}*/
}
