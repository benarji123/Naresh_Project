package pageObject;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


import functions.TestBase;

public class AssetMainPage extends TestBase{

	WebDriver driver;

	public AssetMainPage(WebDriver driver)
	{
		this.driver=driver;

	}
	// public static ThreadLocal<String> rlAssetIDString = new
	// ThreadLocal<String>();
	HashMap<String, String> hashMapString = new HashMap<String, String>();

	@FindBy(xpath = "//span[contains(text(),'Asset Maintenance')]")
	private WebElement assetMaintenanceLink;

	@FindBy(xpath = "//span[contains(text(),'New')]/parent::a")
	private WebElement assetMaintenanceNewButton;

	@FindBy(xpath = "//span[contains(text(),'Program')]/parent::a")
	private WebElement assetMaintenanceProgramButton;

	@FindBy(xpath = "//span[contains(text(),'Theatrical')]/parent::a")
	private WebElement assetMaintenanceTheatricalButton;

	@FindBy(id = "lstAssetType")
	private WebElement assetType;

	@FindBy(id = "txtAssetTitle")
	private WebElement assetTitle;

	@FindBy(name = "imgVendor")
	private WebElement assetVendor;

	@FindBy(id = "txtName")
	private WebElement assetVendorName;

	@FindBy(name = "btnFind")
	private WebElement findButton;

	@FindBy(id = "btnSelect")
	private WebElement selectButton;

	@FindBy(id = "lstSBU")
	private WebElement sourceBusinessUnit;

	@FindBy(name = "WMEDuration")
	private WebElement assetDuration;

	@FindBy(id = "lstAssetStatus")
	private WebElement assetStatus;

	@FindBy(id = "lstAsset_Source")
	private WebElement assetSource;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::a")
	private WebElement saveButton;


	//	@FindBy(xpath = "//*[@id='WebDialogWindow1']//tbody//span[@mkr='1']")
	//	private WebElement TitleValidation; // Title Validation for already existed Title


	@FindBy(xpath = "//*[@id=\"igtbl_reOkBtn\"]")
	private WebElement TitleSave; // Title Validation for already existed Title Save

	//	@FindBy(xpath = "//*[@id=\"btnCancel\"]")
	//	private WebElement TitleCancel; // Title Validation for already existed Title Cacel


	@FindBy(xpath = "//span[@id='lblMsg']")
	private WebElement infoMessage;


	@FindBy(xpath = "//span[contains(text(),'Details')]")
	private WebElement detailsTab;

	@FindBy(xpath = "//span[contains(text(),'General')]")
	private WebElement generalTab;

	@FindBy(xpath = "//span[contains(text(),'Contributors')]")
	private WebElement contributorsTab;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr/td[2]")
	private WebElement firstAlternativeTitle;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr[2]/td[2]")
	private WebElement secondAlternativeTitle;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr/td[3]")
	private WebElement firstAlternativeTitleType;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr[2]/td[3]")
	private WebElement secondAlternativeTitleType;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr/td[4]")
	private WebElement firstAlternativeTitleNetwork;

	@FindBy(xpath = "//table[@data-ig='x:74111462.5:mkr:dataTbl.hdn']/tbody/tr[2]/td[4]")
	private WebElement secondAlternativeTitleNetwork;

	@FindBy(id = "DetailsTab1_Group1_lstReleaseYear")
	private WebElement releaseYear;

	@FindBy(xpath = "//iframe[contains(@src,'/Asset_Maintenance/Home.aspx')]")
	private WebElement assetMaintainanceFrame;

	@FindBy(xpath = "//iframe[contains(@src,'/Asset_Maintenance/Details.aspx')]")
	private WebElement assetMaintainanceDetailsFrame;

	@FindBy(xpath = "//iframe[contains(@src,'/Asset_Maintenance/Contributors_Tab.aspx')]")
	private WebElement assetMaintainanceContributorsTabFrame;

