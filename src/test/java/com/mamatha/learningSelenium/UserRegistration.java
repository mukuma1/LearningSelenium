package com.mamatha.learningSelenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class UserRegistration {
	WebDriver wd;

	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Software Testing\\sftware\\chromedriver 99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		wd.manage().window().maximize();
	}

	@Test
	public void verifyUserRegistartion() {
		WebElement emailaddress = wd.findElement(By.id("email_create"));
		emailaddress.sendKeys(RandomString.make(10) + "@abc.com");// random text generator
		WebElement createAccount = wd.findElement(By.id("SubmitCreate"));
		createAccount.click();

		WebElement title = wd.findElement(By.id("id_gender2"));
		title.click();
		WebElement firstName = wd.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Ashley");
		WebElement lastName = wd.findElement(By.id("customer_lastname"));
		lastName.sendKeys("Wilson");
		WebElement password = wd.findElement(By.id("passwd"));
		password.sendKeys("Wilson@1234");
		WebElement day = wd.findElement(By.id("days"));
		day.sendKeys("10");
		WebElement month = wd.findElement(By.id("months"));
		month.sendKeys("april");
		WebElement year = wd.findElement(By.id("years"));
		year.sendKeys("1988");
		WebElement newsLetter = wd.findElement(By.id("newsletter"));
		newsLetter.click();
		WebElement specialOffers = wd.findElement(By.id("optin"));
		specialOffers.click();
		WebElement firstNameAddr = wd.findElement(By.id("firstname"));
		firstNameAddr.sendKeys("Ashley");
		WebElement lastNameAddr = wd.findElement(By.id("lastname"));
		lastNameAddr.sendKeys("Wilson");
		WebElement company = wd.findElement(By.id("company"));
		company.sendKeys("AW & Co");
		WebElement address1 = wd.findElement(By.id("address1"));
		address1.sendKeys("1213 Dundas Street");
		WebElement address2 = wd.findElement(By.id("address2"));
		address2.sendKeys("Apartment No: 119");
		WebElement city = wd.findElement(By.id("city"));
		city.sendKeys("Jersey City");
		WebElement state = wd.findElement(By.id("id_state"));
		state.sendKeys("New Jersey");
		WebElement zipCode = wd.findElement(By.id("postcode"));
		zipCode.sendKeys("08701");
		WebElement country = wd.findElement(By.id("id_country"));
		country.sendKeys("United States");
		WebElement otherInfo = wd.findElement(By.id("other"));
		otherInfo.sendKeys("Buzzer code: 1119");
		WebElement homePhoneNumber = wd.findElement(By.id("phone"));
		homePhoneNumber.sendKeys("6471234567");
		WebElement mobilePhoneNumber = wd.findElement(By.id("phone_mobile"));
		mobilePhoneNumber.sendKeys("4891234567");
		WebElement addrForReference = wd.findElement(By.id("alias"));
		addrForReference.clear();
		addrForReference.sendKeys("1213 Dundas Street,JerseyCity");
		WebElement registerButton = wd.findElement(By.id("submitAccount"));
		registerButton.click();
		// Assertion
		WebElement profileName = wd.findElement(By.cssSelector("a.account"));
		Assert.assertEquals(profileName.getText(), "Ashley Wilson", "User logged in to a different profile");

	}

	@AfterMethod
	public void closingWebBrowser() {
		wd.quit();
	}
}
