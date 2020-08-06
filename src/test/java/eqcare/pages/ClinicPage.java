package eqcare.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import eqcare.factories.DataProviderFactory;
import eqcare.helper.Utility;

public class ClinicPage {

	WebDriver driver1;

	public ClinicPage(WebDriver ldriver) {
		this.driver1 = ldriver;
	}

	By email=By.name("email");
	By password=By.name("password");
	By loginButton=By.id("login-button");
	By logoutButton=By.id("login-button");
	
	By TestPat = By.xpath("html/body/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[3]/div/div[2]/div/button");
	
	public void loginToApplication(String userName,String passWord)
	{
		Utility.waitForWebElement(driver1, email).sendKeys(userName);
		Utility.waitForWebElement(driver1, password).sendKeys(passWord);
		Utility.waitForWebElement(driver1, loginButton).click();
		
	}
	
	
	
	public void clickToPatient()
	{
		Utility.waitForWebElement(driver1, TestPat).click();
	}

}
