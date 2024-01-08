package com.evs.vtiger.pages.Marketing.Account;



import com.evs.vtiger.utils.WebUtils;

public class MarketingAcountsCreateNewAcountsPage extends CreateNewAcountOR{
	private WebUtils wu;
	public MarketingAcountsCreateNewAcountsPage(WebUtils wt) {
		super(wt);
		this.wu=wt;
	}
	
	public void enterMarketingAccountInfo() throws Exception {
		wu.sendKeys( "Deepti", getAccountNameBox());
		wu.sendKeys("VtigerPractice.com",getWebsiteNameBox());
		wu.sendKeys("7585658965", getPhoneNumberBox());
		wu.sendKeys("deep@meeting.com", getEmailBox());
		wu.dropSelectByValue("1",getAssignToDropdown());
		wu.sendKeys("State-UP-City-Jaunpur",getBillAddress());
		wu.sendKeys("None",getBillPostBox());
		wu.sendKeys("Varanasi", getBillingCity());
		wu.sendKeys("UP", getBillingState());
		wu.sendKeys("423245", getBillingPostalTB());
		
		wu.sendKeys("India", getBillingCountryTB());
		wu.sendKeys("This Account Creation is only for testing Purpose", 
				getDescriptionBox());
	}
	public void SaveMarketingAccountInfo() throws Exception {
		wu.click(getSaveButton());
	}
	

}
