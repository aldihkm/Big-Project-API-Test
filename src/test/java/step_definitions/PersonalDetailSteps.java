package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageObject.HomepageOHRM;
import pageObject.PersonalDetailPage;

public class PersonalDetailSteps {
	public WebDriver driver;

	public PersonalDetailSteps() {
		driver = Hooks.driver;
	}
	
	@When("^i on My Info Page$")
	public void i_on_My_Info_Page() throws Throwable {
	    HomepageOHRM homepageOHRM = new HomepageOHRM(driver);
	    homepageOHRM.clickMyInfo();
	    Thread.sleep(2000);
	}

	@When("^set \"(.*)\" as Middle Name and \"(.*)\" as license number$")
	public void set_as_Middle_Name_and_as_license_number(String middleName, String licenseNumber) throws Throwable {
	    PersonalDetailPage personalDetailPage = new PersonalDetailPage(driver);
	    personalDetailPage.clickEditPersonalDetailButton();
	    Thread.sleep(2000);
	    personalDetailPage.inputMiddleName(middleName);
	    Thread.sleep(2000);
	    personalDetailPage.inputLicenseNumber(licenseNumber);
	}

	@When("^set \"(.*)\" as other id and \"(.*)\" as license expiry date$")
	public void set_as_other_id_and_as_license_expiry_date(String otherId, String expiryDate) throws Throwable {
		 PersonalDetailPage personalDetailPage = new PersonalDetailPage(driver);
		 personalDetailPage.inputOtherId(otherId);
		 Thread.sleep(2000);
		 personalDetailPage.selectLicenseExpiryDate(expiryDate);
		 Thread.sleep(2000);
		 personalDetailPage.selectNationality();
	}

	@Then("^user able to edit personal detail$")
	public void user_able_to_edit_personal_detail() throws Throwable {
		PersonalDetailPage personalDetailPage = new PersonalDetailPage(driver);
		personalDetailPage.clickEditPersonalDetailButton();
		Thread.sleep(2000);
		Assert.assertTrue(personalDetailPage.successMessage());
	}
}
