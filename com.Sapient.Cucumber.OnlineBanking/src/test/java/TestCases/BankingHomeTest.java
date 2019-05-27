package TestCases;

import org.junit.Assert;
import PageObjects.BankingHomePageObjects;
import PageObjects.LoginPageObjects;
import Utilities.BaseClass;
import Utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankingHomeTest {

	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	BankingHomePageObjects objBankingPage = new BankingHomePageObjects(base.driver);
	String strAccountDetail = null;
	
	@Given("^a driver is used for test$")
	public void a_driver_is_used_for_test() throws Throwable {
	    
		base.setupApplication();
		
	}
	
	@Given("^User is on the account information page$")
	public void user_is_on_the_account_information_page() throws Throwable {
	    
		System.out.println("Scenario: Verify Account Information Page");
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		
	}

	@When("^User click on go button$")
	public void user_click_on_go_button() throws Throwable {
	    
		objBankingPage.btnGo.click();
		
	}

	@Then("^Account information page displayed successfully$")
	public void account_information_page_displayed_successfully() throws Throwable {
	   
		Assert.assertTrue(objBankingPage.strCredit.isDisplayed());
		base.closeApplication();
		
	}
	
	@Given("^User is on the account information page of user$")
	public void user_is_on_the_account_information_page_of_user() throws Throwable {
	    
		System.out.println("Scenario: Verify that account number displayed in heading Account History is same as bank account selected");
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		
	}

	@When("^Note account number and user click on go$")
	public void note_account_number_and_user_click_on_go() throws Throwable {
	    
		strAccountDetail = objBankingPage.getAccountDetail();
		objBankingPage.btnGo.click();
		
	}

	@Then("^Account number displayed in heading Account History is same as bank account selected$")
	public void account_number_displayed_in_heading_Account_History_is_same_as_bank_account_selected() throws Throwable {
	    
		Assert.assertEquals(strAccountDetail, objBankingPage.accountID.getText());
		base.closeApplication();
		
	}
	
	@Given("^User is on the account detail page$")
	public void user_is_on_the_account_detail_page() throws Throwable {
	    
		System.out.println("Scenario: Verify that current date is displayed in Balance Detail table");
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		
	}

	@When("^User click on go button on account information page$")
	public void user_click_on_go_button_on_account_information_page() throws Throwable {
		
		objBankingPage.btnGo.click();
		
	}

	@Then("^Verify that current date is displayed in Balance Detail table$")
	public void verify_that_current_date_is_displayed_in_Balance_Detail_table() throws Throwable {
	    
		objBankingPage.verifyDatefromString();
		base.closeApplication();
		
	}
	
}
