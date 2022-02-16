package com.mobile.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

// launch browser for clockify 
// for project already created add tasks (SDLC Tasks)
// for each task add time 
// requirements (20 days) -> Development(30 days) -> testing (10 days) -> deployement(5 days) 


public class sampleTest {
	static WebDriver driver;

	@Test
	public void myTestForTimesheet() {
		
		// chrome driver path 
		//System.setProperty("webdriver.chrome.driver", "./chrome.exe");
		
		// invoke safari driver
		driver = new SafariDriver();
		
		// get URL 
		driver.get("https://app.clockify.me/");
		
		// maximize browser 
		driver.manage().window().maximize();
		
		//add wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Login with google 
		
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),  'Continue with Google')]"));
		ele.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement inputBoxHomePage = driver.findElement(By.xpath("//input[@placeholder='What are you working on?']"));
		
		Assert.assertTrue(inputBoxHomePage.isDisplayed());
		
		// click project element
		
		WebElement prjEle = driver.findElement(By.xpath("//a[@class='cl-project-name cl-project-name-colored cl-dropdown-toggle cl-no-arrow cl-listing-project-client ng-star-inserted']"));
		prjEle.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		createTask("Requirements Gathering");
		createTask("Development");
		createTask("Testing");
		createTask("Deployment");
		
		
		
		
		
		//quit driver
		driver.quit();


	}
	
	public static void createTask(String name) {
		
		WebElement createTask = driver.findElement(By.xpath("//a[@class='cl-pl-3 ng-star-inserted']"));
		createTask.click();
		WebElement taskName = driver.findElement(By.xpath("//input[@class='cl-form-control ng-pristine ng-valid ng-touched']"));
		taskName.sendKeys(name);
		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='cl-btn cl-btn-primary']"));
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

}
