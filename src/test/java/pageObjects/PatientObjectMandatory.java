package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import pageObjects.data.PatientData;
import utilities.ConfigReader;

public class PatientObjectMandatory {

	private static PatientObjectMandatory page;

	public static PatientObjectMandatory getInstance() {
		if (page == null) {
			page = new PatientObjectMandatory();
		}
		return page;
	}

	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	boolean isRequired;

	/// PersonalInfo/////
	@FindBy(xpath = "//a[@title='Patients']")
	WebElement patient_object;
	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement new_btn;
	@FindBy(xpath = "//input[@name='First_Name__c']")
	WebElement first_name;
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	WebElement last_name;
	@FindBy(xpath = "//button[contains(@aria-label,'Gender')]//span")
	WebElement gender;
	@FindBy(xpath = "//input[@name='DOB__c']")
	WebElement dateOfBirth;

	/// Patient Contact Info //
	@FindBy(xpath = "//input[@name='Phone__c']")
	WebElement phone_textbox;

	// Existing Morbidity//
	@FindBy(xpath = "//div[@role='group']/div[contains(text(),'Existing Morbi')]/../div[2]//span[(text()='Chosen')]/../div//span/span")
	private static WebElement ExistingMorbidities;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[7]")
	private static WebElement ExisMorbRefresh;
	@FindBy(xpath = "(//span[@title='BP'])[1]")
	private static WebElement ExistingMorbidity;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")
	private static WebElement EmRightArrow;
	@FindBy(xpath = "//button[@title='Undo Existing Morbidities']")
	private static WebElement ExistMorbidityUndo;
	@FindBy(xpath = "(//span[@class='slds-has-error slds-form-element__help'])[1]")
	private static WebElement ErrorMsg;
	@FindBy(xpath = "(//div[@class='slds-dueling-list__options']//li[11]//span[@title='Other'])[1]")
	private static WebElement ExistMorbidityOther;
	@FindBy(xpath = "//input[@name='Comment_Here__c']")
	private static WebElement otherExisMTextBox;
	@FindBy(xpath = "//h3/span[@title='Existing Morbidities']")
	private static WebElement EmTitle;

	// Existing Infections//
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[8]")
	private static WebElement ExisInfecRefresh;
	@FindBy(xpath = "(//span[@title='Common Cold'])[1]")
	private static WebElement ExistInfection;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[2]")
	private static WebElement EinfRightArrow;
	@FindBy(xpath = "//input[@name='Other_Existing_Infections__c']")
	private static WebElement EinfotherTextBox;

	// Habits//
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[11]")
	private static WebElement HabitsRefresh;
	@FindBy(xpath = "//span[@title='Alcohol']")
	private static WebElement HabitOption;
	@FindBy(xpath = "//span[@title='Drugs']")
	private static WebElement HabitOption1;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[4]")
	private static WebElement HbtRightArrow;

	// Fitness Frequency//
	@FindBy(xpath = "//button[contains(@aria-label,'Fitness Frequency')]//span")
	private static WebElement Fitness;

