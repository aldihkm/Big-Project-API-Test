package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LeaveEntitlementPage extends BaseClass {
	public LeaveEntitlementPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "entitlements_filters_bulk_assign")
	private WebElement btn_bulk_assign;
	
	@FindBy(id = "entitlements_employee_empName")
	private WebElement txt_employee_name;
	
	@FindBy(id = "entitlements_entitlement")
	private WebElement txt_entitlement;
	
	@FindBy(id = "entitlements_leave_type")
	private WebElement drd_leave_type;
	
	@FindBy(id = "period")
	private WebElement drd_leave_period;
	
	@FindBy(xpath = "//form[@id='frmLeaveEntitlementAdd']//li[2]/span[@class='validation-error']")
	private WebElement ttl_error_message_employee_name;
	
	@FindBy(xpath = "//form[@id='frmLeaveEntitlementAdd']//li[5]/span[@class='validation-error']")
	private WebElement ttl_error_message_entitlement;
	
	@FindBy(id = "btnSave")
	private WebElement btn_save_add_entitlement;
	
	@FindBy(id = "btnCancel")
	private WebElement btn_cancel_add_entitlement;
	
	@FindBy(xpath = "//td[.='Added']")
	private WebElement ttl_entitlement_saved;
	
	@FindBy(id = "dialogUpdateEntitlementConfirmBtn")
	private WebElement btn_confirm;
	
	public void clickBulkAssign() {
		btn_bulk_assign.click();
	}
	
	public void inputEmployeeName(String name) {
		txt_employee_name.sendKeys(name);
		txt_employee_name.sendKeys(Keys.ENTER);
	}
	
	public void inputEntitlement(String Entitlement) {
		txt_entitlement.sendKeys(Entitlement);
	}
	
	public boolean errorNameAppear() {
		ttl_error_message_employee_name.isDisplayed();
		return true;
	}
	
	public boolean errorEntitlementAppear() {
		ttl_error_message_entitlement.isDisplayed();
		return true;
	}
	
	public void clickSaveButton() {
		btn_save_add_entitlement.click();
	}
	
	public boolean entitlementSaved() {
		ttl_entitlement_saved.isDisplayed();
		return true;
	}
	
	public void clickConfirmButton() {
		btn_confirm.click();
	}
	
}
