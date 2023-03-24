package com.dvc.productselect.prodlist;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dvc.productselect.ProductClicking;

public class ProductInfo {
	Logger log = Logger.getLogger(ProductInfo.class);

	String productQuery = "";

	public void selectProduct(String productName, WebDriver driver, boolean isADARequested, String prodCategory)
			throws InterruptedException {
		log.info("********** INSIDE INDIVIDUAL PRODUCT CHOOSING **********");
		switch (prodCategory) {
		case "dci":
			productQuery = this.goToDCISwitch(productName, driver, isADARequested, prodCategory);
			break;
		case "dlr":
			productQuery = this.goToDLRSwitch(productName, driver, isADARequested, prodCategory);
			break;
		case "dlp":
			productQuery = this.goToDLPSwitch(productName, driver, isADARequested, prodCategory);
			break;
		case "hkdr":
			productQuery = this.goToHKDRSwitch(productName, driver, isADARequested, prodCategory);
			break;
		case "tkdr":
			productQuery = this.goToTKDRSwitch(productName, driver, isADARequested, prodCategory);
			break;
		default:
			productQuery = this.goToDVCSwitch(productName, driver, isADARequested, prodCategory);
			break;
		}

		Thread.sleep(1000);
		WebElement product = (WebElement) ((JavascriptExecutor) driver).executeScript(productQuery);
		Thread.sleep(200);
		product.click();
		String pName = product.getText();
		Thread.sleep(2000);
		if (isADARequested == true) {
			System.out.println("ADA REQUESTED");
			this.selectADA(driver, isADARequested);
		}
		log.info("**********  SELECTED --> "+pName+" **********");

	}
	public void selectADA(WebDriver driver, boolean isADARequested) throws InterruptedException {
		log.info("********** SELECTING ADA **********");
		
		driver.findElement(By.xpath(
				"/html/body/app-root[1]/div/app-home/div/main/section/app-search/form/app-product-search/form/div[1]/div[4]/div[2]/span/img"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/app-root[1]/div/app-home/div/main/section/app-search/form/app-product-search/form/div[1]/div[4]/div[2]/div/div[3]/label/span[1]"))
				.click();
		Thread.sleep(1000);
		
		log.info("********** ADA SELECTION COMPLETED **********");
		
	}


	private String goToTKDRSwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		//log.info("********** INSIDE INDIVIDUAL PRODUCT CHOOSING **********");
		String pQuery = "";
		switch (productName) {
		case "disney ambassador hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b703105623 > div\")";
			log.info("********** SELECTED DISNEYLAND AMBASSADOR HOTEL **********");
			break;
		case "tokyo disney celebration":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1238514576 > div\")";
			log.info("********** SELECTED tokyo disney celebration **********");
			break;
		case "toy story":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b102278131 > div\")";
			log.info("********** SELECTED TOY STORY **********");
			break;
		case "miracost":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b2024621770 > div\")";
			log.info("********** SELECTED MIRACOST **********");
			break;
		case "tokyo disneyland hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1066315330 > div\")";
			log.info("********** SELECTED TOKYO DISNEYLAND HOTEL **********");
			break;

		default:
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1066315330 > div\")";
			log.info("********** SELECTED TOKYO DISNEYLAND HOTEL **********");// tokyo
																															// disney
																															// land
																															// hotel
			break;
		}
		return pQuery;
	}

	private String goToHKDRSwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		String pQuery = "";
		switch (productName) {
		case "disney explorers lodge":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1619343767 > div\")";
			log.info("********** SELECTED DISNEY EXPLORERS LODGE **********");
			break;
		case "disney hollywood hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b11957768 > div\")";
			log.info("********** SELECTED DISNEY HOLLYWOOD HOTEL **********");
			break;
		case "hongkong disneyland hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1830950279 > div\")";
			log.info("********** SELECTED HONGKONG DISNEYLAND HOTEL **********");
			break;
		default:
			pQuery = "return document.querySelector(\\\"#childProduct\\\").shadowRoot.querySelector(\\\"#b1619343767 > div\\\")";
			log.info("********** DEFAULT SELECTED DISNEY EXPLORERS LODGE **********");
			break;
		}
		return pQuery;

	}

	private String goToDLPSwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		String pQuery = "";
		switch (productName) {
		case "village nature paris":
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1843897467 > div\")";
			log.info("********** SELECTED VILLAGE NATURE PARIS **********");
			break;
		case "disneyland hotel paris":
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b360755760 > div\")";
			log.info("********** SELECTED DISNEYLAND HOTEL PARIS **********");
			break;
		case "disney sequoia lodge":
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b736082589 > div\")";
			log.info("********** SELECTED DISNEY SEQUOIA LODGE **********");
			break;
		case "hotel newyork":
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1523165261 > div\")";
			log.info("********** SELECTED HOTEL NEWYORK **********");
			break;
		case "newport bay club":
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b63360145 > div\")";
			log.info("********** SELECTED NEWPORT BAYCLUB **********");
			break;
		default:
			pQuery = " return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1843897467 > div\")";
			log.info("********** SELECTED VILLAGE NATURE PARIS **********");
			break;

		}
		return pQuery;
	}

	private String goToDLRSwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		String pQuery = "";
		switch (productName) {
		case "disneyland hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b747193764 > div\")";
			log.info("********** SELECTED DISNEYLAND HOTEL **********");
			break;
		case "paradise pier hotel":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b866541433 > div\")";
			log.info("********** SELECTED PARADISE PIER HOTEL **********");
			break;
		default:
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b747193764 > div\")";
			log.info("********** DEFAULT SELECTED DISNEYLAND HOTEL **********");
			break;
		}
		return pQuery;

	}

	private String goToDVCSwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		String pQuery = "";
		switch (productName) {
		case "beach club":
//			if (prodCategory.equalsIgnoreCase("dci")) {
//				productQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1019961653 > div\")";
//				break;
//			}
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1322837947 > div\")";
			break;
		case "aulani":
//			if (prodCategory.equalsIgnoreCase("dci")) {
//				productQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1443236464 > div\")"; // dci
//				break;																													// aulani
//			}			
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b370647010 > div\")"; // dvc
			break;
		case "bay lake":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b2086124816 > div\")";
			break;
		case "old key":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b402929163 > div\")";
			break;
		case "gcal":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b2140035769 > div\")";
			break;
		case "saratoga":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b363250748 > div\")";
			break;
		case "boulder":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1149620713 > div\")";
			break;
		case "riviera":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1162165914 > div\")";
			break;
		case "hilton":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b491874607 > div\")";
			break;

		default:
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1322837947 > div\")";
			break;
		}
		return pQuery;

	}

	private String goToDCISwitch(String productName, WebDriver driver, boolean isADARequested, String prodCategory) {
		String pQuery = "";
		switch (productName) {
		case "beach club":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1019961653 > div\")";
			break;

		case "aulani":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b1443236464 > div\")"; // dci
			break;
		case "all star music":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b305916067 > div\")";
			break;
		case "coronado":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b526224369 > div\")";
			break;
		case "yacht":
			pQuery = "return document.querySelector(\"#childProduct\").shadowRoot.querySelector(\"#b393104515 > div\")";
			break;
		}
		return pQuery;

	}

	
}
