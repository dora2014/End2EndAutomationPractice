package bluecake;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {

	//import testng
	@Test  
	public void baseNavigation() throws IOException {
		driver = super.initializeDriver();
		//base firstBase = new base();
		//firstBase.initializeDriver();
		
		driver.get("http://www.qaclickacademy.com");
		LandingPage landPage = new LandingPage(driver);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//compare actual value to expected value
		String actual = landPage.getTitle().getText();
		Assert.assertEquals("FEATURED 123COURSES", actual);
		
		
	}
	
	@AfterTest
	public void cleanUp() {
		
		
		driver.close();
	}
	
	
	
}
