package org.main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Ex_Reports {

	public static ExtentReports getReport() {

		String path = System.getProperty("user.dir")+"\\ReportsCollection\\Repo.index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("DSS Audit Scheduling Report");
		reporter.config().setDocumentTitle("Dss_Audit");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Lead", "Lavanya.P");
		extent.setSystemInfo("Tester Name", "Balaji.P");

		return extent;

	}

}
