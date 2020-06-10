package quickseries.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import quickseries.pages.ContactUsPage;
import quickseries.pages.HomePage;
import quickseries.factories.DataProviderFactory;
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

		logger.info("Validated Contact us page url");
		
		contact.verifyPageTitleAfterNavigateToContactUs();
		
		logger.info("Validated contact us page title");
		
		contact.verifyHeadingAfterNavigateToDept();
		
		logger.info("Validated contact us page headding");
		
		
	}
	
	
	@Test( priority = 1, dependsOnMethods = "verifyPage")
	public void TC_01_Display_Validation_Errors() {

		logger = report.createTest("Errors Validation");
		
		contact.validateContactPageErrors();
		
		logger.info("Validated UI Error messages displayed");
		
		contact.verifyContactUsUrl();
		
		logger.info("User unable to submit form");
		
		
	}

	// Dept Page - Create Department

	/*
	@Test( priority = 1, dependsOnMethods = "verifyPage")
	public void TC_01_Department_Create() {

		logger = report.createTest("Create Department Scenario");
		
		logger.info("Login as Account Administrator");

		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Dev", 1, 0),

				DataProviderFactory.getExcel().getCellData("Dev", 1, 1));

		login.verifyUrlAfterLogin();

		logger.info("Logged in");

		role.selectRoleAsAccountAdmin();

		logger.info("Account Administrator role selected");

		dept.navigateToDepartmentsPage();

		dept.verifyUrlAfterNavigateToDept();

		logger.info("Department Page");

		dept.AddDepartmentsPage();

		logger.info("Department Added");

		dept.verifyDeparment("Safety_peerjiAdd");

		logger.info("Department adddition verified");

	}
*/

}
