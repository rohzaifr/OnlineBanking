package TestCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import PageObjects.LoginPageObjects;
import Utilities.*;
import cucumber.api.java.en.*;

public class LoginTest {

	//Creating base class object to invoke driver
	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	String date, systemDt = null;
	boolean blnImage = false;
	
	//Launch application
	@Given("^a global driver is used for test$")
	public void a_global_driver_is_used_for_test() throws Throwable {
	    
		System.out.println("LOGIN TEST CASE EXECUTION");
		base.setupApplication();
		
	}
	
	//-----------------------------------------SCENARIO 1----------------------------------------------------
	@Given("^User is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable {
	    
		System.out.println("Scenario: Date Check");
		
	}
	
	//Get date from the application and current system date
	@When("^User navigate to application login page$")
	public void user_navigate_to_application_login_page() throws Throwable {
	    
		date = objLoginPage.date.getText();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		systemDt = dtf.format(now);
		
	}
	
	//Verify if both dates are matching
	@Then("^Valid date displayed successfully$")
	public void valid_date_displayed_successfully() throws Throwable {
	    
		Assert.assertEquals(date, systemDt,"Application and System dates are not matching.");
		base.closeApplication();
		
	}
	
	//-----------------------------------------SCENARIO 2----------------------------------------------------
	@Given("^User is on application home page$")
	public void user_is_on_application_home_page() throws Throwable {
	    
		System.out.println("Scenario: Featured Image");
		
	}

	@When("^User Navigate to application home page$")
	public void user_Navigate_to_application_home_page() throws Throwable {
	    
		blnImage = objLoginPage.FeaturedImageDisplayed();
		
	}
	
	//Verify if Featured Image is displayed on the application
	@Then("^Featured image displayed successfully$")
	public void featured_image_displayed_successfully() throws Throwable {
	    
		if(blnImage){
			
			System.out.println("Featured image is displaying on the Login page.");
			
		}else{
			
			System.out.println("Featured image is not displaying on the Login page.");
			
		}
		base.closeApplication();

	}
	
	//-----------------------------------------SCENARIO 3----------------------------------------------------
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    
		System.out.println("Scenario: Incorrect Login");
		
	}
	
	//Enter invalid username and password
	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable {
	    
		objLoginPage.loginApplication(Utilities.getDataFromConfig("incorrectusername"), Utilities.getDataFromConfig("incorrectpassword"));
		
	}

	//Verify that user is not able to login to the application
	@Then("^User unable to login$")
	public void user_unable_to_login() throws Throwable {
	    
		objLoginPage.validateTextOnIncorrectLogin(Utilities.getDataFromConfig("expectedtext"));
		base.closeApplication();
		
	}
	
	//-----------------------------------------SCENARIO 4----------------------------------------------------
	@Given("^User is on application Page$")
	public void user_is_on_application_Page() throws Throwable {
	    
		System.out.println("Scenario: Correct Login");
		
	}

	//Enter valid credentials
	@When("^User enters credentials$")
	public void user_enters_credentials() throws Throwable {
	    
		objLoginPage.loginApplication(Utilities.getDataFromConfig("username"), Utilities.getDataFromConfig("password"));
		
	}

	//User is able to login successfully in the application
	@Then("^User able to login successfully$")
	public void user_able_to_login_successfully() throws Throwable {
	    
		if(objLoginPage.signin.isDisplayed()){
			
			Assert.assertEquals(base.driver.getTitle(),Utilities.getDataFromConfig("loginpagetitle"));
			System.out.println("User is able to login successfully");
			
		}else{
			
			System.out.println("User is not able to login");
			
		}
		base.closeApplication();
		
	}
	
}
