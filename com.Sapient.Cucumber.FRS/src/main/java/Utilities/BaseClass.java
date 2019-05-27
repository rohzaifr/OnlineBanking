package Utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	
	//Class constructor for invoking webdriver chrome instance
	public BaseClass(boolean launch){
		
		if(launch){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		}
	    
	}
	
	//Pass application url to chrome browser and verify if application launched successfully
	public void setupApplication() throws IOException{
		
		driver.navigate().to(Utilities.getDataFromConfig("url"));
		String strTitle = driver.getTitle();
		if(strTitle.equals(Utilities.getDataFromConfig("maintitle")))
		{
			
			System.out.println("User is on the Flight Reservation main page");
			
		}else{
			
			System.out.println("There is some issue while opening up the application");
			
		}
		
	}
	
	//Close webdriver instance
	public void closeApplication()
	{
		
		driver.quit();
		
	}
	
}
