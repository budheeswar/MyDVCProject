package com.dvc.guest;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvc.productselect.prodlist.ProductInfo;

public class GuestListHandler {
	Logger log = Logger.getLogger(GuestListHandler.class);

	public void doGuestProcess(WebDriver driver) throws InterruptedException {
		//System.out.println("********** INSIDE GUEST HANDLING **********");
		log.info("********** INSIDE GUEST PAGE **********");
		// click add
//	    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
//	    wait.until(d -> d.findElement(By.xpath("/html/body/app-root[1]/app-activity-indicator/div/div[1]/div[2]")).isDisplayed());
		Thread.sleep(5000);
		driver.findElement(By.className("action-link")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html/body/app-root[1]/div/app-reservation/div/main/section[2]/section[2]/app-reservation-recap/div/app-guest-summary/div[2]/div[2]/div/div[1]/div[1]/a"))
				.click();
		Thread.sleep(3000);
		WebElement age_select = driver.findElement(By.id("age"));
		Select age = new Select(age_select);
		age.selectByVisibleText("Adult-P");
		log.info(" <-- selected Adult-P  -->");
		
		Thread.sleep(900);
		// System.out.println("before");

		driver.findElement(By.id("add-guest-btn")).click();
		// System.out.println("after");
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"/html/body/app-root[1]/div/app-reservation/div/main/section[2]/section[2]/app-reservation-recap/div/app-guest-summary/div[1]/span[1]/a[1]/img"))
				.click();
		Thread.sleep(300);
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation/footer/wdpr-button[2]")).click();
		Thread.sleep(3000);
		log.info("********** LOGIN PAGE COMPLETED **********");

	}

}
