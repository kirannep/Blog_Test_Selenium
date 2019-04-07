package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FeatureTest {
	WebDriver driver;
	
  @Test(priority=0)
  public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiran\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://blog.localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
  //Go to admin page to register.
  @Test(priority=1)
  public void adminPage(){
		driver.findElement(By.xpath("/html/body/div[1]/nav/a[5]")).click();
	}
  
  @Test(priority=2)
  public void register(){
		try {
			driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li[2]/a")).click();
			driver.findElement(By.id("name")).sendKeys("raju");
			driver.findElement(By.id("email")).sendKeys("raju@yahoo.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.id("password-confirm")).sendKeys("123456");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className("btn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test(priority=3)
  public void login(){
		//driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li[1]/a")).click();
		driver.findElement(By.id("email")).sendKeys("raju@yahoo.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.className("btn")).click();
	}
  
  @Test(priority=4)
  public void logout(){
		driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
		driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/ul/li/a")).click();
	}
}
