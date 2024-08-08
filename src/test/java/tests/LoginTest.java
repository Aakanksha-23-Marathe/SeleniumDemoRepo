package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	Logger log;
	
	public WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	AccountPage accountpage;

	@BeforeMethod
	public void setup() {
		
		log = LogManager.getLogger(LoginTest.class.getClass());

		driver = InitializeDriver();
		log.debug("Broswer got open");

		driver.get(prop.getProperty("url"));
		log.debug("Url opened in browser");


	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String pwd, String expectedStatus) throws InterruptedException {

		
		landingpage = new LandingPage(driver);
		loginpage = new LoginPage(driver);
		accountpage = new AccountPage(driver);

		landingpage.myAccountDropdown().click();
		log.debug("Click on myaccount dropdown");
		
		landingpage.loginOption().click();
		log.debug("Click on login button");


		loginpage.emailInputField().sendKeys(email);
		log.debug("Email got entered");

		loginpage.pwdInputField().sendKeys(pwd);
		log.debug("Password got entered");

		loginpage.loginButton().click();
		log.debug("Click on login button");


		String actualResult = null;
		try {
			if (accountpage.Edit_your_account_information_Text().isDisplayed()) {
				actualResult = "Successfull";
				log.debug("User got Logged in");

			}
		} catch (Exception e) {

			actualResult = "Failure";
			log.debug("User didn't Logged in");

		}

		Thread.sleep(3000);
		Assert.assertEquals(actualResult, expectedStatus);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		log.debug("Browser got closed");

	}

	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "abd@yopmail.com";
		data[0][1] = "abc@123";
		data[0][2] = "Failure";

		data[1][0] = "aaku@yopmail.com";
		data[1][1] = "abc@123";
		data[1][2] = "Successfull";

		return data;

	}

}
