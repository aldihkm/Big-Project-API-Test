package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.AddEmployeePage;
import pageObject.HomepageOHRM;

public class EmployeeSteps {
	public WebDriver driver;

	public EmployeeSteps() {
		driver = Hooks.driver;
	}
	
	@When("^i on Add Employee Page$")
	public void i_on_Add_Employee_Page() throws Throwable {
	   HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
	   homepageOHRM.clickPimButton();
	   Thread.sleep(2000);
	   homepageOHRM.clickAddEmployeeButton();
	   Thread.sleep(2000);
	}

	@When("^i set \"(.*)\" as first name and \"(.*)\" as last name$")
	public void i_set_as_first_name_and_as_last_name(String name, String lastname) throws Throwable {
	   AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
	   addEmployeePage.inputFirstName(name);
	   Thread.sleep(2000);
	   addEmployeePage.inputLastName(lastname);
	   Thread.sleep(2000);
	   addEmployeePage.saveAddEmployee();
	}

	@Then("^employee created already added$")
	public void employee_created_already_added() throws Throwable {
		 AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		 Thread.sleep(5000);
		 Assert.assertEquals(addEmployeePage.actualEmployeeFirstName(), addEmployeePage.expectedEmployeeFirstName());
	}
	
	@When("^i save without input on mandatory fields$")
	public void i_save_without_input_on_mandatory_fields() throws Throwable {
		AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		addEmployeePage.saveAddEmployee();
	}

	@Then("^user will get error after save data$")
	public void user_will_get_error_after_save_data() throws Throwable {
		AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(addEmployeePage.errorFirstNameField());
		Assert.assertTrue(addEmployeePage.errorLastNameField());
	}
}
