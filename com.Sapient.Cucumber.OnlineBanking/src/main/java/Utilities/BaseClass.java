package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	
	public BaseClass(boolean launch){
		
		if(launch){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExternalJARS\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		}
	    
	}
	
	public void setupApplication() throws IOException{
		
		driver.navigate().to(Utilities.getDataFromConfig("url"));
		String strTitle = driver.getTitle();
		if(strTitle.equals("Altoro Mutual"))
		{
			
			System.out.println("User is on the Application main page");
			
		}else{
			
			System.out.println("There is some issue while opening up the application");
			
		}
		
	}
	
	public void closeApplication()
	{
		
		driver.quit();
		
	}
	
}
