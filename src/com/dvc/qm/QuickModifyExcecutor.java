package com.dvc.qm;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.dvc.driver.SetUpDBSDriver;
import com.dvc.login.LoginScreen;

public class QuickModifyExcecutor {
	

	public static void main(String[] args) throws InterruptedException {
		Logger log = Logger.getLogger(QuickModifyExcecutor.class);
		
		
		
		log.info("********** PERFORMING QUICK MODIFY ********");
		String url = "https://stage.dvc-ubi.wdprapps.disney.com/home/477560151138/m:738253&r:522721219915&s:DREAMS_TPS";
		SetUpDBSDriver driverSetUp=new SetUpDBSDriver();
		WebDriver driver = driverSetUp.initiateDriver(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		
		//Login handling
		LoginScreen login=new LoginScreen();
	    login.doLoginProcess(driver);
	    Thread.sleep(8000);	    
	    
	    CommentQM cqm = new CommentQM();
	    cqm.performCommentQM( driver, "CQM");
	    Thread.sleep(5000);
	    
	    GuestQM gqm= new GuestQM();
	    gqm.performGuestQM(driver, "GQM");
	    Thread.sleep(5000);
	    
	    TotalCostQM tqm = new TotalCostQM();
	    tqm.performTotalCostQM(driver, "TQM");
	    
	    log.info("*************  QUICK MODIFY FINISHED *************");
		
    
	    

	}

}
