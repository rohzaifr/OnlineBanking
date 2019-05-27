package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
		//Get data from Config file
		public static String getDataFromConfig(String strKey) throws IOException{
			
			String strData = null;
			Properties objProp = new Properties();
			FileReader objFile = new FileReader(System.getProperty("user.dir")+"\\Config.properties");
			objProp.load(objFile);
			strData = objProp.getProperty(strKey);
			return strData;
			
		}
		
		//explicit wait
		public static boolean explicitWait(WebDriver driver, WebElement element){
			
			boolean status = true;
			try{
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}catch(Exception e){
				status = false;
				System.out.println("Unable to wait for the element "+element);
				System.out.println("Exception occured - "+e.getMessage());
			}
			return status;
		}

}
