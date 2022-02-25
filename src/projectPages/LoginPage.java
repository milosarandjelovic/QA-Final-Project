package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement LoginButtonHeader() {
		return this.driver.findElement(By.xpath("//*[@class='filled']/a"));
	}

	public WebElement Username() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement Password() {
		return this.driver.findElement(By.name("password"));
	}

	public WebElement RememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	}

	public WebElement LoginButton() {
		return this.driver.findElement(By.className("btn--primary"));
	}

	public void LoginUser(String username, String Password) {
		this.Username().clear();
		this.Password().clear();
		this.Username().sendKeys(username);
		this.Password().sendKeys(Password);
		this.LoginButton().click();
	}

}
