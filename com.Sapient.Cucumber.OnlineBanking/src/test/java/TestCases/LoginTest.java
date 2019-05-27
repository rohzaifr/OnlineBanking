package TestCases;

import org.junit.Assert;
import PageObjects.LoginPageObjects;
import Utilities.*;
import cucumber.api.java.en.*;

public class LoginTest {

	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	
	@Given("^a global driver is used for test$")
	public void a_global_driver_is_used_for_test() throws Throwable {
	    
		base.setupApplication();
		
	}
	
	@Given("^User is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable {
		
		System.out.println("Scenario: Logo verification");
		objLoginPage.linkLogin.click();
	    
	}

	@When("^User navigate to application login page$")
	public void user_navigate_to_application_login_page() throws Throwable {

		String strTitle = base.driver.getTitle();
		if(strTitle.equals("Altoro Mutual: Online Banking Login"))
		{
			
			System.out.println("User is on the Login page");
			
		}else{
			
			System.out.println("There is some issue while opening up the login page");
			
		}
	    
	}

	@Then("^Logo displayed successfully$")
	public void logo_displayed_successfully() throws Throwable {
	    
		if(objLoginPage.verifyLogo()){
			
			System.out.println("Logo is displaying successfully on the application");
			
		}else{
			
			System.out.println("Logo is not displaying on the application");
			
		}
		base.closeApplication();
	    
	}
	
	@Given("^User is on application home page$")
	public void user_is_on_application_home_page() throws Throwable {
	    
		System.out.println("Scenario: Login with invalid credentials");

	}

	@When("^User Navigate to application home page$")
	public void user_Navigate_to_application_home_page() throws Throwable {
	    
		objLoginPage.linkLogin.click();
		
	}

	@When("^User enters invalid Username and Password$")
	public void user_enters_invalid_Username_and_Password() throws Throwable {
	   
		objLoginPage.loginApp(Utilities.getDataFromConfig("incorrectusername"),Utilities.getDataFromConfig("incorrectpassword"));
		
	}

	@Then("^Invalid attempt message displayed successfully$")
	public void invalid_attempt_message_displayed_successfully() throws Throwable {
	    
		Assert.assertTrue(objLoginPage.invalidLoginMsg.isDisplayed());
		base.closeApplication();
		
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    
		System.out.println("Scenario: Successful Login with valid credentials");
	    
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() throws Throwable {
	    
		objLoginPage.linkLogin.click();
		
	}

	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable {
	    
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
	    
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    
		Assert.assertTrue(objLoginPage.validLoginMsg.isDisplayed());
		base.closeApplication();
	    
	}
	
	@Given("^User is on application Page$")
	public void user_is_on_application_Page() throws Throwable {
		
		System.out.println("Verify that tabs are displayed at the top");
		
	}

	@When("^User Navigate to application main Page$")
	public void user_Navigate_to_application_main_Page() throws Throwable {
	    
		objLoginPage.linkLogin.click();
		
	}

	@Then("^Tabs displayed Successfully$")
	public void tabs_displayed_Successfully() throws Throwable {
	    
		Assert.assertTrue(objLoginPage.linkLogin.isDisplayed() && objLoginPage.linkPersonal.isDisplayed() && objLoginPage.linkBusiness.isDisplayed() && objLoginPage.linkInside.isDisplayed());
		base.closeApplication();
		
	}
	
	@Given("^User is on main Page$")
	public void user_is_on_main_Page() throws Throwable {
	    
		System.out.println("Scenario: Successful Logout");
		
	}

	@When("^User click on signoff button$")
	public void user_click_on_signoff_button() throws Throwable {
	    
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		objLoginPage.btnSignOff.click();
		
	}

	@Then("^User logout Successfully$")
	public void user_logout_Successfully() throws Throwable {
	    
		if(objLoginPage.signOffMsg.isDisplayed()){
			
			System.out.println("Application logout successfully");
			
		}else{
			
			System.out.println("There is some issue with the application");
			
		}
		base.closeApplication();
		
	}
	
}
