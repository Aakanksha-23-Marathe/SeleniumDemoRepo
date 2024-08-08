package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement pwdInputField;

	@FindBy(css = "input[value=\"Login\"]")
	private WebElement loginButton;

	public WebElement emailInputField() {
		return emailInputField;
	}

	public WebElement pwdInputField() {
		return pwdInputField;
	}

	public WebElement loginButton() {
		return loginButton;
	}
}
