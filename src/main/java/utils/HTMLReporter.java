package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class HTMLReporter {

	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest svcTest;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes, authors,category, dataSheetName;	
	public static final ThreadLocal<ExtentTest> tlNode = new ThreadLocal<ExtentTest>();	
	public static final ThreadLocal<Properties> tlProp = new ThreadLocal<Properties>();	

	
	public Properties properties = new Properties();
	public Properties language = new Properties();
	{
		try {
			properties.load(new FileInputStream(new File("./src/main/resources/environment.properties")));
			
			// find the language and load that specific properties file
			String lang = properties.getProperty("Language").toLowerCase();
			language.load(new FileInputStream(new File("./src/main/resources/"+lang+".properties")));
			System.out.println();
		} catch (IOException e) {
		}
	}
	
	public void startReport() {

		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(html);		
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		testSuite = extent.createTest(testCaseName, testDescription);		
		return testSuite;
	}

	public ExtentTest startTestcase(String nodes) {
		tlNode.set(testSuite.createNode(nodes));
		
		getTest().assignAuthor(authors);
		getTest().assignCategory(category);
		return getTest();
	}

	public void endResult() {
		extent.flush();
	}

	public void reportStep(String desc,String status, boolean bSnap) {

		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".png").build();
			} catch (IOException e) {

			}
		}		

		if(status.equalsIgnoreCase("PASS")) {
			getTest().pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			getTest().fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			getTest().warning(desc, img);		
		}else {
			getTest().info(desc);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	
	public ExtentTest getTest() {
		return tlNode.get();
	}

	public abstract long takeSnap();

	
	public Properties getProperties() {
		return tlProp.get();
	}

}
