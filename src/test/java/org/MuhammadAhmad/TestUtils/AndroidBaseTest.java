package org.MuhammadAhmad.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.MuhammadAhmad.pageObjects.android.FormPage;
import org.MuhammadAhmad.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils {
	public AndroidDriver driver;
	AppiumDriverLocalService service;
	public FormPage formPage;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\MuhammadAhmad\\resources\\data.properties");
		//ternary operator if values come from terminal it will take these values
		String ipAddress = System.getProperty("ipAddress")!= null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		prop.load(fis);
//		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		//code to start appium server
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		//Opening the app through driver
		UiAutomator2Options options = new UiAutomator2Options();
//		options.setChromedriverExecutable("C:\\Users\\m.ahmad\\Downloads\\chromedriver_win32 (1)");
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\org\\MuhammadAhmad\\resources\\General-Store.apk");
//		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
		service.stop();
		//stop appium server
	}

}
