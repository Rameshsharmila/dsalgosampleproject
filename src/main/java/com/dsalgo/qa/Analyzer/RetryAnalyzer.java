package com.dsalgo.qa.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int retryLimit=2;

	//Override the retry method from the IRetryAnalyzer interface
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
	return false;
	}
}