	// Immunization
	@FindBy(xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[13]")
	private static WebElement ImmunizationDropdown;
	@FindBy(xpath = "//button[contains(@aria-label,'Imunization')]//span")
	private static WebElement ImmunizationOption;

	// Physical Fitness
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[12]")
	private static WebElement PhyFitnessRefresh;
	@FindBy(xpath = "//div[@class='slds-dueling-list__options']//li//span[@title='Walking']")
	private static WebElement PhysicalFitnessOption;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[5]")
	private static WebElement PFRightArrow;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M38 8.3v35')])[5]")
	private static WebElement PFleftArrow;

	// Family History
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[9]")
	private static WebElement FamHistoryRefresh;
	@FindBy(xpath = "(//span[@title='Diabetes'])[2]")
	private static WebElement FamHistoryOption;
	@FindBy(xpath = "(//button[@title='Move selection to Chosen'])[3]")
	private static WebElement FamHisRightArrow;

	// Medication//
	@FindBy(xpath = "//input[@name='Current_Medication__c']")
	private static WebElement CurrentMedication_Value;

	// Vitals//
	@FindBy(xpath = "//input[@name='Temperature__c']")
	private static WebElement Temperature_Value;
	@FindBy(xpath = "//input[@name='Heart_Rate__c']")
	private static WebElement HeartRate_Value;
	@FindBy(xpath = "//input[@name='Respiratory_Rate__c']")
	private static WebElement RespiratoryRate;
	@FindBy(xpath = "//input[@name='BP__c']")
	private static WebElement BP_Value;
	@FindBy(xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[15]")
	private static WebElement GlucoseDropdown;
	@FindBy(xpath = "//button[contains(@aria-label,'Glucose')]//span")
	private static WebElement GlucoseOption;
	@FindBy(xpath = "//input[@name='Glucose_Value__c']")
	private static WebElement Glucosevalue;
	@FindBy(xpath = "//input[@name='White_Blood_Cells_Leukocyte__c']")
	private static WebElement WBCcount;
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private static WebElement SaveBtn;
	@FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
	private static WebElement patientID;
	@FindBy(xpath = "//button[@name='CancelEdit']")
	private static WebElement CancelBtn;

	// ErrorMsgs//
	@FindBy(xpath = "//h2[@title='We hit a snag.']")
	private static WebElement hitSnagErrorMsg;
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='First Name']")
	private static WebElement reviewFieldLink;
	@FindBy(xpath = "//div//label[text()='First Name']/../../div[2]")
	private static WebElement errorMsgIncompleteField;
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='Last Name']")
	private static WebElement reviewInvalidFieldLink;
	@FindBy(xpath = "//div[@role='alert'][contains(text(),'Please enter only Alp')]")
	private static WebElement errorMsgInvalidField;
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='DOB']")
	private static WebElement reviewInvalidDOBLink;
	@FindBy(xpath = "//div[text()='DOB cannot be in future.pls change it to sometime past.']")
	private static WebElement errorMsgInvalidDOBField;
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='Other Existing Morbidities']")
	private static WebElement reviewOtherExisMorLink;
	@FindBy(xpath = "//div[@role='alert'][contains(text(),'Please explain only other existing morb')]")
	private static WebElement errorMsgOtherExisMorField;

	//Success Msg//
	@FindBy(xpath = "//span[contains(@data-aura-class,'forceActionsText')]")
	private static WebElement successMsgPatientCreation;

	//span[contains(@data-aura-class,'forceActionsText')]
	// Constructor
	public PatientObjectMandatory() {

		PageFactory.initElements(driver, this);
	}

	// New Patient form//
	public void newPatientform() {
		executor.executeScript("arguments[0].scrollIntoView()", new_btn);
		new_btn.click();
	}

	public void selectExistingMorbidities() {
		executor.executeScript("arguments[0].scrollIntoView()", ExistingMorbidity);
		ExistingMorbidity.click();
		executor.executeScript("arguments[0].scrollIntoView()", EmRightArrow);
		ac.actionClassMoveTo(EmRightArrow);
	}

	public void selectHabits() {
		executor.executeScript("arguments[0].scrollIntoView()", HabitOption);
		HabitOption.click();
		HbtRightArrow.click();

	}

	public void selectExistingInfections() {
		executor.executeScript("arguments[0].scrollIntoView()", ExistInfection);
		ExistInfection.click();
		EinfRightArrow.click();
	}

	public void selectPhysicalFitness() {
		PhysicalFitnessOption.click();
		PFRightArrow.click();
	}

	public void selectFamilyHistory() {
		executor.executeScript("arguments[0].scrollIntoView()", FamHistoryOption);
		FamHistoryOption.click();
		FamHisRightArrow.click();
	}

	public void saveButton() {
		SaveBtn.click();
	}

	public void cancelButton() {
		executor.executeScript("arguments[0].scrollIntoView()", CancelBtn);
		CancelBtn.click();
	}
	
	public void successMsgText() {
		executor.executeScript("arguments[0].scrollIntoView()", successMsgPatientCreation);
		successMsgPatientCreation.getText();
	}

	public String hitSnagError() {
		return hitSnagErrorMsg.getText();
	}

	public void reviewMissingFieldClick() {
		reviewFieldLink.click();

	}

	public String errorMsgIncompleteText() {
		return errorMsgIncompleteField.getText();
	}

	public void reviewInvalidFieldClick() {
		reviewInvalidFieldLink.click();

	}

	public String errorMsgInvalidChar() {
		return errorMsgInvalidField.getText();
	}

	public void reviewInvalidDOBClick() {
		reviewInvalidDOBLink.click();

	}

	public String errorMsgInvalidDOB() {
		return errorMsgInvalidDOBField.getText();
	}

	public void reviewOtherExisMorClick() {
		reviewOtherExisMorLink.click();

	}

	public String errorMsgOtherExisMor() {
		return errorMsgOtherExisMorField.getText();
	}

	public void clickGender(String genderOption) {
		driver.findElement(By.xpath("//div/lightning-base-combobox-item//span[2]//span[@title='" + genderOption + "']"))
				.click();
	}

	public void clickFitness(String fitnessOption) {
		driver.findElement(
				By.xpath("//div/lightning-base-combobox-item//span[2]//span[@title='" + fitnessOption + "']")).click();
	}

	public void clickImmunization(String immuOption) {
		driver.findElement(By.xpath("//div/lightning-base-combobox-item//span[2]//span[@title='" + immuOption + "']"))
				.click();
	}

	public void clickGlucoseOption(String glucoseOption) {
		driver.findElement(
				By.xpath("//div/lightning-base-combobox-item//span[2]//span[@title='" + glucoseOption + "']")).click();
	}

	public void sendPatientData(PatientData patientData) {
		first_name.sendKeys(patientData.getFirstName());
		last_name.sendKeys(patientData.getLastName());
		gender.click();
		clickGender(patientData.getGender());
		dateOfBirth.click();
		dateOfBirth.sendKeys(patientData.getDob());
		phone_textbox.sendKeys(patientData.getPhoneNumber());
		otherExisMTextBox.sendKeys(patientData.getOtherExistingMorbidities());
		executor.executeScript("arguments[0].scrollIntoView()", Fitness);
		Fitness.click();
		clickFitness(patientData.getFitnessFrequency());
		executor.executeScript("arguments[0].scrollIntoView()", ImmunizationOption);
		ImmunizationOption.click();
		clickImmunization(patientData.getImmunization());
		executor.executeScript("arguments[0].scrollIntoView()", CurrentMedication_Value);
		CurrentMedication_Value.clear();
		CurrentMedication_Value.sendKeys(patientData.getCurrentMedication());
		Temperature_Value.clear();
		Temperature_Value.sendKeys(patientData.getTemperature());
		HeartRate_Value.clear();
		HeartRate_Value.sendKeys(patientData.getHeartRate());
		BP_Value.clear();
		BP_Value.sendKeys(patientData.getBp());
		GlucoseOption.click();
		clickGlucoseOption(patientData.getGlucose());
		executor.executeScript("arguments[0].scrollIntoView()", Glucosevalue);
		Glucosevalue.clear();
		Glucosevalue.sendKeys(patientData.getGlucoseValue());
		WBCcount.clear();
		WBCcount.sendKeys(patientData.getWhiteBloodCells());
	}
}
