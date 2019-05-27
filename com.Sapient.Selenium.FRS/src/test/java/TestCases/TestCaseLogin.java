package TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.annotations.*;
import PageObjects.PageObjectsLogin;
import Utilities.BaseClass;
import Utilities.Utilities;

public class TestCaseLogin{

	BaseClass base = new BaseClass(true);
	PageObjectsLogin objLogin = new PageObjectsLogin(base.driver);
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		base.setupApplication();
		
	}
	
	
	@Test(priority = 0)
	public void DateCheck(){
		
		//Verify if date displayed on application matches with system date
		String date = objLogin.date.getText();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDt = dtf.format(now);
		try{
			Assert.assertEquals(date, systemDt,"Application and System dates are not matching.");
		}catch(AssertionError e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test(priority = 1)
	public void verifyFeaturedImage(){
		
		//Verify if featured image is displayed on sign-in page
		if(objLogin.FeaturedImageDisplayed()){
			
			System.out.println("Featured image is displaying on the Login page.");
			
		}else{
			
			System.out.println("Featured image is not displaying on the Login page.");
			
		}
		
	}

	@Test(priority = 2)
	public void LoginSection() throws IOException{
		
		//Fetch username and password from config file and enter into application
		objLogin.loginApplication(Utilities.getDataFromConfig("WRONGUSER1"), Utilities.getDataFromConfig("WRONGPASS1"));
		
		//Check if login section is displayed
		objLogin.validateTextOnIncorrectLogin(Utilities.getDataFromExcel("expectedtext", "TestData"));
		
	}
	
	@Test(priority = 3)
	public void checkIncorrectLogin1() throws IOException{
		
		//Check if application logged in successfully
		objLogin.loginApplication(Utilities.getDataFromConfig("WRONGUSER1"), Utilities.getDataFromConfig("WRONGPASS1"));
		
		//Check for valid user credentials
		if(objLogin.loginSection.isDisplayed()){
			
			System.out.println("Invalid username:"+Utilities.getDataFromConfig("WRONGUSER1")+" and password:"+Utilities.getDataFromConfig("WRONGPASS1"));
			
		}else{
			
			System.out.println("Valid username and password");
			
		}
		
	}
	
	@Test(priority = 4)
	public void checkIncorrectLogin2() throws IOException{
		
		//Check if application logged in successfully
		objLogin.loginApplication(Utilities.getDataFromConfig("WRONGUSER2"), Utilities.getDataFromConfig("WRONGPASS2"));
		
		//Check for valid user credentials
		if(objLogin.loginSection.isDisplayed()){
			
			System.out.println("Invalid username:"+Utilities.getDataFromConfig("WRONGUSER2")+" and password:"+Utilities.getDataFromConfig("WRONGPASS2"));
			
		}else{
			
			System.out.println("Valid username and password");
			
		}
		
	}
	
	@Test(priority = 5)
	public void checkCorrectLogin() throws IOException{
		
		//Check if application logged in successfully
		objLogin.loginApplication(Utilities.getDataFromConfig("USERNAME"), Utilities.getDataFromConfig("PASSWORD"));
		
		//Check for valid user credentials
		try{
			
			if(objLogin.signin.isDisplayed()){
				
				Assert.assertEquals(base.driver.getTitle(),Utilities.getDataFromExcel("LOGINPAGETITLE", "TestData"));
				System.out.println("User is able to login successfully");
				
			}
			
		}catch(AssertionError e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	@AfterTest
	public void quitDriver(){

		base.closeApplication();
		
	}
	
}
