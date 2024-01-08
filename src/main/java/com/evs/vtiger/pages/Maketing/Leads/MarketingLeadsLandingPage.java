package com.evs.vtiger.pages.Maketing.Leads;

import com.evs.vtiger.utils.WebUtils;

public class MarketingLeadsLandingPage extends MarketingLeadsLandingOR {
	private WebUtils wu;
	public MarketingLeadsLandingPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
	public void clickOnCreateButton() throws Exception {
		wu.click(getCreateLeadsButton());
	}
}
