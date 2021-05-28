package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.HomepageOHRM;
import pageObject.PunchInOut;

public class AttendanceSteps {
	public WebDriver driver;

	public AttendanceSteps() {
		driver = Hooks.driver;
	}

	@When("i click Time button")
	public void i_click_Time_button() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		homepageOHRM.clickTimeButton();
		Thread.sleep(2000);
	}

	@When("i click Attendance Punch In/Out button")
	public void i_click_Attendance_Punch_In_Out_button() throws Throwable {
		HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
		homepageOHRM.clickAttendanceButton();
		homepageOHRM.clickPunchInOut();
		Thread.sleep(2000);
	}

	@Then("i can see Punch In available")
	public void i_can_see_Punch_In_available() throws Throwable {
		PunchInOut punchInOut = new PunchInOut(driver);
		Assert.assertTrue(punchInOut.punchInAppear());
		Thread.sleep(2000);
	}

	@When("i on Punch In Page")
	public void i_on_Punch_In_Page() throws Throwable {
		i_click_Time_button();
		i_click_Attendance_Punch_In_Out_button();
		i_can_see_Punch_In_available();
		Thread.sleep(2000);

	}

	@When("i click Punch In button with \"(.*)\" as notes")
	public void i_click_Punch_In_button(String notes) throws Throwable {
		PunchInOut punchInOut = new PunchInOut(driver);
		punchInOut.inputNote(notes);
		punchInOut.clickPunchIn();
		Thread.sleep(2000);
	}

	@Then("i can notification success Punch In")
	public void i_can_notification_success_Punch_In() throws Throwable {
		PunchInOut punchInOut = new PunchInOut(driver);
		Assert.assertTrue(punchInOut.verifyPunchOutButtonWithClass());
	}

	@When("i on Punch Out Page")
	public void i_on_Punch_Out_Page() throws Throwable {
		i_click_Time_button();
		i_click_Attendance_Punch_In_Out_button();
		Thread.sleep(2000);
	}

	@When("i click Punch Out button with \"(.*)\" as notes$")
	public void i_click_Punch_Out_button_with_as_notes(String notes) throws Throwable {
		PunchInOut punchInOut = new PunchInOut(driver);
		punchInOut.inputNote(notes);
		punchInOut.clickPunchOut();
		Thread.sleep(2000);
	}

	@Then("^i can see notification success Punch Out$")
	public void i_can_see_notification_success_Punch_Out() throws Throwable {
		PunchInOut punchInOut = new PunchInOut(driver);
		Assert.assertTrue(punchInOut.verifyPunchInButton());
		Thread.sleep(2000);
	}

}
