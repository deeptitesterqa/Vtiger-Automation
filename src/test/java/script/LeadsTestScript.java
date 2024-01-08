package script;


import org.testng.annotations.Test;

import com.evs.vtiger.pages.Commen.Method.ReusebleMethod;
import com.evs.vtiger.pages.Maketing.Leads.MarketingLeadsCreateNewLeadsPage;
import com.evs.vtiger.pages.Maketing.Leads.MarketingLeadsLandingPage;
import com.evs.vtiger.utils.WebUtils;

public class LeadsTestScript extends BaseTestScript{
	WebUtils wt = WebUtils.getWebUtils();;

	@Test
	public  void tc001CreateLeads() throws Exception {
		new ReusebleMethod(wt).goToMarketingLeads();
		new MarketingLeadsLandingPage(wt).clickOnCreateButton();
		MarketingLeadsCreateNewLeadsPage ml = new MarketingLeadsCreateNewLeadsPage(wt);
		ml.enterLeadsInfo();
		ml.SaveMarketingLeadInfo();
	}
}
