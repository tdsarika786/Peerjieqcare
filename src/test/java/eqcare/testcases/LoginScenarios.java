package eqcare.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import eqcare.pages.ContactUsPage;
import eqcare.pages.HomePage;
import eqcare.pages.LoginPage;
import eqcare.pages.LogoutPage;
import eqcare.factories.DataProviderFactory;
import eqcare.pages.BaseClass;

public class LoginScenarios extends BaseClass {

	LoginPage login;
	HomePage home;

	@Test(priority = 0)
	public void verifyPage() {

		login = PageFactory.initElements(driver, LoginPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		logger = report.createTest("Login URL validation");

		login.verifyUrlBeforeLogin();

		logger.info("Validating url");

	}

	@Test(priority = 1, dependsOnMethods = "verifyPage")
	public void loginToApplication() {

		logger = report.createTest("Login as patient not enrolled");

		login.loginToApplication(DataProviderFactory.getExcel().getCellData("EQCare", 1, 0),

				DataProviderFactory.getExcel().getCellData("EQCare", 1, 1));

		// login.loginToApplication("automationsaru@gmail.com", "Peerji#123");

		login.verifyUrlAfterLogin();

		logger.info("Patient Logged in");
	}

	@Test(priority = 2, dependsOnMethods = "loginToApplication")
	public void logoutFromApplication() {
		logger = report.createTest("Logout");

		// home.startVideoConsultation();

		home.logOutFromApplication();

		logger.info("Logout done");

	}

}