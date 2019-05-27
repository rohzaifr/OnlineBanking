package TestCases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import PageObjects.PageObjectsBankingHome;
import PageObjects.PageObjectsLogin;
import Utilities.Utilities;

public class TestCaseBankingHome {

	WebDriver driver;
	PageObjectsBankingHome objBnkHome;
	PageObjectsLogin objLogin;
	
	@BeforeMethod
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Utilities.getDataFromConfig("URL"));
		
	}
	
	@Test(priority = 4)
	public void verifyBankingDetails() throws IOException{
		
		//Check if application logged in successfully
		objLogin = new PageObjectsLogin(driver);
		objLogin.strUsername.sendKeys(Utilities.getDataFromConfig("USERNAME"));
		objLogin.strPassword.sendKeys(Utilities.getDataFromConfig("PASSWORD"));
		objLogin.btnLogin.click();
		String strAccDetail = Utilities.getDataFromExcel("ACCOUNTDETAILS", "TestData");
		String strAccNo = strAccDetail.split(" ")[0];
		selectAccount(strAccDetail);
		fetchAccountDetails();
		verifyAccountDetails("Account History - "+strAccNo);
		verifyDate();
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
	
	public void selectAccount(String accountName){
    	
		objBnkHome = new PageObjectsBankingHome(driver);
		Select oSelAccnt = new Select(objBnkHome.accountDetails);
		oSelAccnt.selectByIndex(1);

	}

	public void fetchAccountDetails(){
		
		objBnkHome = new PageObjectsBankingHome(driver);
		objBnkHome.btnGo.click();
		if(objBnkHome.txtAccountNumber.isDisplayed()){
			
			System.out.println("Account Information page is displayed successfully");
			
		}else{
			
			System.out.println("Account Information page is not displayed");
			
		}
		
	}
	
	public void verifyAccountDetails(String expectedAccountHeader){
		
		objBnkHome = new PageObjectsBankingHome(driver);
		String strActualNo = objBnkHome.txtAccountNumber.getText();
		String strAccHeader = "Account History - "+strActualNo;
		if(strAccHeader.compareTo(expectedAccountHeader)==0){
			
			System.out.println("Account header details are correct on the page");
			
		}else{
		
			System.out.println("Account header details are incorrect on the page");
		
		}
		
	}
	
	public void verifyDate() throws IOException{
		
		objBnkHome = new PageObjectsBankingHome(driver);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String strSystemDt = dtf.format(now);
		String strActDateMessage = objBnkHome.date.getText();
		if(strActDateMessage.contains(strSystemDt)){
			
			System.out.println("Current date is displayed in Balance Detail table");
			
		}else{
			
			System.out.println("Current date is not displayed in Balance Detail table");
			
		}
		
	}
	
}
