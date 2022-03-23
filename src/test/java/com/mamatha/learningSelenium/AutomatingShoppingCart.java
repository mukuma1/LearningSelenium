package com.mamatha.learningSelenium;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomatingShoppingCart {
	WebDriver wd;
	WebDriverWait wait;
	Actions action;

	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Software Testing\\sftware\\chromedriver 99\\chromedriver.exe");
		wd = new ChromeDriver();
		action = new Actions(wd);
		wait = new WebDriverWait(wd, 10);
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		wd.manage().window().maximize();
	}

	@Test
	public void verifyOnlineShopingProcess() {
		WebElement email = wd.findElement(By.id("email"));
		email.sendKeys("ashley123@abc.com");
		WebElement password = wd.findElement(By.id("passwd"));
		password.sendKeys("Wilson@1234");
		WebElement loginBttn = wd.findElement(By.id("SubmitLogin"));
		loginBttn.click();

		WebElement profileName = wd.findElement(By.cssSelector("a.account"));
		Assert.assertEquals(profileName.getText(), "Ashley Wilson");
		WebElement selectWomen = wd.findElement(By.cssSelector("a.sf-with-ul"));
		selectWomen.click();
		WebElement quickView = wd.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
		quickView.click();

		WebElement iframe1 = wd.findElement(By.cssSelector("iframe.fancybox-iframe"));
		wd.switchTo().frame(iframe1);
		WebElement quantity = wd.findElement(By.cssSelector("i.icon-plus"));
		quantity.click();
		Select selectsize = new Select(wd.findElement(By.id("group_1")));
		selectsize.selectByValue("3");
		WebElement addToCart = wd.findElement(By.cssSelector("button[name='Submit']"));
		addToCart.click();
		wd.switchTo().parentFrame();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2")));
		WebElement successMessage = wd.findElement(By.cssSelector(".layer_cart_product.col-xs-12.col-md-6 h2"));
		Assert.assertEquals(successMessage.getText(), "Product successfully added to your shopping cart");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_title")));
		WebElement productName = wd.findElement(By.id("layer_cart_product_title"));
		Assert.assertEquals(productName.getText(), "Faded Short Sleeve T-shirts");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_quantity")));
		WebElement confirmQuantity = wd.findElement(By.id("layer_cart_product_quantity"));
		Assert.assertEquals(confirmQuantity.getText(), "2");
		String totalPrice = wd.findElement(By.cssSelector(".layer_cart_row span.ajax_block_cart_total")).getText();
		action.click(wd.findElement(By.cssSelector("a.btn.btn-default.button.button-medium"))).perform();

		Assert.assertEquals(wd.findElement(By.id("total_price")).getText(), totalPrice);
		action.click(wd.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")))
				.perform();

		WebElement deliveryInstruction = wd.findElement(By.cssSelector("textarea[name='message']"));
		deliveryInstruction.sendKeys("Pls use buzzer. Dont leave the product at main entrance");
		action.click(wd.findElement(By.cssSelector("button[name='processAddress']"))).perform();

		action.click(wd.findElement(By.id("cgv"))).perform();
		action.click(wd.findElement(By.cssSelector("button[name='processCarrier']"))).perform();

		action.click(wd.findElement(By.cssSelector("a.bankwire"))).perform();
		assertEquals(wd.findElement(By.cssSelector("h3.page-subheading")).getText(), "BANK-WIRE PAYMENT.");
		action.click(wd.findElement(By.cssSelector("button.button.btn.btn-default.button-medium"))).perform();
		assertEquals(wd.findElement(By.cssSelector(".cheque-indent strong.dark")).getText(),
				"Your order on My Store is complete.");
	}

	@AfterMethod
	public void closingWebBrowser() {
		wd.quit();
	}
}
