package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.*;
import pageObject.AssignLeavePage;
import pageObject.HomepageOHRM;
import pageObject.LeaveEntitlementPage;
import pageObject.LeaveListPage;

public class LeaveSteps {
	public WebDriver driver;

	public LeaveSteps() {
		driver = Hooks.driver;
	}

	@When("i on Add Leave Entitlement page")
	public void i_on_Add_Leave_Entitlement_page() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		homepageOHRM.clickLeaveButton();
		homepageOHRM.clickEntitlementButton();
		homepageOHRM.clickAddLeaveEntitlementButton();
		Thread.sleep(2000);
	}

	@When("i Add Leave Entitlement with \"(.*)\" as name and \"(.*)\" as Entitlement")
	public void i_Add_Leave_Entitlement_with_as_name_and_as_Entitlement(String name, String Entitlement)
			throws Throwable {
		LeaveEntitlementPage leaveEntitlementPage = new LeaveEntitlementPage(driver);
		Thread.sleep(2000);
		leaveEntitlementPage.inputEmployeeName(name);
		leaveEntitlementPage.inputEntitlement(Entitlement);
		leaveEntitlementPage.clickSaveButton();
		Thread.sleep(2000);
		leaveEntitlementPage.clickConfirmButton();
	}

	@Then("Leave should already added")
	public void leave_should_already_added() throws Throwable {
		LeaveEntitlementPage leaveEntitlementPage = new LeaveEntitlementPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(leaveEntitlementPage.entitlementSaved());
		Thread.sleep(2000);
	}

	@When("i not input name and Entitlement")
	public void i_not_input_name_and_Entitlement() throws Throwable {
		LeaveEntitlementPage leaveEntitlementPage = new LeaveEntitlementPage(driver);
		leaveEntitlementPage.clickSaveButton();
		Thread.sleep(2000);
	}

	@Then("^i should get an error message$")
	public void i_should_get_an_error_message() throws Throwable {
		LeaveEntitlementPage leaveEntitlementPage = new LeaveEntitlementPage(driver);
		Assert.assertTrue(leaveEntitlementPage.errorNameAppear());
		Assert.assertTrue(leaveEntitlementPage.errorEntitlementAppear());
		Thread.sleep(2000);
	}

	@When("i on Assign Leave page")
	public void i_on_Assign_Leave_page() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		homepageOHRM.clickLeaveButton();
		homepageOHRM.clickAssignLeave();
		Thread.sleep(2000);
	}

	@When("i add leave with \"(.*)\" as name")
	public void i_add_leave_with_as_name(String name) throws Throwable {
		AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
		Thread.sleep(2000);
		assignLeavePage.inputEmployeeName(name);
		assignLeavePage.leaveType();
		assignLeavePage.selectLeaveType();
		Thread.sleep(2000);
	}

	@When("i set leave \"(.*)\" as From Date and \"(.*)\" as To Date")
	public void i_set_leave_as_From_Date_and_as_To_Date(String fromDate, String toDate) throws Throwable {
		AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
		assignLeavePage.inputFromDate(fromDate);
		Thread.sleep(2000);
		assignLeavePage.inputToDate(toDate);
		Thread.sleep(2000);
		assignLeavePage.clickAssignSaveButton();
		Thread.sleep(2000);
	}

	@Then("leave should added")
	public void leave_should_added() throws Throwable {
		AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
		Assert.assertTrue(assignLeavePage.assignLeaveAppear());
		Thread.sleep(2000);
	}

	@When("^i request leave without input any fields$")
	public void i_request_leave_without_input_any_fields() throws Throwable {
		AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
		assignLeavePage.clickAssignSaveButton();
		Thread.sleep(2000);
	}

	@Then("^i failed to request leave$")
	public void i_failed_to_request_leave() throws Throwable {
		AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
		Assert.assertTrue(assignLeavePage.errorMessageNameAppear());
		Assert.assertTrue(assignLeavePage.errorMessageLeaveTypeAppear());
		Assert.assertTrue(assignLeavePage.errorMessageFromDateAppear());
		Assert.assertTrue(assignLeavePage.errorMessageToDateAppear());
		Thread.sleep(2000);
	}
	
	@When("i on Leave List page")
	public void i_on_Leave_List_page() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		homepageOHRM.clickLeaveButton();
		homepageOHRM.clickLeaveList();
		Thread.sleep(2000);
	}

	@When("search \"(.*)\" as name")
	public void search_as_name(String name) throws Throwable {
	   LeaveListPage leaveListPage = new LeaveListPage(driver);
	   leaveListPage.uncheckLeaveStatus();
	   Thread.sleep(2000);
	   leaveListPage.inputEmployeeName(name);
	   Thread.sleep(2000);
	}

	@Then("i can see my leave lists")
	public void i_can_see_my_leave_lists() throws Throwable {
		LeaveListPage leaveListPage = new LeaveListPage(driver);
		leaveListPage.clickSearchButton();
		Thread.sleep(2000);
		Assert.assertEquals(leaveListPage.expectedDate(), leaveListPage.actualDate());
		Thread.sleep(2000);
	}
}
