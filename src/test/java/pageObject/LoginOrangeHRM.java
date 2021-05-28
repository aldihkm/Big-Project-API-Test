package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LoginOrangeHRM extends BaseClass {

	public LoginOrangeHRM(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "txtUsername")
	private WebElement txt_username;

	@FindBy(id = "txtPassword")
	private WebElement txt_password;

	@FindBy(id = "btnLogin")
	private WebElement btn_login;

	@FindBy(id = "spanMessage")
	private WebElement txt_error_message;

	public boolean LoginPageAppear() {
		txt_username.isDisplayed();
		txt_password.isDisplayed();
		btn_login.isDisplayed();
		return true;
	}

	public void inputUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void inputPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLoginButton() {
		btn_login.click();
	}

	public boolean errorMessageAppear() {
		txt_error_message.isDisplayed();
		return true;
	}
}