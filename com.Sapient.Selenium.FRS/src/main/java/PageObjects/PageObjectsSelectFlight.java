package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsSelectFlight {

	WebDriver driver;
	
	//Class constructor
	public PageObjectsSelectFlight(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//sorting list
	@FindBy(how=How.XPATH, using="//b[contains(text(),'$')]")
	public List<WebElement> elementList;
	
	@FindAll(value={@FindBy (xpath=".//input[@type='radio'][@name='outFlight']")})
	public List<WebElement> flightDepart;
	
	@FindAll(value={@FindBy (xpath=".//input[@type='radio'][@name='inFlight']")})
	public List<WebElement> flightReturn;
	
	@FindBy(how=How.XPATH, using=".//input[@name='reserveFlights']")
	public WebElement btnContinue;
	
	@FindBy(how=How.XPATH, using="//font[contains(text(),'Summary')]")
	public WebElement summary;
	
	//select departure flight
	public String selectDepartFlight(int flightOrder){		

		flightDepart.get(flightOrder).click();
		return flightDepart.get(flightOrder).getAttribute("value");
		
	}
	
	//select return flight
	public String selectReturnFlight(int flightOrder){		

		flightReturn.get(flightOrder).click();
		return flightReturn.get( flightOrder).getAttribute("value");
		
	}
	
	//Click on continue button
	public void clickContinue(){
		
		btnContinue.click();
		
	}
	
	//select flight
	public void selectFlight(){
		
		String departflight;
		String returnflight;
		
		//select departure and return flight
		departflight = selectDepartFlight(3);
		System.out.println("Depart flight (Select Flight): "+departflight);
		returnflight = selectReturnFlight(0);
		System.out.println("Return flight (Select Flight): "+returnflight);
		
		//click on continue button
		clickContinue();
		
		//check if book a flight page is opened
		if(summary.isDisplayed()){
			
			System.out.println("Book a Flight page opened successfully.");
			
		}else{
			
			System.out.println("Book a Flight page is not displayed.");
			
		}
	}
	
}
