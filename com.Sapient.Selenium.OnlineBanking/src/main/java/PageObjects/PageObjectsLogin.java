package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsLogin {

	WebDriver driver;
	
	//Class constructor
	public PageObjectsLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_HyperLink1")
	public WebElement imgSrc;
	
	@FindBy(how=How.ID, using="uid")
	public WebElement strUsername;
	
	@FindBy(how=How.ID, using="passw")
	public WebElement strPassword;
	
	@FindBy(how=How.NAME, using="btnSubmit")
	public WebElement btnLogin;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_AccountLink")
	public WebElement tabOnlineBanking;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader2")
	public WebElement tabPersonal;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader3")
	public WebElement tabSmallBusiness;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader4")
	public WebElement tabInsideAltoroMutual;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_Main_message")
	public WebElement txtIncorrectDetails;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_LoginLink")
	public WebElement btnSignOff;
	
}
