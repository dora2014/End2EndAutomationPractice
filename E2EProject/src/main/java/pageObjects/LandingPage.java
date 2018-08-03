package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver theDriver) {
		this.driver = theDriver;
		
	}
	
	//sign in locater object
	By SignIn = By.cssSelector("a[href*='sign_in']");
	By Title = By.cssSelector(".text-center>h2");
	
	By MenueBar = By.cssSelector("[class='nav navbar-nav navbar-right']");

	public WebElement getLogin() {
		
		return driver.findElement(SignIn);
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(Title);
	}
	
	public WebElement getMenuBar() {
		
		return driver.findElement(MenueBar);
	}
	
}
