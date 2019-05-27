package TestCases;

import PageObjects.SearchFlightPageObjects;
import org.testng.Assert;
import PageObjects.LoginPageObjects;
import PageObjects.SelectFlightPageObjects;
import Utilities.BaseClass;
import Utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectFlightTest {

	//Create object of base class to invoke driver
	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	SearchFlightPageObjects objSearch = new SearchFlightPageObjects(base.driver);
	SelectFlightPageObjects objSelect = new SelectFlightPageObjects(base.driver);
	
	//Launch application
	@Given("^a webdriver is used for test$")
	public void a_webdriver_is_used_for_test() throws Throwable {
	    
		System.out.println("SELECT FLIGHT TEST CASE EXECUTION");
		base.setupApplication();
		
	}
	
	//-----------------------------------------SCENARIO 1----------------------------------------------------
	@Given("^User is on the select flight page$")
	public void user_is_on_the_select_flight_page() throws Throwable {
	    
		System.out.println("Scenario: Check sorting");
		
	}

	//Login to the application
	@When("^User login to application with credentials$")
	public void user_login_to_application_with_credentials() throws Throwable {
	    
		objLoginPage.loginApplication(Utilities.getDataFromConfig("username"), Utilities.getDataFromConfig("password"));
		
	}

	//Search for relevant flights
	@When("^User search for flights$")
	public void user_search_for_flights() throws Throwable {
	    
		objSearch.searchFlight();
		
	}

	//Verify if price of flights is sorted
	@Then("^Flight details are sorted based on price$")
	public void flight_details_are_sorted_based_on_price() throws Throwable {
	    
		objSelect.checkSorting();
		base.closeApplication();
		
	}

	//-----------------------------------------SCENARIO 2----------------------------------------------------
	@Then("^Select flight details and click continue button$")
	public void select_flight_details_and_click_continue_button() throws Throwable {
	    
		objSelect.selectFlight();
		Assert.assertTrue(objSelect.summary.isDisplayed(),"Book a Flight page is not displayed");
		base.closeApplication();
		
	}
	
}
