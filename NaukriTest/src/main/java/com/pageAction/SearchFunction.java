package com.pageAction;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.utils.GetElement;
import com.utils.Utility;

public class SearchFunction {

	static String searchArea = "//span[@class='nI-gNb-sb__placeholder']",
			sKeyword = "//input[contains(@placeholder,'Enter keyword')]",
			sKeyList = "//ul/li/div/span[@class='pre-wrap']", 
			sExp = "//input[@id='experienceDD']",
			sExpList = "(//div/ul)[8]/li/div/span", 
			sLocation = "//input[@placeholder='Enter location']",
			sLocList = "//div/ul/li/div/span/b[@class='pre-wrap']",
			sButton = "//button[@class='nI-gNb-sb__icon-wrapper']",
			jobText = "//span[text()='Work mode']";

	static List<WebElement> list1 = null;
	public static WebElement clickSearch() {
		return GetElement.getWebElement("XPATH", searchArea);
	}

	public static void mSearch(String value1, String keyword) {

		GetElement.getWebElement("XPATH", sKeyword).sendKeys(value1);
		 list1 = GetElement.getWebElements("XPATH", sKeyList);
		 Utility.eWait(list1.get(0));
		for (WebElement webElement : list1) {
			String text = webElement.getText();
			if (text.contains(keyword)) {
				webElement.click();
				break;
			}
		}
		list1.clear();
	}
	
	public static String keyWord() {
		return GetElement.getWebElement("XPATH", sKeyword).getAttribute("keyword");
		
	}

	public static void expSelect(String year) {

		GetElement.getWebElement("XPATH", sExp).click();
		list1 = GetElement.getWebElements("XPATH", sExpList);
		Utility.eWait(list1.get(0));
		for (WebElement webElement : list1) {
			String text = webElement.getText();
			if (text.equalsIgnoreCase(year + " years")) {
				webElement.click();
				break;
			}
		}
		list1.clear();
	}

	public static void clickLocation() {

		GetElement.getWebElement("XPATH", sLocation).click();

	}

	public static void locationSel(String value, String location) {

		GetElement.getWebElement("XPATH", sLocation).sendKeys(value);
		list1 = GetElement.getWebElements("XPATH", sLocList);
		 Utility.eWait(list1.get(0));
		for (WebElement webElement : list1) {
			String text = webElement.getText();
			if (text.equalsIgnoreCase(location)) {
				webElement.click();
				break;
			}
		}
		list1.clear();
	}
	public static WebElement searchBtn() {
		return GetElement.getWebElement("XPATH", sButton);
	}
	public static WebElement jobPage() {
		return GetElement.getWebElement("XPATH", jobText);
	}
}
