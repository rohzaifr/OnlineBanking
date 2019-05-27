package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.PageObjectsBookFlight;
import PageObjects.PageObjectsLogin;
import PageObjects.PageObjectsSearchFlight;
import PageObjects.PageObjectsSelectFlight;
import Utilities.BaseClass;
import Utilities.Utilities;

public class TestCaseBookFlight{

	BaseClass base = new BaseClass(true);
	PageObjectsLogin objLogin = new PageObjectsLogin(base.driver);;
	PageObjectsBookFlight objBookFlight = new PageObjectsBookFlight(base.driver);
	PageObjectsSearchFlight objFlightFinder = new PageObjectsSearchFlight(base.driver);
	PageObjectsSelectFlight objSelectFlight = new PageObjectsSelectFlight(base.driver);
	String departflight, returnflight;
	String[] depFlightDetails, arrFlightDetails;
	boolean blnDepFlight, blnArrFlight, blnDepPrice, blnArrPrice;
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		base.setupApplication();
		
	}
	
	@Test(priority=9)
	//Verify flight details
	public void BookFlights() throws Exception{
		
		//login application and search flight
		objLogin.loginApplication(Utilities.getDataFromConfig("USERNAME"), Utilities.getDataFromConfig("PASSWORD"));
		objFlightFinder.searchFlight();
		
		//select flight
		objBookFlight.selectFlight();
		
		//book a flight
		Assert.assertEquals(base.driver.getTitle(), Utilities.getDataFromExcel("BookFlightPageTitle", "TestData"));
		objBookFlight.bookFlight();
		
	}
	
	@AfterTest
	public void quitDriver(){
		base.closeApplication();
	}
	
}
