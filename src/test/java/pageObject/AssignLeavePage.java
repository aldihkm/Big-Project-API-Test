package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseClass;

public class AssignLeavePage extends BaseClass {

	public AssignLeavePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "assignleave_txtEmployee_empName")
	private WebElement txt_employee_name;

	@FindBy(id = "assignleave_txtLeaveType")
	private WebElement drd_leave_type;

	@FindBy(id = "assignleave_txtFromDate")
	private WebElement txt_from_date;

	@FindBy(id = "assignleave_txtToDate")
	private WebElement txt_to_date;

	@FindBy(id = "assignBtn")
	private WebElement btn_assign;

	@FindBy(css = "h1")
	private WebElement ttl_assign_leave;

	@FindBy(xpath = "//form[@id='frmLeaveApply']//li[1]/span[@class='validation-error']")
	private WebElement ttl_error_message_name;

	@FindBy(xpath = "//form[@id='frmLeaveApply']//li[2]/span[@class='validation-error']")
	private WebElement ttl_error_message_leave_type;

	@FindBy(xpath = "//form[@id='frmLeaveApply']//li[4]/span[@class='validation-error']")
	private WebElement ttl_error_message_from_date;

	@FindBy(xpath = "//form[@id='frmLeaveApply']//li[5]/span[@class='validation-error']")
	private WebElement ttl_error_message_to_date;

	public void inputEmployeeName(String name) {
		txt_employee_name.sendKeys(name);
		txt_employee_name.sendKeys(Keys.ENTER);
	}

	public void leaveType() {
		drd_leave_type.click();
	}

	public void selectLeaveType() {
		Select leaveType = new Select(webDriver.findElement(By.id("assignleave_txtLeaveType")));
		leaveType.selectByVisibleText("Emergency Leave");

	}

	public void inputFromDate(String fromDate) {
		txt_from_date.clear();
		txt_from_date.sendKeys(fromDate);
		txt_from_date.sendKeys(Keys.ENTER);
	}

	public void inputToDate(String toDate) {
		txt_to_date.clear();
		txt_to_date.sendKeys(toDate);
		txt_to_date.sendKeys(Keys.ENTER);
	}

	public void clickAssignSaveButton() {
		btn_assign.click();
	}

	public boolean assignLeaveAppear() {
		ttl_assign_leave.isDisplayed();
		return true;
	}

	public boolean errorMessageNameAppear() {
		ttl_error_message_name.isDisplayed();
		return true;
	}

	public boolean errorMessageLeaveTypeAppear() {
		ttl_error_message_leave_type.isDisplayed();
		return true;
	}

	public boolean errorMessageFromDateAppear() {
		ttl_error_message_from_date.isDisplayed();
		return true;
	}

	public boolean errorMessageToDateAppear() {
		ttl_error_message_to_date.isDisplayed();
		return true;
	}

}
