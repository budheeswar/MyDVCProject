package com.dvc.driver;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dvc.DVCStage;

public class SetUpDBSDriver {
	
	
	
	public WebDriver initiateDriver(String url) throws InterruptedException {
		Logger log = Logger.getLogger(SetUpDBSDriver.class);
		log.info("******* INITIALISING   WEB DRIVER ******");
		
		System.out.println("***** INSIDE DRIVER SETUP *****");
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // opens chrome
		
		log.info("STAGE URL "+url);
		driver.get(url);  // Enters STAGE URL
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("***** DRIVER SETUP COMPLETED *****");
		log.info("******* INITIALISING   WEB DRIVER COMPLETED ******");
		return driver;
		
	}

}
