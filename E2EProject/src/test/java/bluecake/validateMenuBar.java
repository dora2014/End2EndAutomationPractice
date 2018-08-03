package bluecake;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateMenuBar extends base {

	private static Logger log = LogManager.getLogger(validateMenuBar.class.getName());
	
	//import testng
	@Test  
	public void baseNavigation() throws IOException {
		driver = super.initializeDriver();
		//base firstBase = new base();
		//firstBase.initializeDriver();
		
		log.info("initialized the driver");
		log.error("no object present");
		System.out.println(super.getWebUrl());
		
		driver.get(super.getWebUrl());
		LandingPage landPage = new LandingPage(driver);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
		log.info("landed on the landing page");
		log.error("can't see page!");
		
		boolean isDisplayed = landPage.getMenuBar().isDisplayed();
		System.out.println(isDisplayed);
		Assert.assertTrue(isDisplayed);
		//Assert.assertFalse(isDisplayed);
		//driver.close();
		
	}
	
	@AfterTest
	public void cleanUp() {
		
		driver.close();
	}
	
	
	
}
