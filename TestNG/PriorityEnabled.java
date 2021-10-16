package LearningTestNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityEnabled {

	@BeforeMethod
	public void ResistationUser() {
		System.out.println("User Resistation");
	}
	
	@Test(priority=1)
	public void LoginCrediantial() {
		System.out.println("Login Crediantial");
	}
	
	@Test(priority=2,enabled=false)
	public void Home() {
		System.out.println("Hame Page");
	}
	
	@Test(priority=3)
	public void LogOut() {
		System.out.println("Log out");
	}
}
