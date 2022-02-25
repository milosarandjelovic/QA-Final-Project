package projectPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage {
	WebDriver driver;
	WebDriverWait wait;

	public NotificationSystemPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getMessageDisplay() {
		return this.driver.findElement(By.className("system_message"));
	}

	public String getAlertText() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement messageElement = this.getMessageDisplay().findElement(By.className("content"));

		wait.until(
				ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(messageElement, "Processing...")));

		boolean messageIsDisplayed = true;

		String message = "";

		try {
			message = messageElement.getText();

		} catch (Exception e) {
			messageIsDisplayed = false;

		}
		if (!(messageIsDisplayed)) {
			message = messageElement.findElement(By.className("div_error")).getText();

			String msgR2 = messageElement.findElement(By.xpath("//li")).getText();

			message = message + " " + msgR2;
		}
		return message;
	}

	public void noMessageDisplay() {
		wait.until(ExpectedConditions.attributeContains(this.getMessageDisplay(), "style", "display: none;"));
	}

	public void messageDisplay() {
		wait.until(ExpectedConditions.visibilityOf(getMessageDisplay()));
	}
}
