package curs2;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample {
	
	@Test(priority=1)
	public void softAssert() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("Soft assert starts here");
		sa.assertTrue(false);
		System.out.println("After assert");
		sa.assertTrue(false);
		System.out.println("Method closes");
		
		sa.assertAll(); //grupeaza toate failurile la finalul metodei
	}
	
	@Test(priority=2)
	public void hardAssert() {
		
		System.out.println("Hard assert starts here");
		assertTrue(false);
		System.out.println("After assert");
		System.out.println("Method closes");
	}

}
