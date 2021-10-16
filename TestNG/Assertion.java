package LearningTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	@Test
	public void CaseA() {
		String ExceptedOutput="Learn English";
		String ActualOutput="Learn English and Hindi";
		
		Assert.assertEquals(ExceptedOutput,ActualOutput );
	}
	
	@Test
	public void CaseB() {
		boolean b1=1<2;
		boolean b2=2>3;
		Assert.assertTrue(b1!=b2,"2 is greater than 3");
	}
	
	@Test
	public void Case() {
		Assert.fail();
	}
	
	@Test
	public void CaseD() {
		
	}
}
