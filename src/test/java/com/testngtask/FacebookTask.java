package com.testngtask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.CommonActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTask extends CommonActions{
	static CommonActions C = new CommonActions();
	static long startTime;
	@DataProvider(name="firstname")
	public Object [][] firstName(){
		return new Object [][] {{"Hemanth"}};
		
	}
	@DataProvider(name="lastname")
	public Object [][] lastName(){
		return new Object [][] {{"Babu"}};
		
	}
	@DataProvider(name="mobilenumber")
	public Object [][] mobilenumber(){
		return new Object [][] {{"8072861025"}};
		
	}
	@DataProvider(name="password")
	public Object [][] password(){
		return new Object [][] {{"Hemu3123*"}};
		
	}
	
	@DataProvider(name="DOB")
	public Object [][] month(){
		return new Object [][] {{"13","10","1998"}};
		
	}
	
	@Parameters
	@BeforeClass
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		C.launch("https://www.facebook.com/");
	}
	@BeforeMethod
	public void beforeTest() {
		System.out.println("Start Time");
		startTime = System.currentTimeMillis();
		System.out.println(startTime);
	}
	@Test(priority=1)
	public void user_create_Account() throws Throwable {
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		Thread.sleep(3000);
		}
		@Test(priority=2,dataProvider="firstname")
		public void user_enters_firstname(String S) {
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		C.insertText(firstname, S);
		}
		
		@Test(priority=2,dataProvider="lastname")
		public void user_enters_lastname(String S) {
		WebElement lastname = driver.findElement(By.name("lastname"));
		C.insertText(lastname, S);
		}
		
		@Test(priority=3,dataProvider="mobilenumber")
		public void user_enters_mobilenumber(String S) {
		WebElement number=driver.findElement(By.name("reg_email__"));
		C.insertText(number, S);
		}
		
		@Test(priority=4,dataProvider="password")
		public void user_enters_password(String S) {
		WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		C.insertText(password, S);
		}
		
		@Test(priority=5,dataProvider="DOB")
		public void user_enters_dateofbirth(String S1,String S2,String S3) throws Throwable {
		Thread.sleep(5000);
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		C.dropDown(date,S1);
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		C.dropDown(month,S2);
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		C.dropDown(year,S3);
		}
		
		@Test(priority=6)
		public void user_selects_gender() {
		WebElement gender = driver.findElement(By.xpath("//span[@data-type='radio']/span/following-sibling::span/label"));
		gender.click();
		}
		
		@Test(priority=7)
		public void user_takes_screenshot() throws Throwable {
			C.screenShot("Facebook");
		}
		@AfterMethod
		public void afterTest() {
			System.out.println("End Time");
			long endTime = System.currentTimeMillis();
			System.out.println(endTime-startTime);
		}
		@AfterClass
		public static void quitBrowser() throws Throwable {
			Thread.sleep(3000);
			driver.quit();
		}
		

}
