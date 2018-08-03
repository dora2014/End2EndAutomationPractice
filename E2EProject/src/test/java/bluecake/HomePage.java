package bluecake;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	//import testng
	@Test (dataProvider="getData") //inject data from dataProvider method
	public void baseNavigation(String UsrName, 
								String psw,
								String UsrType) throws IOException {
		driver = super.initializeDriver();
		//base firstBase = new base();
		//firstBase.initializeDriver();
		
		driver.get("http://www.qaclickacademy.com");
		LandingPage landPage = new LandingPage(driver);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		landPage.getLogin().click();
		
		LoginPage logPage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		logPage.getEmail().sendKeys(UsrName);
		logPage.getPsw().sendKeys(psw);
		logPage.getLogButton().click();
		
		System.out.println(UsrType);
		
		//driver.close();
		
	}
	
	
	@AfterMethod
	public void cleanUp() {
		
		driver.close();
	}
	
	//testng dataprover annotation
	@DataProvider
	public Object[][] getData() {
		
		//row = numbers of different data set
		//col= number of values for each data set
		Object[][] data=new Object[2][3];
		
		//fill out the data
		data[0][0]="me@me.com";
		data[0][1]="12345";
		data[0][2]="Restricted User";
		
		data[1][0]="you@me.com";
		data[1][1]="678910";
		data[1][2]="Unrestricted User";
		
		return data;
		
	}
	
	
	
}
