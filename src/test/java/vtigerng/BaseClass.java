package vtigerng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	@BeforeSuite
	public void vt001() {
		System.out.println("before suite");
	}
	@BeforeClass
	public void vt002() {
		System.out.println("before testcaseTag");
	}
	@BeforeTest
	public void vt003() {
		System.out.println("before class");
	}
	@AfterSuite
	public void vt004() {
		System.out.println("after suite");
	}
	@AfterTest
	public void vt005() {
		System.out.println("after testTag");
	}
	@AfterClass
	public void vt006() {
		System.out.println("after class");
	}

}
