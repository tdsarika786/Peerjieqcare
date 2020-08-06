package eqcare.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import eqcare.factories.DataProviderFactory;
import eqcare.helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	By user=By.name("textFieldInput");
	By password=By.name("password");
	By loginButton=By.xpath("//*[@data-role='login-button']");
	By logoutButton=By.xpath("//a[contains(text(), 'Logout')]");
	
	
	public void verifyUrlBeforeLogin()
	{
		Utility.verifyURLContains(driver, "eqcare");
	}
	
	
	public void verifyFB()
	
	{
		System.out.println(driver.findElement(By.xpath("//a[2]//img[1]")).isDisplayed());
	}
	
	public void verifyUrlAfterLogin()
	{
		//Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard does not contain dashboard keyword");	
		WebElement ele = Utility.waitForWebElement(driver, logoutButton);
		String contactUsHeader = ele.getText();
		Assert.assertEquals(contactUsHeader, "Logout");
	
		
	}
	

	public void typeUserName()
	{
		Utility.waitForWebElement(driver, user).sendKeys("Admin");
	}
	
	public void typePassword()
	{
		Utility.waitForWebElement(driver, password).sendKeys("admin123");
	}
	
	public void clickOnLoginButton()
	{
		Utility.waitForWebElement(driver, loginButton).click();
	}
	
	
	public void loginToApplication(String userName,String passWord)
	{
		Utility.waitForWebElement(driver, user).sendKeys(userName);
		Utility.waitForWebElement(driver, password).sendKeys(passWord);
		Utility.waitForWebElement(driver, loginButton).click();
		
	}
	

}