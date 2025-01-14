package functions;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunFromJar extends ReusableFunctions{

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    suites.add(ProjectPath+"\\testng.xml");//path to xml..
	    //suites.add("c:/tests/testng2.xml");
	    testng.setTestSuites(suites);
	    testng.run();

	}

}
