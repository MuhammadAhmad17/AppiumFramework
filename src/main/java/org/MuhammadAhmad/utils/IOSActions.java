package org.MuhammadAhmad.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{
	
	IOSDriver driver;
	
	public IOSActions(IOSDriver driver) 
	{

		this.driver = driver;
	}

}
