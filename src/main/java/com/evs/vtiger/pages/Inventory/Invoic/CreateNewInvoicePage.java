package com.evs.vtiger.pages.Inventory.Invoic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtils;


public class CreateNewInvoicePage extends CreateNewInvoiceOR {
	private WebUtils wu;
	public CreateNewInvoicePage(WebUtils wt) {
		super(wt);
		this.wu=wt;
	}
	
	
	public void enterInvoiceInfo() throws Exception {
		wu.sendKeys("ForPractice",getSubjactTB());
		wu.sendKeys("Custome no Box",getCustomerNo());
		wu.click(getSelectButtonContect());
		wu.switchToWindowByUrl(getContactsUrl());
		Thread.sleep(2000);
		SearchContect();
		selectContect();
		wu.switchToWindowByUrl(getInVoiceUrl());
		Thread.sleep(2000);
		wu.click(getAcountButton());
		wu.switchToWindowByUrl(getAcountUrl());
		SearchAcount();
		selectAcount();
		wu.switchToWindowByUrl(getInVoiceUrl());
		Thread.sleep(2000);
		wu.sendKeys("MumbaiSector5", getBillingAdd());
		wu.sendKeys("UpJaunpur",getShipingAdd());
		wu.click(getProductButton());
		wu.switchToWindowByUrl(getProductUrl());
		Thread.sleep(2000);
		SearchProduct();
		selectProduct();
		wu.switchToWindowByUrl(getInVoiceUrl());
		Thread.sleep(2000);
		wu.sendKeys("80", getProductQty());
		wu.sendKeys("80",getLastprice());

	}
	public void saveInfo() throws Exception {
		wu.click(getSaveButton());
	}
	
	public void SearchContect() throws Exception {
		wu.sendKeys("Deep",getSearchTB());
		wu.dropSelectByValue("firstname", getSelectSearchFiled());
		wu.click(getSearchButton());
		Thread.sleep(2000);
	}
	public void selectContect() throws Exception {
		wu.click(getSelectContact());
		wu.popAlertAccept("contctSelect");
	}
	public void SearchAcount() throws Exception {
		wu.sendKeys("Deepti",getSearchTB());
		wu.dropSelectByValue( "accountname", getSelectSearchFiled());
		wu.click(getSelectContact());

	}
	public void selectAcount() throws Exception {
		wu.click(getSelectAccount());
		wu.popAlertAccept("AcountSelect");
	}
	public void SearchProduct() throws Exception {
		wu.sendKeys("RelaincePhone",getSearchTB());
		wu.dropSelectByValue("productname",getSelectSearchFiled());
		wu.click(getSearchButton());

	}
	public void selectProduct() throws Exception {
		wu.click(getSelectProduct());
	}

	

}
