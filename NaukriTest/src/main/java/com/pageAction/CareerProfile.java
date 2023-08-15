package com.pageAction;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.utils.GetElement;

public class CareerProfile {
	
	static String editIcon = "(//span[text()='editOneTheme'])[4]",
			industry = "//input[@id='industryFor']",
			department = "//input[@id='fareaDroopeFor']",
			permanent = "//label[@for='permanent']",
			contract = "//label[@for='contractual']",
			fullTime = "//label[@for='fullTime']",
			partTime = "//label[@for='partTime']",
//			day = "//label[@for='day_shift']",
//			night = "//label[@for='night_shift']",
//			flexible = "//label[@for='flexible_shift']",
			radioBtn = "//div[@class='col s3']/label",
			location = "//input[@id='locationSugg']",
			locateDD = "(//div/ul)[19]/li",
			moneySymbol = "//div[@class='currency-dropdown']",
			salary = "//input[@placeholder='Eg. 4,50,000']";

	
	public static WebElement edit() {
		return GetElement.getWebElement("XPATH", editIcon);
	}
	
	public static void indDropdown(String company) {
		
		String dropDown = "(//ul)[17]/li/a[@href='javascript:;']";
		GetElement.getWebElement("XPATH", industry).click();
		List<WebElement> list = GetElement.getWebElements("XPATH", dropDown);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if(text.contains(company)) {
			webElement.click();
			}
		}
	}
	public static void departDropdown(String depart) {
		
		String dropDown = "(//ul)[17]/li/a[@href='javascript:;']";
		GetElement.getWebElement("XPATH", department).click();
		List<WebElement> list = GetElement.getWebElements("XPATH", dropDown);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if(text.contains(depart)) {
				webElement.click();
				
			}
		}	
	}
	
	public static WebElement pmtCheckbox() {

		return GetElement.getWebElement("XPATH", permanent);
	}

	public static WebElement cntrtCheckbox() {

		return GetElement.getWebElement("XPATH", contract);
	}

	public static WebElement ftCheckbox() {

		return GetElement.getWebElement("XPATH", fullTime);
	}

	public static WebElement ptCheckbox() {

		return GetElement.getWebElement("XPATH", partTime);
	}
	
	public static void radiobtn(String timing) {
	
		List<WebElement> list = GetElement.getWebElements("XPATH", radioBtn);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if (text.equalsIgnoreCase(timing)) {
				webElement.click();
				break;
			}	
		}
	}
	public static void locateSelect(String cityName) {
		
		List<WebElement> list = GetElement.getWebElements("XPATH", locateDD);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if (text.equalsIgnoreCase(cityName) && webElement.isEnabled()==false) {
				webElement.click();
				break;
			}	
		}
	}
}
