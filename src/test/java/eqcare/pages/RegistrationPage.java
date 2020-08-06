package eqcare.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import eqcare.factories.DataProviderFactory;
import eqcare.helper.Utility;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	By registerLink = By.xpath("//*[@data-role='register-button']");

	By password = By.name("password");

	By password1 = By.xpath("(//*[@name='password'])[2]");

	By loginButton = By.xpath("//*[@data-role='login-button']");

	By emailAddress = By.xpath("//*[@placeholder='Enter your e-mail']");

	By firstName = By.xpath("//*[@placeholder='Enter your First Name']");

	By lastName = By.xpath("//*[@placeholder='Enter your Last Name']");

	By address = By.xpath("//*[@placeholder='Enter your address']");

	By city = By.xpath("//*[@placeholder='Enter your city']");

	By postalCode = By.xpath("//*[@placeholder='Enter your Postal Code']");

	By dob = By.xpath("//*[@placeholder='yyyy-mm-dd']");

	By phoneNumber = By.xpath("//*[@placeholder='Enter your phone number']");

	// By nextBtn = By.xpath("//*[@placeholder='account-info-step-next-button']");

//	By emailAdd = By.xpath("//*[@placeholder='Enter your phone number']");

//	By termsCond = By.xpath("//*[@placeholder='Enter your phone number']");

	By gender = By.xpath("//*[@for='gender-female']");

	By nextBtn = By.xpath("//*[@data-role='patient-info-step-next-button']");

	By checkBox1 = By.xpath("(//*[@name='checkboxFieldInput'])[1]");

	By checkBox2 = By.xpath("(//*[@name='checkboxFieldInput'])[2]");

	By confirmButton = By.xpath("//*[@data-role='confirmation-step-register-button']");

	By notCoverageButton = By.xpath("//*[@data-role='not-covered-button']");

	By accountInfoBtn = By.xpath("//*[@data-role='account-info-step-next-button']");

	By nextBtn2 = By.xpath("//*[@data-role='password-step-next-button']");

	By confirmationEmailText = By.xpath("//h2[text()='One last step']");

	By uploadProfilePic = By.xpath("(//input[@type='file'])[1]");

	By uploadGovtID = By.xpath("(//input[@type='file'])[2]");

	public void verifyUrlBeforeLogin()

	{
		clickOnRegisterButton();

		Utility.verifyURLContains(driver, "register");
	}

	public void verifyFB()

	{
		System.out.println(driver.findElement(By.xpath("//a[2]//img[1]")).isDisplayed());
	}

	public void verifyUrlAfterLogin() {
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard does not contain dashboard keyword");
	}

	public void clickOnRegisterButton() {
		Utility.waitForWebElement(driver, registerLink).click();
	}

	public void notEnrolledRegisteration(String email, String userFirstName, String userLastName, String Address,
			String City, String PostalCode, String DOB, String PhoneNo, String Password) throws InterruptedException {
		Utility.waitForWebElement(driver, notCoverageButton).click();

		Utility.waitForWebElement(driver, emailAddress).sendKeys(email);

		WebElement fileButtonProfielPic = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.display='block';", fileButtonProfielPic);

		// Utility.waitForWebElement(driver, uploadProfilePic).sendKeys("/Users/sarikadhall/Downloads/OIP-2.jpeg");

		Utility.waitForWebElement(driver, firstName).sendKeys(userFirstName);

		Utility.waitForWebElement(driver, lastName).sendKeys(userLastName);

		Utility.waitForWebElement(driver, gender).click();
		
		WebElement fileButtonGovtID = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
		JavascriptExecutor executorGovtID = (JavascriptExecutor) driver;
		executorGovtID.executeScript("arguments[0].style.display='block';", fileButtonGovtID);

		Utility.waitForWebElement(driver, uploadGovtID).sendKeys("/Users/sarikadhall/Downloads/OIP-2.jpeg");

		Utility.waitForWebElement(driver, nextBtn).click();

		Utility.waitForWebElement(driver, address).sendKeys(Address);

		Utility.waitForWebElement(driver, city).sendKeys(City);

		Utility.waitForWebElement(driver, postalCode).sendKeys(PostalCode);

		Utility.waitForWebElement(driver, dob).sendKeys(DOB);

		Utility.waitForWebElement(driver, phoneNumber).sendKeys(PhoneNo);

		Utility.waitForWebElement(driver, accountInfoBtn).click();

		Utility.waitForWebElement(driver, password).sendKeys(Password);

		Utility.waitForWebElement(driver, password1).sendKeys(Password);

		Utility.waitForWebElement(driver, nextBtn2).click();

		Thread.sleep(2000);

		WebElement button = driver.findElement(By.xpath("//div[@checkbox-field-id=\"email_confirmation\"]/div/input"));

		WebElement button2 = driver.findElement(By.xpath("//div[@checkbox-field-id=\"terms_and_privacy\"]/div/input"));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", button);

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click()", button2);

		// WebDriverWait wait1=new WebDriverWait(driver,10);
		// wait1.until(ExpectedConditions.elementToBeClickable(ele5));

		// Utility.highLightElement1(driver, checkBox1);

		// Utility.waitForWebElement(driver, checkBox1).click();

		// Utility.waitForWebElement(driver, checkBox2).click();

		Utility.waitForWebElement(driver, confirmButton).click();

		Thread.sleep(2000);
		WebElement ele = Utility.waitForWebElement(driver, confirmationEmailText);
		String confirmationText = ele.getText();
		Assert.assertEquals(confirmationText, "One last step");
	}

}