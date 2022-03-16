package com.mamatha.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.MustBeClosed;
public class FirstSeleniumScrip {
	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Software Testing\\sftware\\chromedriver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		// webDriver.get("http://automationpractice.com/index.php?controller=contact");
		webDriver.get("https://demoqa.com/text-box");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void sendkeysTest() {

		// Identifying the elements
		WebElement fullNameInput = webDriver.findElement(By.id("userName"));
		WebElement emailInput = webDriver.findElement(By.id("userEmail"));
		WebElement cAddressInput = webDriver.findElement(By.id("currentAddress"));
		WebElement pAddressInput = webDriver.findElement(By.id("permanentAddress"));

		// Perform Send Keys
		fullNameInput.sendKeys("Mamatha");
		emailInput.sendKeys("mamatha@gmail.com");
		cAddressInput.sendKeys("Ontario");
		pAddressInput.sendKeys("India");


	}

	@Test
	public void clickSubmitButton() {
		// Identifying the elements
		WebElement fullNameInput = webDriver.findElement(By.id("userName"));
		WebElement emailInput = webDriver.findElement(By.id("userEmail"));
		WebElement cAddressInput = webDriver.findElement(By.id("currentAddress"));
		WebElement pAddressInput = webDriver.findElement(By.id("permanentAddress"));
		WebElement submitBtn = webDriver.findElement(By.id("submit"));

		// Perform Send Keys
		fullNameInput.sendKeys("Mamatha");
		emailInput.sendKeys("mamatha@gmail.com");
		cAddressInput.sendKeys("Ontario");
		pAddressInput.sendKeys("India");
		
		//clicking
		submitBtn.click();
	}
	@Test
	public void isSubmitButtonDisplayed() {
		//Identifying webelement
		WebElement submitButton = webDriver.findElement(By.id("submit"));
		//checking whether the element is displayed
		boolean isSubmitButtonDisplayed= submitButton.isDisplayed();
		System.out.println("Submit Button is Displyed: "+isSubmitButtonDisplayed);
		
	}
	
}
