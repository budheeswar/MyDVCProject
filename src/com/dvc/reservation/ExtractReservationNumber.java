package com.dvc.reservation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dvc.BookingRequest;
import com.dvc.screenshot.CaptureImage;

public class ExtractReservationNumber {
	
	public String getReservationInfo(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		
//		String errorToastQuery = "return document.querySelector(\"body > app-root:nth-child(1) > app-toast-message > wdpr-toast\").shadowRoot.querySelector(\"#text-message\")";
//		WebElement toastElement =(WebElement) ((JavascriptExecutor)driver).executeScript(errorToastQuery);
//		boolean errorToast = toastElement.isDisplayed();
//		System.out.println("Error message "+toastElement.getText());
//	    if(errorToast == true) {
//	    	
//	    	CaptureImage ss = new CaptureImage();
//			try {
//				ss.takeScreenshotAsJPG(driver, new BookingRequest());
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//	    }
		System.out.println("********** EXTRACTING DATA **********");
        Thread.sleep(12000);
		String info= driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[1]/span[2]")).getText();
		System.out.println("********** EXTRACTING DATA COMPLETED **********");
		return info;
	}

}
