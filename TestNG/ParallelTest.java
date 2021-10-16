package LearningTestNG;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void Method1() {
		System.out.println("Thread First");
		long id = Thread.currentThread().getId();
		System.out.println("A_TestMethod. Thread id is: " + id);
	}
	
	@Test
	public void Method2() {
		System.out.println("Thread Second");
		long id = Thread.currentThread().getId();
		System.out.println("A_TestMethod. Thread id is: " + id);
	}
	
	@Test
	public void Method3() {
		System.out.println("Thread Third");
		long id = Thread.currentThread().getId();
		System.out.println("A_TestMethod. Thread id is: " + id);
	}
	
	@Test
	public void Method4() {
		System.out.println("Thread Fourth");
		long id = Thread.currentThread().getId();
		System.out.println("A_TestMethod. Thread id is: " + id);
	}
}
