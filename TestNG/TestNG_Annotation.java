package LearningTestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
public class TestNG_Annotation {

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test
	public void Test1() {
		System.out.println("Create");
	}
	
	@Test
	public void Test2() {
		System.out.println("Delete");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After class");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("After Suite");
	}
	
}
