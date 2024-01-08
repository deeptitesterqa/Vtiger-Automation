package com.evs.vtiger.pages.Maketing.Leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class MarketingLeadsLandingOR {
	public MarketingLeadsLandingOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadsButton;

}
