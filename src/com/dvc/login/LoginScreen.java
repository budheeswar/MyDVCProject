package com.dvc.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dvc.driver.SetUpDBSDriver;

public class LoginScreen {
	
	public void doLoginProcess(WebDriver driver) throws InterruptedException {
		Logger log = Logger.getLogger(LoginScreen.class);
		log.info("***************** INSIDE LOGIN PAGE ****************");
		
	
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys("TEST119@disney.com"); // username
       
        log.info("<-- LOGIN WITH TEST119@DISNEY.COM -->");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/mat-card/mat-card-content/app-login/form/div[4]/div/button/span"))
				.click();// next

		Thread.sleep(500);
		driver.findElement(By.id("login-password")).sendKeys("Mickeyminnie123"); // password

		Thread.sleep(500);
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/mat-card/mat-card-content/app-login/form/div[3]/div/button/span"))
				.click(); // LoginWith my ID
		
		log.info("********************** LOGIN COMPLETED *********************");
	}

}
