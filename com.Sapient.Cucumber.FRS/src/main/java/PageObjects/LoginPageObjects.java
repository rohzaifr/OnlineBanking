package PageObjects;

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
	
	//username object
	@FindBy(how=How.NAME, using="userName")
	public WebElement userName;
	
	//password object
	@FindBy(how=How.NAME, using="password")
	public WebElement password;
	
	//login button object
	@FindBy(how=How.NAME, using="login")
	public WebElement loginbutton;
	
	//sign-off link object
	@FindBy(how=How.LINK_TEXT, using="SIGN-OFF")
	public WebElement signin;
	
	//date string object
	@FindBy(how=How.XPATH, using="//form[@name='home']//tbody//b")
	public WebElement date;
	
	//Featured image object
	@FindBy(how=How.XPATH, using="//img[@src='/images/featured_destination.gif']")
	public WebElement featuredImg;
	
	//incorrect login section object
	@FindBy(how=How.XPATH, using="//a[contains(text(),'form')]")
	public WebElement loginSection;
		
	//Login flight reservation application
	public void loginApplication(String strUser, String strPwd){
		
		userName.sendKeys(strUser);
		password.sendKeys(strPwd);
		loginbutton.click();
		
	}
	
	//Verify that image of Aruba is displayed under featured destination
	public boolean FeaturedImageDisplayed(){
    	
    	if (featuredImg.isDisplayed()){
    		
    		return true;
    		
    	}
    	else 
    	{
    		
    		return false;
    		
    	}
    	
    }
	
	
	//Verify that when user enters incorrect username and password then following section should be displayed
	public void validateTextOnIncorrectLogin(String expectedText){
    	
    	String actualText = loginSection.getText();
    	if (actualText.compareTo(expectedText)==0 ){
    		
    		System.out.println("Invalid username and password");
    		
    	}
    	else
    	{
    		
    		System.out.println("User is able to login with invalid credentials. There might be some issue with the application");
    		
    	}
    	
    }
	
}
