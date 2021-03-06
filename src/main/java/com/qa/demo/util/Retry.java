package com.qa.demo.util;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.demo.base.CommonMethods2;

public class Retry implements IRetryAnalyzer{

    private int count = 0;
    private static int maxTry = 1;
    
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
        	
        	
        CommonMethods2.takeScreenshotAtEndOfTest(); 		// Take ScreenShot
        	
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}
