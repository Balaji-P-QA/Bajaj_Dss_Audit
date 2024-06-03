package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserListPojo{

	public WebDriver driver;

	public UserListPojo(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the userList
	 */
	public WebElement getUserList() {
		return userList;
	}

	/**
	 * @return the addUserBtn
	 */
	public WebElement getAddUserBtn() {
		return addUserBtn;
	}

	/**
	 * @return the name
	 */
	public WebElement getName() {
		return name;
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return userName;
	}

	/**
	 * @return the code
	 */
	public WebElement getCode() {
		return code;
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
	 * @return the role
	 */
	public WebElement getRole() {
		return role;
	}

	/**
	 * @return the region
	 */
	public WebElement getRegion() {
		return region;
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
		return WrngMsg;
	}

	/**
	 * @return the searchTxtbx
	 */
	public WebElement getSearchTxtbx() {
		return searchTxtbx;
	}

	/**
	 * @return the deleteBtn
	 */
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * @return the popupDeleteConfirm
	 */
	public WebElement getPopupDeleteConfirm() {
		return popupDeleteConfirm;
	}

	/**
	 * @return the deleteMsg
	 */
	public WebElement getDeleteMsg() {
		return deleteMsg;
	}

	@FindBy(xpath="//a[text()='User List']")
	private WebElement userList;
	
	@FindBy(xpath="//a[text()='Add User']")
	private WebElement addUserBtn;
	
	@FindBy(xpath="//input[@id='Name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='txt-username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='Code']")
	private WebElement code;
	
	@FindBy(xpath="//input[@id='EmailId']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='ContactNumber']")
	private WebElement contactNumber;
	
	@FindBy(xpath="//select[@name='RoleId']")
	private WebElement role;
	
	@FindBy(xpath="//select[@name='RegionId']")
	private WebElement region;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement toasterMsg;
	
	@FindBy(xpath="//span[@class='text-danger error-msg field-validation-error']")
	private List<WebElement> WrngMsg;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtbx;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//button[@onClick='deleteUser()']")
	private WebElement popupDeleteConfirm;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement deleteMsg;
	
	
	
	
	
	
	
	
	

}
