package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsTransferFunds {

	WebDriver driver;
	
	//Class constructor
	public PageObjectsTransferFunds(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_MenuHyperLink3")
	public WebElement linkTransferFunds;
    
    @FindBy(how=How.ID, using="debitAccount")
    public WebElement fromAccount;
    
    @FindBy(how=How.ID, using="creditAccount")
    public WebElement toAccount;
    
    @FindBy(how=How.ID, using="transferAmount")
    public WebElement tranferAmount;
    
    @FindBy(how=How.ID, using="transfer")
    public WebElement btnTranfer;
    
    @FindBy(how=How.XPATH, using=".//*[@id='soapResp']/span")
    public WebElement transferMessage;
	
}
