package com.qa.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pom.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[@title=\"New Contact\"]")
	WebElement newContacts;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement surname;
	
	@FindBy(xpath="//form[@id=\"contactForm\"]//input[@value='Save']")
	WebElement save;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	////a[text()='Sunil Ban']//parent::td[@class="datalistrow"]//preceding-sibling::td[@class="datalistrow"]/input[@name="contact_id"]
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
		
	}
	
	public void addContacts() {
		contactsLabel.click();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class=\"datalistrow\"]//preceding-sibling::td[@class=\"datalistrow\"]/input[@name=\"contact_id\"]")).click();
		
	}
	
	public void createNewContacts(String title, String ftName, String ltName, String comp ) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		surname.sendKeys(ltName);
		company.sendKeys(comp);
		save.click();
		
		
	}

}
