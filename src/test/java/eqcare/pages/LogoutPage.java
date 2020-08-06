package eqcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import eqcare.helper.Utility;

// This is Page for Logout
public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	By adminText=By.xpath("//a[text()='Welcome Admin']");
	
	By logoutText=By.xpath("//a[contains(text(), 'Logout')]");
	
	
	public void logOutFromApplicationWithAdminRole() {
	
		Utility.waitForWebElement(driver, adminText).click();
		Utility.waitForWebElement(driver, logoutText).click();
	}

}
