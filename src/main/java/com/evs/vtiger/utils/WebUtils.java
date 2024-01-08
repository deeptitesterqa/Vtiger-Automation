package com.evs.vtiger.utils;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import lombok.Getter;
@Getter
public class WebUtils {
	private WebUtils() {}
	
private   WebDriver driver;
private static WebUtils wt;
public static WebUtils getWebUtils() {
	if (wt==null) {
		
		wt=new WebUtils();
	}
	return wt;
}

private ExtentTest extTest;
public void setExtendObj(ExtentTest extTest) {
	this.extTest=extTest;
}
public ExtentTest getExtendObj() {
	return this.extTest;
}
	
public  void LounchBrowser(String browserName,String driverName) throws Exception {
		try {
			System.setProperty("webdriver."+browserName+".driver", "driver\\"+driverName+".exe");
			if (browserName.equals("chrome")) {
				driver=new ChromeDriver();
				
			}else if (browserName.equals("fireFox")) {
				driver=new FirefoxDriver();
				
			}else if (browserName.equals("safari")) {
				driver=new SafariDriver();
			}else if (browserName.equals("edge")) {
				driver=new EdgeDriver();
			}
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.out.println("SessionNotCreatedException");
		}catch (InvalidSelectorException e) {
			System.out.println("InvalidSelectorException");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}}
//############################################################################################################################
	
	public  void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			throw e;
		}}
//###################################################################################	
	public String getSnapShot(String testcaseName) throws IOException {
		TakesScreenshot tc=(TakesScreenshot)driver;
		File sourcefile = tc.getScreenshotAs(OutputType.FILE);
		DateFormat df = new SimpleDateFormat("mm-dd-yy hh_mm_ss_a");
		String tm = df.format(new Date());
		File fileDestination = new File("test-output\\"+testcaseName+tm+".png");
		com.google.common.io.Files.copy(sourcefile, fileDestination);
		extTest.log(Status.INFO, "TakeSnapShot of-"+testcaseName);
		return fileDestination.getAbsolutePath();
	}
