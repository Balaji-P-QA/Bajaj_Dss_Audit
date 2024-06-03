package org.main;

import java.util.Set;

import org.base.BaseClass;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AuditScheduleListener extends BaseClass implements ITestListener {

	ExtentReports extent = Ex_Reports.getReport();

	ExtentTest test;
	

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Testcase Pass");

	}

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

		String FilePath = null;

		try {

			FilePath = SS(result.getMethod().getMethodName());

		} catch (Exception e) {

			e.printStackTrace();

		}

		test.addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {

		test.skip(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
