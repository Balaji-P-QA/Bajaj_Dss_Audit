package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RMPojo {

	public WebDriver driver;
	
	public RMPojo(WebDriver driver) {

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[text()=' Audit Plans ']")
	private WebElement auditPlanslink;
	
	@FindBy(xpath="//a[text()='Pending/Approved/Rejected']")
	private WebElement pendingApproveReject;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private List<WebElement> Auditname;
	
	@FindBy(xpath="//a[text()='Approve']")
	private List<WebElement> approveBtn;
	
	@FindBy(xpath="//button[text()='Re-plan']")
	private List<WebElement> replnBtn;
	
	@FindBy(xpath="//button[text()='Reject']")
	private List<WebElement> rejctBtn;
	
	@FindBy(xpath="//textarea[@id='txt-revisit-comments']")
	private WebElement replnCmnts ;
	
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the auditPlanslink
	 */
	public WebElement getAuditPlanslink() {
		return auditPlanslink;
	}

	/**
	 * @return the pendingApproveReject
	 */
	public WebElement getPendingApproveReject() {
		return pendingApproveReject;
	}

	/**
	 * @return the auditname
	 */
	public List<WebElement> getAuditname() {
		return Auditname;
	}

	/**
	 * @return the approveBtn
	 */
	public List<WebElement> getApproveBtn() {
		return approveBtn;
	}

	/**
	 * @return the replnBtn
	 */
	public List<WebElement> getReplnBtn() {
		return replnBtn;
	}

	/**
	 * @return the rejctBtn
	 */
	public List<WebElement> getRejctBtn() {
		return rejctBtn;
	}

	/**
	 * @return the replnCmnts
	 */
	public WebElement getReplnCmnts() {
		return replnCmnts;
	}

	/**
	 * @return the rePlnCmtBtn
	 */
	public WebElement getRePlnCmtBtn() {
		return rePlnCmtBtn;
	}

	/**
	 * @return the rjctCmnts
	 */
	public WebElement getRjctCmnts() {
		return rjctCmnts;
	}

	/**
	 * @return the rjctCmtBtn
	 */
	public WebElement getRjctCmtBtn() {
		return rjctCmtBtn;
	}

	/**
	 * @return the toasteMsg
	 */
	public WebElement getToasteMsg() {
		return toasteMsg;
	}

	@FindBy(xpath="(//button[text()='Re-plan'])[2]")
    private WebElement rePlnCmtBtn ;
	
	@FindBy(xpath="//textarea[@id='txt-reject-comments']")
	private WebElement rjctCmnts ;
	
	@FindBy(xpath="(//button[text()='Reject'])[2]")
    private WebElement rjctCmtBtn ;		
			
	@FindBy(xpath="//div[@class='toast-message']")
    private WebElement toasteMsg ;
	
	
	
	
	
			
	
	
}
