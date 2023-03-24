package com.dvc.sambath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DBSAutomate {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://stage.dvc-ubi.wdprapps.disney.com/home/478020620012/m:738227");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//input[@id='login-username']"));
		login.sendKeys("test123@disney.com");
		driver.findElement(By.id("login-next")).click();
		Thread.sleep(200);
		driver.findElement(By.id("login-password")).sendKeys("Mickeyminnie123");
		driver.findElement(By.id("login-submit")).click();	
		Thread.sleep(800);
		driver.manage().window().maximize();
		//JavascriptExecutor jk=(JavascriptExecutor)driver;
//		jk.executeScript("document.body.style.zoom='90%'");
		Thread.sleep(1000); 
		WebElement category = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#productCategory').shadowRoot.querySelector('#inputContainer > i')");
		//WebElement category1 = (WebElement) jk.executeScript("return document.querySelector('#productCategory').shadowRoot.querySelector('#input')");
		Thread.sleep(600);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",category);
		Thread.sleep(1200);
		WebElement DCL = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#productCategory').shadowRoot.querySelector('#b983315681 > div')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",DCL);
		Thread.sleep(800);
		WebElement offering = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#vessel').shadowRoot.querySelector('#inputContainer > i')");
		//WebElement offering = (WebElement) jk.executeScript("return document.querySelector('#offerings').shadowRoot.querySelector('#input')");
		//Thread.sleep(800);
		//WebElement product = (WebElement) jk.executeScript("return document.querySelector('#vessel').shadowRoot.querySelector('#selectAll > div')");	
		Thread.sleep(800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",offering);
		Thread.sleep(1000);
//		String product1 =("return document.querySelector('#vessel').shadowRoot.querySelector('#b1432020255 > div')");	
//		WebElement hkdrCheckboxElement = (WebElement) ((JavascriptExecutor) driver).executeScript(product1);
//		Thread.sleep(1000);
//		hkdrCheckboxElement.click();
		
		WebElement Selectall = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#vessel').shadowRoot.querySelector('#selectAll > div')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Selectall);	
		
//		WebElement vessal = (WebElement) jk.executeScript("return document.querySelector('#vessel').shadowRoot.querySelector('#b1432020255 > div')");
//		Thread.sleep(1000);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();",vessal);	
		Thread.sleep(800);
		WebElement date = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-home > div > main > section > app-search > form > app-travel-selection-itinerary > form > div > div.departure-months > div > div.month-range-calendar.form-field > div.next-month > div.month-wrapper > span:nth-child(4)')");
		//Thread.sleep(800);
		//String name = "arugments[0].setAttribute('value','4')";

		//Thread.sleep(800);
		//((JavascriptExecutor)driver).executeScript(name,offering);

		//((JavascriptExecutor)driver).executeScript("arugments[0].click();",product);
		Thread.sleep(800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",date);
		Thread.sleep(800);	
		WebElement Findoffer = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#initiate-btn')");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Findoffer);
		
		
// Result offer Page 
		
		//Thread.sleep(40000);
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait.until(d -> d.getCurrentUrl().equals("https://stage.dvc-ubi.wdprapps.disney.com/offers/display"));
	    Thread.sleep(5000);
		//WebElement search = (WebElement) jk.executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-offers-display > div > main > app-itinerary-offers-list > section > div > div.content.space-between > div:nth-child(1) > div.dcl-requested-offer--close > span.h4-heavy.hand-cursor')");
		WebElement search1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-offers-display > div > main > app-itinerary-offers-list > section > div > div.content.space-between > div:nth-child(4) > div.dcl-requested-offer--close > span.h4-heavy.hand-cursor')");
		System.out.println("sambath");
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",search1);

//		Thread.sleep(9800);
//		WebElement search1 = (WebElement) jk.executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-offers-display > div > main > app-itinerary-offers-list > section > div > div.content.space-between > div:nth-child(2) > div.dcl-requested-offer--close > span.accordion-icon')");
//		System.out.println("sambath");
//		Thread.sleep(800);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();",search1);

		Thread.sleep(2800);
		WebElement Dates = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-offers-display > div > main > app-itinerary-offers-list > section > div > div.content.space-between > div:nth-child(2) > div.dcl-requested-offer-wrapper > form > div > div.search-criteria > div.flex > div > div.pos-relative.width-240px > div > span > span.custom-multi-select-arrow.show-dates--close')");
		Thread.sleep(800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Dates);
		
		Thread.sleep(2000);
		WebElement dateselect = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-offers-display > div > main > app-itinerary-offers-list > section > div > div.content.space-between > div:nth-child(2) > div.dcl-requested-offer-wrapper > form > div > div.search-criteria > div.flex > div > div.pos-relative.width-240px > div > span > div > div')");
		Thread.sleep(800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",dateselect);
//		
//		Thread.sleep(800);
//		WebElement scrolldown = (WebElement) jk.executeScript("return document.querySelector('#continue-btn')");
//		Thread.sleep(800);
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollInfoView(true)",scrolldown);
		
		//jk.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(1800);
		WebElement Accommodation = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#accomodation')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Accommodation);
		
		Thread.sleep(3800);
		WebElement Accommodationselect = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#accomodation > option:nth-child(2)')");
		Thread.sleep(1800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Accommodationselect);
//        Select Acc= new Select(Accommodation);
//        Acc.selectByVisibleText("3A - Concierge Family Oceanview Stateroom with Verandah");
        
		Thread.sleep(1800);
		WebElement taggle = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#switch').shadowRoot.querySelector('div > div > div.switch-bar')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",taggle);
        
		Thread.sleep(1800);
		WebElement Contiune = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#continue-btn')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Contiune);
		
		
// Guest Screen  ---------------------------------------------------------------
		
// Add guest 1
		Thread.sleep(6000);
		WebElement add = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('#tab-group > div > div:nth-child(1) > div > div > div.flex > div > div:nth-child(5) > a > span.padding-left-10px')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",add);
	
//		Thread.sleep(2800);
//		WebElement add1 = (WebElement) jk.executeScript("return document.querySelector('#continue-btn')");
// Add guest 2		
		Thread.sleep(800);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",add);
		
// Update Guest details 
		Thread.sleep(1000);
		WebElement update = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('body > app-root:nth-child(1) > div > app-reservation > div > main > section.full-panel.flex > section.right-panel > app-reservation-recap > div > app-guest-summary > div.guest-summary-wrapper > div:nth-child(2) > div > div.guest-data > div.guest-name > a')");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",update);
		


	}

}
