package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.HomepageOHRM;
import pageObject.LoginOrangeHRM;

public class LoginOrangeHRMSteps {
	public WebDriver driver;

	public LoginOrangeHRMSteps() {
		driver = Hooks.driver;
	}

	@Given("i on Login page")
	public void i_on_Login_page() throws Throwable {
		LoginOrangeHRM loginOrangeHRM = new LoginOrangeHRM(driver);
		driver.navigate().to("http://qa.cilsy.id/");
		Assert.assertTrue(loginOrangeHRM.LoginPageAppear());
		Thread.sleep(2000);
	}

	@When("i input credentials \"(.*)\" as username and \"(.*)\" as password")
	public void i_input_credentials_as_username_and_as_password(String username, String password) throws Throwable {
		LoginOrangeHRM loginOrangeHRM = new LoginOrangeHRM(driver);
		loginOrangeHRM.inputUsername(username);
		loginOrangeHRM.inputPassword(password);
		loginOrangeHRM.clickLoginButton();
		Thread.sleep(2000);
	}

	@When("^i input wrong credentials (.*) and (.*)$")
	public void i_input_wrong_credentials_Admin_and_admin(String username, String password) throws Throwable {
		LoginOrangeHRM loginOrangeHRM = new LoginOrangeHRM(driver);
		loginOrangeHRM.inputUsername(username);
		loginOrangeHRM.inputPassword(password);
		loginOrangeHRM.clickLoginButton();
		Thread.sleep(2000);
	}

	@Then("i go to homepage")
	public void i_go_to_homepage() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		Assert.assertTrue(homepageOHRM.welcomeText());
		Thread.sleep(2000);
	}

	@Then("^error message should appear$")
	public void error_message_should_appear() throws Throwable {
		LoginOrangeHRM loginOrangeHRM = new LoginOrangeHRM(driver);
		Assert.assertTrue(loginOrangeHRM.errorMessageAppear());
		Thread.sleep(2000);
	}

	@Given("i on homepage after login with credential \"(.*)\" as username and \"(.*)\" as password")
	public void i_on_homepage_after_login_with_credential_as_username_and_as_password(String username, String password)
			throws Throwable {
		i_on_Login_page();
		i_input_credentials_as_username_and_as_password(username, password);
		i_go_to_homepage();
		Thread.sleep(2000);

	}

}
