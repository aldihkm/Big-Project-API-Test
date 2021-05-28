package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomepageOHRM extends BaseClass {

	public HomepageOHRM(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "welcome")
	private WebElement txt_welcome;

	@FindBy(xpath = "//b[.='Time']")
	private WebElement btn_time;

	@FindBy(id = "menu_attendance_Attendance")
	private WebElement btn_attendance;

	@FindBy(id = "menu_attendance_punchIn")
	private WebElement btn_punch_in_out;
	
	@FindBy(xpath = "//b[.='Leave']")
	private WebElement btn_leave;
	
	@FindBy(id = "menu_leave_Entitlements")
	private WebElement btn_entitlement;
	
	@FindBy(id = "menu_leave_addLeaveEntitlement")
	private WebElement btn_add_entitlement;
	
	@FindBy(id = "menu_leave_assignLeave")
	private WebElement btn_assign_Leave;
	
	@FindBy(id = "menu_leave_viewLeaveList")
	private WebElement btn_leave_list;
	
	@FindBy(xpath = "//b[.='Admin']")
	private WebElement btn_admin;
	
	@FindBy(id = "menu_admin_UserManagement")
	private WebElement btn_user_management;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	private WebElement btn_user;
	
	@FindBy(xpath = "//b[.='PIM']")
	private WebElement btn_pim;
	
	@FindBy(id = "menu_pim_addEmployee")
	private WebElement btn_add_employee;
	
	@FindBy(xpath = "//b[.='My Info']")
	private WebElement btn_my_info;
	
	@FindBy(xpath = "//b[.='Directory']")
	private WebElement btn_directory;

	public boolean welcomeText() {
		txt_welcome.isDisplayed();
		return true;
	}

	public void clickTimeButton() {
		btn_time.click();
	}

	public void clickAttendanceButton() {
		btn_attendance.click();
	}

	public void clickPunchInOut() {
		btn_punch_in_out.click();
	}
	
	public void clickLeaveButton() {
		btn_leave.click();
	}
	
	public void clickEntitlementButton() {
		btn_entitlement.click();
	}
	
	public void clickAddLeaveEntitlementButton() {
		btn_add_entitlement.click();
	}
	
	public void clickAssignLeave() {
		btn_assign_Leave.click();
	}
	
	public void clickLeaveList() {
		btn_leave_list.click();
	}
	
	public void clickAdminButton() {
		btn_admin.click();
	}
	
	public void clickUserManagementButton() {
		btn_user_management.click();
	}
	
	public void clickUserButton() {
		btn_user.click();
	}
	
	public void clickPimButton() {
		btn_pim.click();
	}
	
	public void clickAddEmployeeButton() {
		btn_add_employee.click();
	}
	
	public void clickMyInfo() {
		btn_my_info.click();
	}
	
	public void clickDirectoryButton() {
		btn_directory.click();
	}

}
