package com.dvc;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.dvc.category.ProductCategory;
import com.dvc.comment.CommentScreenHandler;
import com.dvc.date.DatePicker;
import com.dvc.findoffer.FindOffers;
import com.dvc.guest.GuestListHandler;
import com.dvc.login.LoginScreen;
import com.dvc.payment.PaymentScreenHandler;
import com.dvc.productselect.ProductClicking;
import com.dvc.reservation.ExtractReservationNumber;

public class BookReservationProcess {
	
	public String completeBooking(WebDriver driver, BookingRequest request) throws InterruptedException {
		
		Logger log = Logger.getLogger(BookReservationProcess.class);
		log.info("***************** INSIDE BOOKING RESERVATION PROCESS ****************");
		
		ProductCategory category = new ProductCategory();
		category.selectCategory(driver, request);
		Thread.sleep(2000);

		ProductClicking prodClick=new ProductClicking();
		prodClick.doProductSelecting(driver, request);
		Thread.sleep(1000);
		 
		
		DatePicker date=new DatePicker();
		date.doDatePicking(driver,request);
		Thread.sleep(1000);
		
		FindOffers offers= new FindOffers();
		offers.doFindOffers(driver);
		//Thread.sleep(15000);
		
		GuestListHandler guestPage=new GuestListHandler();
		guestPage.doGuestProcess(driver);
		Thread.sleep(1000);
		
		CommentScreenHandler commentPage=new CommentScreenHandler();
		commentPage.doCommentProcess(driver);
		Thread.sleep(1000);
		
		PaymentScreenHandler paymentPage=new PaymentScreenHandler();
		paymentPage.doPaymentSequencing(driver);
		Thread.sleep(1000);
		
		ExtractReservationNumber reservation=new ExtractReservationNumber();
		String reservation_Info=reservation.getReservationInfo(driver);
		log.info("*****************  BOOKING RESERVATION PROCESS COMPLETED ****************");
		return reservation_Info; 
	}

}
