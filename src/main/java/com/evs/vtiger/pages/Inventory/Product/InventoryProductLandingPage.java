package com.evs.vtiger.pages.Inventory.Product;

import com.evs.vtiger.utils.WebUtils;

public class InventoryProductLandingPage extends InventoryProductLandingOR {
	private WebUtils wu;
	public InventoryProductLandingPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
	
	public void clickOnCreateProductButton() throws Exception {
		wu.click(getCreateProductButton());
	}

}
  