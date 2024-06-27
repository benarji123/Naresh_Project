package functions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;



public class DynamicTestNG extends TestBase{

	public int yesCount;
	//@SuppressWarnings("deprecation")
	public void runTestNGTest(Map<String,String> testngParams) throws Exception {

		//Create an instance on TestNG
		TestNG myTestNG = new TestNG();

		//Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("ADAMTest");
//		mySuite.setParallel(XmlSuite.ParallelMode.TESTS);
//		mySuite.setThreadCount(8);
		//Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("Testclasess");

		//Add any parameters that you want to set to the Test.
		myTest.setParameters(testngParams);


		List<XmlClass> myClasses = new ArrayList<XmlClass> ();
		//Reading methods from excel to execute
		
		//myClasses.add(new XmlClass("testExecution.TestBrowserlaunch"));
		//myClasses.add(new XmlClass("testParallel.TestSecon"));
		
		
		int testcount=0;
		for(int i=1;i<=3;i++){
			//Create a list which can contain the classes that you want to run.
			if(getDatafromJson("FTToWOPExecution").equalsIgnoreCase("Yes")&&i==1) {
				myClasses.add(new XmlClass("execution.AssetCreation"));
				testcount= testcount+1;
				
			}else if(getDatafromJson("WOPVersionCreation").equalsIgnoreCase("Yes")&&i==2) {
				myClasses.add(new XmlClass("execution.WOPVersionCreation"));
				testcount= testcount+1;
				
			}else if(getDatafromJson("AssetIngession").equalsIgnoreCase("Yes")&&i==3) {
//				myClasses.add(new XmlClass("execution.AssetCreation"));
                testcount= testcount+1;
				
			}else {
				if(testcount==0 && i== 3) {
					Assert.fail("No Method is calling to execute");
				}
			}
		}


		//Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);


		//Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		//add the list of tests to your Suite.
		mySuite.setTests(myTests);

		//Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		//Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);

		//Setting the execution Thread Count for Parallel Execution
	    mySuite.setThreadCount(10);

	    //Setting the Verbose Count for Console Logs
	    mySuite.setVerbose(2);

	    // write the generated code in .xml file 
        FileWriter writer = null;
        try {
             writer = new FileWriter(new File("TestRunner.xml"));
            writer.write(((XmlSuite) mySuite).toXml());
            writer.flush();
            writer.close();
            System.out.println(new File("TestRunner.xml").getAbsolutePath());
        } catch(IOException e) {
            e.printStackTrace();
        }
		//invoke run() - this will run your class.
	    	myTestNG.run();
	}
	@Test
	public  void ExecuteScripts () throws Exception
	{
		DynamicTestNG dt = new DynamicTestNG();

		Map<String,String> testngParams = new HashMap<String,String> ();

		try {
			dt.runTestNGTest(testngParams);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) throws Exception {
		readConfigValues();
		try {
			context.getSuite().getXmlSuite().setName("MySuite");
			context.getSuite().getXmlSuite().setThreadCount(8);
			context.getSuite().getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
		} catch (Exception e) {
			throw e;
		}
	}

}
