package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidationSteps {
	
	static WebDriver driver;
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
		
		WebElement d = driver.findElement(By.xpath("//button[text()='✕']"));
		d.click();
	   
	}

	@When("user search mobile")
	public void user_search_mobile() {
		
		WebElement s = driver.findElement(By.name("q"));
		s.sendKeys("Poco",Keys.ENTER);
	   
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
		
		WebElement mobile = driver.findElement(By.xpath("//div[text()='POCO C31 (Royal Blue, 64 GB)'] "));
	    String s1 = mobile.getText();
        System.out.println(s1);
        mobile.click();
	   
	}

	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() {
		
		String parent = driver.getWindowHandle();
		Set<String> children = driver.getWindowHandles();
		
		driver.switchTo().window(parent);
	   
	}


	
	

}
