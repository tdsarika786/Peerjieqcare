package eqcare.helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {
	
	/*
	 * 1- Screenshot- which will return path 2- Handle Sync 3- Highlight element 4-
	 * Lib which will handle alert,frame,window with Explicit Wait 5-
	 * DateTimeUtility 6- Assertion Lib 7- Title, url with Assertion using
	 * ExplicitWait 8- FluentWait- CustomWait function 9- Capturing message and
	 * verify 10-Soft Assert
	 * 
	 * 
	 * 
	 * 
	 */

	public static void verifyPartialText(WebDriver driver, By byLocator, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		WebElement element = waitForWebElement(driver, byLocator);

		boolean status = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));

		Assert.assertTrue(status);

		
	}
	
	public static void verifyURLContains(WebDriver driver,String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}


	public static void verifyText(WebDriver driver, By byLocator, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		boolean status = wait.until(ExpectedConditions.textToBe(byLocator, expectedText));

		Assert.assertTrue(status);
;
	}

	public static String getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir") + "/Screenshots/Screenshot_" + getCurrentTime() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot");
		}
		return path;
	}

	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("ss_mm_HH_dd_MM_yyyy");

		Date date = new Date();

		return dateFormat.format(date);

	}

	public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		
		
		
	}

	
	public static WebElement waitForWebElement(WebDriver driver, By byLocator) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		
		//WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		
		
		highLightElement(driver, element);

		return element;
	}

	

	public static void verifyTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}

	

	public static void navigateToURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.navigate().to(url);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));

	}

	public static void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

		}
	}
	
	public static void highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	//JavascriptExecutor executor1=(JavascriptExecutor)driver;
			//executor1.executeScript("arguments[0].click()",checkBox1);
	
	public static void highLightElement1(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click());", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		//js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}


}