	@FindBy(xpath = "//iframe[contains(@src,'/Asset_Maintenance/ValidateTitle_Popup.aspx')]")
	private WebElement assetTitileValidationTabFrame;

	@FindBy(xpath = "//iframe[contains(@src,'/asset_maintenance/contEdit.aspx')]")
	private WebElement assetMaintainanceContributorsEditFrame;

	@FindBy(xpath = "//iframe[contains(@src,'/List_Maintenance/Contributor_Search.aspx')]")
	private WebElement assetMaintainanceContributorsSearchFrame;

	@FindBy(id = "btnEdit")
	private WebElement assetMaintainanceContributorsButtonEdit;

	@FindBy(id = "btnAdd")
	private WebElement assetMaintainanceContributorsButtonAdd;

	@FindBy(id = "btnSelect")
	private WebElement assetMaintainanceContributorsSelectButton;

	@FindBy(id = "txtName")
	private WebElement assetMaintainanceContributorsName;

	@FindBy(id = "DetailsTab1_btnsaveDetails")
	private WebElement detailsTabSaveButton;

	@FindBy(id = "btnSave")
	private WebElement assetMaintainanceContributorsButtonSave;

	@FindBy(xpath = "//span[contains(text(),'Asset Navigator')]/parent::a")
	private WebElement assetNavigatorMenu;

	@FindBy(xpath = "//iframe[contains(@src,'/Asset_Maintenance/AssetNavigator.aspx')]")
	private WebElement assetNavigatorFrame;

	//@FindBy(xpath = "//span[@title='Add Season']/parent::a")
	//@FindBy(xpath = "//*[@id=\"uwToolBar\"]//ul/li[@title=\"Add Season\"]")
	@FindBy(xpath = "//*[@id=\"uwToolBar\"]//ul//li[contains (@title , 'Add')]")
	private WebElement addSeason;



	@FindBy(xpath = "//div[@id='uwgConrtibutors']//table//table/tbody[2]/tr/td/div/table/tbody/tr/td[2]")
	public WebElement seriesDataElement;

	@FindBy(xpath = "//*[@id=\"uwgConrtibutors\"]/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]")
	public WebElement directorDataElement;

	@FindBy(xpath = "//div[@id='uwgConrtibutors']/table/tbody//table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]")
	public WebElement episodeDataElement;

	@FindBy(xpath = "//table[@data-ig='x:1715484532.5:mkr:dataTbl.hdn']//tbody/tr[2]/td[7]")
	public WebElement episodeDirectorDataElement;

	@FindBy(id = "txtUserDefinedName")
	public WebElement episodeSeasonName;

	@FindBy(name="cmbVolumeSeason")
	public WebElement SeasonNameSelect;

	@FindBy(id = "txtEpisodeOrder")
	public WebElement episodeOrder;

	@FindBy(xpath = "//table[@id='dtInitialAirDate']//input")
	public WebElement episodeAirDate;



	@FindBy(id = "btnOK")
	public WebElement okButton;

	@FindBy(id = "lblAssetIDVal")
	public WebElement rlAssetID;

	@FindBy(xpath = "//div[@id='uwgAkaTitle_EditorControl1']/div/table/tbody/tr/td[2]/img")
	public WebElement firstAlternativeTitleTypeImage;

	@FindBy(xpath ="//div[@id='uwgAkaTitle_EditorControl2']/div/table/tbody/tr/td[2]/img")
	public WebElement secondAlternativeTitleTypeImage;

	@FindBy(xpath = "//a[text()='AKA']")
	public WebElement akaTitleType;

	@FindBy(xpath = "//div[@id='uwgAkaTitle_EditorControl2']/div/table/tbody/tr/td[2]/img")
	public WebElement firstAlternativeTitleTypeNetwork;

	@FindBy(xpath = "//a[text()='AMC']")
	public WebElement firstAlternativeTitleTypeNetworkAsAMC;

