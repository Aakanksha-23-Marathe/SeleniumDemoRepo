package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class DummyThreeTest extends Base {
	public WebDriver driver;
	
	@Test
	public void testThree() throws InterruptedException {
        System.out.println("Krish has changed in github");
        System.out.println("Krish has changed in github");

		System.out.println("Inside testThree");

		driver = InitializeDriver();

		driver.get("https://maven.apache.org/");

		Assert.assertTrue(false);

		driver.close();
	}
}
