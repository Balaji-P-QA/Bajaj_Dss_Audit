package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditEntityPojo {

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the auditEntity
	 */
	public WebElement getAuditEntity() {
		return auditEntity;
	}

	/**
	 * @return the addAuditEntity
	 */
	public WebElement getAddAuditEntity() {
		return addAuditEntity;
	}

	/**
	 * @return the auditEntityType
	 */
	public WebElement getAuditEntityType() {
		return auditEntityType;
	}

	/**
	 * @return the dealerDD
	 */
	public WebElement getDealerDD() {
		return dealerDD;
	}

	/**
	 * @return the dealerSrchDD
	 */
	public WebElement getDealerSrchDD() {
		return dealerSrchDD;
	}

	/**
	 * @return the dealFirmOutlet
	 */
	public WebElement getDealFirmOutlet() {
		return dealFirmOutlet;
	}

	/**
	 * @return the auditEntityCode
	 */
	public WebElement getAuditEntityCode() {
		return auditEntityCode;
	}

	/**
	 * @return the cstName
	 */
	public WebElement getCstName() {
		return cstName;
	}

	/**
	 * @return the outletLocation
	 */
	public WebElement getOutletLocation() {
		return outletLocation;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @return the contactNumber
	 */
	public WebElement getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return the branchType
	 */
	public WebElement getBranchType() {
		return branchType;
	}

	/**
	 * @return the regionDD
	 */
	public WebElement getRegionDD() {
		return regionDD;
	}

	/**
	 * @return the asmDD
	 */
	public WebElement getAsmDD() {
		return asmDD;
	}

	/**
	 * @return the stateDD
	 */
	public WebElement getStateDD() {
		return stateDD;
	}

	/**
	 * @return the cityDD
	 */
	public WebElement getCityDD() {
		return cityDD;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the toasterMsg
	 */
	public WebElement getToasterMsg() {
		return toasterMsg;
	}

	/**
	 * @return the wrngMsg
	 */
	public List<WebElement> getWrngMsg() {
		return wrngMsg;
	}

	/**
	 * @return the searchTxtbx
	 */
	public WebElement getSearchTxtbx() {
		return searchTxtbx;
	}

	/**
	 * @return the delteBtn
	 */
	public WebElement getDelteBtn() {
		return delteBtn;
	}

	/**
	 * @return the popupDeletecnfm
	 */
	public WebElement getPopupDeletecnfm() {
		return popupDeletecnfm;
	}

	/**
	 * @return the deletetstMsg
	 */
	public WebElement getDeletetstMsg() {
		return deletetstMsg;
	}


	public WebDriver driver;
	
	public AuditEntityPojo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[text()='Audit Entity']")
	private WebElement auditEntity;
	
	@FindBy(xpath="//a[text()='Add Audit Entity']")
	private WebElement addAuditEntity;
	
	@FindBy(xpath="//select[@name='AuditEntityTypeId']")
	private WebElement auditEntityType;
	
	@FindBy(xpath="//div[@class='filter-option-inner-inner']")
	private WebElement dealerDD;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement dealerSrchDD;
	
	@FindBy(xpath="//input[@name='AuditEntity']")
	private WebElement dealFirmOutlet;
	
	@FindBy(xpath="//input[@name='AuditEntityCode']")
	private WebElement auditEntityCode;
	
	@FindBy(xpath="//input[@id='cst-input']")
	private WebElement cstName;
	
	@FindBy(xpath="//input[@id='otl-input']")
	private WebElement outletLocation;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='MobileNo']")
	private WebElement contactNumber;
	
	@FindBy(xpath="//select[@name='BranchTypeId']")
	private WebElement branchType;
	
	@FindBy(xpath="//select[@name='RegionId']")
	private WebElement regionDD;
	
	@FindBy(xpath="//select[@name='ASMId']")
	private WebElement asmDD;
	
	@FindBy(xpath="//select[@name='StateId']")
	private WebElement stateDD;
	
	@FindBy(xpath="//select[@name='CityId']")
	private WebElement cityDD;
	
	@FindBy(xpath="//input[@id='SubmitButton']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement toasterMsg;
	
	@FindBy(xpath="// span[@class='text-danger error-msg field-validation-error']")
	private List<WebElement> wrngMsg;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtbx;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement delteBtn;
	
	@FindBy(xpath="//button[@onClick='deleteAuditEntity()']")
	private WebElement popupDeletecnfm;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement deletetstMsg;
	
	
	
	
	
	
	
	
}
