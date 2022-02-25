package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MealPage {
	WebDriver driver;

	public MealPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart(int quantity) {
		String amount = Integer.toString(quantity);
		this.driver.findElement(By.name("product_qty")).click();
		this.driver.findElement(By.name("product_qty")).sendKeys(Keys.BACK_SPACE);
		this.driver.findElement(By.name("product_qty")).sendKeys(amount);
		this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	}

	public void addToFavorite() {
		this.driver.findElement(By.className("favourite")).click();
	}
}
