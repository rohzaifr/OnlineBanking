package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsBankingHome {

	WebDriver driver;
	
	//Class constructor
	public PageObjectsBankingHome(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="listAccounts")
	public WebElement accountDetails;
	
	@FindBy(how=How.ID, using="btnGetAccount")
	public WebElement btnGo;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_Main_accountid")
	public WebElement txtAccountNumber;
	
	@FindBy(how=How.XPATH, using=".//*[@id='wrapper']/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[3]/td[1]")
	public WebElement date;
	
}
