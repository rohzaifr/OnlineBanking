package PageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BankingHomePageObjects {

	WebDriver driver;
	
	//Class constructor
	public BankingHomePageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="btnGetAccount")
	public WebElement btnGo;
	
	@FindBy(how=How.XPATH, using="//b[contains(text(),'Credits')]")
	public WebElement strCredit;
	
	@FindBy(how=How.ID, using="listAccounts")
	public WebElement accountDetails;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_Main_accountid")
	public WebElement accountID;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Ending balance as of')]")
	public WebElement strDate;
	
	public String getAccountDetail(){
		
		Select select = new Select(accountDetails);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		String strAccDetail = defaultItem.split(" ")[0];
		return strAccDetail;
		
	}
	
	public void verifyDatefromString(){
		
		String strDateText = strDate.getText();
		strDateText = strDateText.split(" ")[4];
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String strSystemDt = dtf.format(now);
		strDateText = dtf.format(now);
		Assert.assertEquals(strDateText, strSystemDt);
		
	}
	
}
