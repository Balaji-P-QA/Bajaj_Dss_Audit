package org.master;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.POM.AuditEntityPojo;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AuditEntity extends BaseClass {

	public Robot r;
	
	AuditEntityPojo a = new AuditEntityPojo(driver);

	@Test
	private void entity() throws InterruptedException, IOException, AWTException {

		login("balcvcybage1@bajajauto.co.in", "Dell@e5400");

		Thread.sleep(2000);

		Category.MasterSection();

		Thread.sleep(2000);

		WebElement auditEntity = a.getAuditEntity();
		auditEntity.click();

		Thread.sleep(2000);

		String auditEntityWork = "delete";

		if (auditEntityWork.equalsIgnoreCase("Create")) {

			WebElement addAuditEntity = a.getAddAuditEntity();
			addAuditEntity.click();

			Thread.sleep(2000);

			WebElement auditEntityType = a.getAuditEntityType();

			WebElement dealerDD = a.getDealerDD();

			WebElement dealerSrchDD = a.getDealerSrchDD();
			
			WebElement dealFirmOutlet = a.getDealFirmOutlet();

			WebElement auditEntityCode = a.getAuditEntityCode();

			WebElement cstName = a.getCstName();

			WebElement outletLocation = a.getOutletLocation();

			WebElement email = a.getEmail();

			WebElement contactNumber = a.getContactNumber();

			String entity_Type = "Dealer";

			if (entity_Type.equalsIgnoreCase("CST")) {

				Select s = new Select(auditEntityType);
				s.selectByVisibleText("CST");

				Thread.sleep(2000);

				dealerDD.click();

				dealerSrchDD.sendKeys("Automation_Deal/firm/outlet");

				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);

				Thread.sleep(2000);

				dealFirmOutlet.sendKeys("Automation_Deal/firm/outlet");

				Thread.sleep(2000);

				auditEntityCode.sendKeys("CST1234");

				Thread.sleep(2000);

				cstName.sendKeys("Automation_CST");

				Thread.sleep(2000);

				outletLocation.sendKeys("Automation_CST_Location");

				Thread.sleep(2000);

				email.sendKeys("automation_cst@mailinator.com");

				Thread.sleep(2000);

				contactNumber.sendKeys("9911223311");

				Thread.sleep(2000);

			} else if (entity_Type.equalsIgnoreCase("ASC")) {

				Select s = new Select(auditEntityType);
				s.selectByVisibleText("ASC");

				Thread.sleep(2000);

				dealerDD.click();

				dealerSrchDD.sendKeys("Automation_Deal/firm/outlet");

				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);

				Thread.sleep(3000);

				dealFirmOutlet.sendKeys("Automation_Deal/firm/outlet");

				Thread.sleep(2000);

				auditEntityCode.sendKeys("ASC1234");

				Thread.sleep(2000);

				outletLocation.sendKeys("Automation_ASC_Location");

				Thread.sleep(2000);

				email.sendKeys("automation_asc@mailinator.com");

				Thread.sleep(2000);

				contactNumber.sendKeys("9911223322");

				Thread.sleep(2000);

			} else if (entity_Type.equalsIgnoreCase("Branch")) {

				Select s = new Select(auditEntityType);
				s.selectByVisibleText("Branch");

				WebElement branchType = a.getBranchType();
				Select s1 = new Select(branchType);
				s1.selectByVisibleText("2S");

				dealerDD.click();

				dealerSrchDD.sendKeys("Automation_Deal/firm/outlet");

				Thread.sleep(3000);

				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);

				Thread.sleep(2000);

				dealFirmOutlet.sendKeys("Automation_Deal/firm/outlet");

				Thread.sleep(2000);

				auditEntityCode.sendKeys("BR1234");

				Thread.sleep(2000);

				outletLocation.sendKeys("Automation_BR_Location");

				Thread.sleep(2000);

				email.sendKeys("automation_br@mailinator.com");

				Thread.sleep(2000);

				contactNumber.sendKeys("9911223333");

				Thread.sleep(2000);

			} else if (entity_Type.equalsIgnoreCase("Dealer")) {

				Select s = new Select(auditEntityType);
				s.selectByVisibleText("Dealer");

				WebElement regionDD = a.getRegionDD();

				WebElement asmDD = a.getAsmDD();

				WebElement stateDD = a.getStateDD();

				WebElement cityDD = a.getCityDD();

				dealFirmOutlet.sendKeys("Automation_Deal/firm/outlet");

				Thread.sleep(2000);

				Thread.sleep(2000);

				email.sendKeys("automation_dealer@mailinator.com");

				Thread.sleep(2000);

				contactNumber.sendKeys("9911223344");

				Thread.sleep(2000);

				Select s3 = new Select(regionDD);
				s3.selectByVisibleText("Bhubaneswar");

				Thread.sleep(2000);

				Select s4 = new Select(asmDD);
				s4.selectByVisibleText("balcvcybage4(ASM)");

				Thread.sleep(2000);

				Select s5 = new Select(stateDD);
				s5.selectByVisibleText("Odisa");

				Thread.sleep(2000);

				Select s6 = new Select(cityDD);
				s6.selectByVisibleText("kanchipuram");

				Thread.sleep(2000);
			}

			WebElement saveBtn = a.getSaveBtn();
			saveBtn.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			try {

				WebElement toasterMsg = a.getToasterMsg();

				String tosterMsgTxt = toasterMsg.getText();

				if (tosterMsgTxt.equalsIgnoreCase("New audit entity has been created successfully!")) {

					System.out.println(tosterMsgTxt);

				} else {

					System.out.println(tosterMsgTxt);

				}

			} catch (Exception e) {

				List<WebElement> wrngMsg = a.getWrngMsg();

				for (WebElement wrngMsgs : wrngMsg) {

					System.out.println(wrngMsgs.getText());

				}

			}

		} else if (auditEntityWork.equalsIgnoreCase("delete")) {
			
			WebElement searchTxtbx = a.getSearchTxtbx();
			searchTxtbx.sendKeys("Dealer1234");
			
			Thread.sleep(2000);
			
			try {
				
				WebElement delteBtn = a.getDelteBtn();
				delteBtn.click();
				
				Thread.sleep(2000);
				
				WebElement popupDeletecnfm = a.getPopupDeletecnfm();
				popupDeletecnfm.click();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebElement deletetstMsg = a.getDeletetstMsg();
				
				System.out.println(deletetstMsg.getText());
				
			} catch (Exception e) {
				
				System.out.println("User entered entity is not available");
				
				
			}
			
		
		}

	}

}
