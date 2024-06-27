package functions;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.testng.Assert;


public class ReusableFunctions extends ReadexcelFile{

	public static String path = null;	
	public static JSONObject jsonObject;

	//Function for Print the steps in allure report


	//	@Step("{0}")
	//	public static void logStepWithScreenshot(String stepName ){
	//		attachScreen(stepName);
	//	}
	//
	//	public static void selectBydropDown(WebElement ele, String value) {
	//		ele.click();
	//		Select paymentoption= new Select (ele);
	//		paymentoption.selectByVisibleText(value);
	//	}
	//	//Function for take the screen shot in allure report
	//	@Attachment("Screenshot")
	//	public static byte[] attachScreen(String Exception) {
	//		//logStep(Exception);
	//		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	//	}

	//enter Text in TextBox
	public void enterText(WebElement Ele,String Value) {
		try {
			waitForVisible(Ele);
			Ele.clear();
			Ele.sendKeys(Value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	//enter Text in TextBox
	public void clickonButton(WebElement Ele) {
		try {
			//waitForVisible(Ele);
			waitForlongVisible(Ele);
			waitForClickable(Ele);
			Ele.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//Mouse hover
	public static void mouseHover(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}


	public static void Scroll(String scrollType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(scrollType.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,1000)");
		}else  if(scrollType.equalsIgnoreCase("up")){
			js.executeScript("window.scrollBy(500,0)");
		}

	}



	//Wait for Page load check
	public static void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(pageLoadCondition);
	}

	//Scroll to Web Element
	public static void scrolltoElement(WebElement Elenent) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Elenent);

	}
	//Function for provide wait for loader image
	public static void waitforloadingDisable(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
	}

	public static void waitforloadingDisableinsuredDetailsPg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Img1")));
	}


