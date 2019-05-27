package TestCases;

import org.testng.Assert;
import PageObjects.BankingHomePageObjects;
import PageObjects.LoginPageObjects;
import PageObjects.TransferFundsPageObjects;
import Utilities.BaseClass;
import Utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TransferFundsTest {

	BaseClass base = new BaseClass(true);
	LoginPageObjects objLoginPage = new LoginPageObjects(base.driver);
	BankingHomePageObjects objBankingPage = new BankingHomePageObjects(base.driver);
	TransferFundsPageObjects objTransferFunds = new TransferFundsPageObjects(base.driver);
	String strCreditAcc, strDebitAcc = null;
	
	@Given("^a webdriver is used for test$")
	public void a_webdriver_is_used_for_test() throws Throwable {
	    
		base.setupApplication();
		
	}

	@Given("^User is on the transfer funds page$")
	public void user_is_on_the_transfer_funds_page() throws Throwable {
	    
		System.out.println("Scenario: Verify Transfer Funds Page");
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		
	}

	@When("^User click on transfer funds link$")
	public void user_click_on_transfer_funds_link() throws Throwable {
	    
		objTransferFunds.linkTransferFunds.click();
		
	}

	@Then("^Transfer Funds page displayed successfully$")
	public void transfer_Funds_page_displayed_successfully() throws Throwable {
	    
		Assert.assertTrue(objTransferFunds.strTransferPage.isDisplayed());
		base.closeApplication();
		
	}
	
	@Given("^User is on the fund transfer page$")
	public void user_is_on_the_fund_transfer_page() throws Throwable {
	    
		System.out.println("Scenario: Verify funds transfer initiated");
		objLoginPage.linkLogin.click();
		objLoginPage.loginApp(Utilities.getDataFromConfig("username"),Utilities.getDataFromConfig("password"));
		objTransferFunds.linkTransferFunds.click();
		
	}

	@When("^User enter from and to account$")
	public void user_enter_from_and_to_account() throws Throwable {
	    
		objTransferFunds.enterAccDetail(objTransferFunds.debitAccount, 0);
		strDebitAcc = objTransferFunds.getAccountNumber(objTransferFunds.debitAccount);
		objTransferFunds.enterAccDetail(objTransferFunds.creditAccount, 1);
		strCreditAcc = objTransferFunds.getAccountNumber(objTransferFunds.creditAccount);
		
	}

	@When("^user enter amount and click on transfer money button$")
	public void user_enter_amount_and_click_on_transfer_money_button() throws Throwable {
	    
		objTransferFunds.txtAmount.sendKeys(Utilities.getDataFromConfig("amount"));
		objTransferFunds.btnTransfer.click();
		
	}

	@Then("^Funds transfer message displayed successfully$")
	public void funds_transfer_message_displayed_successfully() throws Throwable {
	    
		Utilities.explicitWait(base.driver, objTransferFunds.successTransferMsg);
		String successMsg = objTransferFunds.successTransferMsg.getText();
		if(successMsg.contains(Utilities.getDataFromConfig("amount")) && successMsg.contains(strDebitAcc) && successMsg.contains(strCreditAcc)){
			
			System.out.println("Message is displayed with correct amount: "+Utilities.getDataFromConfig("amount")+" and from account: "+strDebitAcc+" and to account: "+strCreditAcc+" details");
			
		}else{
			
			System.out.println("There is some issue while transferring funds");
			
		}
		base.closeApplication();
	}
	
}
