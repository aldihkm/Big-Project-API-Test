package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LeaveListPage extends BaseClass{
	public LeaveListPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = "//div[@id='leaveList_chkSearchFilter_checkboxgroup']/input[@value='1']")
	private WebElement ckb_leave_status;
	
	@FindBy(id = "leaveList_txtEmployee_empName")
	private WebElement txt_employee_name;
	
	@FindBy(id = "btnSearch")
	private WebElement btn_search;
	
	@FindBy(xpath = "//a[.='2021-07-16']")
	private WebElement txt_leave_date_list;
	
	
	public void uncheckLeaveStatus() {
		ckb_leave_status.click();
	}
	
	public void inputEmployeeName(String name) {
		txt_employee_name.sendKeys(name);
		txt_employee_name.sendKeys(Keys.ENTER);
	}
	
	public void clickSearchButton() {
		btn_search.click();
	}
	
	public String actualDate() {
		return txt_leave_date_list.getText();
	}
	
	public String expectedDate() {
		return "2021-07-16";
	}
}
