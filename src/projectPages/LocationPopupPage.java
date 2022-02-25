package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage {
	private WebDriver driver;
	JavascriptExecutor js;

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public WebElement getLocation() {
		return driver.findElement(By.xpath("//*[@class='location-selector']/a"));
	}

	public void closeLocationWindow() {
		driver.findElement(By.className("close-btn-white")).click();
		;
	}

	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}

	public void openLocationWindow() {
		this.getLocation().click();
	}

	public void setLocation(String locationName) {
		this.openLocationWindow();
		String locationItem = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), locationItem);
		this.getSubmit().click();
	}

}
