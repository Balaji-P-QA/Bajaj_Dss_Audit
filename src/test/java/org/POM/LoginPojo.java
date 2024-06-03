package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo {

	public WebDriver driver;

	public LoginPojo(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	/**
	 * @return the wrongCredentialMsg
	 */
	public List<WebElement> getWrongCredentialMsg() {
		return wrongCredentialMsg;
	}

	/**
	 * @return the emptyUsernameMsg
	 */
	public WebElement getEmptyUsernameMsg() {
		return emptyUsernameMsg;
	}

	/**
	 * @return the emptyPasswordMsg
	 */
	public WebElement getEmptyPasswordMsg() {
		return emptyPasswordMsg;
	}

	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtField;

	@FindBy(id = "idSIButton9")
	private WebElement nextBtnField;

	@FindBy(xpath = "//input[@name='UserName']")
	private WebElement usernameField;

	@FindBy(id = "passwordInput")
	private List<WebElement> passwordInputField; // 1

	@FindBy(id = "errorText")
	private List<WebElement> wrongCredentialMsg; // 2

	@FindBy(className = "submit")
	private List<WebElement> signInBtn; // 3

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the txtField
	 */
	public WebElement getTxtField() {
		return txtField;
	}

	/**
	 * @return the nextBtnField
	 */
	public WebElement getNextBtnField() {
		return nextBtnField;
	}

	/**
	 * @return the usernameField
	 */
	public WebElement getUsernameField() {
		return usernameField;
	}

	/**
	 * @return the passwordInputField
	 */
	public List<WebElement> getPasswordInputField() {
		return passwordInputField;
	}

	/**
	 * @return the errMsg
	 */
	public List<WebElement> getErrMsg() {
		return wrongCredentialMsg;
	}

	/**
	 * @return the signInBtn
	 */
	public List<WebElement> getSignInBtn() {
		return signInBtn;
	}

	/**
	 * @return the numberOftimeTxt
	 */
	public WebElement getNumberOftimeTxt() {
		return numberOftimeTxt;
	}

	/**
	 * @return the dontShowAgainChkbox
	 */
	public List<WebElement> getDontShowAgainChkbox() {
		return DontShowAgainChkbox;
	}

	/**
	 * @return the yesBtn
	 */
	public WebElement getYesBtn() {
		return yesBtn;
	}

	/**
	 * @return the noBtn
	 */
	public WebElement getNoBtn() {
		return noBtn;
	}

	@FindBy(xpath = "//div[contains(text(),\"number of times\")]")
	private WebElement numberOftimeTxt;

	@FindBy(name = "DontShowAgain")
	private List<WebElement> DontShowAgainChkbox; // 1

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement yesBtn;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement noBtn;

	@FindBy(xpath = "//div[@id='usernameError']")
	private WebElement emptyUsernameMsg;

	@FindBy(xpath = "//label[text()='Enter your password.']")
	private WebElement emptyPasswordMsg;

}
