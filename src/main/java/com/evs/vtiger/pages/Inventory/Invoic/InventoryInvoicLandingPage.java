package com.evs.vtiger.pages.Inventory.Invoic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtils;

public class InventoryInvoicLandingPage extends InventoryInvoiceLandingOR {
	private WebUtils wu;
	public InventoryInvoicLandingPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
		
	public void clickOnCreateInvoiceButton() throws Exception {
		wu.click(getCreateButton());
	}

}
