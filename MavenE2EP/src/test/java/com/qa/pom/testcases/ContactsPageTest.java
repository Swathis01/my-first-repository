/*
 * @autor : Swathi Samala
 * 
 */
package com.qa.pom.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.ContactsPage;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.qa.pom.util.TestUtil;


public class ContactsPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()throws IOException{
		initilization();
		tu= new TestUtil();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
		cp=hp.contactsLinkValidate();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabel() {
		Assert.assertTrue(cp.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		cp.selectContactsByName("Manvi Tanvi");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) {
		hp.clickOnNewContactLink();
		cp.createNewContacts(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}

}
