package org.MuhammadAhmad.pageObjects.android;

import java.util.List;

import org.MuhammadAhmad.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{
	
	AndroidDriver driver;
	
	public ProductCatalogue(AndroidDriver driver) //Constructor of ProductCatalogue class
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"ADD TO CART\"]")
	private List<WebElement> addToCart;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(6000);
		return new CartPage(driver);
	}

}
