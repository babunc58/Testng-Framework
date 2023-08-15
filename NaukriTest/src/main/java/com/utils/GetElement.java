package com.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.TestBase;

public class GetElement {

	public static WebElement getWebElement(String indentifierType, String identifierValue) {

		switch (indentifierType) {

		case "XPATH":
			return TestBase.driver.findElement(By.xpath(identifierValue));
		
		case "CSS":
			return TestBase.driver.findElement(By.cssSelector(identifierValue));
		
		case "ID":
			return TestBase.driver.findElement(By.id(identifierValue));
		
		case "NAME":
			return TestBase.driver.findElement(By.name(identifierValue));
		
		case "TAGNAME":
			return TestBase.driver.findElement(By.tagName(identifierValue));

		default:
			return null;

		}
	}
	

	public static List<WebElement> getWebElements(String indentifierType, String identifierValue) {

		switch (indentifierType) {

		case "XPATH":
			return TestBase.driver.findElements(By.xpath(identifierValue));
		
		case "CSS":
			return TestBase.driver.findElements(By.cssSelector(identifierValue));
		
		case "ID":
			return TestBase.driver.findElements(By.id(identifierValue));
		
		case "NAME":
			return TestBase.driver.findElements(By.name(identifierValue));
		
		case "TAGNAME":
			return TestBase.driver.findElements(By.tagName(identifierValue));

		default:
			return null;

		}
	}
	
}
