package LoginScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {

	public static void main(String[] args)
	{
	    //System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\chromedriver_win32");
		
		WebDriver driver = new ChromeDriver();
		
		    driver.get("https://coroebusbeta.in/b2b-beta-web/#/account/login");
		 //driver.get("https://www.playtolearn.in/Acclimate_Beta/");
		   driver.manage().window().maximize();
		
		     // driver.findElement(By.cssSelector("input[type=email]")).sendKeys("radhika@thegamificationcompany.com");
		     // driver.findElement(By.cssSelector("input[type=password ]")).sendKeys("123456");
		
	       driver.findElement(By.xpath("//*[@id='floatingInput']")).sendKeys("GOP_IN501");
		
		   driver.findElement(By.xpath("//*[@id=\"floatingPassword\"]")).sendKeys("Tgc@12345");
		 String str =  driver.getTitle();
		 System.out.println(str);
		   
		   
	       //driver.findElement(By.cssSelector("input[type=submit")).click();
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
	   	 WebElement logo = driver.findElement(By.xpath("//img[@alt='Logo']"));
	   	System.out.println(logo);

	}

}
