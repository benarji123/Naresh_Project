package functions;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import io.github.bonigarcia.wdm.WebDriverManager;





public class TestBase extends ReusableFunctions{
	public static String BrowserGUI;

	public static String Url;
	public static String Ep_name;
	static String orderready="No";
	public int executerows;
	public static String SystemType;
	//public static SoftAssert sa = new SoftAssert();
	static String orderlineNumber;
	static String repeatOrdr;
	static String repeatedProvinces;	
	public static int OrdersCount;
	public static int nextNumber;
	public int orderloop;
	public static String AssertValue="No";
	public static String OrderSame="No";
	static String[] ListofRPs;
	public static int repeatloop;
	public static int repeatcount=0;
	public static int orderline=1;
	public static int order=1;
	public static int ordertestcount=StartRow;
	public static ArrayList<String> VersionEpisodeNames=new ArrayList<String>();
	public static ArrayList<String> CreatedEpisodeList=new ArrayList<String>();
	public static String assetTitleString;
	public static String assetTypeString;
	public static int row;
	public static Actions action;
	public static String FilmTrackProjectID;
	//Launch browser and application
	public static  void launch() throws Exception {
		String BrowserName = null;

		for(int browserloop=1;browserloop<rowCount;browserloop++) {
			if(readdata[browserloop][1].equalsIgnoreCase("Yes")) {
				BrowserName = readdata[browserloop][0].toString();
				BrowserGUI=readdata[browserloop][3];

				break;
			}else if(readdata[browserloop][2].equalsIgnoreCase("Yes")) {
				BrowserName = readdata[browserloop][0].toString();
				System.out.println("Set Default browser to : "+BrowserName);

				BrowserGUI=readdata[browserloop][3];


				break;
			}else {
				if(browserloop==ReadexcelFile.rowCount){
					System.out.println("Browser Not Selected So Default "+BrowserName+" browser was launched");
					BrowserGUI=readdata[2][3];


				}
			}

		}
		launchBrowser(BrowserName); // Launch FireFox
		readUrl();
		driver.get(Url); // Enter Url in the address


	}

	public static String readUrl() throws Exception {
		//read Url from Excel
		int rownumber;
		readOneExcel("URL");
		System.out.println("getDatafromJson(\"Stystem\") :: "+getDatafromJson("Stystem")+"----"+getDatafromJson("Environment"));
		for(rownumber=1; rownumber<rowCount;rownumber++) {
			if(readdata[rownumber][3].toString().equalsIgnoreCase(getDatafromJson("Stystem"))&&readdata[rownumber][0].toString().equalsIgnoreCase(getDatafromJson("Environment"))) {
				SystemType=getDatafromJson("Stystem");
				break;
			}
		}
		System.out.println("Url need to Validate is :: "+readdata[rownumber][1].toString());
		return Url=readdata[rownumber][1].toString();

	}

	public static void LaunchandLogin() {
		try {
			//readExcel("Launch");
			readOneExcel("Launch");
			launch();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectValueFromDropdownUsingVisibleText(WebElement element, String visibleText) {
		try {
			waitForVisible(element);
			element.click();
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			System.out.println("Premier Year Dropdown was not present");
		}

	}

	//Launching browser based on input
	@SuppressWarnings("deprecation")
	public static  void launchBrowser(String BrowserName) {

		if(BrowserName.equalsIgnoreCase("Firefox")) {
			// System Property for Firefox Driver   
			System.setProperty("webdriver.gecko.driver",ProjectPath+"\\drivers\\geckodriver.exe");
			// Instantiate a Firefox class.  
			driver = new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("chrome")) {
			// System Property for Chrome Driver   
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			//options.addExtensions (new File(Projectpath+"\\Extentions\\extension_1_0_32_0.crx"));
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver(capabilities);  
		}if(BrowserName.equalsIgnoreCase("IE")) {
			// System Property for IE Driver   
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			// Instantiate a IE class.  
			driver = new InternetExplorerDriver();

		}else {
			System.out.println("Specified Driver is not correct, Please check once");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}



	public  void getOrderlist() {

		try {
			//read data from Order_Creation sheet

			readExcel("MultipleExecution");
			StartRow=Integer.parseInt(readdata[1][0]);
			StartRow=StartRow-1;

			EndRow=Integer.parseInt(readdata[1][1]);
			EndRow=EndRow-1;
			readExcel("Order_Creation"); // Read from excel and get order list
			ordertestcount=Integer.parseInt(readdata[StartRow][0]);
			OrdersCount=Integer.parseInt(readdata[EndRow][0]);
			System.out.println("Order Count : "+OrdersCount);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void setTextUsingRobotClass(String text, WebElement element) throws AWTException {
		Actions action = new Actions(driver);
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		element.sendKeys(Keys.ENTER);
		action.sendKeys(element, Keys.chord(Keys.CONTROL, "v")).build().perform();
		element.sendKeys(Keys.TAB);
	}





	//Capture Screenshot
	public void CaptureScreenShot(String FileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/"+FileName+".png"));
		System.out.println("the Screenshot is taken");

	}

	//Public get Start and End Time
	public void StartandEndTime(int timegap) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss"+"-00:00");
		format.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		StartTime=format.format(date);
		String [] Stime = StartTime.split(",");
		StartTime =Stime[0]+"T"+Stime[1];
		System.out.println(StartTime);


		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, timegap);
		format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss"+"-00:00");
		EndTime=format.format(cal.getTime());
		Stime = EndTime.split(",");
		EndTime =Stime[0]+"T"+Stime[1];
		System.out.println(EndTime);
	}

	public void clearall() {
		Result.clear();
		rowCount=orderline;
	}

	public static void RunWinAppDriver() {
		String command = ProjectPath+"\\drivers\\Winium.Desktop.Driver.exe";
		ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
		try {
			builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Launching Application function
	public static void LaunchingApplication() throws Exception {
		RunWinAppDriver();
		Thread.sleep(2000);
		DesktopOptions option = new DesktopOptions();

		option.setApplicationPath(ProjectPath+"\\WOPApps\\STAGE-WOP.rdp");

		Windriver = new WiniumDriver(new URL("http://localhost:9999"), option);

		Thread.sleep(5000);
		
	}



}
