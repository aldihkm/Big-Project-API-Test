package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.AddUserPage;
import pageObject.HomepageOHRM;

public class AdminSteps {
	public WebDriver driver;

	public AdminSteps() {
		driver = Hooks.driver;
	}
	
	@When("^i on add user page$")
	public void i_on_add_user_page() throws Throwable {
	   HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
	   homepageOHRM.clickAdminButton();
	   homepageOHRM.clickUserManagementButton();
	   homepageOHRM.clickUserButton();
	   Thread.sleep(2000);
	}

	@When("^i set \"(.*)\" as employee name and \"(.*)\" as username$")
	public void i_set_as_employee_name_and_as_username(String name, String username) throws Throwable {
	   AddUserPage addUserPage = new AddUserPage(driver);
	   addUserPage.clickAddButton();
	   addUserPage.inputEmployeeName(name);
	   addUserPage.inputUsername(username);
	   addUserPage.clickSaveButton();
	   Thread.sleep(2000);
	}

	@Then("^user should added$")
	public void user_should_added() throws Throwable {
		AddUserPage addUserPage = new AddUserPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue(addUserPage.verifyUserAdded());
		Thread.sleep(2000);
	}
	
	@When("^i directly click save$")
	public void i_directly_click_save() throws Throwable {
		AddUserPage addUserPage = new AddUserPage(driver);
		addUserPage.clickAddButton();
		addUserPage.clickSaveButton();
		Thread.sleep(2000);
	}

	@Then("^user cannot save$")
	public void user_cannot_save() throws Throwable {
		AddUserPage addUserPage = new AddUserPage(driver);
		Assert.assertTrue(addUserPage.errorNotInputNameAppear());
		Assert.assertTrue(addUserPage.errorNotInputUsername());
		Thread.sleep(2000);
	}
	    

}
