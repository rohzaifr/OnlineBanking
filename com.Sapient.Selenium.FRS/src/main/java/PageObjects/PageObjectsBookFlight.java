package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageObjectsBookFlight {

	WebDriver driver;
	String[] depFlightDetails, arrFlightDetails;
	boolean blnDepFlight, blnArrFlight, blnDepPrice, blnArrPrice;
	public String departflight, returnflight;
	
	//Class constructor
	public PageObjectsBookFlight(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//form[@name='bookflight']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]")
	public WebElement depDetails;
	
	@FindBy(xpath=".//form[@name='bookflight']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]")
	public WebElement depPrice;
	
	@FindBy(xpath=".//form[@name='bookflight']/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]")
	public WebElement arrDetails;
	
	@FindBy(xpath=".//form[@name='bookflight']/table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]")
	public WebElement arrPrice;
	
	@FindAll(value={@FindBy (xpath=".//input[@type='radio'][@name='outFlight']")})
	public List<WebElement> flightDepart;
	
	@FindAll(value={@FindBy (xpath=".//input[@type='radio'][@name='inFlight']")})
	public List<WebElement> flightReturn;
	
	@FindBy(how=How.XPATH, using=".//input[@name='reserveFlights']")
	public WebElement btnContinue;
	
	//This function is fetching the flight details from Select Flight page and verifying the details from Book Flight page
	public void bookFlight(){
			
		depFlightDetails = departflight.split("\\$");
		arrFlightDetails = returnflight.split("\\$");
		String strDepFlight = getFlightDetails(depDetails);
		System.out.println("Depart flight (Book Flight): "+strDepFlight);
		String strArrFlight = getFlightDetails(arrDetails);
		System.out.println("Return flight (Book Flight): "+strArrFlight);
		String strDepPrice = getFlightDetails(depPrice);
		System.out.println("Depart flight Price (Book Flight): "+strDepPrice);
		String strArrPrice = getFlightDetails(arrPrice);
		System.out.println("Return flight Price (Book Flight): "+strArrPrice);
		blnDepFlight = ValidateFlightDetails(strDepFlight , depFlightDetails[0]+" "+depFlightDetails[1]);
		blnArrFlight = ValidateFlightDetails(strArrFlight , arrFlightDetails[0]+" "+arrFlightDetails[1]);
		blnDepPrice = ValidateFlightDetails(strDepPrice , depFlightDetails[2]);
		blnArrPrice = ValidateFlightDetails(strArrPrice , arrFlightDetails[2]);
		if (blnDepFlight && blnDepPrice) {
			
			System.out.println("Details matched for depart flight");
			
		}else{
			
			System.out.println("Details not matched for depart flight");
			
		}
		if (blnArrFlight && blnArrPrice){
			
			System.out.println("Details matched for return flight");
			
		}else{
			
			System.out.println("Details not matched for return flight");
			
		}
		Assert.assertTrue(blnDepFlight);
		Assert.assertTrue(blnArrFlight);
		Assert.assertTrue(blnDepPrice);
		Assert.assertTrue(blnArrPrice);
		
	}
	
	//get name of the flight
	public String getFlightDetails(WebElement element){
		
		return element.getText();
		
	}
	
	//Compare the name of the flights 
	public boolean ValidateFlightDetails(String strBookFlight, String strSelectFlight){
		
		int compareValue = strBookFlight.compareTo(strSelectFlight);
		if (compareValue == 0 )
			
			return true;
		
		else
			
			return false;

	}
	
	//Select flight from Select flight page and click on continuebutton
	public void selectFlight() throws IOException{
		
		//select departure and return flight
		departflight = selectDepArrFlight(3,flightDepart);
		System.out.println("Depart flight (Select Flight): "+departflight);
		returnflight = selectDepArrFlight(0,flightReturn);
		System.out.println("Return flight (Select Flight): "+returnflight);
		
		//click on continue button
		btnContinue.click();
		
	}
	
	//select departure/arrival flight
	public String selectDepArrFlight(int flightOrder, List<WebElement> element){		

		element.get(flightOrder).click();
		return element.get(flightOrder).getAttribute("value");
		
	}
	
}
