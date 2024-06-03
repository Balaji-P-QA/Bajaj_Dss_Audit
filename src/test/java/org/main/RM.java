package org.main;

import org.POM.RMPojo;
import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RM extends BaseClass {

	@Test(priority = 3,groups = "Status")
	private void auditstatus() throws InterruptedException {

		RMPojo r = new RMPojo(driver);

		Thread.sleep(2000);

		r.getAuditPlanslink().click();

		Thread.sleep(2000);

		r.getPendingApproveReject().click();

		Thread.sleep(5000);

		String Status = "Approve";

		if (Status.equalsIgnoreCase("Approve")) {

			r.getApproveBtn().get(0).click();

			Thread.sleep(1000);

			System.out.println(r.getToasteMsg().getText());

		}
		else if (Status.equalsIgnoreCase("Reject")) {

			r.getRejctBtn().get(0).click();

			Thread.sleep(1000);

			r.getRjctCmnts().sendKeys("CMT_Reject");

			Thread.sleep(4000);

			r.getRjctCmtBtn().click();

			Thread.sleep(1000);

			System.out.println(r.getToasteMsg().getText());

		} else {

			r.getReplnBtn().get(0).click();

			Thread.sleep(1000);

			r.getReplnCmnts().sendKeys("CMT_RePlanned");

			Thread.sleep(1000);

			r.getRePlnCmtBtn().click();

			Thread.sleep(1000);

			System.out.println(r.getToasteMsg().getText());

		}

	}

}
