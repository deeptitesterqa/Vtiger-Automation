package com.evs.vtiger.pages.Maketing.Leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtils;


public class MarketingLeadsCreateNewLeadsPage extends MarketingCreateNewLeadsOR {
	private WebUtils wu;
	public MarketingLeadsCreateNewLeadsPage(WebUtils wt) {
		super(wt);
		this.wu=wt;

	}
	
    

	public  void enterLeadsInfo() throws Exception {
		wu.sendKeys("Somi",getFirstNameTB());
		wu.sendKeys("Bano",getLastNameTB());
		wu.sendKeys("Xzy",getCompanyNameTB());
		wu.sendKeys("myTitle", getEnterTitle());
		wu.dropSelectByValue("Web Site",getLeadScore());
		wu.dropSelectByValue("Qualified",getLeadStatus());
		wu.sendKeys("9458652365", getPhoneTB());
		wu.sendKeys("deep@meeting.com",getEmailTB());
		wu.sendKeys("UPRoad",getStreetTB());
		wu.sendKeys("ab123",getPostTB());
		wu.sendKeys("221002", getPostalCode());
		wu.sendKeys("India",getCountryTB());
		wu.sendKeys("jaunpur",getCityTB());
		wu.sendKeys("up", getStateTB());
		wu.sendKeys("createMyLeads",getDescriptionTB());
	
	}
	public void SaveMarketingLeadInfo() throws Exception {
		wu.click(getSaveButton());
	}
	
}
