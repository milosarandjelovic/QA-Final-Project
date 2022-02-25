package projectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getSearchResults() {
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	public int getSearchResultsNumber() {
		return this.getSearchResults().size();
	}

}
