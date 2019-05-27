package TestCases;

import PageObjects.SearchFlightPageObjects;
import PageObjects.LoginPageObjects;
import Utilities.BaseClass;
import Utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFlightTest {

	//Create object of base class to invoke driver
	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	SearchFlightPageObjects objSearch = new SearchFlightPageObjects(base.driver);
	boolean blnSearch = false;
	
	//Launch application
	@Given("^a driver is used for test$")
	public void a_driver_is_used_for_test() throws Throwable {
	    
		System.out.println("SEARCH FLIGHT TEST CASE EXECUTION");
		base.setupApplication();
		
	}

	//-----------------------------------------SCENARIO 1----------------------------------------------------
	@Given("^User is on the search flight page$")
	public void user_is_on_the_search_flight_page() throws Throwable {
	    
		System.out.println("Scenario: Search a Flight");
		
	}

	//Login to the application
	@When("^User login to application$")
	public void user_login_to_application() throws Throwable {
	    
		objLoginPage.loginApplication(Utilities.getDataFromConfig("username"), Utilities.getDataFromConfig("password"));
		
	}
	
	//Enter details and search for valid flight
	@When("^User provide valid creteria$")
	public void user_provide_valid_creteria() throws Throwable {
	    
		objSearch.searchFlight();
		
	}

	//Verify if relevant flight details are displayed
	@Then("^Flight details displayed$")
	public void flight_details_displayed() throws Throwable {
	    
		blnSearch = objSearch.flightdetail.isDisplayed();
		if(blnSearch){
			
			System.out.println("Flight details searched successfully");
			
		}else{
			
			System.out.println("Flight details search criteria is incorrect");
			
		}
		base.closeApplication();
	}
	
}
