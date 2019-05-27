package PageObjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.Utilities;

public class SearchFlightPageObjects {

	WebDriver driver;
	
	//Class constructor
	public SearchFlightPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//type of trip element
	@FindBy(how=How.XPATH, using="//input[@value='oneway']")
	public WebElement trip;
	
	//number of passengers element
	@FindBy(how=How.NAME, using="passCount")
	public WebElement passengerCount;
	
	
	//from port element
	@FindBy(how=How.NAME, using="fromPort")
	public WebElement fromPort;
	
	//from month element
	@FindBy(how=How.NAME, using="fromMonth")
	public WebElement fromMonth;
	
	//from day element
	@FindBy(how=How.NAME, using="fromDay")
	public WebElement fromDay;
	
	//to port element
	@FindBy(how=How.NAME, using="toPort")
	public WebElement toPort;
	
	//to month element
	@FindBy(how=How.NAME, using="toMonth")
	public WebElement toMonth;
	
	//to day element
	@FindBy(how=How.NAME, using="toDay")
	public WebElement toDay;
	
	//travel class element
	@FindBy(how=How.XPATH, using="//input[@value='First']")
	public WebElement travelClass;
	
	//type of airline element
	@FindBy(how=How.NAME, using="airline")
	public WebElement airlineType;
	
	//find flight button element
	@FindBy(how=How.NAME, using="findFlights")
	public WebElement btnFindFlight;
	
	//flight detail element
	@FindBy(how=How.XPATH, using="//font[contains(text(),'DEPART')]")
	public WebElement flightdetail;
	
	public void searchFlight() throws IOException{
		
		trip.click();
		
		//Select the number of passengers
		Select passCount = new Select((WebElement) passengerCount);
		passCount.selectByValue(Utilities.getDataFromConfig("passcount"));
		
		//Select source location
		Select srcPort = new Select((WebElement) fromPort);
		srcPort.selectByValue(Utilities.getDataFromConfig("fromport"));
		
		//Select month of travel
		Select srcMonth = new Select((WebElement) fromMonth);
		srcMonth.selectByValue(Utilities.getDataFromConfig("frommonth"));
		
		//Select day of travel
		Select srcDay = new Select((WebElement) fromDay);
		srcDay.selectByValue(Utilities.getDataFromConfig("fromday"));
		
		//Select destination location
		Select destPort = new Select((WebElement) toPort);
		destPort.selectByValue(Utilities.getDataFromConfig("toport"));
		
		//Select month of travel
		Select destMonth = new Select((WebElement) toMonth);
		destMonth.selectByValue(Utilities.getDataFromConfig("tomonth"));
		
		//Select day of travel
		Select destDay = new Select((WebElement) toDay);
		destDay.selectByValue(Utilities.getDataFromConfig("today"));
		
		//Select type of class for travel-either economy or business or first
		travelClass.click();
		
		//Click on search flight button
		btnFindFlight.click();
		
	}
	
}
