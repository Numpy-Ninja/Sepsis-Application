package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class UploadFileBloodReport {

	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	ExistingMorbidities existingMorbidities = new ExistingMorbidities();
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	String filePath = ConfigReader.getFilePath();
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	float temperature;
	int HeartRate;
	int RespiratoryRate;
	int WBC;

	// Locators

	@FindBy(xpath = "//a[@title='Patients']")
	private static WebElement patient_object;
	@FindBy(xpath = "//a[@id='relatedListsTab__item']")
	private static WebElement RelatedTab;
	@FindBy(xpath = "(//input[@type='file'])[1]")
	private static WebElement upload_btn;
	@FindBy(xpath = "//button[@title='Close']//lightning-primitive-icon[@variant='bare']")
	private static WebElement close_btn;
	
	@FindBy(xpath = "(//*[name()='svg'][@data-key='close'])[1]")
	private static WebElement doneBtn;
	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private static WebElement uploadAlert;
	@FindBy(xpath = "//button[@title='Select a List View: Patients']")
	private static WebElement listView;
	@FindBy(xpath = "//span[normalize-space()='Existing Patients List View']")
	private static WebElement existingPatientList;
	@FindBy(xpath = "//thead/tr/th[3]/div/span")
	private static WebElement sortToggle;
	@FindBy(xpath = "//tbody/tr[1]/th[1]/span[1]/a[1]")
	private static WebElement lastElement;
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Patient__c.Risk_of_Sepsis__c']")
	private static WebElement sepsisRisk;
	@FindBy(xpath = "//span[normalize-space()='Temperature']")
	private static WebElement Temperature;
	@FindBy(xpath = "//span[normalize-space()='Respiratory Rate']")
	private static WebElement respiratoryRate;
	@FindBy(xpath = "//span[normalize-space()='Heart Rate']")
	private static WebElement heartRate;
	@FindBy(xpath = "//span[normalize-space()='White Blood Cells (Leukocyte)']")
	private static WebElement wbc;

	// Constructor

	public UploadFileBloodReport() {

		PageFactory.initElements(driver, this);
	}

	public void SalesForcelogin_page() {

		driver.get(SFurl);

	}

	public void patientObject_select() {

		executor.executeScript("arguments[0].click();", patient_object);

	}

	public void selectPatientId() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lastElement);
	}

	public void getTextParameters() {
		temperature = Integer.parseInt(Temperature.getText());
		WBC = Integer.parseInt(wbc.getText());
		HeartRate = Integer.parseInt(heartRate.getText());
		RespiratoryRate = Integer.parseInt(respiratoryRate.getText());
	}

	public void ClickRelatedTab() {
		driver.navigate().refresh();
		ac.waitForElementToappear(RelatedTab);
		ac.actionClassMoveTo(RelatedTab);
	}

	public void enterFilePath() throws InterruptedException {
		upload_btn.sendKeys(filePath);
		Thread.sleep(3000);
		//ac.waitForElementToappear(doneBtn);
		//ac.actionClassMoveTo(doneBtn);
		 doneBtn.click();

		
		
	}
	public String uploadAlertText() throws InterruptedException {

		ac.waitForElementToappear(uploadAlert);

		return uploadAlert.getText();

	}

	public String getSepsisRisk() {
		

		executor.executeScript("window.scrollTo(0,500)");
		String risk = sepsisRisk.getText().substring(15);	
		System.out.println(sepsisRisk.getText());
		return risk;

	}
	
	public void close_btn()
	{
		ac.actionClassMoveTo(close_btn);
	}
	public String getRiskOfSepsis(String sepsisStatus) {
		String SepsisRisk = "";
		//Boolean surgeryCheckbx= existingMorbidities.SurgeryCkbxChecked();
		switch (sepsisStatus) {
		case "Normal":
		if ( WBC < 11000 && RespiratoryRate >= 12 || RespiratoryRate <= 18 && HeartRate < 90
			 && temperature <=100.4)
			SepsisRisk="Normal";
		break;
		case "LOW":
			if (WBC >= 4000 && WBC <= 12000 && RespiratoryRate >= 12&& RespiratoryRate <= 20 && HeartRate > 90
					|| HeartRate < 60 && temperature > 100.4 || temperature < 96.8)
				SepsisRisk = "LOW";
			break;
		case "Medium":
			if (WBC >= 4000 && WBC <= 12000  && RespiratoryRate > 20
					|| RespiratoryRate < 12  && HeartRate > 90
					|| HeartRate < 60 && temperature > 100.4 || temperature < 96.8)
				SepsisRisk = "Medium";
			break;
         case "High":
        	 
     			if (WBC >= 12000 || WBC <= 4000  && RespiratoryRate > 20
     					|| RespiratoryRate < 12  && HeartRate > 90
     					|| HeartRate < 60 && temperature > 100.4 || temperature < 96.8)
     				SepsisRisk = "High";
     			break;
	         case "Critical":
	        		if (WBC >= 12000 || WBC <= 4000  && RespiratoryRate > 20
 					|| RespiratoryRate < 12  && HeartRate > 90
 					|| HeartRate < 60 && temperature > 100.4 || temperature < 96.8 )
 				SepsisRisk = "Critical";
	             break;

		}
		return SepsisRisk;
		
		
	}
}
