package execution;


import java.io.FileNotFoundException;
import java.io.IOException;
//import java.text.DateFormat;
//import java.text.DateFormatSymbols;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import pageObject.WOPVersionadd;


public class CreateAset extends WOPVersionadd {
	
	public static boolean test;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		try {
			//imageFindandread("AMCNIDForVersion.PNG",10,"right",100);
			
			test(8);
			lauchWOP("EpisodeName","VersionName");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
 		
		try {
			createDataSheet_RemovePrevious("FT");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Launch Browser
	//LaunchandLogin();
		System.setProperty("webdriver.ie.driver", "D:\\MyWorkPlace\\com.AMC.Monocept\\drivers\\IEDriverServer_380.exe"); 
//		InternetExplorerOptions options = new InternetExplorerOptions();
//        options.useCreateProcessApiToLaunchIe();
//        options.addCommandSwitches("-k");
//        InternetExplorerDriver driver = new InternetExplorerDriver(options);
//        try {
//            driver.get("https://google.com/ncr");
//            Capabilities caps = driver.getCapabilities();
//            System.out.println(caps);
//        } finally {
//            driver.quit();
//        }
		
	
//	System.setProperty("webdriver.ie.driver", "D:\\MyWorkPlace\\com.AMC.Monocept\\drivers\\IEDriverServer_new.exe"); 
    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();  
    capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);  
    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
 
    capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
    capabilities.setCapability("requireWindowFocus", true);
    WebDriver driver = new InternetExplorerDriver(capabilities);
    driver.get("https://www.google.com");
	}

	public static boolean test(int result) {
	
		if(result>10) {
			
			return test= true;
			
		}else {
			
			return test= false;
		
		}
		
		
		
		
	}
}
