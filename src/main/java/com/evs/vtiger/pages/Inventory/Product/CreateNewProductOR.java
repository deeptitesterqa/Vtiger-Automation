package com.evs.vtiger.pages.Inventory.Product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class CreateNewProductOR {
	
	public CreateNewProductOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement ProductNameBox;
	
	@FindBy(xpath = "//input[@name='sales_start_date']")
	private WebElement StartDate;
	
	
	@FindBy(xpath = "//input[@name='sales_end_date']")
	private WebElement EndDate;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")	
	private WebElement SaveButton;

}
