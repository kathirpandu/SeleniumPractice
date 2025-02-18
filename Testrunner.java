package runner:

import java.io.BufferedWriter:

import java.io.FileNotFoundException:

import java.io.FileWriter;

import java.io.Exception:

import org.apache.log4j.Logger:

import org.apache.log4j.PropertyConfigurator:

import org.testng.annotations.AfterClass:

import org.testng.annotations.BeforeClass;

import org.testing.annotations.DataProvider:

import io.cucumber.testing.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

import commonUtils.CommonUtil;

import commonUtils. Driver Properties:

import commonUtils. PropertiesFile;

CucumberOptions (features "src/test/resources/features", glue("runperutil",

" stepDefinitions"), monochrome true, dryRun false, tags "", plugin | "pretty",

"html:C:\\Users\\Documents\\Results and Screenshot\\RegressionProject_Results\\CD\\CDcucumber-reports.html",

//"html:C:\\Users\\Documents\\Results and Screenshot\\RegressionProject_Results\\ICR\\ICRcucumber-reports.html",

"html:target/cucumber-reports/cucumber-reports.html",

// "json:target/cucumber-reports/cucumber-reports.Json",

//"junit:target/cucumber-reports/cucumber-reports.xml".

//"json:target/cucumber.json",

"rerun:target/failedtestcase.text",

"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

//BICR XML or BICR_XML_MT_Incoming BICR MT103

public class TestRunner extends AbstractTestNGCucumberTests (

static Logger logger Logger.getLogger (TestRunner.class);

PropertiesFile prop new PropertiesFile():

DriverProperties DriverProp new DriverProperties();

CommonUtil commonUtil new CommonUtil();

BeforeClass

public void browserinit() throws IOException, FileNotFoundException (

logger.info("Test Execution Started");

prop.propertiesFiles();

PropertyConfigurator.configure("log4j.properties"):

DriverProp.browserinitialization();

public void teardown()

commonUtil. Terminate Browser();

logger.info("Test Execution Completed");
