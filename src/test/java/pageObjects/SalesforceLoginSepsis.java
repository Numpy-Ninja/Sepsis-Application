package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class SalesforceLoginSepsis {
	public WebDriver driver;
	AbstractComponents ac ;
	String SFurl ;
	//String username = ConfigReader.getUsername();
	// password = ConfigReader.getPassword();
	JavascriptExecutor executor ;

	// Locators

	@FindBy(id = "username")
	private static WebElement user;
	@FindBy(id = "password")
	private static WebElement pwd;
	@FindBy(id = "Login")
	private static WebElement login_button;
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private static WebElement waffle_btn;
	@FindBy(xpath = "//p[contains(.,'Sepsis')]")
	private static WebElement sepsisApp;
	@FindBy(xpath = "//a[@title='Patients']")
	private static WebElement patient_object;
	@FindBy(xpath = "//div[contains(text(),'New')]")
	private static WebElement new_btn;
	@FindBy(xpath = "//h2[contains(text(),'New Patient:')]")
	private static WebElement new_patient;
	

	public SalesforceLoginSepsis() {

		driver = BaseClass.getdriver();
		ac = new AbstractComponents(driver);
		SFurl = ConfigReader.getApplicationUrl();
		// String username = ConfigReader.getUsername();
		// password = ConfigReader.getPassword();
		executor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void SalesForcelogin_page() {

		driver.get(SFurl);

	}

	public void Login(String username, String password) {

		ac.waitForElementToappear(user);

		user.clear();

		user.sendKeys(username);
		ac.waitForElementToappear(pwd);
		pwd.clear();
		pwd.sendKeys(password);

	}

	public void login_button() {

		login_button.click();

	}

	public void waffle_click() {

		ac.waitForElementToappear(waffle_btn);
		waffle_btn.click();
	}

	public void sepsisApp_click() {
		// waitForElementToappear(sepsisApp);
		sepsisApp.click();
	}

	public void patientObject_select() {
		executor.executeScript("arguments[0].click();", patient_object);

	}
	
	public void selectNew() {
		ac.waitForElementToappear(new_btn);
		new_btn.click();
	}
	
	public String newPatientHeader() {
		return new_patient.getText();
	}
}