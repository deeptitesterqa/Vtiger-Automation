package vtigerng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{
	@Test(priority = 3)
	public void verifyTc001Markrtinh(){
		System.out.println("Tc001");
	}
	@Test(priority = 3,dependsOnMethods = {"verifyTc003Markrtinh","verifyTc001Markrtinh"})
	public void verifyTc002Markrtinh(){
		System.out.println("Tc002");
	}
	@Test(priority = 1)
	public void verifyTc003Markrtinh(){
		System.out.println("Tc003");
	}
	@BeforeMethod
	public void verifyTc004Markrtinh() {
		System.out.println("tc004");
	}
	@AfterMethod
	public void verifyTc005Markrtinh() {
		System.out.println("tc005");
	}

}
