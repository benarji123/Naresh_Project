package execution;

import org.testng.annotations.Test;


import functions.TestImplementation;

import org.testng.annotations.BeforeTest;
import java.io.IOException;

import org.testng.annotations.AfterTest;

public class AssetCreation extends TestImplementation{
	
	@Test 
	public void assetCreation() throws Exception {
		createAssetinFTtoWOP();
	}



	@BeforeTest
	public void beforeTest() throws Exception, IOException {
		System.out.println("Execution started");
		readOneExcel("FTProjectInputData");
		executerows=rowCount-1;
		readConfigValues();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Asset Creation Execution End");
		driver.quit();
	}

}
