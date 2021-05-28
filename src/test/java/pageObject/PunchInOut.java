package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class PunchInOut extends BaseClass {
	public PunchInOut(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "h1")
	private WebElement ttl_punch_in;

	@FindBy(id = "note")
	private WebElement txt_note;

	@FindBy(id = "btnPunch")
	private WebElement btn_punch_in;
	
	@FindBy(css = "h1")
	private WebElement ttl_punch_out;
	
	@FindBy(id = "btnPunch")
	private WebElement btn_punch_out;
	
	@FindBy(className = "punchOutbutton")
	private WebElement btn_punch_out_class;
	
	@FindBy(className = "punchInbutton")
	private WebElement btn_punch_in_class;

	public boolean punchInAppear() {
		ttl_punch_in.isDisplayed();
		return true;
	}

	public void inputNote(String notes) {
		txt_note.sendKeys(notes);
	}

	public void clickPunchIn() {
		btn_punch_in_class.click();
	}
	
	public boolean punchOutAppear() {
		ttl_punch_out.isDisplayed();
		return true;
	}
	
	public void clickPunchOut() {
		btn_punch_out_class.click();
	}
	
	public boolean verifyPunchOutButtonWithClass() {
		btn_punch_out_class.isDisplayed();
		return true;
	}
	
	public boolean verifyPunchInButton() {
		btn_punch_in_class.isDisplayed();
		return true;
	}
}
