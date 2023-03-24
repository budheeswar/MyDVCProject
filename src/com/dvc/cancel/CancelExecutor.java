package com.dvc.cancel;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dvc.BookingRequest;
import com.dvc.driver.SetUpDBSDriver;
import com.dvc.login.LoginScreen;

public class CancelExecutor {
	
	public static void main(String[] args) throws InterruptedException  {
		Logger log = Logger.getLogger(CancelExecutor.class);
		BookingRequest request = new BookingRequest();
		
		String url = "https://stage.dvc-ubi.wdprapps.disney.com/home/486430619946/m:738253&r:508261&s:RESMGMT";
		SetUpDBSDriver driverSetUp=new SetUpDBSDriver();
		WebDriver driver = driverSetUp.initiateDriver(url);
		
		//Login handling
		LoginScreen login=new LoginScreen();
	    login.doLoginProcess(driver);
	    Thread.sleep(8000);
	   
	    CancellationClass cancel = new CancellationClass();
	    boolean status = cancel.doCancelReservation(driver, url, request);
	   
	    if(status == true) {
	    	System.out.println();
	    	System.out.println(" <-- Reservation Cancelled Successfully --> ");
	    	
	    	
	    }
	    
	    
	    
	    
	}
	

}