	@FindBy(xpath = "//a[text()='Legal']")
	public WebElement secondLeaglTitleType;


	public AssetMainPage createAsset() throws Exception {
		 readOneExcel("CreateAsssetscount");
		 executerows=Integer.parseInt(readdata[1][0].toString());
		readOneExcel("AssetDataforCreation");
		
		for(row=1;row<executerows;row++) {

			selectAssetMaintenance();
			clickOnProgramButton(row);
			selectAssetType(row);
			enterAssetTitle(row);
			selectVendorForAsset(row);
			selectSourceBusinessUnit(row);
			Thread.sleep(2000);
			enterAssetDuration(row);
			selectAssetStatus(row);
			selectAssetSource(row);
			clickOnSaveButton();
			clickOnGeneralTab();
			clickOnDetailsTab();
			enterDetailsTabInformation(row);
			clickOnSaveButtonOnDetailsTab();
			enterRLDetailsOnContributorsTab(row,assetTitleString);
			giveRLAssetID();


			if (!assetTypeString.contains("Theatrical")) {
				addNewSeasonAndEpisode();
			} 


		}
		return this;

	}



	public AssetMainPage selectAssetMaintenance() {
		driver.switchTo().frame(0);
		clickonButton(assetMaintenanceLink);  //Click on Asset Maintenance button
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		clickonButton(assetMaintenanceNewButton);  //Select New Option for create New Asset
		return this;

	}


	private AssetMainPage clickOnProgramButton(int rowNumber) {
		String assetTypeString = readdata[rowNumber][0];
		if (assetTypeString.contains("Theatrical")) {
			clickOnTheatricalButton();
		} else {
			clickonButton(assetMaintenanceProgramButton);
		}
		return this;
	}

	private AssetMainPage clickOnTheatricalButton() {
		clickonButton(assetMaintenanceTheatricalButton);
		return this;
	}


	private AssetMainPage selectAssetType(int rowNumber) {
		assetTypeString = readdata[rowNumber][0];
		selectValueFromDropdownUsingVisibleText(assetType, assetTypeString);
		return this;
	}


	private String enterAssetTitle(int rowNumber) throws InterruptedException {
		assetTitleString = readdata[rowNumber][1];
		Thread.sleep(2000);
		enterText(assetTitle, assetTitleString);

		return assetTitleString;
	}


	private AssetMainPage selectVendorForAsset(int rowNumber) {
		String vendorName = readdata[rowNumber][6];
		clickonButton(assetVendor);
		driver.switchTo().defaultContent();
		driver.switchTo()
		.frame(driver.findElement(By.xpath("//iframe[@src=\"/List_Maintenance/Enterprise_PopupSearch.aspx?"
				+ "&entitytype=External&title=Vendor&type=Vendor&opt=yes&multiselect=yes&LEVEL=1&From=AM\"]")));
		enterText(assetVendorName, vendorName);
		clickonButton(findButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", vendorName)))));
		clickonButton(element);
		clickonButton(selectButton);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		return this;
	}



	private AssetMainPage selectSourceBusinessUnit(int rowNumber) {
		String assetSourceBusinessString = readdata[rowNumber][2];
		selectValueFromDropdownUsingVisibleText(sourceBusinessUnit, assetSourceBusinessString);
		return this;
	}

	private AssetMainPage enterAssetDuration(int rowNumber) throws InterruptedException {
		String assetDurationText = readdata[rowNumber][3];
		String[] times = assetDurationText.split(":");
		if(times[0].length()==1) {
			assetDurationText="0"+assetDurationText;
		}
		Thread.sleep(4000);
		assetDuration.click();
		assetDuration.sendKeys(assetDurationText);
		//enterText(assetDuration, assetDurationText);
		return this;
	}

	private AssetMainPage selectAssetStatus(int rowNumber) {
		String assetStatusString = readdata[rowNumber][4];
		selectValueFromDropdownUsingVisibleText(assetStatus, assetStatusString);
		return this;
	}


	private AssetMainPage selectAssetSource(int rowNumber) {
		String assetSourceString = readdata[rowNumber][5];
		selectValueFromDropdownUsingVisibleText(assetSource, assetSourceString);
		return this;
	}

	private AssetMainPage clickOnSave() throws Exception {
		Reporter.log("Click on New Button", true);
		waitForVisible(saveButton);
		saveButton.click();
		return this;
	}

	private AssetMainPage clickOnSaveButton() {
		Reporter.log("Click on New Button", true);
		clickonButton(saveButton);

		try {
			System.out.println(infoMessage.getText());

		}catch(Exception e) {
			driver.switchTo().defaultContent();
			driver.switchTo()
			.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/ValidateTitle_Popup.aspx')]")));
			//			TitleValidation.isDisplayed();
			//			switchToTitleValidationTabFrame();
			System.out.println("Asset Title already exist Kindly create same again");
			TitleSave.click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);

		}
		return this;
	}

