package com.dvc.refund;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvc.driver.SetUpDBSDriver;
import com.dvc.login.LoginScreen;

public class RefundExecutor {
	
	public static final String testData ="477560151138/m:738253&r:522721197011&s:DREAMS_TPS";
	
	public static void main(String[] args) throws InterruptedException {

		String url = "https://stage.dvc-ubi.wdprapps.disney.com/home/" + testData + ""; // globally we declared
		// id
		SetUpDBSDriver driverSetUp = new SetUpDBSDriver();
		WebDriver driver = null;
		try {
			driver = driverSetUp.initiateDriver(url);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		LoginScreen login = new LoginScreen();
		try {
			login.doLoginProcess(driver);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

       // Making driver wait till page load completely
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // folio button
		wait.until(d -> d.findElement(By.xpath(
				"/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[1]/a"))
				.isDisplayed());
		Thread.sleep(4500);
		
		
		// Folio Click
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[1]/a")).click();
		Thread.sleep(7000);
		
		//refund btn
		String refundQuery = "return document.querySelector(\"#refund-btn\")";
		WebElement refundElement = (WebElement) ((JavascriptExecutor)driver).executeScript(refundQuery);
		refundElement.click();
		
		// Get max Refundable Amount
		String maxRefundAmountQuery = "return document.querySelector(\"body > div.wdpr-modal-dom-wrapper > wdpr-modal > div > div > div.content-section > div > div.row > div:nth-child(2)\")";
		WebElement mxRefundAmount = (WebElement) ((JavascriptExecutor)driver).executeScript(maxRefundAmountQuery);
		String maxRfndAmt = mxRefundAmount.getText();
		System.out.println(" MAX AMOUNT "+maxRfndAmt);
		String RefundAmount = maxRfndAmt.replace("$", " ");
		System.out.println("Amount Without Currency Symbol "+RefundAmount);
		
		
		String RefundInputQuery = "return document.querySelector(\"#amount.form-field\")";
		WebElement RefundInputElement = (WebElement) ((JavascriptExecutor)driver).executeScript(RefundInputQuery);
//		try {
//			RefundInputElement.click();
//		}catch(Exception e) {
//			System.out.println("input exception ");
//		}		
		System.out.println(RefundInputElement.getText());
		
		String refundBtnQ = "return document.querySelector(\"#refund-btn\")";
		WebElement RefundBtn = (WebElement) ((JavascriptExecutor)driver).executeScript(refundBtnQ);
		try {
			RefundBtn.click();
		}catch(Exception e) {
			Thread.sleep(2000);
		}
		RefundBtn.click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("close-btn")).click();
		
		

	}

}
