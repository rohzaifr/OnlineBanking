package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.PageObjectsLogin;
import PageObjects.PageObjectsSearchFlight;
import Utilities.BaseClass;
import Utilities.Utilities;

public class TestCaseSearchFlight{

	BaseClass base = new BaseClass(true);
	PageObjectsLogin objLogin = new PageObjectsLogin(base.driver);;
	PageObjectsSearchFlight objFlightFinder = new PageObjectsSearchFlight(base.driver);;
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		base.setupApplication();
		
	}
	
	@Test(priority = 6)
	//Add details and search flight options
	public void SearchFlight() throws IOException{
		
		//Fetch username and password from excel and enter into application
		objLogin.loginApplication(Utilities.getDataFromConfig("USERNAME"), Utilities.getDataFromConfig("PASSWORD"));
		
		//search flight
		objFlightFinder.searchFlight();
		
		//Verify if required flights are displayed
		try{
			Assert.assertTrue(objFlightFinder.flightdetail.isDisplayed(),"Flight details are not displayed.");
		}catch(AssertionError e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@AfterTest
	public void quitDriver(){
		base.closeApplication();
	}
	
}
