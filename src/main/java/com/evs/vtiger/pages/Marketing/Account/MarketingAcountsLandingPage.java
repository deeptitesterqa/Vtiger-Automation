package com.evs.vtiger.pages.Marketing.Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtils;

public class MarketingAcountsLandingPage extends MarketingAcountsLandingOR{
	private WebUtils wu;
	public MarketingAcountsLandingPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
	
	
	public void clickOnCreateAcountButton() throws Exception {
		wu.click(getCreateButton());
	}

}
