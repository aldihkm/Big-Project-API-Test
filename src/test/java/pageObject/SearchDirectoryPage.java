package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BaseClass;

public class SearchDirectoryPage extends BaseClass {
	public SearchDirectoryPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "searchDirectory_emp_name_empName")
	private WebElement txt_name;
	
	@FindBy(id = "searchBtn")
	private WebElement btn_search;
	
	@FindBy(xpath = "//b[.='Aldi Niki Hakim']")
	private WebElement ttl_name;
	
	@FindBy(xpath = "//li[.='QA']")
	private WebElement ttl_job_title;
	
	public void inputName(String name) {
		txt_name.sendKeys(name);
		txt_name.sendKeys(Keys.ENTER);
	}
	
	public void selectJobTitle() {
		Select jobTitle = new Select(webDriver.findElement(By.id("searchDirectory_job_title")));
		jobTitle.selectByVisibleText("QA");
	}
	
	public void clickSearchButton() {
		btn_search.click();
	}
	
	public String actualName() {
		return ttl_name.getText();
	}
	
	public String expectedName() {
		return "Aldi Niki Hakim";
	}
	
	public String actualJobTitle() {
		return ttl_job_title.getText();
	}
	
	public String expectedJobTitle() {
		return "QA (Deleted)";
	}
}
