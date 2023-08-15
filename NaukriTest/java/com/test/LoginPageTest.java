package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pageAction.Loginpage;
import com.utils.ExcelReader;

public class LoginPageTest extends TestBase {

	@Test(dataProvider = "ExcelData")
	public void loginMethod(String username, String password) {

		Loginpage.login(username, password);
		logger.info("user login");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), false);
		logger.info("Test passed");
	}

	@DataProvider(name = "ExcelData")
	public String[][] testData() {

		String[][] testData = ExcelReader.getTestData();
		return testData;
	}

	@Test
	public void loginMethod1() {

		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		logger.info("user login");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("Test passed");
	}

}