	private AssetMainPage clickOnGeneralTab() {
		Reporter.log("Click on General Tab", true);
		generalTab.click();
		return this;
	}

	private AssetMainPage clickOnDetailsTab() {
		Reporter.log("Click on Details Tab", true);
		detailsTab.click();
		return this;
	}

	private AssetMainPage clickOnSaveButtonOnContrinutorsTab() {
		Reporter.log("Click on Save Button on Contributors tab", true);
		assetMaintainanceContributorsButtonSave.click();
		return this;
	}


	private AssetMainPage enterDetailsTabInformation(int rowNumber) throws Exception {

		//		String alternativeTitleForAKA = readdata[rowNumber][7];
		//		String alternativeTitleForLegal = readdata[rowNumber][8];
		//		if(alternativeTitleForAKA.isEmpty() || alternativeTitleForAKA.contains("NA")) {
		//			enterDetailsForFirstAlternativeTitle(alternativeTitleForAKA);
		//		}else {
		//			System.err.println("FirstAlternativeTitle is Not Specifid");
		//		}
		//
		//		if(alternativeTitleForLegal.isEmpty() || alternativeTitleForLegal.contains("NA")) {
		//			enterDetailsForSecondAlternativeTitle(alternativeTitleForLegal);
		//		}else {
		//			System.err.println("alternativeTitleForLegal is Not Specifid");
		//		}
		driver.switchTo()
		.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/Details.aspx')]")));	
		String releaseYearText = readdata[rowNumber][7]; // Get Premier Year from Data

		selectValueFromDropdownUsingVisibleText(releaseYear, releaseYearText);
		return this;
	}




	@SuppressWarnings("unused")
	private AssetMainPage enterDetailsForFirstAlternativeTitle(String alternativeTitle) throws Exception {
		clickonButton(firstAlternativeTitle);
		System.out.println(String.format("Set AKA alternative title as %s", alternativeTitle));
		setTextUsingRobotClass(alternativeTitle, firstAlternativeTitle);
		clickonButton(firstAlternativeTitleType);
		Reporter.log("Select alternative title type as AKA");

		clickonButton(firstAlternativeTitleTypeImage);

		clickonButton(akaTitleType);
		clickonButton(firstAlternativeTitleNetwork);
		System.out.println("Select alternative title network as AMC");

		clickonButton(firstAlternativeTitleTypeNetwork);

		clickonButton(firstAlternativeTitleTypeNetworkAsAMC);
		return this;
	}

