package quickseries.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import quickseries.factories.DataProviderFactory;
import quickseries.helper.Utility;

public class ContactUsPage {

	WebDriver driver;

	public ContactUsPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Contact Us heading
	By ContactUsHeading = By.xpath("//h3[text()='Contact us']");

	By SendBtn = By.xpath("//input[@value='SEND']");

	By CaptchaSpanErrorMsg = By.xpath("//span[contains(text(),'Please solve Captcha')]");

	By FirstNameErrorMsg = By.xpath("//input[@name='first-name']/following-sibling::span");

	By LastNameErrorMsg = By.xpath("//input[@name='last-name']/following-sibling::span");

	By CompanyErrorMsg = By.xpath("//input[@name='your-company']/following-sibling::span");

	By PhoneNoErrorMsg = By.xpath("//input[@name='phone-number']/following-sibling::span");

	By EmailErrorMsg = By.xpath("//input[@name='your-email']/following-sibling::span");

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'field is required')]") })
	public List<WebElement> ErrorMessages;

	@FindAll({ @FindBy(xpath = "//*[@role='grid']/tbody/tr/td[3]") })
	public List<WebElement> RowDepartmentsName;

	public void verifyContactUsUrl() {
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"),
				"Contact us Page does not contain contact-us url");
	}

	public void verifyPageTitleAfterNavigateToContactUs() {
		Assert.assertTrue(driver.getTitle().contains("Get in touch! - QuickSeries"),
				"Contact us Page does not contain Get in touch! in title");
	}

	public void verifyHeadingAfterNavigateToDept() {
		WebElement ele = Utility.waitForWebElement(driver, ContactUsHeading);
		String contactUsHeader = ele.getText();
		Assert.assertEquals(contactUsHeader, "Contact us");
	}

	public void validateContactPageErrors() {

		Utility.waitForWebElement(driver, SendBtn).click();

		WebElement eleFirstNameErrorMsg = Utility.waitForWebElement(driver, FirstNameErrorMsg);

		WebElement eleLastNameErrorMsg = Utility.waitForWebElement(driver, LastNameErrorMsg);

		WebElement eleCompanyErrorMsg = Utility.waitForWebElement(driver, CompanyErrorMsg);

		WebElement elePhoneNoErrorMsg = Utility.waitForWebElement(driver, PhoneNoErrorMsg);

		WebElement eleEmailErrorMsg = Utility.waitForWebElement(driver, EmailErrorMsg);

		WebElement eleCaptchaSpanErrorMsg = Utility.waitForWebElement(driver, CaptchaSpanErrorMsg);

		String firstNameErrorMessage = eleFirstNameErrorMsg.getText();

		String lastNameErrorMessage = eleLastNameErrorMsg.getText();

		String companyErrorMessage = eleCompanyErrorMsg.getText();

		String phoneNoErrorMessage = elePhoneNoErrorMsg.getText();

		String emailErrorMessage = eleEmailErrorMsg.getText();

		String captchaErrorMessage = eleCaptchaSpanErrorMsg.getText();

		boolean exist = false;

		String errorMessage = "The field is required.";

		String captchaError = "Please solve Captcha correctly";

		if (firstNameErrorMessage.equals(errorMessage) && lastNameErrorMessage.equals(errorMessage)

				&& companyErrorMessage.equals(errorMessage) && phoneNoErrorMessage.equals(errorMessage)

				&& emailErrorMessage.equals(errorMessage) && captchaErrorMessage.equals(captchaError)) {
			exist = true;
			System.out.println("First Name-" + firstNameErrorMessage);

			System.out.println("Last Name-" + lastNameErrorMessage);

			System.out.println("Company-" + companyErrorMessage);

			System.out.println("Phone No-" + phoneNoErrorMessage);

			System.out.println("Email-" + emailErrorMessage);

			System.out.println("Captcha-" + captchaErrorMessage);

		}

		else {
			exist = false;
		}

		if (exist == true) {
			assert true;
		}

		else
			assert false;

	}

	public void navigateToConatctUsPage() {

		Utility.navigateToURL(driver, DataProviderFactory.getConfig().getValue("ContactUsPage"));


	}

}
