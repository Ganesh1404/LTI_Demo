package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{	
	//@Author name: Ganesh Jadhav
	// this method is use to get test data from excel sheet
	// need to pass 2 parameters ie. 1: rowIndex ,  2: cellIndex
	public static String getTestData(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ganes\\eclipse-workspace\\Selenium\\TestData\\excel_sheet_Framework.xlsx");
				
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	//@Author name: Ganesh Jadhav
	// this method is use to capture Screenshot
	// need to pass 2 parameters ie. 1: driver ,  2: TCID	
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\ganes\\eclipse-workspace\\Maven_Sample1\\Screenshot\\TestID"+TCID+".jpg");
		
		org.openqa.selenium.io.FileHandler.copy(source, dest);
	}
	
	public static String getPropertyFileData(String key) throws IOException
	{
		Properties obj=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\ganes\\eclipse-workspace\\Selenium\\Property.properties");
		obj.load(file);
		String value=obj.getProperty(key);
		
		return value;
	}
}
