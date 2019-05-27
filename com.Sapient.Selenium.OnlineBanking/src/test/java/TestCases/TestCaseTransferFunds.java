package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageObjectsLogin;
import PageObjects.PageObjectsTransferFunds;
import Utilities.Utilities;

public class TestCaseTransferFunds {

	WebDriver driver;
	PageObjectsTransferFunds objTransfer;
	PageObjectsLogin objLogin;
	
	@BeforeMethod
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Utilities.getDataFromConfig("URL"));
		
	}
	
	@Test(priority = 5)
	public void FundsTransfer() throws IOException{
		
		//Check if application logged in successfully
		objLogin = new PageObjectsLogin(driver);
		objLogin.strUsername.sendKeys(Utilities.getDataFromConfig("USERNAME"));
		objLogin.strPassword.sendKeys(Utilities.getDataFromConfig("PASSWORD"));
		objLogin.btnLogin.click();
		clickLink();
		initiateTransfer(Utilities.getDataFromExcel("AMOUNT", "TestData"));
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
	
	public boolean verifyLinkIsPresent(WebElement element){
    	
    	if (element.isDisplayed())
    		
    		return true;
    	
    	else
    		
    		return false;
    	
    }
    
    
    public void clickLink(){
    	
    	objTransfer = new PageObjectsTransferFunds(driver);
    	System.out.println("Link Transfer funds - Present :" +verifyLinkIsPresent(objTransfer.linkTransferFunds));
    	if (verifyLinkIsPresent(objTransfer.linkTransferFunds)){
    		
    		objTransfer.linkTransferFunds.click();
    		if(objTransfer.btnTranfer.isDisplayed()){
    			
    			System.out.println("Transfer Funds page is displayed successfully");
    			
    		}
    		
    	}
    	else
    		
    		System.out.println("Unable to click as link is not present");
    	
    }
    
    public void initiateTransfer(String strAmount) throws IOException{
    	
    	objTransfer = new PageObjectsTransferFunds(driver);
    	Select oFrom = new Select(objTransfer.fromAccount);
    	Select oTo = new Select(objTransfer.toAccount);
    	oFrom.selectByIndex(0);
    	oTo.selectByIndex(1);
    	objTransfer.tranferAmount.sendKeys(strAmount);
    	objTransfer.btnTranfer.click();
    	String actualMessage=objTransfer.transferMessage.getText();
    	if(actualMessage.contains("successfully transferred")){
    		
    		System.out.println("Message is displayed with correct amount and from/to account details");
    		
    	}else{
    		
    		System.out.println("There is some issue while initiating the transfer");
    		
    	}
    	
    }
	
}
