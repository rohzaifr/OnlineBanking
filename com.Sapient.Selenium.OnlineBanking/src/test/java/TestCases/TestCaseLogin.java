package TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import PageObjects.PageObjectsLogin;
import Utilities.Utilities;

public class TestCaseLogin {

	WebDriver driver;
	PageObjectsLogin objLogin;
	
	@BeforeMethod
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Utilities.getDataFromConfig("URL"));
		
	}
	
	@Test(priority = 0)
	public void verifyLogo() throws IOException{
		
		//Check if application logged in successfully
		if(logoImageDisplayed()){
			
			System.out.println("AltoroMutual logo image is displaying on the Login page.");
			
		}else{
			
			System.out.println("AltoroMutual logo image is not displaying on the Login page.");
			
		}
		
	}
	
	@Test(priority = 1)
	public void verifyTabs() throws IOException{
		
		//Check if application logged in successfully
		checkTabsPresent();
		
	}
	
	@Test(priority = 2)
	public void checkIncorrectLogin() throws IOException{
		
		//Check if application logged in successfully
		loginApplication("incorrectUser", "incorrectPassword");
		validateTextOnIncorrectLogin(Utilities.getDataFromExcel("INCORRECTMESSAGE", "TestData"));
		
	}
	
	@Test(priority = 3)
	public void checkCorrectLogin() throws IOException{
		
		//Check if application logged in successfully
		objLogin = new PageObjectsLogin(driver);
		String strUsername, strPassword;
		strUsername = Utilities.getDataFromConfig("USERNAME");
		strPassword = Utilities.getDataFromConfig("PASSWORD");
		loginApplication(strUsername, strPassword);
		try{
			
			if(objLogin.btnSignOff.isDisplayed()){
				
				Assert.assertEquals(driver.getTitle(),Utilities.getDataFromExcel("LOGINPAGETITLE", "TestData"));
				System.out.println("User is able to login successfully");
			}
			
		}catch(AssertionError e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
	
	public void launchApplication(String strUrl){
		
		driver.get(strUrl);
		
	}
	
	public void loginApplication(String strUser, String strPwd){
		
		objLogin = new PageObjectsLogin(driver);
		objLogin.strUsername.sendKeys(strUser);
		objLogin.strPassword.sendKeys(strPwd);
		objLogin.btnLogin.click();
		
	}
	
    public boolean verifyTabsPresent(WebElement element){
    	
    	if (element.isDisplayed()) {
    		
    		return true;
    		
    	}
    	else{
    		
    		return false;
    		
    	}
    	
    }
    
    public void checkTabsPresent(){
    	
    	objLogin = new PageObjectsLogin(driver);
    	System.out.println("Tab : Online Banking Login -  Present : "+verifyTabsPresent(objLogin.tabOnlineBanking));
    	System.out.println("Tab : Personal -  Present : "+verifyTabsPresent(objLogin.tabPersonal));
    	System.out.println("Tab : Small Business -  Present : "+verifyTabsPresent(objLogin.tabSmallBusiness));
    	System.out.println("Tab : Inside Altoro Mutual -  Present : "+verifyTabsPresent(objLogin.tabInsideAltoroMutual));
    	
    }
    
    public boolean logoImageDisplayed(){
    	
    	objLogin = new PageObjectsLogin(driver);
    	if (objLogin.imgSrc.isDisplayed()){
    		
    		return true;
    		
    	}
    	else 
    	{
    		
    		return false;
    		
    	}
    	
    }
    
    public void validateTextOnIncorrectLogin(String expectedText){
    	
    	objLogin = new PageObjectsLogin(driver);
    	String actualText = objLogin.txtIncorrectDetails.getText();
    	if (actualText.compareTo(expectedText)==0 ){
    		
    		System.out.println("Correct message is displayed when incorrect details are entered on the login page");
    		
    	}
    	else
    	{
    		
    		System.out.println("Incorrect message is displayed when incorrect details are entered on the login page");
    		
    	}
    	
    }
	
}
