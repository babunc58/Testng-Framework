package com.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class Utility extends TestBase{
	
	public static void sleepFor(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void copyPaste(String fileLocation) {
		
		try {
			Robot robot= new Robot();
			
			robot. setAutoDelay (2000) ;

			StringSelection stringSelection = new StringSelection (fileLocation) ; 
			Toolkit. getDefaultToolkit ().getSystemClipboard ().setContents (stringSelection, null) ;

			robot. setAutoDelay (1000) ;

			robot. keyPress (KeyEvent . VK_CONTROL) ; 
			robot. keyPress (KeyEvent . VK_V) ;

			robot . keyRelease (KeyEvent . VK_CONTROL) ; 
			robot . keyRelease (KeyEvent . VK_V) ;

			robot. setAutoDelay (1000) ;

			robot. keyPress (KeyEvent . VK_ENTER) ; 
			robot. keyRelease (KeyEvent . VK_ENTER) ;
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}	
	}
	
	public static void refresh() {
		
		driver.navigate().refresh();
	}
	
	public static boolean filelocator(String location, String fileName) {
		
		File files = new File(location);
		File[] listFiles = files.listFiles();
		int i=0;
		for (File file : listFiles) {
			String name = file.getName();
			if(name.equals(fileName)) {
				i++;
			}					
		}
		if(i==0) return false;
		else return true;
	}	
	public static void eWait(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(d -> element.isDisplayed());
	}
	public static void  Checkbox(WebElement pmt) {
		if (pmt.isEnabled() == false) {
			pmt.click();
		}
	}
}
