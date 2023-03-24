package com.dvc.qm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TotalCostQM {
	
	public void performTotalCostQM(WebDriver driver, String Acknoledgement) throws InterruptedException {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(d -> d.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[1]/a")).isDisplayed());
	    Thread.sleep(3000);
	    
		//Total Cost Paid
	    driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[2]/div/div[1]/div[1]/span[2]/a/span[2]")).click();
	    Thread.sleep(7000);
	   // System.out.println(" Before URL "+driver.getCurrentUrl());
	    driver.findElement(By.id("continue-btn")).click();
	   
	    Thread.sleep(9000);
	    //System.out.println("URl "+driver.getCurrentUrl());
	    
	    String paymentURL = "https://stage.dvc-ubi.wdprapps.disney.com/reservation/reservation-payment";
	    String res_summaryURL = "https://stage.dvc-ubi.wdprapps.disney.com/reservation-summary";
	   
	    if(driver.getCurrentUrl().equals(res_summaryURL)) {
	    	System.out.println("<-- QUICK MODIFY OF TOTAL COST PAID EDIT COMPLETED -->");
	    }
	}

}
