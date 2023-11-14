import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Standalone {
	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeTest
	public void setup() throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);

		driver.get("http://login.salesforce.com");

	}

	@Test
	public void test() throws InterruptedException

	{
		driver.findElement(By.id("username")).sendKeys("numpyninjaworkforce@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Salesforce@1");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement waffle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		executor.executeScript("arguments[0].click();", waffle);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//p[contains(.,'Sepsis')]")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Patients']"));

		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'New')]")).click();
//	WebElement radiobuttonNP = driver.findElement(By.cssSelector("div:nth-child(3) .slds-radio--faux"));
//      executor.executeScript("arguments[0].click();", radiobuttonNP);
		Thread.sleep(3000);
//      WebElement next = driver.findElement(By.xpath("//span[contains(.,'Next')]"));
//      executor.executeScript("arguments[0].click();", next);
//    WebElement newform=  driver.findElement(By.linkText("New"));
//    executor.executeScript("arguments[0].click();", newform);
		Thread.sleep(3000);

		WebElement name = driver.findElement(By.xpath("//input[@name='First_Name__c']"));
		name.sendKeys("Veena");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Last_Name__c']")).sendKeys("Sravanthi");

		////Glucose dropdown
		Thread.sleep(3000);
		WebElement glucoseDropdown = driver.findElement(By.xpath(" (//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[15]"));
		String javascript = "arguments[0].scrollIntoView()";
		
		executor.executeScript(javascript, glucoseDropdown);
		System.out.println("glucose dropdown clicked");
		
		Thread.sleep(3000);
		WebElement selectGlucoseOption = driver.findElement(By.xpath("//span[@title='HbA1c']"));
		//actions.moveToElement(selectGlucoseOption).click().build().perform();

		executor.executeScript("arguments[0].click();", selectGlucoseOption);
		
		Thread.sleep(5000);
		System.out.println("glucose option clicked");
		
		// ExistingMorbidities

		WebElement em = driver.findElement(By.xpath("(//span[@title='High Cholesterol'])[1]"));
		
		executor.executeScript(javascript, em);
		em.click();

		// driver.findElement(By.xpath("(//span[@title='High
		// Cholesterol'])[1]")).click();

		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")).click();
		Thread.sleep(3000);

		WebElement undo = driver.findElement(By.xpath("//button[@title='Undo Existing Morbidities']"));
		executor.executeScript("arguments[0].click();", undo);
		WebElement error = driver.findElement(By.xpath("//span[contains(text(),'An option must be selected')]"));
		System.out.println(error.getText());
		driver.findElement(By.xpath("(//span[@title='Other'])[1]")).click();
		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")).click();
		driver.findElement(By.xpath("//input[@name='Comment_Here__c']")).sendKeys("Sinuscitis");

		Thread.sleep(3000);

		// assertion

		// Allergy

   WebElement allergy=driver.findElement(By.xpath("//input[@type='checkbox' and @name='Allergies__c']"));
	 executor.executeScript("arguments[0].click();", allergy);
	 System.out.println("clicked on allergy checkbox");
	 Thread.sleep(3000);
	 WebElement allergytextbox = driver.findElement(By.xpath("//input[@class='slds-input' and @name='Allergy_Type__c']"));
	 allergytextbox.sendKeys("peanut");
	

		// habits
		WebElement Habits=driver.findElement(By.xpath("//span[@title='Alcohol']"));
	
		actions.moveToElement(Habits).click().build().perform();
		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[4]")).click();
		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M38 8.3v35')])[4]")).click();

		driver.findElement(By.xpath("//span[@title='Other']")).click();

		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[4]")).click();

		Thread.sleep(3000);

//Existing infections
		driver.findElement(By.xpath("(//span[@title='Other'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Other_Existing_Infections__c']")).sendKeys("Sinuscitis");

		// Family History

		WebElement FHOption = driver.findElement(By.xpath("(//span[@title='Diabetes'])[2]"));
		executor.executeScript("arguments[0].click();", FHOption);

		WebElement leftArrow = driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14 43.7V8')])[3]"));
		leftArrow.click();

		driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M38 8.3v35')])[3]")).click();
		// System.out.println(error.getText());

		WebElement FHOption1 = driver.findElement(By.xpath("(//span[@title='BP'])[2]"));
		FHOption1.click();
		leftArrow.click();
		Thread.sleep(2000);

		// Physical Fitness

		driver.findElement(By.xpath("(//div/ul/li[1]/div/span/span)[3]")).click();
		Thread.sleep(3000);

		WebElement PfArrow = driver.findElement(By.xpath("(//button[@title='Move selection to Chosen'])[5]"));


		actions.moveToElement(PfArrow).click().build().perform();

		Thread.sleep(3000);
		
		WebElement leftarrow=driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M38 8.3v35')])[5]"));
		
		actions.moveToElement(leftarrow).click().build().perform();
		
//		WebElement undoPF = driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M30.3 12.6c10')])[1]"));
//		actions.moveToElement(undoPF).click().build().perform();
//		System.out.println(error);
//		Thread.sleep(2000);
//		WebElement walking = driver.findElement(By.xpath("//span[@title='Walking']"));
//		actions.moveToElement(walking).click().build().perform();
//
//		// driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'M14
//		// 43.7V8')])[5]")).click();
//		Thread.sleep(2000);
//		actions.moveToElement(PfArrow).click().build().perform();
//		// LAPhysical.click();
//		Thread.sleep(2000);

		// Fitness Frequency

		WebElement DropDown = driver.findElement(
				By.xpath("(//div[@class='slds-combobox_container'])[14]"));
		actions.moveToElement(DropDown).click().build().perform();
		Thread.sleep(3000);
		WebElement op = driver.findElement(By.xpath("(//lightning-base-combobox-item[3]/span[2]/span)[2]"));
		actions.moveToElement(op).click().build().perform();

		// International Travel

		WebElement Itravel = driver.findElement(By.xpath("//input[@name='International_travel_in_last_3_months__c']"));
		actions.moveToElement(Itravel).click().build().perform();
		Thread.sleep(2000);
		WebElement country = driver.findElement(By.xpath("//input[@name='Enter_country_Name__c']"));
		actions.moveToElement(country).click().build().perform();

		executor.executeScript("arguments[0].value='" + "India" + "';", country);
		// country.sendKeys("India");

		// Surgeries
		WebElement surgeries = driver.findElement(By.xpath("//input[@name='Surgeries_with_in_6_months__c']"));
		actions.moveToElement(surgeries).click().build().perform();
		driver.findElement(By.xpath("//input[@name='how_to_make_a_text_box_visble_if_a_check__c']")).sendKeys("N/A");

		// Immunization

		WebElement DropDownImm = driver.findElement(
				By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[13]"));
		actions.moveToElement(DropDownImm).click().build().perform();
		Thread.sleep(3000);
		WebElement opt = driver.findElement(By.xpath("//lightning-base-combobox-item[2]/span[2]/span"));

		actions.moveToElement(opt).click().build().perform();
		
		//Glucose dropdown
		
	
	}

	@AfterTest
	public void teardown() {
		driver.close();

	}

}