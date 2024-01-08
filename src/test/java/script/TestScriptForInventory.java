package script;


import org.testng.annotations.Test;

import com.evs.vtiger.pages.Commen.Method.ReusebleMethod;
import com.evs.vtiger.pages.Inventory.Invoic.CreateNewInvoicePage;
import com.evs.vtiger.pages.Inventory.Invoic.InventoryInvoicLandingPage;
import com.evs.vtiger.pages.Inventory.Product.CreateNewProductPage;
import com.evs.vtiger.pages.Inventory.Product.InventoryProductLandingPage;
import com.evs.vtiger.utils.WebUtils;

public class TestScriptForInventory extends BaseTestScript {
    @Test
	public  void vt002CreateInvoice() throws Exception {
		WebUtils wt = WebUtils.getWebUtils();;
		ReusebleMethod rm = new ReusebleMethod(wt);
		rm.goToInventoryProducts();
		new InventoryProductLandingPage(wt).clickOnCreateProductButton();
		new CreateNewProductPage(wt).enterProductInfo();
		rm.goToInventoryInvoice();
		InventoryInvoicLandingPage lp = new InventoryInvoicLandingPage(wt);
		lp.clickOnCreateInvoiceButton();
		CreateNewInvoicePage ip = new CreateNewInvoicePage(wt);
		ip.enterInvoiceInfo();
	}

}
