package com.stepdefinition;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinStep {
WebDriver driver;
	
	@Given("User is on adactin page")
	public void tc1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	   
	}

	@When("User should enter user name and password")
	public void tc2() {
		driver.findElement(By.id("username")).sendKeys("Selvafrench123");
		driver.findElement(By.id("password")).sendKeys("Selvafrench123");
	  
	}

	@When("user should click login button")
	public void tc3() {
		driver.findElement(By.id("login")).click();
	}

	@Then("user should verify success message")
	public void tc4() {
		String text = driver.findElement(By.id("username_show")).getAttribute("value");
		assertEquals("done ","Hello Selvafrench123!",text );
		

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
