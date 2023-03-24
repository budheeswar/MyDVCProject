package com.dvc.comment;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dvc.guest.GuestListHandler;

public class CommentScreenHandler {
	Logger log = Logger.getLogger(CommentScreenHandler.class);
	
	public void doCommentProcess(WebDriver driver) throws InterruptedException {
		log.info("********** INSIDE COMMENT HANDLER **********");
		//System.out.println("********** INSIDE COMMENT HANDLER **********");
		Thread.sleep(2500);
		driver.findElement(By.id("comment")).sendKeys(" TESTING COMMENT ");
		Thread.sleep(1000);
		driver.findElement(By.id("update-btn")).click();
		log.info("<-- added comment with \" TESTING COMMENT \" -->");
		Thread.sleep(900);
		driver.findElement(By.xpath("/html/body/app-root[1]/div/app-reservation/footer/wdpr-button[2]")).click();
		//Thread.sleep(5000);
		//System.out.println("********** COMMENTING FINISHED **********");
		log.info("********** COMMENTING FINISHED **********");
		}

}
