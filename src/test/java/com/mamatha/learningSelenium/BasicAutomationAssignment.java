package com.mamatha.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAutomationAssignment {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Software Testing\\sftware\\chromedriver 99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php?controller=contact");
		wd.manage().window().maximize();
	}

	@Test
	public void test1() {
		// Identifying Web elements
		WebElement subjectHeading = wd.findElement(By.xpath("//select[@name='id_contact']"));
		WebElement option1 = wd.findElement(By.xpath("//option[@value='0']"));
		WebElement option2 = wd.findElement(By.xpath("//option[@value='1']"));// webmaster
		WebElement option3 = wd.findElement(By.xpath("//option[@value='2']"));// customer service
		WebElement emailAddress = wd.findElement(By.id("email"));
		WebElement orderReference = wd.findElement(By.id("id_order"));
		WebElement message = wd.findElement(By.id("message"));
		WebElement send = wd.findElement(By.id("submitMessage"));

		// performing action
		subjectHeading.click();
		if (option3.getText().equals("Customer service")) {
			option3.click();
		}
		emailAddress.sendKeys("mamatha@gmail.com");
		orderReference.sendKeys("Model demo_1");
		message.sendKeys("Size not matching. Would like to return");
		send.click(); // .submit() not working???
		
		WebElement confirmationMessgae = wd.findElement(By.cssSelector("p.alert.alert-success"));
		if (confirmationMessgae.getText().contains("successfully")) {
			System.out.println("Message Submitted");
		}

	}
}
