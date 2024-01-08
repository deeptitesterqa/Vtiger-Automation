package com.evs.vtiger.pages.Inventory.Invoic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class InventoryInvoiceLandingOR {
	public InventoryInvoiceLandingOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createButton;


}
