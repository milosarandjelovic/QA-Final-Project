package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage {
	WebDriver driver;

	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getClearAllButton() {
		return this.driver.findElement(By.partialLinkText("Clear All"));
	}

	public void cartClearAll() {
		this.getClearAllButton().click();
	}
}
