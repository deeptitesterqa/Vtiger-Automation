package com.evs.vtiger.pages.Commen.Method;

import com.evs.vtiger.utils.WebUtils;


public class ReusebleMethod extends ReusebleMethodOR {
	private WebUtils wu;
	public ReusebleMethod(WebUtils wt) {
		super(wt);
		this.wu=wt;
	}

	public void login(String name,String pass) throws Exception {
		wu.sendKeys(name, getUserNameTB());
		wu.sendKeys(pass, getUserPasswordTB());
		wu.click(getLoginButton());

	}
	public void logout() throws Exception {
		wu.click(getLogOut());
	}

	public void goToMarketingLeads() throws Exception {
		wu.mouseHover(getMarketingTab());
		wu.click(getMarketingLeads());
	}

	public void goToMarketingAcounts() throws Exception {
		wu.mouseHover(getMarketingTab());
		wu.click(getMarketingAccounts());
	}

	public void goToInventoryInvoice() throws Exception {
		wu.mouseHover(getInventoryTab());
		wu.click(getInventoryInvoice());
	}

	public void goToInventoryProducts() throws Exception {
		wu.mouseHover(getInventoryTab());
		wu.click(getInventoryProducts());
	}

}
