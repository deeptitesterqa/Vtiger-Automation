package com.evs.vtiger.pages.Maketing.Leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class MarketingCreateNewLeadsOR {
	public MarketingCreateNewLeadsOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTB;
    
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameTB;
    
    @FindBy(xpath ="//input[@name='company']")
    private WebElement companyNameTB;
    
    @FindBy(xpath = "//input[@name='designation']")
    private WebElement EnterTitle;
    
    @FindBy(xpath = "//select[@name='leadsource']")
    private WebElement LeadScore;
    
    @FindBy(xpath ="//select[@name='leadstatus']")
    private WebElement LeadStatus;
    
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneTB;
    
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTB;
    
    @FindBy(xpath = "//textarea[@name='lane']")
    private WebElement StreetTB;
    
    @FindBy(xpath = "//input[@id='pobox']")
    private WebElement postTB;

    @FindBy(xpath = "//input[@id='code']")
    private WebElement postalCode;
    
    @FindBy(xpath = "//input[@id='country']")
    private WebElement CountryTB;
    
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityTB;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateTB;
    
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionTB;

    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
    private WebElement SaveButton;
	
	

}
