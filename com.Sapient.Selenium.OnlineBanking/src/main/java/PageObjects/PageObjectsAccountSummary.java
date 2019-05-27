package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjectsAccountSummary {

	WebDriver driver;
	
	//Class constructor
	public PageObjectsAccountSummary(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_MenuHyperLink1")
	public WebElement linkAccntSummary;
    
    @FindBy(how=How.ID, using="listAccounts")
    public WebElement listAccount;
    
    @FindBy(how=How.ID, using="btnGetAccount")
    public WebElement btnGo;
    
    @FindBy(how=How.XPATH, using="(.//*[@id='credits']/table/tbody/tr[1])[2]/td[1]")
    public WebElement debitRecordAccount;
    
    @FindBy(how=How.XPATH, using="(.//*[@id='credits']/table/tbody/tr[1])[2]/td[3]")
    public WebElement debitRecordDesc;
    
    @FindBy(how=How.XPATH, using="(.//*[@id='credits']/table/tbody/tr[1])[2]/td[4]")
    public WebElement debitRecordAmount;
    
    @FindBy(how=How.ID, using="_ctl0__ctl0_LoginLink")
    public WebElement btnSignoff;
	
}
