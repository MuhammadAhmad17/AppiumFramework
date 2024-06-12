package org.MuhammadAhmad;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.MuhammadAhmad.TestUtils.AndroidBaseTest;
import org.MuhammadAhmad.pageObjects.android.CartPage;
import org.MuhammadAhmad.pageObjects.android.FormPage;
import org.MuhammadAhmad.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest{
	
	
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void FillForm(HashMap<String,String> input) throws InterruptedException
	{
//		FormPage formPage = new FormPage(driver); //object of Form page class
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0); 
		CartPage cartPage = productCatalogue.goToCartPage();
		
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		double totalSum = cartPage.getProductSum();
		double displayFormattedsum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedsum);
		cartPage.acceptTermsAndConditions();
	    cartPage.submitOrder();
		Thread.sleep(5000);	
	}

	@BeforeMethod(alwaysRun=true)
	public void preSetup()
	{
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data= getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\MuhammadAhmad\\testData\\eCommerce.json");
		
//		return new Object[][] {{"Muhammad Ahmad","female","Argentina"},{"Ahmad","male","Argentina"}};
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	
}
