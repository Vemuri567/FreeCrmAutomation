package Testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class junitex{
	
	@Test(dataProvider="excel")
	public void login(String username,String password){
		WebDriver driver=null;
		  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		  ChromeOptions options=new ChromeOptions();
		  options.setPageLoadStrategy(PageLoadStrategy.NONE);
		  driver=new ChromeDriver(options);
		 driver.get("https://www.freecrm.com");
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	       // driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//span[text()='Log In']")).click();
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.TAB);
	        //driver.findElement(By.xpath("//input[@name='password']")).click();
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//div[text()='Login']")).click();
	        //driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	
	
	@DataProvider(name="excel")
	public Object[][]  test1(){
		Readingdatafromexcel xl=new Readingdatafromexcel("TestData\\SampleExcel.xlsx");
		int rowcount=Readingdatafromexcel.getRowcount("Sheet1");
		Object [][]testdata=new Object[rowcount-1][2];
		for(int i=2;i<=rowcount;i++){
			
			testdata[i-2][0]=Readingdatafromexcel.getCellData("Sheet1","UserName",i);
			testdata[i-2][1]=Readingdatafromexcel.getCellData("Sheet1","Password",i);
			
		}
		return testdata;
	}
	
}
