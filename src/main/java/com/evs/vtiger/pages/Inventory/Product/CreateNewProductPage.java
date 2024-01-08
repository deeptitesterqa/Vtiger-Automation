package com.evs.vtiger.pages.Inventory.Product;


import com.evs.vtiger.utils.WebUtils;

public class CreateNewProductPage extends CreateNewProductOR{
	private WebUtils wu;
	public CreateNewProductPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
	
	public void enterProductInfo() throws Exception {
		wu.sendKeys("RelaincePhone",getProductNameBox());
		wu.sendKeys("2023/12/12",getStartDate());
		wu.sendKeys("2024/12/12",getEndDate());
		
	}
	public void saveProductInfo() throws Exception {
		wu.click(getSaveButton());

	}

}







