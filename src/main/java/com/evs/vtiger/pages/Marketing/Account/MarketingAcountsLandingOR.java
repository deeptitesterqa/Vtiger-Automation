package com.evs.vtiger.pages.Marketing.Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class MarketingAcountsLandingOR {
	public MarketingAcountsLandingOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@title='Create Account...']")
	private WebElement CreateButton;

}
