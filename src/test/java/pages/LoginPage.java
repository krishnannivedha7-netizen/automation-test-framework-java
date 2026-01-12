package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

	private WebDriver driver;
	
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private WaitUtils waitUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
	}
	
	public void enterUsername(String username) {
		waitUtils.waitForVisibility(usernameField);
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		waitUtils.waitForVisibility(passwordField);
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() {
		waitUtils.waitForClickable(loginButton);
		driver.findElement(loginButton).click();
	}
	
	public void login(String username, String password) {
		
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	
	
	private By errorMessage = By.cssSelector("[data-test='error']");
	private By productsTitle = By.className("title");
	
	public boolean isErrorMessageDisplayed() {
		waitUtils.waitForVisibility(errorMessage);
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public boolean isLoginSuccessful() {
		waitUtils.waitForVisibility(productsTitle);
		return driver.findElement(productsTitle).isDisplayed();
	}
	
	}
