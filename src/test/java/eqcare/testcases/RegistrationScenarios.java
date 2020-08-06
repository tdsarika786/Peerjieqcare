package eqcare.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import eqcare.pages.ContactUsPage;
import eqcare.pages.HomePage;
import eqcare.pages.LoginPage;
import eqcare.pages.RegistrationPage;
import eqcare.factories.DataProviderFactory;
import eqcare.pages.BaseClass;

public class RegistrationScenarios extends BaseClass {

	RegistrationPage register;

	
	@Test(priority=0)
	public void verifyPage()
	{		
				
		register=PageFactory.initElements(driver, RegistrationPage.class);
		
		logger=report.createTest("Registration Page URL validation");
		
		register.verifyUrlBeforeLogin();	
		
		logger.info("Validating url");
		
	}
	
	@Test(priority=1,dependsOnMethods="verifyPage")
	public void registerToApplication() throws InterruptedException
	{
		
		logger=report.createTest("Register Not Enrolled User");
		
		//register.clickOnRegisterButton();
		
		register.notEnrolledRegisteration(DataProviderFactory.getExcel().getCellData("Users", 1, 0),
				
		DataProviderFactory.getExcel().getCellData("Users", 1, 1),DataProviderFactory.getExcel().getCellData("Users", 1, 2),
		
	    DataProviderFactory.getExcel().getCellData("Users", 1, 4),
		
		DataProviderFactory.getExcel().getCellData("Users", 1, 5), DataProviderFactory.getExcel().getCellData("Users", 1, 6),
		
		DataProviderFactory.getExcel().getCellData("Users", 1, 7), DataProviderFactory.getExcel().getCellData("Users", 1, 8),
		
		DataProviderFactory.getExcel().getCellData("Users", 1, 9)
		);
		
		//login.verifyUrlAfterLogin();
		
		logger.info("User Register in EQCare as Patient");
	}
	
	@Test(priority=2,dependsOnMethods="loginToApplication", enabled=false)
	public void logoutFromApplication()
	{
		logger=report.createTest("Logout");
		
	//	logout.logOutFromApplicationWithAdminRole();
		
		logger.info("Logout done");
		
	}

}