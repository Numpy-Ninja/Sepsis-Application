import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Standalone  {
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException{
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("http://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("numpyninjaworkforce@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Salesforce@1");
		driver.findElement(By.id("Login")).click();
		 Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[contains(.,'Sepsis')]")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Patients']"));
	      JavascriptExecutor executor = (JavascriptExecutor)driver;
	      executor.executeScript("arguments[0].click();", element);
	      Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),'New')]")).click();
//		WebElement radiobuttonNP = driver.findElement(By.cssSelector("div:nth-child(3) .slds-radio--faux"));
//	      executor.executeScript("arguments[0].click();", radiobuttonNP);
			   Thread.sleep(3000);
	      WebElement next = driver.findElement(By.xpath("//span[contains(.,'Next')]"));
	      executor.executeScript("arguments[0].click();", next);
//	    WebElement newform=  driver.findElement(By.linkText("New"));
//	    executor.executeScript("arguments[0].click();", newform);
		Thread.sleep(3000);

		WebElement name = driver.findElement(By.xpath("//input[@name='First_Name__c']"));
		   name.sendKeys("Veena");
		   Thread.sleep(2000);
		driver.findElement( By.xpath("//input[@name='Last_Name__c']")).sendKeys("Sravanthi");
		
		
		
		Thread.sleep(2000);
		
		
	}
@Test
public void test()
{
}
 public void teardown()
 {
	driver.close();
	driver.quit();
 }

}