package quickseries.pages;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;


public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}



	public void verifyUrl() {
		Assert.assertTrue(driver.getCurrentUrl().contains("quickseries"), "Home Page does not contain quickseries in url");
	}


}
