package com.evs.vtiger.pages.Marketing.Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class CreateNewAcountOR {
	
	public CreateNewAcountOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement AccountNameBox;
	
	@FindBy(xpath = "//input[@name='website']")
	private WebElement WebsiteNameBox;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement PhoneNumberBox;
	
	@FindBy(xpath = "//input[@id='email1']")
	private WebElement EmailBox;
	
	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement AssignToDropdown;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement BillAddress;
	
	@FindBy(xpath = "//input[@id='bill_pobox']")
	private WebElement BillPostBox;
	
	
	@FindBy(xpath = "//input[@id='bill_city']")
	private WebElement BillingCity;
	
	@FindBy(xpath = "//input[@id='bill_state']")
	private WebElement BillingState;
	
	@FindBy(xpath = "//input[@id='bill_code']")
	private WebElement BillingPostalTB;
	
	@FindBy(xpath = "//input[@id='bill_country']")
	private WebElement BillingCountryTB;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement DescriptionBox;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveButton;
	

}
