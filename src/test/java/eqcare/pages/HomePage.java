package eqcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import eqcare.factories.DataProviderFactory;
import eqcare.helper.Utility;


public class HomePage {

	WebDriver driver;
	
	By logoutText=By.xpath("//a[contains(text(), 'Logout')]");
	
	By startVisitButton=By.xpath("//a[@data-role='start-visit-button']");
	
	By startCallButton=By.xpath("//a[@data-role='start-call-button']");
	
	By videoEndCallButton=By.xpath("//a[@data-role='video-end-call-button']");
	
	By confirmEndCallButton=By.xpath("//a[@data-role='confirm-end-call-button']");
	
	By ratingHeart=By.xpath("//div[@class='rating-heart-5']");
	
	By submitText=By.xpath("//a[contains(text(), 'Submit')]");
	
	By homeButton=By.xpath("//a[contains(text(), 'Homepage')]");
	
	//Device Check
	
	By nextStepText=By.xpath("//a[contains(text(), 'Next Step')]");
	
	By continueToVisitText=By.xpath("//a[contains(text(), 'Continue To Visit')]");
	
	By homeLink=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[1]/div[2]/a[1]");
	
	
	

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}



	public void verifyUrl() {
		Assert.assertTrue(driver.getCurrentUrl().contains("quickseries"), "Home Page does not contain quickseries in url");
	}


	
	
	public void logOutFromApplication() {
	
		Utility.waitForWebElement(driver, logoutText).click();
	}

	public void startVideoConsultation() {
		
		
		
		Utility.waitForWebElement(driver, startCallButton).click();
		
		
		
		Utility.waitForWebElement(driver, videoEndCallButton).click();
		
		Utility.waitForWebElement(driver, confirmEndCallButton).click();
		
		Utility.waitForWebElement(driver, ratingHeart).click();
		
		Utility.waitForWebElement(driver, submitText).click();
		
		Utility.waitForWebElement(driver, homeButton).click();
	
	}
	
	
     public void deviceCheck() {
		
		Utility.waitForWebElement(driver, startVisitButton).click();
		
       // Utility.waitForWebElement(driver, startVisitButton).click();
		
		Utility.waitForWebElement(driver, nextStepText).click();
		
		//Utility.waitForWebElement(driver, nextStepText).click();
		
		Utility.waitForWebElement(driver, continueToVisitText).click();
		
		//Utility.waitForWebElement(driver, startVisitButton).click();
		
     }
     
     public void navigateToHomePage() {

    	 Utility.waitForWebElement(driver, homeLink).click();


 	}
}