	@SuppressWarnings("unused")
	private AssetMainPage enterDetailsForSecondAlternativeTitle(String alternativeTitle) throws Exception {
		clickonButton(secondAlternativeTitle);
		Reporter.log(String.format("Set Legal alternative title as %s", alternativeTitle));
		setTextUsingRobotClass(alternativeTitle, secondAlternativeTitle);
		clickonButton(secondAlternativeTitleType);
		System.out.println("Select alternative title type as Legal");

		clickonButton(firstAlternativeTitleTypeImage);

		clickonButton(secondLeaglTitleType);
		clickonButton(secondAlternativeTitleNetwork);
		System.out.println("Select alternative title network as AMC");

		clickonButton(secondAlternativeTitleTypeImage);

		clickonButton(firstAlternativeTitleTypeNetworkAsAMC);
		return this;
	}









	@SuppressWarnings("unused")
	private void switchToAssetMaintenceFrame() {
		Reporter.log("Switching to Asset Maintence Frame", true);
		driver.switchTo().frame(assetMaintainanceFrame);
	}

	@SuppressWarnings("unused")
	private void switchToAssetMaintenceDetailsFrame() {
		Reporter.log("Switching to Asset Maintence Details Frame", true);
		driver.switchTo().frame(assetMaintainanceDetailsFrame);
	}

	private void clickOnSaveButtonOnDetailsTab() {
		Reporter.log("Click on Save Button On Details Tab", true);
		clickonButton(detailsTabSaveButton);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
	}

	private void switchToAssetMaintenanceFrame() {
		Reporter.log("Switch to asset maintenance frame");
		driver.switchTo().frame(assetMaintainanceFrame);
	}

	private void clickOnContributorsTab() {
		Reporter.log("Click on Contributors Tab", true);
		clickonButton(contributorsTab);
	}


	@SuppressWarnings("unused")
	private void switchToTitleValidationTabFrame() {
		Reporter.log("Switch to asset maintenance contributors tab frame");
		driver.switchTo().frame(assetTitileValidationTabFrame);
	}
	private void switchToAssetMaintenanceContributorsTabFrame() {
		Reporter.log("Switch to asset maintenance contributors tab frame");
		driver.switchTo().frame(assetMaintainanceContributorsTabFrame);
	}

