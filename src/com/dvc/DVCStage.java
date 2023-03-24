package com.dvc;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.dvc.cancel.CancellationClass;
import com.dvc.driver.SetUpDBSDriver;
import com.dvc.login.LoginScreen;
import com.dvc.output.GenerateData;
import com.dvc.screenshot.CaptureImage;

public class DVCStage {
		
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
		Logger log = Logger.getLogger(DVCStage.class);
		log.info("***************************************  STARTING   **********************************************");
		
		BookingRequest request = new BookingRequest();
		
		String homeURL = "https://stage.dvc-ubi.wdprapps.disney.com/home/";
		String url = homeURL+request.MembershipID+"/m:"+request.MemberID+"";  
		
		SetUpDBSDriver driverSetUp=new SetUpDBSDriver();
		WebDriver driver = driverSetUp.initiateDriver(url);
		

        LoginScreen login=new LoginScreen();
        login.doLoginProcess(driver);
        Thread.sleep(8000);
        
		
		BookReservationProcess  book= new BookReservationProcess();
		String reservationInfo = book.completeBooking(driver, request);
		System.out.println("Reservation Info  "+reservationInfo);		
		Thread.sleep(2000);
		
		CaptureImage ss = new CaptureImage();
		ss.takeScreenshotAsJPG(driver, request);
		
		GenerateData data = new GenerateData();
		String testData = data.build(reservationInfo,request); // prints testdata in console
		
		
		if(request.cancelReservation == true) {
			String cancelURL = homeURL+testData;
			CancellationClass cancel = new CancellationClass();
			cancel.doCancelReservation(driver, cancelURL, request);
		}
		
		
				

	}

}
