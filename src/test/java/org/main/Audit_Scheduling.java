package org.main;

import org.POM.Schedule;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Audit_Scheduling extends BaseClass {

	public Schedule s;
	public int Totaldates;

	@Test(priority = 2, groups = "Schedule")
	public void auditSchedule() throws InterruptedException {

		s = new Schedule(driver);

		Thread.sleep(5000);

		s.getAuditPlanscheduleLink().click();

		driver.navigate().refresh();

		Thread.sleep(5000);

		s.getAddBtn().click();

		WebElement entityTypeDropdowm = s.getEntityTypeDropdowm();

		Select se = new Select(entityTypeDropdowm);

		se.selectByVisibleText("Dealer");//1

		Thread.sleep(2000);

		WebElement entityDropdowm = s.getEntityDropdowm();

		Select se2 = new Select(entityDropdowm);

		se2.selectByVisibleText("graph1");//2

		// Assert.assertEquals(false, "Expected Entity is not available");

		Thread.sleep(2000);

		WebElement auditTemplateDropdowm = s.getAuditTemplateDropdowm();

		Select se3 = new Select(auditTemplateDropdowm);

		se3.selectByVisibleText("Test_valid");//3

		// Assert.assertEquals(false, "Expected Template is not available");

		Thread.sleep(2000);

		s.getCalendar().click();

		Thread.sleep(8000);

		int fromDate = 27;//4
		int toDate = 28;//5

		WebElement date = driver
				.findElement(By.xpath("//th[text()='Apr 2024']/../../following-sibling::tbody//td[text()='27']"));
		date.click();

		Thread.sleep(3000);

		WebElement date2 = driver
				.findElement(By.xpath("//th[text()='Apr 2024']/../../following-sibling::tbody//td[text()='28']"));
		date2.click();

		Thread.sleep(2000);

		s.getCalendarApplyBtn().click();

		Thread.sleep(2000);

		s.getIsNewChkbx().click();

		Thread.sleep(2000);

		s.getSaveBtn().click();

		Thread.sleep(1000);

		System.out.println(driver.findElement(By.xpath("//div[@class='toast-message']")).getText());

	}

}
