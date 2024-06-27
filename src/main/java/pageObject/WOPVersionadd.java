package pageObject;


import functions.TestBase;



public class WOPVersionadd extends TestBase{



	@SuppressWarnings("unused")
	public static void lauchWOP(String EpisodeName,String VersionName) throws Exception {
		boolean checkWOPStatus= isImagePresent("WOPAlreadyOpen.PNG");
		if(checkWOPStatus==false) {
			try {
				LaunchingApplication();
			} catch (Exception e1) {
				// TODO Auto-generated catch block	
				e1.printStackTrace();
			}

			//			boolean checkWOPPwd= isImagePresent("WOPAlreadyOpen.PNG");
			//			
			//			ClickOnImage("Connect.PNG",10); // Click for Connect 
			//			ClickOnImage("Start Application.PNG",40); // Click for Start Application
			//			ClickOnImage("OK button.PNG",10); // Click for OkayButton to select Environment 
			//			System.out.println("Successfully Launched ");


			boolean checkconnection= isImagePresent("Connect.PNG");
			if(checkconnection==true) {
				ClickOnImage("Connect.PNG",10); // Click for Connect 
			}
			
			try {
				Windriver.findElementByClassName("Password").clear();
				Windriver.findElementByClassName("Password").sendKeys(getDatafromJson("WopPassword"));
				
				
			}catch(Exception pwd) {
				
			}
			boolean checkWOPPwd= isImagePresent("Password.PNG");
			if(checkWOPPwd==true) {
				ClickandEnterTextInImage("Password.PNG", getDatafromJson("WopPassword"), 10);
				ClickOnImage("PasswordOkayButton.PNG", 10);
			}

			ClickOnImage("Start Application.PNG",40); // Click for Start Application
			ClickOnImage("OK button.PNG",10); // Click for OkayButton to select Environment 


			System.out.println("Successfully Launched ");
		}else {
			ClickOnImage("WOPAlreadyOpen.PNG",10); // Click for Already open WOP
		}
		waitForImage("WOPLaunchfromTaskbar.PNG",10);
		checkWOPStatus= isImagePresent("WOPLaunchfromTaskbar.PNG");
		if(checkWOPStatus==true) {
			ClickOnImage("WOPLaunchfromTaskbar.PNG",10); // Click for Already open Product Broser
			System.out.println("WOP Launcged from Task Bar");
			ClickOnImage("EraseSearch.PNG",10); // Click for remove the Search text
		}else {
			System.out.println("WOP Newly Opned");
			ClickOnImage("EraseSearch.PNG",10); // Click for remove the Search text
		}

		ClickandEnterTextInImage("ProductSearch.PNG","Product browser",40); // Serch for Product Browser 

		DoubleclickOnImage("ProductBrowser.PNG",10); // Click for Select ProductBrowser
		ClickOnImage("EraseSearchDetails.PNG",10); // Click for remove the Search text
		ClickandEnterTextInImage("EnterAMCNID.PNG",EpisodeName,10); // Click for enter Episode for Search

		//		ClickOnImage("SearchIcon.PNG",10); // Click for Search the data
		//		ClickOnImage("SelectedProduct.PNG",10); // Click for product from the list

		ClickOnImage("SearchIcon.PNG",10); // Click for Search the data
		DoubleclickOnImage("SelectedProduct.PNG",10); // Double Click for product from the list
		waitForImage("ProductMenu.PNG",10);
		ClickOnImage("ProductMenu.PNG",20); // Click for product Menu for create Versions
		ClickOnImage("SelectNewVersion.PNG",10); // Click for New Version for create Versions

		ClickandEnterTextInImage("SearchVersion.PNG",VersionName,10); // Search for version	
		ClickOnImage("SelectCheckBoxinVersions.PNG",10); // Select Check box for Version
		ClickOnImage("VersionOKButton.PNG",10); // Select Okay button for Version creation
		//Validate Version creation
		waitForImage("ErrorCreatingVersion.PNG",5);
		checkWOPStatus= isImagePresent("ErrorCreatingVersion.PNG");
		if(checkWOPStatus==true) {
			ClickOnImage("ErrorCreatingVersion.PNG",10); // Select Error Message to read the Text
			System.err.println("The Selected Product version already exist for this Product -- Click Close ");
			ClickOnImage("ErrorCloseButton.PNG",10); // Select Error Message close button to 

		}else {
			waitForImage("YesONVersion.PNG",5);
			checkWOPStatus= isImagePresent("YesONVersion.PNG");
			if(checkWOPStatus==true) {
				ClickOnImage("YesONVersion.PNG",10); //Click on Yes for create new version completed
			}
			ClickOnImage("Save.PNG",10); //Click on Save for create new version completed
			System.out.println("Version Created Successfully for "+EpisodeName+" with :: "+VersionName);
			ClickOnImage("AMCNIDForVersion.PNG",10); //Click on Save for create new version completed
			for(int i=0;i<60;i++) {
				Thread.sleep(5000);
				String changedAMCNID = imagecopyText("checkAMCNIDChange.PNG",10);
				if(changedAMCNID.contains(".")) {
					System.out.println("AMCN ID was Changed to Asset ID :: "+changedAMCNID);
					break;
				}else if(i==59){
					System.err.println("AMCN ID was not Changed to Asset ID after 60 Seconds:: "+changedAMCNID);


				}
				//RecognizeTextandExtract("AMCNIDForVersionNew.PNG");
				//System.err.println(imageFindandread("AMCNIDForVersion.PNG",10,"right",100));
			}
		}




	}


}
