package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPageObjects {

	WebDriver driver;
	
	//Class constructor
	public TransferFundsPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_MenuHyperLink3")
	public WebElement linkTransferFunds;
	
	@FindBy(how=How.ID, using="debitAccount")
	public WebElement debitAccount;
	
	@FindBy(how=How.ID, using="creditAccount")
	public WebElement creditAccount;
	
	@FindBy(how=How.ID, using="transferAmount")
	public WebElement txtAmount;
	
	@FindBy(how=How.NAME, using="transfer")
	public WebElement btnTransfer;
	
	@FindBy(how=How.XPATH, using="//h1[contains(text(),'Transfer Funds')]")
	public WebElement strTransferPage;
	
	@FindBy(how=How.XPATH, using=".//*[@id='soapResp']/span")
	public WebElement successTransferMsg;
	
	public void enterAccDetail(WebElement element, int index){
		
		Select objSelect = new Select(element);
		objSelect.selectByIndex(index);
		
	}
	
	public String getAccountNumber(WebElement element){
		
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		String strAccDetail = defaultItem.split(" ")[0];
		return strAccDetail;
		
	}
		
}
