package org.MuhammadAhmad.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.MuhammadAhmad.utils.AppiumUtils;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils{

	public IOSDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\MuhammadAhmad\\resources\\data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		//code to start appium server
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("");
		options.setApp("");
		options.setPlatformVersion("");
		
		driver = new IOSDriver(service.getUrl(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
