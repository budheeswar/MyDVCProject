package com.dvc.payment;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentScreenHandler {
	Logger log = Logger.getLogger(PaymentScreenHandler.class);
	
	public void doPaymentSequencing(WebDriver driver) throws InterruptedException {
		//System.out.println("********** INSIDE PAYMENT HANDLER **********");
		log.info("********** INSIDE PAYMENT HANDLER **********");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation/div/main/section[2]/section[1]/app-reservation-payment/div/div[2]/wdpr-tabs/div/div[1]/div[2]/div/div[3]/div[1]/div[1]/img")).click();
	    Thread.sleep(2000);
	    log.info("<-- CONTRACT SELECTED FOR PAYMENT -->");
	    driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation/footer/wdpr-button[2]")).click();
	    System.out.println("Submit button clicked");
	    log.info("<-- SUBMIT BUTTON CLICKED -->");
	    
	    log.info("********** PAYMENT PAGE COMPLETED **********");
	    
	    
	   
	}

}
