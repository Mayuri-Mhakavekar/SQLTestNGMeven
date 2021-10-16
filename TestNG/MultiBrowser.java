package LearningTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiBrowser {

	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.gecko.driver", "C:\\Users\\MAYURI\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if((browser.equalsIgnoreCase("chrome"))) {
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\MAYURI\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get("https://www.google.co.in/"); 
	}
	 @Test
	 public void login() throws InterruptedException {

		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(2000);
	}  

	@AfterClass
	public void afterTest() {
			driver.quit();

		}

}
