package LoginScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelConnection 
{

	public static void main(String [] str) throws IOException, InterruptedException
	{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.playtolearn.in/Acclimate_Beta/");
	driver.manage().window().maximize();
	
	//File Location
	FileInputStream file = new FileInputStream("E:\\Selenium\\Acclimate Test Cases.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	
	// Get the sheet
	XSSFSheet sheet = workbook.getSheet("Login");
	
	//Get 1st Row from the sheet
	int noOfRows = sheet.getLastRowNum();
	// System.out.println("Total Number of Rows :- " +noOfRows);
	int noOfCol = sheet.getRow(2).getLastCellNum();
	// System.out.println("Total number of Cells : - " +noOfCol);
	
	for(int r=0; r<noOfRows-1; r++)
	{
		XSSFRow row = sheet.getRow(r);
		for(int c=0; c<noOfCol; c++ )
		{
			XSSFCell cell = row.getCell(c);
			switch(cell.getCellType())
			{
			case STRING:System.out.println(cell.getStringCellValue()); break;
			case NUMERIC:System.out.println(cell.getNumericCellValue()); break;
			}
			
		}
	}
	
	
}
	

	}
	



