package org.MuhammadAhmad;

import org.MuhammadAhmad.TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_1 extends AndroidBaseTest{
	
	@BeforeMethod
	public void preSetup()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
//		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
//				ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
	}
	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException
	{
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Muhammad Ahmad");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
//		Thread.sleep(3000);
		
	}
	
	@Test
	public void FillForm_PositiveFlow() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Muhammad Ahmad");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
//		Thread.sleep(3000);
		
	}
	

	
}
