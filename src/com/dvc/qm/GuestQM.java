package com.dvc.qm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuestQM {
	
	public void performGuestQM(WebDriver driver, String Acknoledgement) throws InterruptedException {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(d -> d.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[1]/div[2]/div/span[1]/a")).isDisplayed());
	    Thread.sleep(3000);
	    
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation-summary/div/main/section/div/div[3]/div[1]/div/div[1]/span[2]/a")).click();
	    Thread.sleep(3000);
	    //Add guest
	    driver.findElement(By.className("action-link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("save-exit-btn")).click();
		Thread.sleep(7000);
		String res_summaryURL = "https://stage.dvc-ubi.wdprapps.disney.com/reservation-summary";
		if(driver.getCurrentUrl().equals(res_summaryURL)) {
	    	System.out.println("<-- QUICK MODIFY OF GUEST EDIT COMPLETED -->");
	    }
				
	}

}
