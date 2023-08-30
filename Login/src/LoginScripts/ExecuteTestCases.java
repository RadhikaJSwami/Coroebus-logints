package LoginScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteTestCases {

	public static void main(String[] args) throws IOException, InterruptedException 
    {
		//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Invoke the browser
		 driver.get("https://www.playtolearn.in/Acclimate_Beta/");
	     driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
			//File Location 
			FileInputStream file= new FileInputStream("E:\\Selenium\\Acclimate Test Cases.xlsx");
	        //
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			//get the sheets 
			XSSFSheet sheet = workbook.getSheet("Login");//providing sheet name 
			//XSSFSheet sheet = workbook.getSheetAt(0); //If want to give sheet Index.(Index start with 0)
			
			//Get the first row from the sheet
			int noOfRows = sheet.getLastRowNum();
			System.out.println("Total Number of Rows :- " +noOfRows);
			
		//Get the Cell value from the columns
			for(int row=1; row<noOfRows; row++) 
			{
				XSSFRow currentrow = sheet.getRow(row);
				
				String Username = currentrow.getCell(2).getStringCellValue();
				
				String Password = currentrow.getCell(3).getStringCellValue();
				String ExpectedResult = currentrow.getCell(4).getStringCellValue();
				
			
		    	WebElement web =  driver.findElement(By.cssSelector("input[type=email]"));
		    	web.sendKeys(Username);
		    	Thread.sleep(2000);
		    	
		 
				 WebElement web1 = driver.findElement(By.cssSelector("input[formcontrolname=password]"));
				 web1.sendKeys(Password);
				 Thread.sleep(2000);				 
				 
				 driver.findElement(By.className("btn")).click();
	
				web1.clear();
				 
				 if(driver.getCurrentUrl().contains("https://www.playtolearn.in/Acclimate_Beta/#/main-header/sidenav"))			 
				 {
					 System.out.println("Login Successfully  " + row +"Records" );
					 driver.close();
				 }
				 else
				 {
					 
					 System.out.println(driver.getPageSource().concat("Result" +ExpectedResult) ); 
				 }
				
			}
			
			driver.close();
			driver.quit();
			file.close();
	}

}
