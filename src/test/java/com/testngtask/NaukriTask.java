package com.testngtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.CommonActions;

public class NaukriTask extends CommonActions {
	static long startTime;
	static CommonActions C = new CommonActions();
	@BeforeClass(groups="sanity")
	public static void launch() {
		C.launch("https://www.naukri.com/");
	}
	@BeforeMethod(groups="sanity")
	public void beforeTest() {
		System.out.println("Start Time");
		startTime = System.currentTimeMillis();
		System.out.println(startTime);
	}
	@Test(priority=-1,groups="sanity")
	public void user_clicks_the_registerbutton() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
	}
	@Parameters({"Name"})
	@Test(priority=0,groups="smoke")
	public void user_enters_the_name(String S) {
		WebElement name = driver.findElement(By.id("name"));
		C.insertText(name,S);
	}
	@Parameters({"emailid"})
	@Test(priority=1,groups="smoke")
	public void user_enters_the_emailid(String S) {
		WebElement email = driver.findElement(By.id("email"));
		C.insertText(email,S);
	}
	@Parameters({"password"})
	@Test(priority=2,groups="smoke")
	public void user_enters_the_password(String S) throws Throwable {
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.id("password"));
		C.insertText(password,S);
	}
	@Parameters({"mobilenumber"})
	@Test(priority=3,groups="smoke")
	public void user_enters_the_mobilenumber(String S) {
		WebElement mobile = driver.findElement(By.id("mobile"));
		C.insertText(mobile,S);
	}
	
	@Test(priority=4,groups="smoke")
	public void user_click_the_experiencesection() {
		WebElement experience = driver.findElement(By.xpath("//div[@class='iconWrap']/following-sibling::div"));
		experience.click();
	}
	
	@Test(priority=5,groups="smoke")
	public void user_takes_screenshot() throws Throwable {
		C.screenShot("naukri");
	}
	@AfterMethod(groups="sanity")
	public void afterTest() {
		System.out.println("End Time");
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
	@AfterClass(groups="sanity")
	public static void quitBrowser() throws Throwable {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
