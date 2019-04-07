package co.blog.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_blog_web {

	WebDriver driver;
	
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
	
	public void adminPage(){
		driver.findElement(By.xpath("/html/body/div[1]/nav/a[5]")).click();
	}
	
	//test case with password less than 6 char
	public void register(){
		try {
			driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li[2]/a")).click();
			driver.findElement(By.id("name")).sendKeys("sandy1");
			driver.findElement(By.id("email")).sendKeys("sandy1@yahoo.com");
			driver.findElement(By.id("password")).sendKeys("12345");
			driver.findElement(By.id("password-confirm")).sendKeys("12345");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className("btn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//test case with password of atleast 6 char
	public void register2(){
		try {
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.id("password-confirm")).sendKeys("123456");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className("btn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(){
		driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
		driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/ul/li/a")).click();
	}
	
	public void login(){
		//driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li[1]/a")).click();
		driver.findElement(By.id("email")).sendKeys("sandy1@yahoo.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.className("btn")).click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test_blog_web obj = new Test_blog_web();
		obj.invokeBrowser();
		obj.adminPage();
		//obj.register();
		obj.driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		//obj.register2();
		obj.login();
		obj.logout();
	}

}
