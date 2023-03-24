package com.dvc.managepckg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvc.driver.SetUpDBSDriver;
import com.dvc.login.LoginScreen;

public class ManagePackageExecutor {
	
	public static final String testData ="477560151138/m:738253&r:522721197011&s:DREAMS_TPS";

	public static void main(String[] args) throws InterruptedException {

		String url = "https://stage.dvc-ubi.wdprapps.disney.com/home/" + testData + ""; // globally we declared 
																						// id
		SetUpDBSDriver driverSetUp = new SetUpDBSDriver();
		WebDriver driver = driverSetUp.initiateDriver(url);

		LoginScreen login = new LoginScreen();
		login.doLoginProcess(driver);
		
		// Making driver wait till page load completely
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40)); // folio button 
	    wait.until(d -> d.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[1]/a")).isDisplayed());
	    Thread.sleep(3000);
		
	    //Ellipses
		driver.findElement(By.id("action-menu")).click();
		Thread.sleep(1000);
		//manage package click
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[2]/span/span/span[1]")).click();
		Thread.sleep(5000);
		
		
		//Disney Dining Plan Plus
		String planQuery = "return document.querySelector(\"body > div.wdpr-modal-dom-wrapper > wdpr-modal > div > div > div.content-section > div:nth-child(3) > div.row > span:nth-child(1) > label > span\")";
		WebElement planElement =(WebElement)((JavascriptExecutor)driver).executeScript(planQuery);
		planElement.click();
		
		// Confirm Button
		String contQ = "return document.querySelector(\"body > div > wdpr-modal\").querySelector(\"wdpr-button \")";
		WebElement contElement =(WebElement)((JavascriptExecutor)driver).executeScript(contQ);
		contElement.click();
		Thread.sleep(5000);
		
		
		// Car Holder Select
		String chQ = "return document.querySelector(\"body > div > wdpr-modal\").querySelector(\"#card-holder\")";
		WebElement cHElement =(WebElement)((JavascriptExecutor)driver).executeScript(chQ);
		Select chOptions = new Select(cHElement);
		chOptions.selectByValue("0"); // Selecting first Card member
		Thread.sleep(2000);
		
		//Get Contact info btn
		String getContQ = "return document.querySelector(\"body > div > wdpr-modal\").querySelector(\"#get-contact-info-btn\")";
		WebElement gcElement =(WebElement)((JavascriptExecutor)driver).executeScript(getContQ);
		gcElement.click();
		Thread.sleep(5000);
		
		//APP API
		
		String appTitleQuery = "return document.querySelector(\"body > div.wdpr-modal-dom-wrapper > wdpr-modal > h3\")";
		WebElement appTitle = (WebElement)((JavascriptExecutor)driver).executeScript(appTitleQuery);
		System.out.println("$$$$$$$$$$$$"+appTitle.getText());
		
		String appIFrmQ = "return document.querySelector(\"#payui-main\")";
		WebElement iFrmElement = (WebElement)((JavascriptExecutor)driver).executeScript(appIFrmQ);
		Thread.sleep(100);
		
		driver.switchTo().frame(iFrmElement);		
		
		String cardQuery = "return document.querySelector(\"#cardNumber-CREDIT_CARD\")";
		WebElement cardNumber = (WebElement)((JavascriptExecutor)driver).executeScript(cardQuery);
		cardNumber.sendKeys("4266 9020 0018 4224");
		System.out.println("card number entered");
		
		String mmQuery = "return document.querySelector(\"#expiration-CREDIT_CARD\")";
		WebElement expiration = (WebElement)((JavascriptExecutor)driver).executeScript(mmQuery);
		expiration.sendKeys("01/26");
		Thread.sleep(2000);
		
		String applyCardQuery = "return document.querySelector(\"#edit-button-credit_card\")";
		WebElement applyCardElement = (WebElement)((JavascriptExecutor)driver).executeScript(applyCardQuery);
		applyCardElement.click();
		Thread.sleep(2500);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("authorize-btn")).click();
		Thread.sleep(5000);
		
		
	}

}
