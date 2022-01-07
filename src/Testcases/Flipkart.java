package Testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	static String login_xpath="//a[contains(text(),'Login')]";
	static String email_xpath="//input[@class='_2IX_2- VJZDxU']";
	static String button_close="//button[text()='✕']";
	static WebDriver driver;
	public static void launchdriver(){
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
         driver=new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
//        if(driver.findElement(By.xpath(button_close)).isDisplayed()){
//        	driver.findElement(By.xpath(button_close)).click();
//        }
        
		
	}
	
	public static void login(){
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("mobiles");
		
		driver.findElement(By.xpath(login_xpath)).click();
		try{
			WebElement email=driver.findElement(By.xpath(email_xpath));
			email.sendKeys("9963321819");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
