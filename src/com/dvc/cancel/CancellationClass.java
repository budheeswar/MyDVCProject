package com.dvc.cancel;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dvc.BookingRequest;

public class CancellationClass {
	
	public boolean doCancelReservation(WebDriver driver,String URL, BookingRequest request) throws InterruptedException {
		Logger log = Logger.getLogger(CancellationClass.class);
		//System.out.println("********** PERFORMING CANCELLATION **********");
		log.info("********** PERFORMING CANCELLATION **********");
		boolean cancellation_Status = false;
		String statusXPath = "/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[1]/span[1]";
	    String status = driver.findElement(By.xpath(statusXPath)).getText();
		//Ellipses
		if(status.equals("Reservation Cancelled")) {
			
			//System.out.println("Unable to perform Again..   -->");
			log.warn(" <-- Reservation already Cancelled... -->");
		}
		else {
			driver.findElement(By.id("action-menu")).click();
		    Thread.sleep(10);
		    driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[2]/span/span/span[3]")).click();
		    
		    Thread.sleep(1000);
		    //Acknoledgement -> [yes,Cancel]
		    String ackQuery = "return document.querySelector(\"#ok-confirmation-btn\")";
		    WebElement ackElement = (WebElement) ((JavascriptExecutor) driver).executeScript(ackQuery);
		    ackElement.click();
		    log.info("<-- Acknoledgement giving as \"Yes,Cancel\"  -->");
		    Thread.sleep(10000);
		    
		    if(status.equals("Reservation Cancelled")) {
		    	cancellation_Status = true;
		    	System.out.println("<-- DONE -->");
		    	
		    }
		   
			
		}
	    
		return cancellation_Status;
	}

}
