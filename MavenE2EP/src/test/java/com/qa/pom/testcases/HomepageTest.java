package com.qa.pom.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.ContactsPage;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.qa.pom.util.TestUtil;

public class HomepageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	public HomepageTest() {
		
		super();

	}
	@BeforeMethod
	public void setup()throws IOException{
		initilization();
		tu= new TestUtil();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String hptitle=hp.homePageTitle();
		Assert.assertEquals(hptitle, "CRMPRO", "Homepage title not matched");
	}
	
	@Test(priority=2)
	public void validateUserNameTest() {	
		tu.switchToFrame();
		Assert.assertTrue(hp.userNameValidate());
	}
	
	@Test(priority=3)
	public void contactsLinkTest() {
		tu.switchToFrame();
		cp = hp.contactsLinkValidate();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
