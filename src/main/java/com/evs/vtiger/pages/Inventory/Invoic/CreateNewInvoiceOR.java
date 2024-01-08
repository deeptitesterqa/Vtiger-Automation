package com.evs.vtiger.pages.Inventory.Invoic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.WebUtils;

import lombok.Getter;
@Getter
public class CreateNewInvoiceOR {
	public CreateNewInvoiceOR(WebUtils wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}
	@FindBy(xpath ="//input[@name='subject']" )
	private WebElement subjactTB ;
	
	@FindBy(xpath ="//input[@id='customerno']" )
	private WebElement customerNo	;
	
	@FindBy(xpath ="(//img[@title='Select'])[2]" )
	private WebElement selectButtonContect;
	
	private String ContactsUrl="http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView";
	private String InVoiceUrl="http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory";
	
	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement AcountButton;
	
	private String AcountUrl="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=";
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement BillingAdd;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement ShipingAdd;
	
     @FindBy(xpath="//img[@id='searchIcon1']")
     private WebElement ProductButton;
     
     private String ProductUrl="http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&&&return_module=Invoice&currencyid=1";
	
     @FindBy(xpath="//input[@id='qty1']")
     private WebElement productQty;
     
     @FindBy(xpath="//input[@id='listPrice1']")
     private WebElement lastprice;
     
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveButton;
    
    @FindBy(xpath="//input[@id='search_txt']")
    private WebElement searchTB;
    
    @FindBy(xpath="//select[@name='search_field']")
    private WebElement selectSearchFiled;
    
    @FindBy(xpath="//input[@name='search']")
    private WebElement searchButton;
    
    @FindBy(xpath="//a[text()='Yadav Deep']")
    private WebElement selectContact;
    
     @FindBy(xpath="//a[text()='Deepti']")
     private WebElement selectAccount;
     
     @FindBy(xpath="//a[text()='RelaincePhone']")
     private WebElement selectProduct;
     

}
