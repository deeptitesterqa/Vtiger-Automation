package script;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evs.vtiger.pages.Commen.Method.ReusebleMethod;
import com.evs.vtiger.utils.WebUtils;

public class BaseTestScript {
	WebUtils wt = WebUtils.getWebUtils();;

	private ExtentReports extent;
	@BeforeSuite	
public void suite() {
	 extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("test-output/vtigerExtentReport.html");
	extent.attachReporter(spark);
	System.out.println("hello befoure suite");
}
	@Parameters({"browername","browser"})
	@BeforeClass
	public void browser(String broeswename,String browser) throws Exception {
        wt.LounchBrowser(broeswename,browser);
		 wt.getUrl("http://localhost:8888/");
	}
	@Parameters({"userName","userPasssword"})
	@BeforeMethod
	public void login(String name,String pass,Method mt) throws Exception {
		ExtentTest tc = extent.createTest(mt.getName());
		wt.setExtendObj(tc);

		ReusebleMethod rm = new ReusebleMethod(wt);
		rm.login(name,pass);
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("aftersuit");
		extent.flush();
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method m) throws Exception {
		if (result.getStatus()==result.FAILURE) {
			String snapshot = wt.getSnapShot(m.getName());
			wt.getExtendObj().addScreenCaptureFromPath(snapshot);
		}
		ReusebleMethod rm = new ReusebleMethod(wt);
	rm.logout();
	extent.flush();

		
	}
	
	

}
