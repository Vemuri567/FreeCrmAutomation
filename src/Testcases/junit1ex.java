package Testcases;

import org.apache.poi.util.SystemOutLogger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

public class junit1ex {
	
	@BeforeClass
	public static void tc05(){
		System.out.println("Beforeclass");
	}
	
	@Before
	public void tc01(){
		System.out.println("Before");
	}
	
	@Test
	public void tc02(){
		SoftAssert sa=new SoftAssert();
		//sa.assertEquals(2, 3);
		//sa.assertEquals(false, true);
		//Verify.verify(3<2);
	   sa.assertEquals("Two strings are equal", "Hello", "Helloworld");
		System.out.println("xyz");
		
		//sa.fail("error");
		sa.assertAll();
	}
	
	@Test
	public void tc03(){
		//tc02();
		System.out.println("tc02");
		//homepage();
	}
	
	@After
	public void tc04(){
		System.out.println("After");
	}
	
	@AfterClass
	public static void tc06(){
		System.out.println("Afterclass");
	}
	

}
