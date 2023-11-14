package driverFactory;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static Actions a;

	public AbstractComponents(WebDriver driver) {

		//this.wait = wait;
		this.driver = driver;

	}

	public void waitForElementToappear(WebElement user) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(user));
	}

	public void actionClass(WebElement e, String s) {

		a = new Actions(driver);
		a.sendKeys(e, s).build().perform();

	}

	public void actionClassMoveTo(WebElement e) {

		a = new Actions(driver);
		a.moveToElement(e).click().build().perform();

	}

	public void actionClassShiftHold() {
		a.sendKeys(Keys.chord(Keys.chord(Keys.CONTROL + "S"))).build().perform();
	}

}
