package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageObjectsAccountSummary;
import PageObjects.PageObjectsLogin;
import Utilities.Utilities;

public class TestCaseAccountSummary {

	WebDriver driver;
	PageObjectsAccountSummary objAccSummary;
	PageObjectsLogin objLogin;
	
	@BeforeMethod
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Utilities.getDataFromConfig("URL"));
		
	}
	
	@Test(priority = 6)
	public void verifyAccountSummary() throws IOException{
		
		//Check if application logged in successfully
		objLogin = new PageObjectsLogin(driver);
		objLogin.strUsername.sendKeys(Utilities.getDataFromConfig("USERNAME"));
		objLogin.strPassword.sendKeys(Utilities.getDataFromConfig("PASSWORD"));
		objLogin.btnLogin.click();
		fetchAccountDetails();
		validateDebitRecord(Utilities.getDataFromExcel("ACCOUNTNUMBER", "TestData"), Utilities.getDataFromExcel("DESCRIPTION", "TestData"), Utilities.getDataFromExcel("AMOUNT2", "TestData"));
		signOff();
		Assert.assertEquals(driver.getTitle(), Utilities.getDataFromExcel("PAGETITLELOGOFF", "TestData"));
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
	
	public void clickLink(){
		objAccSummary = new PageObjectsAccountSummary(driver);
		objAccSummary.linkAccntSummary.click();
    }
    
    public void fetchAccountDetails(){
    	objAccSummary = new PageObjectsAccountSummary(driver);
    	Select oAccnt=new Select(objAccSummary.listAccount);
    	oAccnt.selectByIndex(1);
    	objAccSummary.btnGo.click();
    }
    
    public void signOff(){
    	objAccSummary = new PageObjectsAccountSummary(driver);
    	objAccSummary.btnSignoff.click();
    }
    public void validateDebitRecord(String accountNumber,String description,String amount){
    	
    	objAccSummary = new PageObjectsAccountSummary(driver);
    	String strNumber=objAccSummary.debitRecordAccount.getText();
    	String strDesc=objAccSummary.debitRecordDesc.getText();
    	String strAmount = objAccSummary.debitRecordAmount.getText();
    	if ((strNumber.compareTo(accountNumber)==0) && (strDesc.compareTo(description)==0) && (strAmount.compareTo(amount)==0)){
    		
    		System.out.println("Correct entry is displayed on the account information screen");
    		
    	}
    	else{
    		
    		System.out.println("Inorrect entry is displayed on the account information screen");
    		
    	}
    	
    }
    
}
