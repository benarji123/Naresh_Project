package functions;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import pageObject.AssetMainPage;
import pageObject.FTAssetMainPage;
import pageObject.LogInPage;
import pageObject.WOPVersionadd;

public class TestImplementation extends WOPVersionadd {
	LogInPage Login ;
	AssetMainPage AssetMainPage;
	FTAssetMainPage FTAssetMainPage;

	public  void createAssetinFTtoWOP() throws Exception, IOException {
		LaunchandLogin();
		Login = PageFactory.initElements(driver, LogInPage.class);
		//Login.login();
		// login();
		waitForLoad();
		AssetMainPage = PageFactory.initElements(driver, AssetMainPage.class);
		FTAssetMainPage=  PageFactory.initElements(driver, FTAssetMainPage.class);
		if(SystemType.equalsIgnoreCase("RL")) {
			DeleteSheets("RL");
			createDataSheet_RemovePrevious("RL");
		}else {
			DeleteSheets("FT");
			createDataSheet_RemovePrevious("FT");
		}
		for(nextNumber=1;nextNumber<executerows;nextNumber++) {
			Result.clear();
			try {
				if(SystemType.equalsIgnoreCase("RL")) {
					AssetMainPage.createAsset();
				}else {

					FTAssetMainPage.CreateProject(nextNumber);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Result.add(CreatedEpisodeList.toString());
			writeResult(SystemType);
		}
	}

	public static void CreateversionInWOP(String EpisodeName,String VersionName) {
		try {

			lauchWOP(EpisodeName,VersionName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
