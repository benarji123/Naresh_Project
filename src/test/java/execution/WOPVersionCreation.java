package execution;

import org.testng.annotations.Test;


import functions.TestImplementation;

import org.testng.annotations.BeforeTest;
import java.io.IOException;

import org.testng.annotations.AfterTest;

public class WOPVersionCreation extends TestImplementation{

	@Test 
	public void assetCreation() throws Exception {

		if(VersionEpisodeNames.size()>0) {
			for(int i=0;i<VersionEpisodeNames.size();i++) {
				CreateversionInWOP(VersionEpisodeNames.get(i),VersionEpisodeNames.get(i+1));
				i=i+1;
			}

		}else {
			readOneExcel("WOPVersionCreation");
			for(int i=1;i<rowCount;i++) {
				CreateversionInWOP(readdata[i][0],readdata[i][2]);

			}
		}	
	}



	@BeforeTest
	public void beforeTest() throws Exception, IOException {
		System.out.println("Execution started");
		readOneExcel("FTProjectInputData");
		executerows=rowCount-1;
		//readConfigValues();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("WOP Version Creation Execution End");
		//driver.quit();
	}

}
