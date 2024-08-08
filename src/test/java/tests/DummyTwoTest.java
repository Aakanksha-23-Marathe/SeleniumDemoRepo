package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class DummyTwoTest extends Base {

	public WebDriver driver;

	@Test
	public void testTwo() throws InterruptedException {
		
		System.out.println("Karan has updated this code");
		System.out.println("Inside testTwo");

		driver = InitializeDriver();

		driver.get("https://maven.apache.org/");

		Thread.sleep(3000);

		driver.close();
	}
}
