package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddUserPage extends BaseClass {
	public AddUserPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "btnAdd")
	private WebElement btn_add_user;
	
	@FindBy(id = "systemUser_employeeName_empName")
	private WebElement txt_employee_name;
	
	@FindBy(id = "systemUser_userName")
	private WebElement txt_username;
	
	@FindBy(id = "btnSave")
	private WebElement btn_save;
	
	@FindBy(xpath = "//span[.='Employee does not exist']")
	private WebElement ttl_error_employee;
	
	@FindBy(xpath = "//span[.='Required']")
	private WebElement ttl_error_username;
	
	@FindBy(xpath = "//a[.='testnw']")
	private WebElement txt_name_added;
	
	public void clickAddButton() {
		btn_add_user.click();
	}
	
	public void inputEmployeeName(String empName) {
		txt_employee_name.sendKeys(empName);
		txt_employee_name.sendKeys(Keys.ENTER);
	}
	
	public void inputUsername(String username) {
		txt_username.sendKeys(username);
		txt_username.sendKeys(Keys.ENTER);
	}
	
	public void clickSaveButton() {
		btn_save.click();
	}
	
	public boolean errorNotInputNameAppear() {
		ttl_error_employee.isDisplayed();
		return true;
	}
	
	public boolean errorNotInputUsername() {
		ttl_error_username.isDisplayed();
		return true;
	}
	
	public boolean verifyUserAdded() {
		txt_name_added.isDisplayed();
		return true;
	}
}
