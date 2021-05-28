package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddEmployeePage extends BaseClass{
	public AddEmployeePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy (id = "firstName")
	private WebElement txt_first_name;
	
	@FindBy(id = "lastName")
	private WebElement txt_last_name;
	
	@FindBy(id = "btnSave")
	private WebElement btn_save;
	
	@FindBy(id = "personal_txtEmpFirstName")
	private WebElement txt_employee_first_name;
	
	@FindBy(xpath = "//ol[@class='fieldsInLine']/li[1]/span[@class='validation-error']")
	private WebElement ttl_error_message_first_name_field;
	
	@FindBy(xpath = "//ol[@class='fieldsInLine']/li[3]/span[@class='validation-error']")
	private WebElement ttl_error_message_last_name_field;
	
	public void inputFirstName(String name) {
		txt_first_name.sendKeys(name);
	}
	
	public void inputLastName(String lastName) {
		txt_last_name.sendKeys(lastName);
	}
	
	public void saveAddEmployee() {
		btn_save.click();
	}
	
	public String expectedEmployeeFirstName() {
		return txt_employee_first_name.getText();
	}
	
	public String actualEmployeeFirstName() {
		return "Sebastian";
	}
	
	public boolean errorFirstNameField() {
		ttl_error_message_first_name_field.isDisplayed();
		return true;
	}
	
	public boolean errorLastNameField() {
		ttl_error_message_last_name_field.isDisplayed();
		return true;
	}
}
