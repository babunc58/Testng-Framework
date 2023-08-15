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
		ResumePage.resume().click();
		Utility.sleepFor(5000);
		logger.info("redirect to  profile page");
		Utility.copyPaste("C:\\Users\\karth\\Desktop\\TestResume.docx");
		logger.info("file successfully uploaded");
		Utility.sleepFor(4000);
		Utility.refresh();
		Assert.assertEquals(ResumePage.deleteIcon().isDisplayed(), true);
		logger.info("Test passed");
		
		
	}
	
	@Test
	public void download() {
		Loginpage.login("naveenautoproj@gmail.com", "Chellamuthu4858");
		Assert.assertEquals(Loginpage.profile().isDisplayed(), true);
		logger.info("login passed");
		Utility.sleepFor(4000);
		ResumePage.profileFunction();
		ResumePage.downloadResume().click();
		logger.info("file downloaded");
		Utility.sleepFor(4000);
		boolean filelocator = Utility.filelocator("C:\\Users\\karth\\Downloads", "Resume(3).docx");
		Assert.assertEquals(filelocator, true);
		logger.info("Test passed");
		
		
	}

}
