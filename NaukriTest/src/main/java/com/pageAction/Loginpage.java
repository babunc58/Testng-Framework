package com.pageAction;

import org.openqa.selenium.WebElement;

import com.utils.GetElement;

public class Loginpage {
	
	static String login = "//a[@id='login_Layer']",
			userName = "//input[contains(@placeholder,'Username')]",
			password = "//input[contains(@placeholder,'password')]",
			signInBtn = "//button[@type='submit']",
			Profile = "//div[text()='Jobs']";

	public static void login(String username, String pass) {
		
		GetElement.getWebElement("XPATH",login ).click();
		GetElement.getWebElement("XPATH",userName ).sendKeys(username);
		GetElement.getWebElement("XPATH",password ).sendKeys(pass);
		GetElement.getWebElement("XPATH",signInBtn ).click();
		
		
	}
	public static WebElement profile() {
		
		return GetElement.getWebElement("XPATH",Profile );
	}
	
}
