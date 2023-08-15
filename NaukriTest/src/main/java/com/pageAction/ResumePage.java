package com.pageAction;

import org.openqa.selenium.WebElement;
import com.utils.GetElement;
import com.utils.Utility;

public class ResumePage {

	static String profile = "//div[@class='nI-gNb-drawer__icon-img-wrapper']",
			viewProfile = "//a[@class='nI-gNb-info__sub-link']",
			upLoad = "(//div[@class='action'])[1]",
			deleteIcon = "//div[@id='lazyAttachCV']//span[2]",
			profileElement = "//div[@class='s12 typ-16Bold']",
			downloadButton = "//i[@title='Click here to download your resume']";

	public static void profileFunction() {

		GetElement.getWebElement("XPATH", profile).click();
		GetElement.getWebElement("XPATH", viewProfile).click();
		Utility.eWait(resume());

	}

	public static WebElement deleteIcon() {

		return GetElement.getWebElement("XPATH", deleteIcon);

	}

	public static WebElement resume() {

		return GetElement.getWebElement("XPATH", profileElement);

	}
	
	public static WebElement downloadResume() {
		
		return GetElement.getWebElement("XPATH", downloadButton);
		
	}

}
