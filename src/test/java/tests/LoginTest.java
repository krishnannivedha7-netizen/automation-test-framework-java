package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		Assert.assertTrue(
				loginPage.isLoginSuccessful(),
				"Login failed: Products page not displayed"
				);
		}
	@Test
	public void invalidLoginTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "wrong_password");
		
		Assert.assertTrue(
				loginPage.isErrorMessageDisplayed(),
				"Error Message not displayed for invalid login"
				);
	}

}
