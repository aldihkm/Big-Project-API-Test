package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BaseClass;

public class PersonalDetailPage extends BaseClass{
	public PersonalDetailPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "btnSave")
	private WebElement btn_edit_personal_detail;
	
	@FindBy(id = "personal_txtEmpMiddleName")
	private WebElement txt_middle_name;
	
	@FindBy(id = "personal_txtLicenNo")
	private WebElement txt_license_number;
	
	@FindBy(id = "personal_cmbNation")
	private WebElement drd_nationality;
	
	@FindBy(id = "personal_txtOtherID")
	private WebElement txt_other_id;
	
	@FindBy(id = "personal_txtLicExpDate")
	private WebElement txt_license_expiry_date;
	
	@FindBy(css = ".message")
	private WebElement ttl_notification_success;
	
	public void clickEditPersonalDetailButton() {
		btn_edit_personal_detail.click();
	}
	
	public void inputMiddleName(String middleName) {
		txt_middle_name.clear();
		txt_middle_name.sendKeys(middleName);
	}
	
	public void inputLicenseNumber(String licenseNumber) {
		txt_license_number.clear();
		txt_license_number.sendKeys(licenseNumber);
	}
	
	public void selectNationality() {
		Select nationality = new Select(webDriver.findElement(By.id("personal_cmbNation")));
		nationality.selectByVisibleText("Indonesian");
	}
	
	public void inputOtherId(String otherId) {
		txt_other_id.clear();
		txt_other_id.sendKeys(otherId);
	}
	
	public void selectLicenseExpiryDate(String expiryDate) {
		txt_license_expiry_date.clear();
		txt_license_expiry_date.sendKeys(expiryDate);
		txt_license_expiry_date.sendKeys(Keys.ENTER);
	}
	
	public String expectedMiddleName() {
		return "Niki";
	}
	
	public String actualMiddleName() {
		return txt_other_id.getText();
	}
	
	public boolean successMessage() {
		return ttl_notification_success.isDisplayed();
	}
}
