package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.BaseClass;
import driverFactory.AbstractComponents;
import utilities.ConfigReader;

public class Vitals {
	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Locators Medication

	@FindBy(xpath = "//input[@name='Current_Medication__c']")
	private static WebElement CurrentMedication;

	// Locators - Vitals

	@FindBy(xpath = "//input[@name='Temperature__c']")
	private static WebElement Temperature;
	@FindBy(xpath = "//input[@name='Heart_Rate__c']")
	private static WebElement HeartRate;
	@FindBy(xpath = "//input[@name='Respiratory_Rate__c']")
	private static WebElement RespiratoryRate;
	@FindBy(xpath = "//input[@name='BP__c']")
	private static WebElement BP;
	@FindBy(xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[15]")
	private static WebElement GlucoseDropdown;
	@FindBy(xpath = "//div/lightning-base-combobox-item[2]//span[2]/span[@title='Before BF']")
	private static WebElement GlucoseOption;
	@FindBy(xpath = "//input[@name='Glucose_Value__c']")
	private static WebElement GlucoseValue;
	@FindBy(xpath = "//input[@name='White_Blood_Cells_Leukocyte__c']")
	private static WebElement WBCcount;
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private static WebElement SaveBtn;
	@FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
	private static WebElement patientID;
	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private static WebElement alertMsgSave;

	@FindBy(xpath = "//button[@title='Select a List View: Patients']")
	private static WebElement listView;
	@FindBy(xpath = "//span[normalize-space()='Existing Patients List View']")
	private static WebElement existingPatientList;
	@FindBy(xpath = "//thead/tr/th[3]/div/span")
	private static WebElement sortToggle;
	@FindBy(xpath = "//tbody/tr[1]/th[1]/span[1]/a[1]")
	private static WebElement lastElement;
	// @FindBy(xpath="(//lightning-formatted-text[@slot='primaryField'])[3]")
	@FindBy(xpath = "//div[1]/div/div[1]/div[2]/h1/slot/lightning-formatted-text")
	private static WebElement LastpatientId;
	@FindBy(xpath = "//a[@title='Patients']")
	private static WebElement patient_object;

	// Constructor

	public Vitals() {

		PageFactory.initElements(driver, this);
	}

	public void SalesForcelogin_page() {

		driver.get(SFurl);

	}

	// Medication Methods

	public void MedicationClick() {
		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, CurrentMedication);
		CurrentMedication.click();
	}

	public void medicatiovalue(String mdvalue) {
		CurrentMedication.sendKeys(mdvalue);
	}

	// Vitals Methods

	public void VitalsTempClick() {
		Temperature.click();
	}

	public void VitalsTemp(String temperature2) {
		Temperature.sendKeys(temperature2);
	}

	public void VitalsHeartRate(String heartrate) {

		HeartRate.sendKeys(heartrate);
	}

	public void VitalsRespiratoryRate(String respiratoryrate) {
		RespiratoryRate.sendKeys(respiratoryrate);
	}

	public void VitalsBP(String bp) {
		BP.sendKeys(bp);
	}

	public void VitalsGlucoseDropdown() {

		GlucoseDropdown.click();
	}

	public void VitalsGlucoseOption() {

		GlucoseOption.click();
	}

	public void VitalsGlucoseValue(String gv) {

		GlucoseValue.sendKeys(gv);
	}

	public void VitalsWBCcount(String wbc) {
		WBCcount.sendKeys(wbc);
	}

	public void HearrateClick() {
		HeartRate.click();

	}

	public void respiratoryclick() {
		RespiratoryRate.click();

	}

	public void VitalsBPClick() {

		BP.click();

	}

	public void VitalsGlucoseclick() {
		GlucoseValue.click();

	}

	public void wbcclick() {

		ac.actionClassMoveTo(WBCcount);
	}

	public void saveBtnclick() {
		ac.actionClassMoveTo(SaveBtn);
	}

	public void ClickPatientobj() {
		ac.waitForElementToappear(patient_object);
		// executor.executeScript("arguments[0].click();", patient_object);
		ac.actionClassMoveTo(patient_object);

	}

	public String getalertMsg() {
		ac.waitForElementToappear(alertMsgSave);
		System.out.println(alertMsgSave.getText());
		return alertMsgSave.getText();
	}

	public void selectListView() {
		ac.waitForElementToappear(listView);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", listView);

	}

	public void selectExistPatientView() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", existingPatientList);
	}

	public void SortDesc() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", sortToggle);

	}

	public void clickOnPatientId() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lastElement);

	}

	public String getLastElementText() {

		ac.waitForElementToappear(LastpatientId);
		return LastpatientId.getText();
	}

	public String getExpectedMsg() {

		String lastRecord = getLastElementText().substring(3, 7);
		System.out.println(lastRecord);// pt-0164

		char quotes = '"';
		String expectedAlertMsg = "Patient \"PT-" + lastRecord + quotes + " was created.";
		System.out.println(expectedAlertMsg);
		return expectedAlertMsg;

	}

}