	private void switchToAssetMaintenanceContributorsEditFrame() throws Exception {
		Reporter.log("Switch to asset maintenance contributors edit frame");


		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();

		//		Set<String>s=driver.getWindowHandles();
		//
		//		// Now iterate using Iterator
		//		Iterator<String> I1= s.iterator();
		//
		//		while(I1.hasNext())
		//		{
		//
		//		String child_window=I1.next();
		//
		//		if(!parent.equals(child_window))
		//		{
		//		driver.switchTo().window(child_window);
		//
		//		System.out.println(driver.switchTo().window(child_window).getTitle());
		//		waitForVisible(assetMaintainanceContributorsEditFrame);
		//		assetMaintainanceContributorsEditFrame.isDisplayed();
		//		driver.switchTo().frame(assetMaintainanceContributorsEditFrame);
		//	
		//		}
		//
		//		}
		//switch to the parent window
		driver.switchTo().window(parent);


		try {
			waitForVisible(assetMaintainanceContributorsEditFrame);

			driver.switchTo().frame(assetMaintainanceContributorsEditFrame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.switchTo().frame(assetMaintainanceContributorsEditFrame);
	}

	private void switchToAssetMaintenanceContributorsSearchFrame() {
		Reporter.log("Switch to asset maintenance contributors search frame");
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		//switch to the parent window
		driver.switchTo().window(parent);
		try {
			waitForVisible(assetMaintainanceContributorsSearchFrame);

			driver.switchTo().frame(assetMaintainanceContributorsSearchFrame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void clickOnContributorsTabEditButton() {
		Reporter.log("Click on Contributors Tab Edit Button", true);
		clickonButton(assetMaintainanceContributorsButtonEdit);
	}

	private void clickOnContributorsTabAddButton() {
		Reporter.log("Click on Contributors Tab Add Button", true);
		clickonButton(assetMaintainanceContributorsButtonAdd);
	}




	private void clickOnContributorsTabFindButton() {
		Reporter.log("Click on Contributors Tab Find Button", true);

		clickonButton(findButton);
	}



	private void clickOnContributorsTabSelectButton() {
		Reporter.log("Click on Contributors Tab Select Button", true);
		clickonButton(assetMaintainanceContributorsSelectButton);
	}

	private String findContributorDirectorForSeries(int rowNumber) {
		String contributorDirectorName = readdata[rowNumber][8];
		Reporter.log("Find contributor");
		System.out.println("Find contributor");
		assetMaintainanceContributorsName.sendKeys(contributorDirectorName);
		//		clickOnContributorsTabFindButton();
		//		WebDriverWait wait = new WebDriverWait(driver, 30);
		//		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(driver
		//				.findElement(By.xpath(String.format("(//td[contains(text(),'%s')])[1]", contributorDirectorName)))));
		//		element2.click();
		return contributorDirectorName;
	}

	@SuppressWarnings("unused")
	private String findContributorDirectorForEpisode(int rowNumber) {
		String contributorDirectorName = readdata[rowNumber][9];
		Reporter.log("Find contributor");
		assetMaintainanceContributorsName.sendKeys(contributorDirectorName);
		return contributorDirectorName;
	}


	// This function is to enter information on Contributors Tab on RL Asset
	// Creation
	private void enterRLDetailsOnContributorsTab(int rowNumber, String assetTitle)
			throws Exception {
		driver.switchTo().defaultContent();
		switchToAssetMaintenanceFrame();
		clickOnContributorsTab();
		switchToAssetMaintenanceContributorsTabFrame();
		clickOnContributorsTabEditButton();
		driver.switchTo().defaultContent();
		switchToAssetMaintenanceContributorsEditFrame();
		clickOnContributorsTabAddButton();
		driver.switchTo().defaultContent();
		switchToAssetMaintenanceContributorsSearchFrame();
		String contributorDirectorName = findContributorDirectorForSeries(rowNumber);
		clickOnContributorsTabFindButton();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath(String.format("(//td[contains(text(),'%s')])[1]", contributorDirectorName)))));
		element2.click();
		clickOnContributorsTabSelectButton();
		driver.switchTo().defaultContent();
		switchToAssetMaintenanceContributorsEditFrame();
		Reporter.log("Select Series from the grid", true);
		Thread.sleep(2000);
		clickonButton(seriesDataElement);
		driver.findElement(By.xpath("//img[@data-ig='x:1808348613.4:mkr:ButtonImage']")).click();
		List<WebElement> elements1 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[4]/div/ul/li/a"));
		for (WebElement element : elements1) {
			if (element.getText().equalsIgnoreCase(assetTitle)) {
				element.click();
				break;
			}
		}
		Thread.sleep(2000);
		Reporter.log("Select type as Director from the grid", true);
		clickonButton(directorDataElement);
		WebElement elementText = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//img[@data-ig='x:1808348611.4:mkr:ButtonImage']"))));
		elementText.click();
		List<WebElement> elements2 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[6]//ul/li"));
		for (WebElement element : elements2) {
			if (element.getText().equals("Director")) {
				element.click();
				break;
			}
		}
		clickOnSaveButtonOnContrinutorsTab();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		switchToAssetMaintenanceFrame();
		clickOnGeneralTab();
		waitForVisible(saveButton);
		clickOnSave();
	}




	// This method is for adding new season and episode under series
	public AssetMainPage addNewSeasonAndEpisode() throws Exception {
		int rowNumber=1;
		String oldSeason = "SeasonNotMentioned";
		String epsiodeName;
		String seasonName;
		String episodeOrderData = "NotMentioed";
		System.out.println("Click on Asset Navigator Menu");
		clickonButton(assetNavigatorMenu);
		driver.switchTo().defaultContent();
		System.out.println("Switch to asset navigator frame");
		driver.switchTo().frame(assetNavigatorFrame);
		
		for(rowNumber=row;rowNumber<executerows;rowNumber++) {
			String ParentType =readdata[rowNumber][0];
			String ParentTitle =readdata[rowNumber][1];

			if(assetTypeString.equalsIgnoreCase(ParentType)&&ParentTitle.equalsIgnoreCase(assetTitleString)) {
				epsiodeName = readdata[rowNumber][9];
				seasonName = readdata[rowNumber][10];
				episodeOrderData = readdata[rowNumber][11];
				if(!oldSeason.equalsIgnoreCase(seasonName)) {

					
					//String episodeAirDateData = readdata[rowNumber][12];
					System.out.println("Click on Add Season Button");
					clickonButton(addSeason);
					System.out.println("Switch to default content");
					driver.switchTo().defaultContent();
					System.out.println("Switch to Add Item frame");
					driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/AddItem.aspx')]")));
					System.out.println(String.format("Enter season name as %s", seasonName));
					//enterText(episodeSeasonName, seasonName);
					selectValueFromDropdownUsingVisibleText(SeasonNameSelect, seasonName);
					System.out.println("Click on Save Button");
					clickonButton(assetMaintainanceContributorsButtonSave);
					driver.switchTo().defaultContent();
					System.out.println("Switch to asset navigator frame");
					driver.switchTo().frame(assetNavigatorFrame);
					System.out.println("Click on Season");
					driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", seasonName))).click();
					System.out.println("Click on Add Episode Button");
					clickonButton(addSeason);
					driver.switchTo().defaultContent();
					driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/AddItem.aspx')]")));
					System.out.println(String.format("Episode episode name as %s", epsiodeName));
					enterText(episodeSeasonName, epsiodeName);
					System.out.println(String.format("Episode episode order as %s", episodeOrderData));
					enterText(episodeOrder, episodeOrderData);
					//				System.out.println(String.format("Episode episode air date as %s", episodeAirDateData));
					//				enterText(episodeAirDate, episodeAirDateData);
					System.out.println("Click on Save Button");
					clickonButton(assetMaintainanceContributorsButtonSave);
					driver.switchTo().defaultContent();
					Reporter.log("Switch to asset navigator frame", true);
					driver.switchTo().frame(assetNavigatorFrame);
					row=row+1;
					oldSeason=seasonName;
				}else {
					System.out.println("Click on Season");
					driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", seasonName))).click();
					System.out.println("Click on Add Episode Button");
					clickonButton(addSeason);
					driver.switchTo().defaultContent();
					driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/AddItem.aspx')]")));
					System.out.println(String.format("Episode episode name as %s", epsiodeName));
					enterText(episodeSeasonName, epsiodeName);
					System.out.println(String.format("Episode episode order as %s", episodeOrderData));
					enterText(episodeOrder, episodeOrderData);
					//				System.out.println(String.format("Episode episode air date as %s", episodeAirDateData));
					//				enterText(episodeAirDate, episodeAirDateData);
					System.out.println("Click on Save Button");
					clickonButton(assetMaintainanceContributorsButtonSave);
					driver.switchTo().defaultContent();
					Reporter.log("Switch to asset navigator frame", true);
					driver.switchTo().frame(assetNavigatorFrame);
					row=row+1;
					oldSeason=seasonName;
				}
			}else {
				row=rowNumber-1;
				driver.switchTo().defaultContent();
				driver.navigate().refresh();
				break;
			}
			if(rowNumber==rowCount-1) {
				System.out.println("Click on Ok Button");
				clickonButton(okButton);
				driver.switchTo().defaultContent();
				driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Asset_Maintenance/Home.aspx')]")));
				clickOnSave();
			}
		}
		return this;
	}

	private String giveRLAssetID() {
		System.out.println("RL ID is :: "+rlAssetID.getText());
		return rlAssetID.getText();
	}



}
