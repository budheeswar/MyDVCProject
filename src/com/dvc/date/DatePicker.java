package com.dvc.date;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dvc.BookingRequest;

import io.opentelemetry.api.internal.StringUtils;

public class DatePicker {
	Logger log = Logger.getLogger(DatePicker.class);

	public void doDatePicking(WebDriver driver, BookingRequest request) throws InterruptedException {
		log.info("********** INSIDE DATE PICKING **********");
		//System.out.println("********** INSIDE DATE PICKING **********");
		
		//Date Icon
		String dateq = "return document.querySelector(\"#arrival-date\").shadowRoot.querySelector(\"#editable-input-container > wdpr-input\").shadowRoot.querySelector(\"#button-container > button > i\")";
		WebElement date = (WebElement) ((JavascriptExecutor) driver).executeScript(dateq);
		date.click();

		while (true) {
			// getting month element
			String monthQuery = "return document.querySelector(\"#arrival-date\").shadowRoot.querySelector(\"#calendar-container > div.calendar-header > span > span.month\")";
			WebElement monthElement = (WebElement) ((JavascriptExecutor) driver).executeScript(monthQuery);
			String current_month = monthElement.getText();

			if (current_month.equals(request.getRequired_month()) == true) {
				break;
			}
			Thread.sleep(500);
			// getting Pre-Month Element clicking button ->HardCoded
			String premonthquery = "return document.querySelector(\"#arrival-date\").shadowRoot.querySelector(\"#calendar-container > div.calendar-header > button:nth-child(1)\")";
			WebElement prevMonthElement = (WebElement) ((JavascriptExecutor) driver).executeScript(premonthquery);
			prevMonthElement.click();
		}
		Thread.sleep(1000);

		// getting day Element
		String dayQuery="";
		
		if(StringUtils.isNullOrEmpty(request.dayJSPathQuery)) { //if we not give jspath
			dayQuery = "return document.querySelector(\"#arrival-date\").shadowRoot.querySelector(\"#calendar-container > div.calendar-body > div.calendar > div:nth-child("+(request.day+1)+") > div\")";
			
		}
		
		else {
			dayQuery = request.dayJSPathQuery;  //if we give jspath
		}
		WebElement dayElement = (WebElement) ((JavascriptExecutor) driver).executeScript(dayQuery);
		Thread.sleep(2000);
		dayElement.click();
		log.info("<-- Selected DATE is "+request.required_month+" "+dayElement.getText()+" -->");
		//Thread.sleep(40000);
		//System.out.println("********** DATE PICKING COMPLETED **********");
		log.info("********** DATE PICKING COMPLETED **********");
	}

}
