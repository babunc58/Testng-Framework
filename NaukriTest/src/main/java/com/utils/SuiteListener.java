package com.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.base.TestBase;

public class SuiteListener implements IAnnotationTransformer, ITestListener {

	public void onTestFailure(ITestResult result) {
		
		

		try {
		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getMethod().getMethodName();
		File fi = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(fi, new File(filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyser.class);

	}
}
