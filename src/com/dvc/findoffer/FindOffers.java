package com.dvc.findoffer;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindOffers {
	Logger log = Logger.getLogger(FindOffers.class);

	public void doFindOffers(WebDriver driver) throws InterruptedException {
		// clicking find offer
		log.info("********** INSIDE FIND OFFER **********");
		driver.findElement(By.id("initiate-btn")).click();
		
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(d -> d.findElement(By.id("continue-btn")).isDisplayed());
	    Thread.sleep(4000);
	    
		String offerFlow=driver.findElement(By.id("continue-btn")).getText(); //continue to guest list
		if(offerFlow.equals("Continue")) {			
			System.out.println("button is continue button");
			Thread.sleep(200);
			driver.findElement(By.id("continue-btn")).click();
			log.info("<-- Clicked on Continue Button -->");
			//Thread.sleep(6000);
		}
		
		if(offerFlow.equals("Create Waitlist")){
			System.out.println("button is Create Waitlist");
			driver.findElement(By.xpath("/html/body/app-root[1]/div/app-offers-display/div/main/app-offers-list/section[2]/app-vacation-calendar/div[1]/div/div[2]/mwl-calendar-month-view/div/div/div[2]/div/mwl-calendar-month-cell[3]")).click();
			Thread.sleep(4000);
			String offerFlow1=driver.findElement(By.id("continue-btn")).getText();
			if(offerFlow1.equals("Continue")) {
				driver.findElement(By.id("continue-btn")).click();
			}
			if(offerFlow.equals("Create Waitlist")) {
				System.out.println("button is create waitlist so have to change calendar date [Find Offers ->line 29]");
			}
		}	
		
		log.info("********** FIND OFFER COMPLETED **********");
		}


}
