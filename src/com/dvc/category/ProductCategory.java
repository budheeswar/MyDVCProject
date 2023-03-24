package com.dvc.category;

import java.time.Duration;
import java.time.Instant;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvc.BookReservationProcess;
import com.dvc.BookingRequest;

public class ProductCategory {
	static Logger log = Logger.getLogger(ProductCategory.class);
	

	public void selectCategory(WebDriver driver, BookingRequest request) throws InterruptedException {
		log.info("***************** INSIDE PRODUCT CATEGORY ****************");
		
		switch (request.prodCategory) {
		case "dci":
			this.selectDCI(driver, request.prodCategory);
			//System.out.println(" Selected DCI category ");
			break;
		case "dlr":
			this.selectDLR(driver, request.prodCategory);
			//System.out.println(" Selected DLR Category");
			break;
		case "dlp":
			this.selectDLP(driver, request.prodCategory);
			//System.out.println(" Selected DLP Category");
			break;
		case "hkdr":
			this.selectHKDR(driver, request.prodCategory);
			//System.out.println(" Selected HKDR Category");
			break;
		case "tkdr":
			this.selectTKDR(driver, request.prodCategory);
			//System.out.println(" Selected TKDR Category");
			break;
		default:
			//System.out.println(" choosing DEFAULT  DVC Villas category ");
			log.info("**********  choosing DEFAULT  DVC Villas category  **********");
			break;
		}
		log.info("**********  SELECTING PRODUCT CATEGORY FINISHED **********");
		//System.out.println("********** PRODUCT CATEGORY COMPLETED *********");
	}

	private void selectTKDR(WebDriver driver, String category) throws InterruptedException {
		log.info("********** INSIDE SELECTING TKDR **********");
		String categoryQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#inputContainer > i\")";
		WebElement categoryDropdownElement = (WebElement) ((JavascriptExecutor) driver).executeScript(categoryQuery);
		// Thread.sleep(200);
		categoryDropdownElement.click();
		Thread.sleep(1000);

		String tkdrQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#b1936310151 > div\")";
		WebElement tkdrCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(tkdrQuery);
		tkdrCheckboxElement.click();
		log.info("**********  SELECTING TKDR FINISHED **********");

	}

	private void selectHKDR(WebDriver driver, String category) throws InterruptedException {
		log.info("********** INSIDE SELECTING HKDR **********");
		String categoryQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#inputContainer > i\")";
		WebElement categoryDropdownElement = (WebElement) ((JavascriptExecutor) driver).executeScript(categoryQuery);
		// Thread.sleep(200);
		categoryDropdownElement.click();
		Thread.sleep(1000);

		String hkdrQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#b1812245205 > div\")";
		WebElement hkdrCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(hkdrQuery);
		hkdrCheckboxElement.click();
		log.info("**********  SELECTING HKDR FINISHED **********");

	}

	private void selectDLP(WebDriver driver, String category) throws InterruptedException {
		log.info("********** INSIDE SELECTING DLP **********");
		String categoryQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#inputContainer > i\")";
		WebElement categoryDropdownElement = (WebElement) ((JavascriptExecutor) driver).executeScript(categoryQuery);
		// Thread.sleep(200);
		categoryDropdownElement.click();
		Thread.sleep(1000);

		String dlpQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#b2120976097 > div\")";
		WebElement dlpCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(dlpQuery);
		dlpCheckboxElement.click();
		log.info("**********  SELECTING DLP FINISHED **********");

	}

	private void selectDLR(WebDriver driver, String category) throws InterruptedException {
		log.info("********** INSIDE SELECTING DLR **********");
		String categoryQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#inputContainer > i\")";
		WebElement categoryDropdownElement = (WebElement) ((JavascriptExecutor) driver).executeScript(categoryQuery);
		// Thread.sleep(200);
		categoryDropdownElement.click();
		Thread.sleep(1000);

		String dlrQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#b1137138455 > div\")";
		WebElement dlrCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(dlrQuery);
		dlrCheckboxElement.click();
		log.info("**********  SELECTING DLR FINISHED **********");

	}

	public void selectDCI(WebDriver driver, String category) throws InterruptedException {
		log.info("********** INSIDE SELECTING DCI **********");
		String categoryQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#inputContainer > i\")";
		WebElement categoryDropdownElement = (WebElement) ((JavascriptExecutor) driver).executeScript(categoryQuery);
		categoryDropdownElement.click();
		Thread.sleep(1000);
		String dciQuery = "return document.querySelector(\"#productCategory\").shadowRoot.querySelector(\"#b1069284717\")";
		WebElement dciCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(dciQuery);
		dciCheckboxElement.click(); // selecting dci
		log.info("********** INSIDE SELECTING DCI **********");

	}
	

}
