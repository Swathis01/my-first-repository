package com.qa.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pom.base.TestBase;

public class HomePage extends TestBase {

	
	
	//Page Factory - OR: Object repo
	/*@FindBy(xpath="//td[@class='logo_text']")
	WebElement validateTitle;*/
	
	@FindBy(xpath="//td[@class='headertext' and @align='left']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[@id='navmenu']//a[@title='New Contact']")
	WebElement newContactLink;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean userNameValidate() {
		return userNameLabel.isDisplayed();
	}
	
	public DealsPage dealsLinkValidate() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public ContactsPage contactsLinkValidate() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public TasksPage taskLinkValidate() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
}