	public static void waitforloadingDisableTW(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("typing_loader")));
	}	

	public static void waitforloadingDisablePaymentPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 750);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	}	

	//Wait functions
	public static WebElement waitTillElementVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}

	//Wait functions
	public static WebElement waitTilliFrameVisible(WebElement FrameName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameName));
		return elementloaded;
	}


	public static WebElement waitTillElementTobeLocated(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return elementloaded;
	}

	public static boolean waitTillElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e) {


			return false;
		}
	}
	public static  boolean waitForVisible(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static  boolean waitForlongVisible(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
			//wait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static  boolean waitForClickable(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static void waitForVisibleDropdown(List<WebElement> elements) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 25; i++) {
			try {
				if (elements.size() != 0) {
					break;
				} else {
					throw new Exception("list size is 0");
				}

			} catch (Exception e) {
				if (i == 25) {
					throw e;

				} else {
					Thread.sleep(1000);

				}
			}

		}
	}

	//Wait for Page Load
	public static void waitTillPageLoaded(WebDriver driver)  {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Click functionality by Java Script
	public static void clickByJS(WebElement el, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Move to Element Function 
	public static void moveToElement(WebElement element, WebDriver driver) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	// Point To Element
	public static void pointToElement(WebElement e1, WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
	}

	// Function for provide wait for VerifyPage Title
	public static void verifypageTitle(String str, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(str));
	}

	//Read Values from Input Json
	public static void readConfigValues() {
		JSONParser parser = new JSONParser();
		String PathJson = ResultPath+"config.json";
		System.out.println("PathJson : "+PathJson);
		try {
			Object obj = parser.parse(new FileReader(PathJson));
			jsonObject = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static String getDatafromJson(String Value) {
		String inputValue = null;
		//get Values from Json File
		inputValue = (String)jsonObject.get(Value); // get Values form Json file based on input Value
		System.out.println("Value from Input file :: "+Value+"-----"+inputValue);
		System.out.println("==============================");
		return inputValue;

	}

	// Reads the Sikuli pictures folder path

	public static Pattern fileReaders(String filename) {

		filename = ProjectPath + "\\WOPImages\\" + filename;

		Pattern pattern = new Pattern(filename);

		return pattern;
	}

	public static void ClickOnImage(String ImagePath,int Wait) throws InterruptedException {
		Pattern	pattern = fileReaders(ImagePath);
		try {
			waitForImage(ImagePath,Wait);
			Sikuliscreen.find(pattern);
			Sikuliscreen.click();
		} catch (FindFailed e) {
			System.err.println(pattern+ "  Not found on the screen");
			//Assert.fail(pattern+ "  Not found on the screen");
		}
	}


	public static String getTextfromImage(String ImagePath,int Wait) throws Exception {
		String textfromIamge = "Text not found on the image";
		Pattern	pattern = fileReaders(ImagePath);
		try {
			waitForImage(ImagePath,Wait);
			Match c =Sikuliscreen.find(pattern);
			Region r=new Region(c.getRect());
			textfromIamge=r.getName();
		} catch (FindFailed e) {
			System.out.println("Error Not Found");
		}
		return textfromIamge;
	}


	public static void ClickandEnterTextInImage(String ImagePath,String Text,int Wait) throws InterruptedException {
		Pattern	pattern = fileReaders(ImagePath);
		try {
			Sikuliscreen.wait(pattern.exact(),Wait*1000);
			waitForImage(ImagePath,Wait);
			Sikuliscreen.click();
			Sikuliscreen.type("a", KeyModifier.CTRL); // select all text
			Sikuliscreen.type(Key.BACKSPACE); // delete selection
			Sikuliscreen.type(Text);
		} catch (FindFailed e) {
			System.err.println(pattern+ "  Not found on the screen");
			Assert.fail(pattern+ "  Not found on the screen");
		}
	}
	public static void DoubleclickOnImage(String ImagePath,int Wait) throws InterruptedException {
		Pattern	pattern = fileReaders(ImagePath);

		try {

			waitForImage(ImagePath,Wait);

			//Sikuliscreen.wait(pattern.exact(),Wait*1000);
			Sikuliscreen.find(pattern);
			Sikuliscreen.doubleClick();
		} catch (FindFailed e) {
			System.err.println(pattern+ "  Not found on the screen");
			Assert.fail(pattern+ "  Not found on the screen");
		}

	}



	public static void waitForImage(String image, int time) throws InterruptedException{
		for(int i=0; i<time; i++){
			if(isImagePresent(image)){
				break;
			}
			else{
				Thread.sleep(2000);
			}
		}
	}
	public static boolean isImagePresent(String ImagePath)
	{
		Pattern	pattern = fileReaders(ImagePath);
		boolean status = false;

		try {
			Sikuliscreen.find(pattern.similar(0.7));
			status = true;
		} catch (FindFailed e) {
			System.out.println("Looking for Image : "+ImagePath);
		}
		return status;
	}   

	//Image click using Sikuli
	public static String imageFindandread(String ImagePath, int wait, String direction, int length) throws FindFailed {
		String textvalue = null;
		System.out.println("Start Reading Image ====================");
		//Search For the view
		Pattern ProdSearchView= fileReaders(ImagePath);
		Sikuliscreen.wait(ProdSearchView, wait);
		if(direction.equalsIgnoreCase("right")) {
			textvalue=Sikuliscreen.find(ProdSearchView).right(length).textLine();	
		}else if(direction.equalsIgnoreCase("left")) {
			textvalue=Sikuliscreen.find(ProdSearchView).left(length).text();	
		}else {
			textvalue=Sikuliscreen.find(ProdSearchView).text();
		}
		return textvalue;
	}




	//Select and copy
	public static String imagecopyText(String ImagePath,int waitTime) throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		String textvalue = null;
		//Search For the view
		Pattern ProdSearchView= fileReaders(ImagePath);
		Sikuliscreen.wait(ProdSearchView, waitTime);
		Sikuliscreen.doubleClick(ProdSearchView);
		Sikuliscreen.type("a", KeyModifier.CTRL); 
		//Sikuliscreen.wait(2000);
		Thread.sleep(2000);
		Sikuliscreen.type("c", KeyModifier.CTRL); 
		Thread.sleep(2000);
		//Sikuliscreen.wait(2000);
		textvalue = (String) Toolkit.getDefaultToolkit()
				.getSystemClipboard().getData(DataFlavor.stringFlavor);
		//System.out.println("The Value is : "+textvalue);
		return textvalue;
	}


	public static void connectDB() {

		/*	 
        Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            String user = "sa";
            String pass = "secret";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

		 */
	}
}
