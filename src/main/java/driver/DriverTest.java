package driver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Screen;


public class DriverTest {
	protected static String ProjectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	public static WiniumDriver Windriver;
	public static Screen Sikuliscreen = new Screen();;
	public static ArrayList<String> Result=new ArrayList<String>();
	protected static String ResultPath =System.getProperty("user.home")+"\\Desktop\\AssetData\\";
}
