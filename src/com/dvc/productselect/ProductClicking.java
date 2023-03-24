package com.dvc.productselect;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvc.BookReservationProcess;
import com.dvc.BookingRequest;
import com.dvc.driver.SetUpDBSDriver;
import com.dvc.productselect.prodlist.ProductInfo;

public class ProductClicking {
	
	Logger log = Logger.getLogger(ProductClicking.class);
	
	
	public void doProductSelecting(WebDriver driver,BookingRequest request) throws InterruptedException {
		log.info("***************** INSIDE PRODUCT SELECTING ****************");
		Thread.sleep(1000);
		//Product Drop Down
		
		String query = "return document.querySelector('#childProduct').shadowRoot.querySelector('#inputContainer > i')";		 
		WebElement dropdown = (WebElement) ((JavascriptExecutor) driver).executeScript(query);
		Thread.sleep(500);
		dropdown.click();
        Thread.sleep(2000);        
        
        ProductInfo productname=new ProductInfo();
        productname.selectProduct(request.productName,driver,request.isAdaRequested,request.prodCategory);
        Thread.sleep(1000);
        if(request.isEIEnabled == true) {
			this.doEISelection(driver);
		}
        log.info("*****************  PRODUCT SELECTING FINISHED ****************");
        
		
		
	}
	public void doEISelection(WebDriver driver) throws InterruptedException {
		    log.info("***************** SELECTING EXCHANGE INBOUND CHECKBOX ****************");
			System.out.println("<-- EI REQUESTED -->");
			String eiQuery="return document.querySelector('#exchange-inbound').shadowRoot.querySelector('#checkmark')";
			WebElement eiElement = (WebElement) ((JavascriptExecutor) driver).executeScript(eiQuery);
			Thread.sleep(1000);
			eiElement.click();
			System.out.println("<-- EI CHECKLISTED -->");
			log.info("***************** SELECTING EXCHANGE INBOUND CHECKBOX FINISHED ****************");
		
	}

}
