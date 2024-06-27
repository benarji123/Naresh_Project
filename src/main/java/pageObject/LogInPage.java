package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functions.TestBase;

public class LogInPage extends TestBase{

	WebDriver driver;

	public LogInPage(WebDriver driver)
	{
		this.driver=driver;

	}

	@FindBy(id = "userNameInput")
	private WebElement userNameField;

	@FindBy(id = "passwordInput")
	private WebElement passwordField;

	@FindBy(id = "submitButton")
	private WebElement submitButton;


	@FindBy(id = "Username")
	private WebElement FTuserNameField;

	@FindBy(id = "Password")
	private WebElement FTpasswordField;

	@FindBy(xpath = "//button[contains (text(), 'Log In with AMC Azure')]")
	private WebElement LoginWithAzure;


	@FindBy(xpath = "//input[@name='loginfmt']")
	private WebElement AzureSignIn;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement NextButtonOnAzure;

	@FindBy(id = "passwordInput")
	private WebElement PasswordInput;


	@FindBy(id = "submitButton")
	private WebElement SigninButton;

	@FindBy(id = "loginButton")
	private WebElement FTsubmitButton;



	@FindBy(xpath = "//*[@class='row text-title']")
	private WebElement CheckStaySignedIn;


	public void login() {
		readOneExcel("LogIn");
		PageFactory.initElements(driver, this);
		int readlogin=1;

		if(SystemType.equalsIgnoreCase("FT")) {
			readlogin=2;
			enterText(FTuserNameField,getDatafromJson("FTUserName"));
			//enterText(FTpasswordField, getDatafromJson("FTPassword"));
			clickonButton(LoginWithAzure);
			try {
				enterText(AzureSignIn, "naresh.kumar@amcnetworks.com");
				clickonButton(NextButtonOnAzure);
				System.out.println("Click on Next button");
				enterText(PasswordInput, "Swift007!");
				clickonButton(SigninButton);

				try {
					if(CheckStaySignedIn.isDisplayed()) {
						NextButtonOnAzure.click();
					}else {
						System.out.println("StaySignedinPage not found");
					}


				}catch(Exception e) {
					System.out.println("StaySignedinPage not found");
				}

			}catch(Exception e) {
				System.out.println("Azure login already done");
			}
		}else {
			enterText(FTuserNameField,getDatafromJson("RLUserName"));
			enterText(FTpasswordField, getDatafromJson("RLPassword"));
			clickonButton(submitButton);
		}

	}

}
