package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	String webUrl;
	
	public String getWebUrl() {
		return webUrl;
		
	}
	
	//return driver object
	public WebDriver initializeDriver() throws IOException {
		
		
		Properties prop = new Properties();
		String propFile = "C:\\Users\\Waising\\E2EProject\\src\\main\\java\\resources\\data.properties";
		
		System.out.println(System.getProperty("user.dir"));
		
		
			//access to the property file
		FileInputStream fis = new FileInputStream(propFile);
		
		
		//load the property file
		prop.load(fis);
		//read and get value of the property
		String browserName = prop.getProperty("browser");
		webUrl = prop.getProperty("url");
		
		if(browserName.equals("chrome")) {
			//execute chrome driver

			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			
			//execute firefox
			System.setProperty("webdriver.firefox.driver", "C:\\selenium\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("IE")){
			
			//execute IE
		}
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public void screenShot(String className) throws IOException {
		
		long currentTime = System.currentTimeMillis();
		String userPath=System.getProperty("user.dir");
		System.out.println(userPath);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//	File dest = new File("C:\\Users\\Waising\\"+userPath + className+currentTime + ".png");
		
		File dest = new File(userPath + "\\test-output\\" + className+currentTime + ".png");
		
		Files.copy(src.toPath(), dest.toPath());
	}
	

}
