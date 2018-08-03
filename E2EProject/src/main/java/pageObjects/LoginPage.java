package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver theDriver) {
		this.driver = theDriver;
		
	}
	
	//sign in locater object
	By email = By.cssSelector("[id='user_email']");
	By psw = By.cssSelector("[type='password']");
	By logButton = By.cssSelector("[value='Log In']");

	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement getPsw() {
		
		return driver.findElement(psw);
	}
	
	public WebElement getLogButton() {
		
		return driver.findElement(logButton);
	}

}
