package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import PageObjects.PageObjectsLogin;
import PageObjects.PageObjectsSearchFlight;
import PageObjects.PageObjectsSelectFlight;
import Utilities.BaseClass;
import Utilities.Utilities;

public class TestCaseSelectFlight{

	BaseClass base = new BaseClass(true);
	PageObjectsLogin objLogin = new PageObjectsLogin(base.driver);
	PageObjectsSearchFlight objFlightFinder = new PageObjectsSearchFlight(base.driver);
	PageObjectsSelectFlight objSelectFlight = new PageObjectsSelectFlight(base.driver);	
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		
		//Launch chrome browser and open application
		base.setupApplication();
		
	}
	
	@Test(priority = 7)
	//Check if flight details are sorted based on price
	public void checkSorting() throws IOException{
		
		int count = 0;
		String strFirst;
		String[] strFinal;
		
		//Fetch username and password from excel and enter into application
		objLogin.loginApplication(Utilities.getDataFromConfig("USERNAME"), Utilities.getDataFromConfig("PASSWORD"));
		objFlightFinder.searchFlight();
				
		//Get the price in the list array
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		for(WebElement we : objSelectFlight.elementList){
		   strFirst = we.getText();
		   strFinal = strFirst.split("\\$");
		   obtainedList.add(strFinal[1]);
		   count = count + 1;
		   if(count == 3){
			   break;
		   }
		}
		
		//sort the above list array
		ArrayList<String> sortedList = new ArrayList<String>();   
		for(String s : obtainedList){
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		
		//compare both the array
		Assert.assertTrue(sortedList.equals(obtainedList),"The order of the flights displayed is not sorted on its price");
		
	}
	
	@Test(priority = 8)
	//select flight details and click on continue button
	public void selectFlight() throws IOException{
		
		//Fetch username and password from excel and enter into application
//		objLogin.loginApplication(Utilities.getDataFromConfig("USERNAME"), Utilities.getDataFromConfig("PASSWORD"));
//		objFlightFinder.searchFlight();
		
		//select departure and return flight
		objSelectFlight.selectFlight();
		
	}
	
	@AfterTest
	public void quitDriver(){
		base.closeApplication();
	}
	
}
