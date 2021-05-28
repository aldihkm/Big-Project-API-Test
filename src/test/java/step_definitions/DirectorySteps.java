package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.HomepageOHRM;
import pageObject.SearchDirectoryPage;

public class DirectorySteps {
	public WebDriver driver;

	public DirectorySteps() {
		driver = Hooks.driver;
	}
	
	@When("^i on employee directory page$")
	public void i_on_employee_directory_page() throws Throwable {
	    HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
	    homepageOHRM.clickDirectoryButton();
	    Thread.sleep(2000);
	}

	@When("^i search \"(.*)\" as employee name$")
	public void i_search_as_employee_name(String name) throws Throwable {
	   SearchDirectoryPage searchDirectoryPage = new SearchDirectoryPage(driver);
	   searchDirectoryPage.inputName(name);
	   Thread.sleep(2000);
	   searchDirectoryPage.selectJobTitle();
	   searchDirectoryPage.clickSearchButton();
	   Thread.sleep(2000);
	}

	@Then("^employee that i searched is appear$")
	public void employee_that_i_searched_is_appear() throws Throwable {
		 SearchDirectoryPage searchDirectoryPage = new SearchDirectoryPage(driver);
		 Assert.assertEquals(searchDirectoryPage.expectedName(), searchDirectoryPage.actualName());
		 Assert.assertEquals(searchDirectoryPage.expectedJobTitle(), searchDirectoryPage.actualJobTitle());
		 Thread.sleep(2000);
	}
}
