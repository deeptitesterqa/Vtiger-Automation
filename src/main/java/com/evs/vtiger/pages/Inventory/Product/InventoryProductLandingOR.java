package com.evs.vtiger.pages.Inventory.Product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class InventoryProductLandingOR {
	
	public InventoryProductLandingOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath="//img[@title='Create Products...']")
	private WebElement createProductButton;

}
