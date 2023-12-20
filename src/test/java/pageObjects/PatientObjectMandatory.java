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
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M47.6 17.8L27.1 38')])[1]/../../../../../..")
	WebElement patientObject;
	@FindBy(xpath = "//div[contains(text(),'New')]/..")
	WebElement new_btn;
	@FindBy(xpath = "(//span[text()='New Patient'])[1]/../..")
	WebElement newPatient;
	@FindBy(xpath = "//input[@name='First_Name__c']")
	WebElement first_name;
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	WebElement last_name;
	@FindBy(xpath = "//button[contains(@aria-label,'Gender')]")
	WebElement gender;
	@FindBy(xpath = "//input[@name='DOB__c']")
	WebElement dateOfBirth;

	/// Patient Contact Info //
	@FindBy(xpath = "//label[text()='Phone']")
	WebElement phone_label;
	@FindBy(xpath = "//input[@name='Phone__c']")
	WebElement phone_textbox;
	@FindBy(xpath = "//input[@name='Email__c']")
	WebElement email;

	// Emergency Contact Info//
	@FindBy(xpath = "//input[@name='Emergency_Contact_Number__c']")
	WebElement emergency_contactnumber;

	// Doctor's Contact //
	@FindBy(xpath = "//input[@name='Doctor_Email__c']")
	WebElement doctor_email;

	// Existing Morbidity//
	@FindBy(xpath = "//div[@role='group']/div[contains(text(),'Existing Morbi')]/../div[2]//span[(text()='Chosen')]/../div//span/span")
	private static WebElement ExistingMorbidities;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M30.3 12.6c10.4')])[7]")
	private static WebElement ExisMorbRefresh;
	@FindBy(xpath = "(//span[@title='BP'])[1]")
	private static WebElement ExistingMorbidity;
	@FindBy(xpath = "(//span[@title='None'])[1]")
	private static WebElement ExistingMorbidityNone;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")
	private static WebElement EmRightArrow;
	@FindBy(xpath = "//button[@title='Undo Existing Morbidities']")
	private static WebElement ExistMorbidityUndo;
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
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='Phone']")
	private static WebElement reviewInvalidPhoneFieldLink;
	@FindBy(xpath = "//div[text()='US phone numbers should be in this format: (999) 999-9999.']")
	private static WebElement errorMsgInvalidPhonenumberField;
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='BP']")
	private static WebElement reviewInvalidBPFieldLink;
	@FindBy(xpath = "//div[text()='BP should be in Systolic and Diastolic']")
	private static WebElement errorMsgInvalidBPField;
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
	@FindBy(xpath = "//div[@class='fieldLevelErrors']//a[text()='Email']")
	private static WebElement reviewInvalidEmailLink;
	@FindBy(xpath = "//div[text()='You have entered an invalid format.']")
	private static WebElement errorMsgInvalidEmailField;

	// Success Msg//
	@FindBy(xpath = "//span[contains(@data-aura-class,'forceActionsText')]")
	private static WebElement successMsgPatientCreation;
	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private static WebElement alertMsgSave;
	@FindBy(xpath = "//button[@title='Select a List View: Patients']")
	private static WebElement listView;
	@FindBy(xpath = "//span[@class=' virtualAutocompleteOptionText' and text()='Existing Patients List View']")
	private static WebElement existingPatientList;
	@FindBy(xpath = "//table[@aria-label='Existing Patients List View']")
	private static WebElement tableView;
	@FindBy(xpath = "//thead/tr/th[3]/div/span")
	private static WebElement sortToggle;
	@FindBy(xpath = "//tbody/tr[1]/th[1]/span[1]/a[1]")
	private static WebElement lastElement;
	@FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
	private static WebElement LastpatientId;
	@FindBy(xpath = "//button[@title='Close']")
	private static WebElement successMsgClose;

	// Risk of Sepsis //
	@FindBy(xpath = "//tbody/tr[1]/td[4]/span/span")
	private static WebElement riskOfSepsis;
	@FindBy(xpath = "//div[contains(@class,'windowViewMode-normal')]//span[text()='Risk of Sepsis']/../..//lightning-formatted-text")
	private static WebElement riskOfSepsisStatus;
	// tbody/tr[1]/td[4]/span/span

	// Constructor
	public PatientObjectMandatory() {

		PageFactory.initElements(driver, this);
	}

	// New Patient form//
	public void patientObject_select() {
		executor.executeScript("arguments[0].click();", patient_object);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newPatientform() {
		ac.waitForElementToappear(new_btn);
		new_btn.click();
	}

	public void patientObjectSelect() {
		//executor.executeScript("arguments[0].click();", patientObject);
		patientObject.click();
		ac.waitForElementToappear(newPatient);
		newPatient.click();
	}

	public void newPatientformClick() {
		ac.waitForElementToappear(newPatient);
		newPatient.click();
	}

	public void selectExistingMorbidities() {
		executor.executeScript("arguments[0].scrollIntoView()", ExistingMorbidity);
		ExistingMorbidity.click();
		executor.executeScript("arguments[0].scrollIntoView()", EmRightArrow);
		ac.actionClassMoveTo(EmRightArrow);
	}

	public void selectExistingMorbiditiesNone() {
		executor.executeScript("arguments[0].scrollIntoView()", ExistingMorbidityNone);
		ExistingMorbidityNone.click();
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

	public String getalertMsg() {
		System.out.println(alertMsgSave.getText());
		return alertMsgSave.getText();
	}

	public String getPatientIdFromSaveSuccessMsg() {
		String str = getalertMsg();
		System.out.println(str);
		String patientRecord = str.substring(9, 16);
		System.out.println(patientRecord);
		return patientRecord;
	}

	public void selectListView() {
		ac.waitForElementToappear(listView);
		executor.executeScript("arguments[0].click();", listView);

	}

	public void selectExistPatientView() {
		executor.executeScript("arguments[0].click();", existingPatientList);
	}

	public void getTableViewOfExisPatients() {
		ac.waitForElementToappear(tableView);
	}

	public void SortDesc() {
		executor.executeScript("arguments[0].click();", sortToggle);
	}

	public void lastPatientClick() {
		ac.waitForElementToappear(lastElement);
		lastElement.click();

	}

	public String getLastPatientId() {
		ac.waitForElementToappear(lastElement);
		return lastElement.getText();
	}

	public String getLastElementText() {
		ac.waitForElementToappear(LastpatientId);
		return LastpatientId.getText();
	}

	public String getExpectedMsg() {
		String lastRecord = getLastElementText().substring(3, 7);
		char quotes = '"';
		String expectedAlertMsg = "Patient \"PT-" + lastRecord + quotes + " was created.";
		System.out.println(expectedAlertMsg);
		return expectedAlertMsg;

	}

	public String getSepsisRisk() {

		//executor.executeScript("window.scrollTo(0,500)");
		String risk = riskOfSepsisStatus.getText();
		System.out.println(risk);
		return risk;

	}

	public String getRiskOfSepsis() {
		ac.waitForElementToappear(riskOfSepsis);
		return riskOfSepsis.getText();
	}

	public void cancelButton() {
		executor.executeScript("arguments[0].scrollIntoView()", CancelBtn);
		CancelBtn.click();
	}

	public void succmsgCloseIcon() {
		ac.waitForElementToappear(successMsgClose);
		successMsgClose.click();
	}

	public void successMsgText() {
		executor.executeScript("arguments[0].scrollIntoView()", successMsgPatientCreation);
		successMsgPatientCreation.getText();
	}

	// Missing field //
	public String hitSnagError() {
		return hitSnagErrorMsg.getText();
	}

	public void reviewMissingFieldClick() {
		reviewFieldLink.click();

	}

	public String errorMsgIncompleteText() {
		return errorMsgIncompleteField.getText();
	}

	// Invalid Phone field //

	public void reviewInvalidPhoneFieldClick() {
		reviewInvalidPhoneFieldLink.click();

	}

	public String errorMsgInvalidPhonenumber() {
		return errorMsgInvalidPhonenumberField.getText();
	}

	// Invalid BP field //

	public void reviewInvalidBPFieldClick() {
		reviewInvalidBPFieldLink.click();

	}

	public String errorMsgInvalidBP() {
		return errorMsgInvalidBPField.getText();
	}

	// Invalid text field //

	public void reviewInvalidFieldClick() {
		reviewInvalidFieldLink.click();

	}

	public String errorMsgInvalidChar() {
		return errorMsgInvalidField.getText();
	}

	// Invalid DOB field //

	public void reviewInvalidDOBClick() {
		reviewInvalidDOBLink.click();

	}

	public String errorMsgInvalidDOB() {
		return errorMsgInvalidDOBField.getText();
	}

	// Invalid ExisMorb //

	public void reviewOtherExisMorClick() {
		reviewOtherExisMorLink.click();

	}

	public String errorMsgOtherExisMor() {
		return errorMsgOtherExisMorField.getText();
	}

	// Invalid Email field //

	public void reviewInvalidEmailClick() {
		reviewInvalidEmailLink.click();

	}

	public String errorMsgInvalidEmail() {
		return errorMsgInvalidEmailField.getText();
	}

	// DropDown click //

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
		//executor.executeScript("arguments[0].scrollIntoView(true);", phone_textbox);
		ac.actionClassMoveTo(phone_textbox);
		phone_textbox.sendKeys(patientData.getPhoneNumber());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		email.sendKeys(patientData.getEmail());
		emergency_contactnumber.sendKeys(patientData.getEmergencyContactNumber());
		doctor_email.sendKeys(patientData.getDoctorEmail());
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
		RespiratoryRate.sendKeys(patientData.getRespiratoryRate());
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
