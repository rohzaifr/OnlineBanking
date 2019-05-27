package TestCases;

import PageObjects.SearchFlightPageObjects;
import PageObjects.SelectFlightPageObjects;

import org.testng.Assert;

import PageObjects.BookFlightPageObjects;
import PageObjects.LoginPageObjects;
import Utilities.BaseClass;
import Utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookFlightTest {

	//Create object of base class to invoke driver
	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	SearchFlightPageObjects objSearch = new SearchFlightPageObjects(base.driver);
	SelectFlightPageObjects objSelect = new SelectFlightPageObjects(base.driver);
	BookFlightPageObjects objBook = new BookFlightPageObjects(base.driver);
	
	//Launch application
	@Given("^a global webdriver is used for test$")
	public void a_global_webdriver_is_used_for_test() throws Throwable {
	    
		System.out.println("BOOK FLIGHT TEST CASE EXECUTION");
		base.setupApplication();
		
	}

	//-----------------------------------------SCENARIO 1----------------------------------------------------
	@Given("^User is on the book flight page$")
	public void user_is_on_the_book_flight_page() throws Throwable {
	    
		System.out.println("Scenario: Book Flight");
		
	}

	//Login to the application
	@When("^User successfully login to application$")
	public void user_successfully_login_to_application() throws Throwable {
	    
		objLoginPage.loginApplication(Utilities.getDataFromConfig("username"), Utilities.getDataFromConfig("password"));
		
	}

	//Search flight details and select the relevant flight
	@When("^User select flight details$")
	public void user_select_flight_details() throws Throwable {
	    
		objSearch.searchFlight();
		objBook.selectFlight();
		Assert.assertEquals(base.driver.getTitle(), Utilities.getDataFromConfig("BookFlightPageTitle"));
		
	}

	//Book a flight
	@Then("^Flight booked successfully$")
	public void flight_booked_successfully() throws Throwable {
	    
		objBook.bookFlight();
		base.closeApplication();
		
	}
	
}
