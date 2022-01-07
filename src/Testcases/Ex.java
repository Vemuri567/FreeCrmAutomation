package Testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchtext_xpath=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        if(searchtext_xpath.isDisplayed())
        {
        	searchtext_xpath.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try
        {
        	WebElement Hellosignin_xpath=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
            Actions builder=new Actions(driver);
            builder.moveToElement(Hellosignin_xpath).perform();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
        	System.out.println("Hellosign element not displayed");
        }
        
        
        WebElement signin_xpath=driver.findElement(By.xpath("//a[@data-nav-ref='nav_signin']//span[text()='Sign in']"));
        signin_xpath.click();
	}

}