//##############################################WebElementMethods###########################################################################

	
//	public static List<WebElement> myFindElements(String xPath ,String elementsName){
//		List<WebElement> we=null;
//		try {
//			we=driver.findElements(By.xpath(xPath));
//			//System.out.println(elementsName+"found successfully");
//			
//		
//		}catch (InvalidSelectorException e) {
//			System.out.println(elementsName+"not found becouse xpath sentex is invaild");
//		}catch (Exception e) {
//			throw e;}
//		return we;
//		
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public  void click(WebElement we) throws Exception {
		String elementName=we.getAccessibleName();
	if (we.isEnabled()==true && we.isDisplayed()==true) {
		try {
			we.click();
			extTest.log(Status.INFO, "click on -"+elementName);
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(we));
			we.click();
			System.out.println("StaleElementReferenceException");
	
		}catch (ElementClickInterceptedException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(we));
			Actions obj = new Actions(driver);
			obj.click(we).build().perform();
		}catch(Exception e) {
			try {
				JavascriptExecutor javaScript=	(org.openqa.selenium.JavascriptExecutor) driver;
				javaScript.executeScript("arguments[0].click()", we);
			} catch (Exception e2) {
				throw e2; 
			}
		}}}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	
	public   String getText(WebElement we) throws Exception {
		String elementName=we.getAccessibleName();
		String weText; 
		try {
			weText=we.getText();
			extTest.log(Status.INFO, "GetText of element-"+elementName);
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(we));
			weText=we.getText();
		}catch (Exception e) {
			throw e;
		}
		return weText;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public   void sendKeys(String value,WebElement we ) throws Exception {
		String name=we.getAccessibleName();
			if (we.isEnabled()==true  && we.isDisplayed()==true) {
				try {
					we.sendKeys(value);
					extTest.log(Status.INFO, "Value pass in-"+name);	
				} catch (ElementNotInteractableException e) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
					wait.until(ExpectedConditions.visibilityOf(we));
					Actions obj = new Actions(driver);
					obj.sendKeys(we, value);
					System.out.println("sendKeys not work then we use Actions Sendkeys");
				}catch (StaleElementReferenceException e) {
					
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
					wait.until(ExpectedConditions.visibilityOf(we));
					we.sendKeys(value);
				}catch (Exception e) {	
					try {
						JavascriptExecutor javaScript=	(org.openqa.selenium.JavascriptExecutor) driver;
						javaScript.executeScript("arguments[0].value='"+value+"'", we);
					} catch (Exception e2) {
						throw e2;
					}
				}
			}else {
				System.out.println("Element is disable and not displayed");
			}}  
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void dropSelectByValue(String value,WebElement we) throws Exception {
		String dropName=we.getAccessibleName();
			Select ss = new Select(we);
			try {
	ss.selectByValue(value);
	extTest.log(Status.INFO, "Option selected by value in-"+dropName);
	} catch (Exception e) {
				throw e;
			}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void dropSelectByIndex(int index,WebElement we) throws Exception {
		String dropName=we.getAccessibleName();

		Select ss = new Select(we);
		try {
ss.selectByIndex(index);
extTest.log(Status.INFO, "Option selected by index in-"+dropName);
		} catch (Exception e) {
			throw e;
		}}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void dropSelectByInnerText(String innerText,WebElement we) throws Exception {
		String dropName=we.getAccessibleName();
		Select ss = new Select(we);
		try {
       ss.selectByVisibleText(innerText);
       extTest.log(Status.INFO, "Option selected by innerText in-"+dropName);
		} catch (Exception e) {
			throw e;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static int dropGetOptionsCount(String xPath,String value,String dropName) {
//		WebElement we = myFindElement(xPath, dropName);
//		Select ss = new Select(we);
//		int count;
//		try {
//      List<WebElement> listWe = ss.getOptions();
//    count = listWe.size();
//		System.out.println(dropName+" All Option count is ==>"+count);	
//		} catch (Exception e) {
//			throw e;
//		}
//		return count;
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//	public static ArrayList<String> dropGetOption(String xPath,String dropName) {
//		WebElement we = myFindElement(xPath, dropName);
//		Select ss = new Select(we);
//	List<WebElement> web = ss.getOptions();
//	ArrayList<String> ls=new  ArrayList<String>();
//	for (WebElement wea : web) {
//		System.out.println(wea.getText());
//		ls.add(wea.getText());
//	}
//	return ls;
//	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static String dropSelectedOption(String xPath,String dropName) {
//		WebElement we = myFindElement(xPath, dropName);
//		Select ss = new Select(we);
//		String selectedOption;
//		try {
//			WebElement weSelectedOption = ss.getFirstSelectedOption();
//			selectedOption	=weSelectedOption.getText();
//		System.out.println(dropName+"Selected option is got it ==>"+selectedOption);	
//		} catch (Exception e) {
//			throw e;
//		}
//		return selectedOption;
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void mouseHover(WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
		if (we.isEnabled()==true && we.isDisplayed()==true) {
			try {
				Actions act = new Actions(driver);
				act.moveToElement(we).build().perform();
				extTest.log(Status.INFO, "mouseHover on element-"+elementName);
			} catch (Exception e) {
				throw e;
		}
		}else {
			System.out.println("Element is disable or not displayed");
		}}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void sendKeysByActions(String value,WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
       if (we.isEnabled()==true && we.isDisplayed()==true) {
    	   try {
   			Actions act = new Actions(driver);
   			act.sendKeys(we, value).build().perform();
   			extTest.log(Status.INFO, "value send by ActionClass in -"+elementName);

   		} catch (StaleElementReferenceException e) {
   			
   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
   			wait.until(ExpectedConditions.visibilityOf(we));
   			we.sendKeys(value);
   			}catch (Exception e) {
   				throw e;
   			}}else {
   				System.out.println("Element not enable or not displayed");
   			}
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void myClickByActions(WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
		if (we.isEnabled()==true && we.isDisplayed()==true) {
			try {
	   			Actions act = new Actions(driver);
              act.click(we).build().perform();
     			extTest.log(Status.INFO, "click by ActionClass in -"+elementName);

			}  catch (StaleElementReferenceException e) {
	   			
	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	   			wait.until(ExpectedConditions.visibilityOf(we));
	   			Actions act = new Actions(driver);
	              act.click(we).build().perform();
	              }
			catch (Exception e) {
				throw e;
			}}else {
   				System.out.println("Element not enable or not displayed");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	public  void dubleClick(WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
		if (we.isEnabled()==true && we.isDisplayed()==true) {
			try {
	   			Actions act = new Actions(driver);
              act.doubleClick(we).build().perform();
     			extTest.log(Status.INFO, "dubleClick by ActionClass in -"+elementName);

			}  catch (StaleElementReferenceException e) {
	   			
	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	   			wait.until(ExpectedConditions.visibilityOf(we));
	   			Actions act = new Actions(driver);
	              act.doubleClick(we).build().perform();
	              }
			catch (Exception e) {
				throw e;
			}}else {
   				System.out.println("Element not enable or not displayed");
			}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void rightClick(WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
		if (we.isEnabled()==true && we.isDisplayed()==true) {
			try {
	   			Actions act = new Actions(driver);
              act.contextClick(we).build().perform();
     			extTest.log(Status.INFO, "RightClick by ActionClass in -"+elementName);

			}  catch (StaleElementReferenceException e) {
	   			
	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	   			wait.until(ExpectedConditions.visibilityOf(we));
	   			Actions act = new Actions(driver);
	              act.contextClick(we).build().perform();
	              
	              }
			catch (Exception e) {
				throw e;
			}}else {
   				System.out.println("Element not enable or not displayed");
			}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public  void dragAndDrop(WebElement source,WebElement target) throws Exception {

		if (source.isEnabled()==true && target.isDisplayed()==true) {
			try {
	   			Actions act = new Actions(driver);
              act.dragAndDrop(source, target).build().perform();
     			extTest.log(Status.INFO, "Drag And Drop by ActionClass in -");

			}  catch (StaleElementReferenceException e) {
	   			
	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	   			wait.until(ExpectedConditions.visibilityOf(source));
	   			Actions act = new Actions(driver);
	              act.dragAndDrop(source, target).build().perform();
	              
	              }
			catch (Exception e) {
				throw e;
			}}else {
   				System.out.println("Element not enable or not displayed");
			}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void  variTextValue(String expectedValue, String actualValue) {
		if (expectedValue.equals(actualValue)==true) {
			System.out.println("Test Case is passed Expectedvalue==>"+expectedValue+" actualValue==>"+actualValue);
			
		}else {
			System.out.println("Test Case is failed Expectedvalue==>"+expectedValue+" actualValue==>"+actualValue);
		}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void popAlertAccept(String alertName) throws Exception {
		try {
			driver.switchTo().alert().accept();
			extTest.log(Status.INFO, "PopAlert Accept to-"+alertName);
		} catch (NoAlertPresentException e) {
			System.out.println("there is no alert in"+alertName);
		}catch (Exception e) {
			throw e;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void popAlertDisMiss(String alertName) throws Exception {
		try {
			driver.switchTo().alert().dismiss();;
			extTest.log(Status.INFO, "PopAlert dismiss to-"+alertName);
		} catch (NoAlertPresentException e) {
			System.out.println("there is no alert in"+alertName);
		}catch (Exception e) {
			throw e;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void getTextFormPopAlert(String alertName) throws Exception {
		try {
			String massge = driver.switchTo().alert().getText();
			extTest.log(Status.INFO, "PopAlert getText to-"+alertName);
		} catch (NoAlertPresentException e) {
			System.out.println("there is no alert in"+alertName);
		}catch (Exception e) {
			throw e;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void popAlertSendKeys(String value, String alertName ) throws Exception {
		
		try {
			driver.switchTo().alert().sendKeys(value);;
			
			extTest.log(Status.INFO, "value send in alert pop to-"+alertName);
		
		} catch (NoAlertPresentException e) {
			System.out.println("there is no alert in"+alertName);
		}catch (Exception e) {
			throw e;
		}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void switchToFrameByIndex(int index) throws Exception {
		try {
			driver.switchTo().frame(index);
			System.out.println("Switch to frame by index value");
		} catch (NoSuchFrameException e) {
			System.out.println("There is no frame");
		}catch (Exception e) {
			throw e;
		}}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void switchToFrameByString(String nameOrId) throws Exception {

		try {
			driver.switchTo().frame(nameOrId);
			extTest.log(Status.INFO,"Switch to frame by String Id Or Name");


		} catch (NoSuchFrameException e) {
			System.out.println("There is no frame");
		}catch (Exception e) {
			throw e;}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void switchToFrameByWebElement(WebElement we) throws Exception {
		String FrameName=we.getAccessibleName();
		try {
			driver.switchTo().frame(we);
			extTest.log(Status.INFO,"Switch to frame by WebElement-"+FrameName);

		} catch (NoSuchFrameException e) {
			System.out.println("There is no frame");
		}catch (Exception e) {
			throw e;}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void switchToMainPage() throws Exception {
		try {
			driver.switchTo().defaultContent();
			extTest.log(Status.INFO,"Switch to main Page");
			}catch (Exception e) {
			throw e;}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public  void switchToParentFrame() throws Exception {
		try {
			driver.switchTo().parentFrame();
			extTest.log(Status.INFO,"Switch to parent frame");
			}catch (Exception e) {
			throw e;}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void getTableCountRow(String xPath,String elementName) {
//		int size;
//		List<WebElement> elements = myFindElements(xPath+"//tr", elementName);
//		try {
//			 size = elements.size();
//		} catch (Exception e) {
//			throw e;
//		}}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//	public void checkClickElements(String xPath,String elementName) {
//		int size;
//		List<WebElement> elements = myFindElements(xPath, elementName);
//		try {
//			 size = elements.size();
//			 for (int i = 0; i < size; i++) {
//				 WebElement we = elements.get(i);
//				 elements = myFindElements(xPath, elementName);
//				 if (we.isSelected()==false) {
//					 we.click();
//			}}
//		} catch (Exception e) {
//			throw e;
//		}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static  void checkUnClickElements(String xPath,String elementName) {
//		int size;
//		List<WebElement> elements = myFindElements(xPath, elementName);
//		try {
//			 size = elements.size();
//			 for (int i = 0; i < size; i++) {
//				 
//				 WebElement we = elements.get(i);
//				 elements = myFindElements(xPath, elementName);
//				 if (we.isSelected()==true) {
//					we.click();
//				}
//			}
//		} catch (Exception e) {
//			throw e;
//		}}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static  List<String> getTableColumName(String xPath,String elementName) {
//		int size;
//		List <String> arr = new ArrayList<String>();
//		List<WebElement> elements = myFindElements(xPath+"//tr[1]//td", elementName);
//		try {
//			 size = elements.size();
//			 for (int i = 0; i < size; i++) {
//				 WebElement we = elements.get(i);
//				 elements = myFindElements(xPath, elementName);
//				String  ColumsName = we.getText();
//				 arr.add(ColumsName);
//			}
//			 System.out.println(arr);
//
//		} catch (Exception e) {
//			throw e;
//		}
//		return arr;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static  int getTableColumCountByNameColumName(String xPath,String elementName,String Name) {
//		int columNumber=-1;
//		List<String> arr = getTableColumName(xPath+"//tr[1]//td", elementName);
//		try {
//			for (int i = 0; i < arr.size(); i++) {
//				
//				String ColumName = arr.get(i);
//				if (ColumName.equalsIgnoreCase(Name)) {
//					i++;
//					columNumber=i;
//					System.out.println(i);
//				}}
//		} catch (Exception e) {
//			throw e;
//		}
//		return columNumber;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static  int getTableRowCountByNameTableIdName(String xPath,String elementName,String Name ,String RowNum) {
//		int columNumber=-1;
//		List<WebElement> arr = myFindElements(xPath+"//tr//td["+RowNum+"]", elementName);
//		try {
//			for (int i = 0; i < arr.size(); i++) {
//				
//				WebElement we = arr.get(i);
//				String ColumName = we.getText();
//				//System.out.println(ColumName);
//				if (ColumName.equalsIgnoreCase(Name)) {
//					i++;
//					columNumber=i;
//					System.out.println(columNumber);
//					break;
//				}
//				}
//		} catch (Exception e) {
//			throw e;
//		}
//		return columNumber;}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static  List<String> getTableRowDataByRowNumber(String xPath,String elementName,int number) {
//		int size;
//		List <String> arr = new ArrayList<String>();
//		List<WebElement> elements = myFindElements(xPath, elementName);
//		try {
//			 size = elements.size();
//			 for (int i = 0; i < size; i++) {
//    if (i==number) {
//    	WebElement we = elements.get(i);
//		String  ColumsName = we.getText();
//		 arr.add(ColumsName);
//}
//			}
//			 System.out.println(arr);
//
//		} catch (Exception e) {
//			throw e;
//		}
//		return arr;}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// public static  List<String> getTableColomDataByColomNumber(String xPath,String elementName,int number) {
//		int size;
//		List <String> arr = new ArrayList<String>();
//		List<WebElement> elements = myFindElements(xPath, elementName);
//		try {
//			 size = elements.size();
//			 for (int i = 0; i < size; i++) {
//				if (i==number) {			
//					 elements = myFindElements(xPath, elementName);
//					WebElement we = elements.get(i);
//						String  ColumsName = we.getText();
//						 arr.add(ColumsName);
//		}}
//			 System.out.println(arr);
//
//		} catch (Exception e) {
//			throw e;
//		}
//		return arr;}
//////////////////////////////////////////////WindowHandleMethods////////////////////////////////////////////////////////////////////////////////////
public  void switchToWindowByUrl(String url) throws Exception {
	Set<String> values = driver.getWindowHandles();
	try {
		for (String str : values) {
			driver.switchTo().window(str);

			String currentUrl = driver.getCurrentUrl();
			extTest.log(Status.INFO, "switch to window by url");
			if (currentUrl.equalsIgnoreCase(url)) {
             break;
			}else {
			System.out.println("url not match");
		}}
	} catch (NoSuchWindowException e) {
		System.out.println("Window not found");
	}catch (Exception e) {
		throw e;
	}}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public  void switchToWindowByTitle(String title) throws Exception {
	Set<String> values = driver.getWindowHandles();
	try {
		for (String str : values) {
			driver.switchTo().window(str);

			String currentUrl = driver.getTitle();
			if (currentUrl.equalsIgnoreCase(title)) {
				extTest.log(Status.INFO, "switch to window by title");

             break;
			}else {
			System.out.println("url not match");
		}}
	} catch (NoSuchWindowException e) {
		System.out.println("Window not found");
	}catch (Exception e) {
		throw e;
	}}}


