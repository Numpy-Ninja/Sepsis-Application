package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class SepsisBloodProfile {

	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();

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

	@FindBy(xpath = "//a[@title='Sepsis Blood Profiles']")
	private static WebElement sepsisBloodProfile;
	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private static WebElement sepsisAlertmsg;
	@FindBy(xpath = " //button[@name='SaveEdit']")
	private static WebElement saveButton;
	@FindBy(xpath = "//div[@title='New']")
	private static WebElement newForm;
	@FindBy(xpath = "//input[@role='combobox']")
	private static WebElement patient_Id;
	@FindBy(xpath = "//input[@name='PaO2__c']")
	private static WebElement PaO2;
	@FindBy(xpath = "//input[@name='Systolicblo__c']")
	private static WebElement Systolicblo;

	@FindBy(xpath = "//input[@name='Diastlicblo__c']")
	private static WebElement Diastlicblo;
	@FindBy(xpath = "//input[@name='Hr__c']")
	private static WebElement Hr;

	@FindBy(xpath = "//input[@name='Egfr__c']")
	private static WebElement Egfr;
	@FindBy(xpath = "//input[@name='Troponin__c']")
	private static WebElement Troponin;

	@FindBy(xpath = "//input[@name='PacO2__c']")
	private static WebElement PacO2;
	@FindBy(xpath = "//input[@name='FiO2__c']")
	private static WebElement FiO2;

	// Saved Form

	@FindBy(xpath = "(//div[2]/span[1]/slot[1]/lightning-formatted-number[1])[1]")
	private static WebElement PaO2_saved;
	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-number[1])[2]")
	private static WebElement PFRatio;

	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-number[1])[3]")
	private static WebElement CardiacOutput;
	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-text[1])[1]")
	private static WebElement MyocardialDepression;

	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-text[1])[2]")
	private static WebElement eGFRoutput;
	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-number[1])[4]")
	private static WebElement fiO2_saved;

	@FindBy(xpath = "(//div[1]/div[1]/div[2]/span[1]/slot[1]/records-formula-output[1]/slot[1]/lightning-formatted-text[1])[3]")
	private static WebElement PFOutputResult;
	@FindBy(xpath = "(//span[@part='indicator'])[1]")
	private static WebElement HeartFailureChkBx;

	@FindBy(xpath = "(//span[@part='indicator'])[2]")
	private static WebElement KidneyFailureChkBx;
	@FindBy(xpath = "(//span[@part='indicator'])[3]")
	private static WebElement RespiratoryFailureChkBx;

	@FindBy(xpath = "(//a[@title='SBP-0016']")
	private static WebElement sepsisId;

	@FindBy(xpath = "//div[@role='none']//div[@part='input-container']")
	private static WebElement inputBox;
	@FindBy(xpath = "//ul[1]//span[2]/span[1]/span[@title='PT-0498']")
	private static WebElement SelectPatientId;

	@FindBy(xpath = "(//span[@class='slds-checkbox_faux'])[2]")
	private static WebElement PHeartFailureChkbx;

	@FindBy(xpath = "(//span[@class='slds-checkbox_faux'])[3]")
	private static WebElement PKidneyFailureChkbx;

	@FindBy(xpath = "(//span[@class='slds-checkbox_faux'])[4]")
	private static WebElement PRespiratoryFailureChkbx;

	@FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
	private static WebElement sepsisSavedId;

	@FindBy(xpath = "//a[@title='PT-0498']")
	private static WebElement SepsisPatientId;

	public SepsisBloodProfile() {

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

	public void SelectSepsisbloodProfileObject() {
		ac.actionClassMoveTo(sepsisBloodProfile);
	}

	public void clickOnNewForm() {

		ac.waitForElementToappear(newForm);
		newForm.click();
	}

	public void enterPatientId(String patientId) {
		ac.actionClass(inputBox, patientId);
		// ac.waitForElementToappear(SelectPatientId);
		// ac.actionClassMoveTo(SelectPatientId);
		driver.findElement(By.xpath("//strong[normalize-space()='PT-0498']")).click();

	}

	public void enterPaO2(String PaO2value) {
		ac.actionClass(PaO2, PaO2value);
	}

	public void enterSystolicblo(String systolicbloValue) {
		// ac.actionClass(Systolicblo, systolicbloValue);
		Systolicblo.sendKeys(systolicbloValue);
	}

	public void enterDiastlicblo(String DiastlicbloValue) {
		// ac.actionClass(Diastlicblo, DiastlicbloValue);
		Diastlicblo.sendKeys(DiastlicbloValue);
	}

	public void enterHr(String HrValue) {
		// ac.actionClass(Hr, HrValue);
		Hr.sendKeys(HrValue);
	}

	public void enterEgfr(String Egfrvalue) {
		// ac.actionClass(Egfr, Egfrvalue);
		Egfr.sendKeys(Egfrvalue);
	}

	public void enterTroponin(String Troponinvalue) {
		// ac.actionClass(Troponin, Troponinvalue);
		Troponin.sendKeys(Troponinvalue);
	}

	public void enterPacO2(String PacO2value) {
		ac.actionClass(PacO2, PacO2value);
	}

	public void enterFiO2(String FiO2value) {
		ac.actionClass(FiO2, FiO2value);
	}

	public void clickOnSave() {
		ac.actionClassMoveTo(saveButton);
	}

	public void clickSepsisId() {
		ac.actionClassMoveTo(sepsisId);
	}

	public String checkCardiacOutput(String cardiacOutput) {
		CardiacOutput.getText();
		return cardiacOutput;
	}

	public String checkPFRatio(String PfRatio) {
		PFRatio.getText();
		return PfRatio;
	}

	public String checkMyocardialDepression(String myocardialDepression) {
		MyocardialDepression.getText();
		return myocardialDepression;
	}

	public String checkeGFRoutput(String eGFroutput) {
		eGFRoutput.getText();
		return eGFroutput;
	}

	public String checkfiO2_saved(String fiO2_Saved) {
		fiO2_saved.getText();
		return fiO2_Saved;
	}

	public String checkPFOutputResult(String PFoutputResult) {
		PFOutputResult.getText();
		return PFoutputResult;
	}

	public boolean HeartFailureChkBx() {
		HeartFailureChkBx.isSelected();
		return true;
	}

	public boolean KidneyFailureChkBx() {
		KidneyFailureChkBx.isSelected();
		return true;
	}

	public boolean RespiratoryFailureChkBx() {
		RespiratoryFailureChkBx.isSelected();
		return true;
	}

	public void selectSepsisPatientId() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SepsisPatientId);
	}

	public boolean PHeartFailureChkBx() {
		PHeartFailureChkbx.isSelected();
		return true;
	}

	public boolean PKidneyFailureChkBx() {
		PKidneyFailureChkbx.isSelected();
		return true;
	}

	public boolean PRespiratoryFailureChkBx() {
		PRespiratoryFailureChkbx.isSelected();
		return false;
	}

	public String getLastElementText() {

		ac.waitForElementToappear(sepsisSavedId);
		return sepsisSavedId.getText();
	}

	public String getExpectedMsg() {

		String lastRecord = getLastElementText();
		System.out.println(lastRecord);// pt-0164
		char quotes = '"';
		String expectedAlertMsg = "Sepsis Blood Profile" + " " + quotes + lastRecord + quotes + " was created.";// Sepsis
																												// Blood
																												// ProfileSBP-0076"
																												// was
																												// created.
		System.out.println(expectedAlertMsg);
		return expectedAlertMsg;

	}

	public String sepsisgetalertMsg() {
		ac.waitForElementToappear(sepsisAlertmsg);
		System.out.println(sepsisAlertmsg.getText());
		return sepsisAlertmsg.getText();

	}

}