package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pageAction.Loginpage;
import com.pageAction.SearchFunction;
import com.utils.Utility;

public class SeachFntTest extends TestBase {
	
	
	@Test(dependsOnMethods ="searchClick",priority = 3 )
	public void fullSearch() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		SearchFunction.clickSearch().click();
		SearchFunction.mSearch("QA","Testing");
		Utility.sleepFor(4000);
		SearchFunction.mSearch("Automation","Testing");
		Utility.sleepFor(4000);
		SearchFunction.expSelect("4");
		SearchFunction.searchBtn().click();
		Assert.assertEquals(SearchFunction.jobPage().isDisplayed(), true);
		logger.info("Test passed");
	}
	
	@Test(priority = 1)
	public void searchClick() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		SearchFunction.clickSearch().click();
		Assert.assertEquals(SearchFunction.searchBtn().isDisplayed(), true);
		System.out.println("Search area is enabled");
		logger.info("Test passed");
	}
	
	
	@Test(dependsOnMethods ="searchClick",priority = 2)
	public void keySelect() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		SearchFunction.clickSearch().click();
		SearchFunction.mSearch("QA","Testing");
		Assert.assertEquals(SearchFunction.keyWord().contains("Testing"), true);
		logger.info("Test passed");
		
	}	
	

}
