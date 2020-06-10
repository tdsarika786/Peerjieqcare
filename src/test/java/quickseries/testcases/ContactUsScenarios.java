package quickseries.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import quickseries.pages.ContactUsPage;
import quickseries.pages.HomePage;
import quickseries.pages.BaseClass;

public class ContactUsScenarios extends BaseClass {

	ContactUsPage contact;

	HomePage home;

	@Test(priority = 0)
	public void verifyPage() {

		contact = PageFactory.initElements(driver, ContactUsPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		home.verifyUrl();

		logger = report.createTest("Quickseries Contact Us URL validation");

		logger.info("Validating Quickseries url");

		contact.navigateToConatctUsPage();

		contact.verifyContactUsUrl();

		logger.info("Validated contact us page url");

		contact.verifyPageTitleAfterNavigateToContactUs();

		logger.info("Validated contact us page title");

		contact.verifyHeadingAfterNavigateToDept();

		logger.info("Validated contact us page headding");

	}

	@Test(priority = 1, dependsOnMethods = "verifyPage")
	public void TC_01_Display_Validation_Errors() {

		logger = report.createTest("Contact Us Form Errors Validation");

		contact.validateContactPageErrors();

		logger.info("Validated UI Error messages displayed");

		contact.verifyContactUsUrl();

		logger.info("Verified user cannot submit empty form ");

	}

}
