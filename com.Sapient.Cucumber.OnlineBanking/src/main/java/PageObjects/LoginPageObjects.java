package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;
	
	//Class constructor
	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_HyperLink1")
	public WebElement imgSrc;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_AccountLink")
	public WebElement linkLogin;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader2")
	public WebElement linkPersonal;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader3")
	public WebElement linkBusiness;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_LinkHeader4")
	public WebElement linkInside;
	
	@FindBy(how=How.ID, using="uid")
	public WebElement strUsername;
	
	@FindBy(how=How.ID, using="passw")
	public WebElement strPassword;
	
	@FindBy(how=How.NAME, using="btnSubmit")
	public WebElement btnLogin;
	
	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Congratulations!')]")
	public WebElement validLoginMsg;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_Content_Main_message")
	public WebElement invalidLoginMsg;
	
	@FindBy(how=How.ID, using="_ctl0__ctl0_LoginLink")
	public WebElement btnSignOff;
	
	@FindBy(how=How.XPATH, using="//b[contains(text(),'Privacy and Security')]")
	public WebElement signOffMsg;
	
	public boolean verifyLogo(){

		boolean logo = false;
		logo = imgSrc.isDisplayed();
		return logo;
		
	}
	
	public void loginApp(String strUser, String strPass) throws IOException{
		
		strUsername.sendKeys(strUser);
		strPassword.sendKeys(strPass);
		btnLogin.click();
		
	}
	
}
