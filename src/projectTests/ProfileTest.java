package projectTests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	String url = this.baseUrl + "/guest-user/loginform";

	@Test(priority = 1)
	public void editProfileTest() throws InterruptedException {

		driver.get(url);

		locationPopupPage.closeLocationWindow();

		loginPage.LoginUser(this.email, this.password);

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Login Successfull"),
				" [ERROR] Unexpected login message ");
		notificationSystemPage.noMessageDisplay();

		url = this.baseUrl + "/member/profile";
		driver.get(url);

		profilePage.updateProfileInfo("Saoirse", "Ronan", "2401 3rd Ave, Bronx", "12334453236", "112", "USA",
				"New York", "New York");

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Setup Successful"),
				" [ERROR] Unexpected setup message ");
		notificationSystemPage.noMessageDisplay();

		authPage.logoutUser();

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Logout Successfull!"),
				" [ERROR] Unexpected logout message ");
		notificationSystemPage.noMessageDisplay();
	}

	@Test(priority = 2)
	public void changeProfileImage() throws IOException, InterruptedException, AWTException {
		String imgUrl = new File("img//image.jpg").getCanonicalPath();

		url = this.baseUrl + "/guest-user/loginform";
		driver.get(url);

		locationPopupPage.closeLocationWindow();

		loginPage.LoginUser(this.email, this.password);

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Login Successfull"),
				" [ERROR] Unexpected login message ");
		notificationSystemPage.noMessageDisplay();

		url = this.baseUrl + "/member/profile";
		driver.get(url);

		profilePage.setProfileImg(imgUrl);

		Thread.sleep(3000);

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Profile Image Uploaded Successfully"),
				" [ERROR] Unexpected upload profile image message ");
		notificationSystemPage.noMessageDisplay();

		profilePage.deleteProfileImage();

		notificationSystemPage.messageDisplay();
		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Profile Image Deleted Successfully"),
				" [ERROR] Unexpected delete profile image message ");
		notificationSystemPage.noMessageDisplay();

		authPage.logoutUser();

		Assert.assertTrue(notificationSystemPage.getAlertText().contains("Logout Successfull!"),
				" [ERROR] Unexpected logout message ");
		notificationSystemPage.noMessageDisplay();
	}
}
