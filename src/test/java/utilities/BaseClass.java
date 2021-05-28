package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public static WebDriver webDriver;
	
	public BaseClass(WebDriver webDriver) {
		BaseClass.webDriver = webDriver;
	}

}