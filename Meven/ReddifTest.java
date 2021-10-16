package mvn.mvnProject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReddifTest {

	
public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	
	public ExtentTest test;
	@BeforeTest
	public void setExtent() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extent-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Website Testing "); // Tile of report - you can change
		htmlReporter.config().setReportName("Rediff Testing"); // Name of the report - you can change
		htmlReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
		 
		extent.attachReporter(htmlReporter);
	
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Shivani");
		extent.setSystemInfo("OS","Windows 10");
		
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MAYURI\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	}

	// Test1
	@Test
	public void RediffMoneyTitleTest() {
		test = extent.createTest("RdiffMoneyTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		test.log(Status.INFO, "test.log - INFO - checking title in this test");
		Assert.assertEquals(title, "Rediff ");

	}

	// Test2
	@Test
	public void RediffMoneyLogoTest() {
		test = extent.createTest("RediffMoneyLogoTest");
		boolean b = driver.findElement(By.xpath("//span[@class='hmsprite logo']")).isDisplayed();
		test.log(Status.INFO, "test.log - INFO  - Checking the Rediff Moneywiz");
		Assert.assertTrue(b);
	}

	// Test3
	@Test
	public void RediffMoneyLoginTest() {
		test = extent.createTest("RediffMoneyLoginTest");

		test.createNode("Login with Valid input");
		test.log(Status.INFO, "test.log - INFO - created node");
		
		Assert.assertTrue(true);
		//Creates a node in the same test
		//This is a sub node in the same node
		//Verify it in the output 
		
		
		test.createNode("Login with In-valid input");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		//ITestResult - will have result of the test execution 
		//After completion of every method this method will run
		//Result variable will contain result of previous method executed
		//result.g
		//ITestResult.
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			//test.log - logs result in the Extent Report
			
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
			String screenshotPath = RediffTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
