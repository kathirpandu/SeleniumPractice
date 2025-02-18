package runnerutil:

import java.awt.AWTException:

import java.awt.Robot:

import java.awt.event.KeyEvent;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date:

//import java.text. SimpleDateFormat:

import java.util.List;

import java.util.Map;

import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;

import org.apache.poi.openxml4j.exceptions. InvalidFormatException;

import org.openqa.selenium. By:

import org.openqa.selenium.Keys;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.NoSuchWindowException;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.StaleElementReferenceException:

import org.openqa.selenium.TakesScreenshot:

import org.openqa.selenium.UnhandledAlertException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType:

import commonUtils.CommonUtil;

import commonUtils. DriverProperties;

import commonUtils.ExcelReader;

import commonUtils. PropertiesFile;

import capPageObjects.HomePageObjects;

import io.cucumber.java.After;

import io.cucumber.java.AfterStep:

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;

//import io.cucumber.java.it.Date;

public class Hooks extends DriverProperties (

public WebElement BaseNumber = null;

CommonUtil commonUtil new CommonUtil();

HomePageObjects homePageObjects new HomePageObjects():

static Logger logger Logger.getLogger (Books.class);

@Before()

@purpose: used to Navigate to CSP Login Page
public WebElement BaseNumber null;

CommonUtil commonUtil new CommonUtil();

HomePageObjects homePageObjects new HomePageObjects();

static Logger logger Logger.getLogger (Hooks.class);

@Before()

@purpose: used to Navigate to CSP Login Page

public void NavigatetoCSPLogin() {

logger.info("Hooks Before");

Set<String> s driver.getWindowHandles();

for (String Handle: s) {

driver.switchTo().window (Handle);

String CurrentTitle = driver.getTitle();

try {

if (CurrentTitle.equalsIgnoreCase ("CSP Login Page")) {

driver.get(PropertiesFile.Url);

break;

} else if (CurrentTitle.equalsIgnoreCase("")) {

driver.get(Properties File.Url);

break;

} else if (CurrentTitle.equalsIgnoreCase ("Single Sign-On")) {

break;

1

} catch (Exception e) {

driver.close();

public void ClearHistory() {

try [

driver.manage().deleteAllCookies();

} catch (Exception E) [

E.printStackTrace();

1

@After ()
public void LogoutCSP() {

logger.info("Hooks After");

try {

Set<String> s = driver.getWindowHandles();

for (String Handle: s) {

driver.switchTo().window (Handle);

String CurrentTitle driver.getTitle();

if (CurrentTitle.equalsIgnoreCase ("Client Service Platform")) {

homePageObjects.LogoutfromCSP();

commonUtil.CloseAllWindows ExceptLogin();

break;

}

}

} catch (Exception e) {

commonUtil.CloseAllWindows ExceptLogin();

BAfterStep

@purpose: used to Attach Screen Shot For Scenario

@Param: Scenario (Scenario)

public void attach_screenshot (Scenario scenario) throws IOException (

try [

String filepath =null;

if (commonUtil.sheet_Name.contains("ICR")) {

filepath PropertiesFile.icrscreenShotPath:

if (commonUtil.sheet_Name.contains("CD")) {

filepath PropertiesFile.cdscreenShotPath:

File dest;

File source((TakesScreenshot) driver).getScreenshot.As (OutputType.FILE);

if (scenario.isFailed()) {

dest-new File(filepath+commonUtil.Tc_No+"_TC_Failed_StepDef_"+scenario.getName()+" "+System.currentTimeMillis()+".png"):

else [

dest-new File(filepath+commonUtil.Tc_No+"_TC_Passed_StepDef_"+scenario.getName()+"_"+System.currentTimeMillis()+".png"):

FileUtils.copyFile (source, deat);

byte[] screenshot-FileUtils.readFileToByteArray(dest):

scenario.attach (screenshot, "image/png",scenario.getName());

catch (Exception e) (

logger.info("Screenshot not able to take due to window closed"):

1
