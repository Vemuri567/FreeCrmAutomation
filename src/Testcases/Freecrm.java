package Testcases;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Freecrm  {
	
	
	
public static void main(String[] args){
	
  WebDriver driver=null;
  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
  ChromeOptions options=new ChromeOptions();
  options.setPageLoadStrategy(PageLoadStrategy.NONE);
  driver=new ChromeDriver(options);
Readingdatafromexcel xl=new Readingdatafromexcel("TestData\\SampleExcel.xlsx");
	
	   int rowcount=Readingdatafromexcel.getRowcount("Sheet1");
	   System.out.println(rowcount);
	   
	   for(int i=2;i<=rowcount;i++){
		   
		   String username=Readingdatafromexcel.getCellData("Sheet1","UserName",i);
		   String password=Readingdatafromexcel.getCellData("Sheet1","Password",i);
			
	        driver.get("https://www.freecrm.com");
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	       // driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//spxan[text()='Log In']")).click();
	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.TAB);
	        //driver.findElement(By.xpath("//input[@name='password']")).click();
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//div[text()='Login']")).click();
	        //driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	        String title=driver.getTitle();
	        Assert.assertEquals(title, "cogmento");
	        if(title.equals("cogmento")){
	        	System.out.println(true); 
	        }
	        System.out.println(title);
	       Set<String> windowhandles= driver.getWindowHandles();
	       //int count= windowhandles.size();
	       
	       for(String name:windowhandles){
	    	   driver.switchTo().window(name);
	    	   if(driver.getTitle().equals("Cogmento CRM")){
	    		  
	    	   }
	       }
	       
	       
	   }
	   
	}

}
