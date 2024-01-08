package com.evs.vtiger.pages.Commen.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;

@Getter
public class ReusebleMethodOR {
	public ReusebleMethodOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userNameTB;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement userPasswordTB;
	
	@FindBy(xpath="//input[@name='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logOut;
	
	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketingTab;
	
	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Leads']")
	private WebElement MarketingLeads;
	
	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Accounts']")
	private WebElement MarketingAccounts;
	
	@FindBy(xpath="//a[text()='Inventory']")
	private WebElement InventoryTab;
	
	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Invoice']")
	private WebElement InventoryInvoice;
	
	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Products']")
	private WebElement InventoryProducts;
	

}
