package com.dvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.dvc.driver.SetUpDBSDriver;

public class GoogleAutomate {

	public static void main(String[] args) throws InterruptedException {
		String homeURL = "https://www.google.com/";
		//String url =   // globally we declared membership id
		SetUpDBSDriver driverSetUp=new SetUpDBSDriver();
		WebDriver driver = driverSetUp.initiateDriver(homeURL);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Buddeeswar", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/nav/div/div/div[1]/a[6]/span")).click();

	}

}
