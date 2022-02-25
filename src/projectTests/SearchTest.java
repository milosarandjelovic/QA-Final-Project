package projectTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {
	String url = this.baseUrl + "/meals";
	String locationName = "City Center - Albany";

	@Test
	public void searchResultTest() throws InterruptedException, IOException {

		SoftAssert sa = new SoftAssert();

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		driver.get(url);

		Thread.sleep(3000);

		locationPopupPage.setLocation(locationName);

		Thread.sleep(3000);

		for (int i = 1; i <= 6; i++) {
			String searchUrl = sheet.getRow(i).getCell(1).getStringCellValue();
			String searchLocation = sheet.getRow(i).getCell(0).getStringCellValue();
			int numberOfResults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();

			driver.get(searchUrl);

			Thread.sleep(1000);

			locationPopupPage.getLocation().click();

			Thread.sleep(1000);

			locationPopupPage.setLocation(searchLocation);

			Thread.sleep(1000);

			int pageResNum = searchResultPage.getSearchResultsNumber();

			sa.assertTrue(pageResNum == numberOfResults, " [ERROR] Unexpected number of search results message ");

			Thread.sleep(2000);

			for (int j = 0; j < numberOfResults; j++) {

				WebElement mealItem = searchResultPage.getSearchResults().get(j);
				String meal = mealItem.getText();

				Thread.sleep(1000);
				String searchMeal = sheet.getRow(i).getCell(j + 3).getStringCellValue();

				System.out.println(meal + "   " + searchMeal);

				Thread.sleep(1000);

				sa.assertTrue(meal.contains(searchMeal), "[ERROR] Results don't match! ");
				Thread.sleep(1000);
			}

			wb.close();
			sa.assertAll();

			

		}

	}
}
