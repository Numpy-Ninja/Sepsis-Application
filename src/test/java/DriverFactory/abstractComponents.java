package DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponents {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public abstractComponents() {

		this.wait = wait;

	}

	public void waitForElementToappear(WebElement user) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(user));
	}

	public void ActionClass(WebElement e, String s) {
		Actions a = new Actions(driver);
		a.sendKeys(e, s).build().perform();

	}


}
