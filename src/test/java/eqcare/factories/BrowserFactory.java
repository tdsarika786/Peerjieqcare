package eqcare.factories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

	public static void closeApplication(WebDriver driver) {
		driver.quit();
		System.out.println("LOG:INFO- Session closed");
	}

	public static WebDriver getApplication(String browser, String appURL) {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/Drivers/chromedriver1");
			System.setProperty("webdriver.chrome.driver", "/Users/sarikadhall/Downloads/chromedriver");

			// ChromeOptions optionsC = new ChromeOptions();
			// optionsC.addArguments(Arrays.asList("disable-infobars",
			// "ignore-certificate-errors",
			// "start-maximized","use-fake-ui-for-media-stream"));

			//////

			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("use-fake-ui-for-media-stream");
			//options.addArguments("--window-size=1920,1080");
			options.addArguments("start-fullscreen");
			//DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability("browser", "Chrome");
			//caps.setCapability("browser_version", "75.0");
			//caps.setCapability("os", "Windows");
			//caps.setCapability("os_version", "10");
			//caps.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(options);

			// return new ChromeDriver(options);

			/////

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sarikadhall/Downloads/geckodriver");

			// System.setProperty("webdriver.gecko.driver",
			// System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {

			// System.setProperty("webdriver.ie.driver",
			// System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver = new SafariDriver();
		} else {
			System.out.println("Sorry we do not support this browser");
		}
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getApplication1(String browser, String appURL) {

		WebDriver driver1 = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/Drivers/chromedriver1");
			System.setProperty("webdriver.chrome.driver", "/Users/sarikadhall/Downloads/chromedriver");

			// ChromeOptions optionsC = new ChromeOptions();
			// optionsC.addArguments(Arrays.asList("disable-infobars",
			// "ignore-certificate-errors",
			// "start-maximized","use-fake-ui-for-media-stream"));

			//////

			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("use-fake-ui-for-media-stream");

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "75.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			driver1 = new ChromeDriver(options);

			// return new ChromeDriver(options);
		}
		/////
		// driver.manage().window().maximize();
		driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver1.get(appURL);
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver1;

	}

}
