package com.qa.pom.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.qa.pom.util.TestUtil;


public class LoginPageTest extends TestBase {

	TestUtil tu;
	LoginPage lp;
	HomePage hp;
	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeMethod
	public void setup()throws IOException{
		initilization();
		tu= new TestUtil();

		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title= lp.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		Boolean flag=lp.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
