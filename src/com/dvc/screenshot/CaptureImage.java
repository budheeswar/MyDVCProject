package com.dvc.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dvc.BookingRequest;
import com.google.common.io.Files;

public class CaptureImage {
	Logger log = Logger.getLogger(CaptureImage.class);

	public void takeScreenshotAsJPG(WebDriver driver, BookingRequest request) throws IOException {
		
		log.info("********** TAKING SCREENSHOT **********");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat sdf = new SimpleDateFormat(" HH_mm_ss");
		Date d =new Date();
		String date = sdf.format(d);
		String imgName = "";
		if(request.isEIEnabled == true) {
			imgName= request.prodCategory.toUpperCase()+"-EI "+request.productName.toUpperCase()+date;
		}
		else {
			imgName= request.prodCategory.toUpperCase()+" "+request.productName.toUpperCase()+date;
		}
		
		
		
		Files.copy(file, new File("C:\\Users\\RAJOB001\\selenium\\AutomateScreenshots\\"+imgName+".jpg"));
		log.info("<-- Screenshot saved in  C:\\Users\\RAJOB001\\selenium\\AutomateScreenshots\\"+imgName+".jpg");
		
		log.info("********** TAKING SCREENSHOT COMPLETED **********");
	}

}
