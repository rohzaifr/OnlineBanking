package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectFlightPageObjects {

	WebDriver driver;
	public String departflight, returnflight;
	
	//Class constructor
	public SelectFlightPageObjects(WebDriver driver){
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
	
	public void checkSorting() throws IOException{
		
		int count = 0;
		String strFirst;
		String[] strFinal;
		
		//Get the price in the list array
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		System.out.println("List obtained from application");
		for(WebElement we : elementList){
		   strFirst = we.getText();
		   strFinal = strFirst.split("\\$");
		   obtainedList.add(strFinal[1]);
		   System.out.println(strFinal[1]);
		   count = count + 1;
		   if(count == 3){
			   break;
		   }
		}
		
		//sort the above list array
		System.out.println("sorted List");
		ArrayList<String> sortedList = new ArrayList<String>();   
		for(String s : obtainedList){
			sortedList.add(s);
			System.out.println(s);
		}
		Collections.sort(sortedList);
		
		//compare both the array
		Assert.assertTrue(sortedList.equals(obtainedList),"The order of the flights displayed is not sorted on its price");
		
	}
	
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
