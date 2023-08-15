package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pageAction.Loginpage;
import com.pageAction.ResumePage;
import com.utils.Utility;

public class ResumeFntTest extends TestBase {
	
	
	@Test
	public void profile() {
		
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		
		Assert.assertEquals(ResumePage.resume().isDisplayed(), true);
		
	}
	
	@Test
	public void upload() {
		
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		Utility.sleepFor(4000);
		ResumePage.profileFunction();
		logger.info("redirect to  profile page");
		ResumePage.resume().click();
		Utility.sleepFor(5000);
		
		Utility.copyPaste("C:\\Users\\karth\\Desktop\\TestResume.docx");
		logger.info("file successfully uploaded");
		Utility.sleepFor(4000);
		Utility.refresh();
		Assert.assertEquals(ResumePage.deleteIcon().isDisplayed(), true);
		logger.info("Test passed");
		
		
	}
	
	@Test(dependsOnMethods = "upload" )
	public void downloadResume() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		Utility.sleepFor(4000);
		ResumePage.profileFunction();
		logger.info("redirect to  profile page");
		ResumePage.downloadResume().click();
		logger.info("file downloaded");
		Utility.sleepFor(4000);
		boolean filelocator = Utility.filelocator("C:\\Users\\karth\\Downloads", "Resume.docx");
		Assert.assertEquals(filelocator, true);
		logger.info("Test passed");
		
		
	}
	
	@Test(dependsOnMethods = "upload" )
	public void deleteResume() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		Utility.sleepFor(4000);
		ResumePage.profileFunction();
		logger.info("redirect to  profile page");
		ResumePage.deleteIcon().click();
		
	}

}
