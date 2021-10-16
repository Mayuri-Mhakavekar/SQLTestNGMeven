package First_PKJ;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AfterBeforeClass {
	
	
	@BeforeMethod
	public void Before() {
		System.out.println("B E F O R E Method");
	}
	
	
	
	@AfterMethod
	public void After() {
		System.out.println("A F T E R Method");
	}
	
	@Test
	public void add_cust() {
		System.out.println("Add Customer.........");
	}
	
	@Test
	public void Delete_cust() {
		System.out.println("Delete Customer.........");
	}
	
}
