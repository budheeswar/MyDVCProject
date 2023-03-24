package com.dvc.output;

import org.apache.log4j.Logger;

import com.dvc.BookingRequest;
import com.dvc.screenshot.CaptureImage;

public class GenerateData {
	Logger log = Logger.getLogger(GenerateData.class);
	
	public String build(String Reservation_info, BookingRequest request) throws InterruptedException {
		
		log.info("********** GENERATING DATA **********");
		
		String resNo = Reservation_info.replace("Reservation #", "");
		String testData = request.MembershipID+"/m:"+request.MemberID+"&r:"+resNo;
		
		switch(request.prodCategory) {
		case "dci":
			this.generateDCIData(testData , request);
			break;
		case "dlr":
			this.generateDLRData(testData , request);
			break;
		case "dlp":
			this.generateDLPData(testData , request);
			break;
		case "hkdr":
			this.generateHKDRData(testData , request);
			break;
		case "tkdr":
			this.generateTKDRData(testData , request);
			break;
		default:
			System.out.println("DVC Reservation");
			this.generateDVCData(testData , request);
		}
		
		System.out.println();
		System.out.println();
		
		log.info("<-- TESTDATA = "+testData);
		log.info("********** DBS Reservation Booking Successfully Completed  **********");
		return testData;
		
	}
	private void generateTKDRData(String data , BookingRequest request) {
		System.out.println("##################################### DETAILS #############################");
		System.out.println("DCNI-TKDR "+request.productName+"   TEST_DATA = "+data+"&s:RESMGMT   Book ");
		
	}
	private void generateHKDRData(String data , BookingRequest request) {
		System.out.println("##################################### DETAILS #############################");
		System.out.println("DCNI-HKDR "+request.productName+"   TEST_DATA = "+data+"&s:RESMGMT   Book ");
		
	}
	private void generateDLPData(String data , BookingRequest request) {
		System.out.println("##################################### DETAILS #############################");
		System.out.println("DCNI-DLP "+request.productName+" TEST_DATA = "+data+"&s:RESMGMT   Book ");
		
	}
	private void generateDLRData(String data, BookingRequest request) {
		System.out.println("##################################### DETAILS #############################");
		System.out.println("DCNI-DLR "+request.productName+" TEST_DATA = "+data+"&s:RESMGMT   Book ");
		
		
	}
	public void generateDVCData(String data, BookingRequest request) {
		if(request.isEIEnabled == true && request.isAdaRequested == true ) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-EI-MP ,"+request.productName.toUpperCase()+" , ADA      TEST_DATA = "+data+"&s:DREAMS_TPS Book");
		}
		else if(request.isEIEnabled == true && request.isAdaRequested == false) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-EI-MP ,"+request.productName.toUpperCase()+" , Non ADA      TEST_DATA = "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == false && request.isAdaRequested == false && request.productName != "gcal") {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-MP ,"+request.productName.toUpperCase()+" , Non ADA    TEST_DATA =  "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == false && request.isAdaRequested == false && request.productName == "gcal") {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-MP ,"+request.productName.toUpperCase()+" , Non ADA    TEST_DATA =  "+data+"&s:DLRTBX  Book");
		}
		
		else if(request.isEIEnabled == false && request.isAdaRequested == true && request.productName != "gcal") {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-MP ,"+request.productName.toUpperCase()+" , ADA     TEST_DATA = "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == false && request.isAdaRequested == true && request.productName == "gcal") {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DVC-MP ,"+request.productName.toUpperCase()+" , ADA     TEST_DATA = "+data+"&s:DLRTBX  Book");
		}
		
		
	}
	public void generateDCIData(String data, BookingRequest request) {
		String response = "";
		if(request.isEIEnabled == true && request.isAdaRequested == true) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DCI-EI-MP "+request.productName.toUpperCase()+" ADA     TEST_DATA = "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == true && request.isAdaRequested == false) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DCI-EI-MP "+request.productName.toUpperCase()+" Non ADA     TEST_DATA = "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == false && request.isAdaRequested == false) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DCI-MP "+request.productName.toUpperCase()+" Non ADA     TEST_DATA = "+data+"&s:DREAMS_TPS  Book");
		}
		else if(request.isEIEnabled == false && request.isAdaRequested == true) {
			System.out.println("##################################### DETAILS #############################");
			System.out.println("DCI-MP "+request.productName.toUpperCase()+"  ADA       TEST_DATA =  "+data+"&s:DREAMS_TPS  Book");
		}
		
	}

}
