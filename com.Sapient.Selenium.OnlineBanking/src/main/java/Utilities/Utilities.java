package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
		//Get Data from Excel
		@SuppressWarnings("resource")
		public static String getDataFromExcel(String strProperty, String strSheetName) throws IOException{
			
			String Value = null;
			File objFile = new File(System.getProperty("user.dir")+"\\TestData.xls");
			FileInputStream objFis = new FileInputStream(objFile);
			HSSFWorkbook myWorkbook = new  HSSFWorkbook(objFis);
			Sheet mySheet = myWorkbook.getSheet(strSheetName);
			int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
			for(int i = 0; i < rowCount+1; i++){
				Row myRow = mySheet.getRow(i);
				if(myRow.getCell(0).getStringCellValue().equals(strProperty)){
					Value = myRow.getCell(1).getStringCellValue();
				}
			}
			return Value;
			
		}
		
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
