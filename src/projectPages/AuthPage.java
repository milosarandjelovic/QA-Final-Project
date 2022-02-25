package projectPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {
	WebDriver driver;
	WebDriverWait wait;

	public AuthPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserButton() {
		return this.driver.findElement(By.xpath("//a[@class='after-arrow user-trigger-js']"));
	}

	public WebElement getLogoutButton() {
		return this.driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li[2]/a"));
	}

	public void logoutUser() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.getUserButton().click();
		wait.until(ExpectedConditions.visibilityOf(getLogoutButton()));
		this.getLogoutButton().click();

	}
}
