package commonUtils;

import java.awt.AWTException;

import java.awt.HeadlessException;

import java.awt.Rectangle;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

import java.io.BufferedReader;

import java.awt.datatransfer. DataFlavor;

import java.awt.datatransfer.Transferable;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.FileWriter;

import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.time.Duration;

import java.util.ArrayList;

import java.util. Iterator;

import java.util.LinkedHashMap;

import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel, Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.annotation.*;

import java.net.HttpURLConnection;

import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.Element Not InteractableException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.NoSuchWindowException;

import org.openqa.selenium.OutputType;

import org.openqa.selenium. StaleElement ReferenceException;

import org.openqa.selenium. TakesScreenshot;

import org.openqa.selenium.TimeoutException;

import org.openqa.selenium. UnhandledAlertException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType;

import org.openqa.selenium.devtools.v104.input.Input;

import org.openqa.selenium, interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedCondition:

import org.openqa.selenium.support.ui. ExpectedConditions;

import org.openqa.selenium.support.ui. FluentWait;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
public class CommonUtil extends DriverProperties {

public static String Parent, Te No;

private static final String ALGORITHM "AES";

private static final String KEY "abcdefghijklmnop";

static Logger logger Logger.getLogger (CommonUtil.class);

public static String sheet Name= null;

private static String filepath = null;

public void TerminateBrowser() {

driver.quit();

1

public boolean loginPageCheck() (

boolean login false;

try (

Alert alert driver.switchTo().alert();

WaitTillElementLoad (1000);

String alertText alert.getText();

if ("This activity will clear".contains (alertText)) {

logger.info(alert.getText());

alert.accept();

login true;

} else {

logger.info(alertText);

alert.accept();

login false;

logger.info("Issue while login page");

} catch (NoAlertPresentException e) (

login = true;

try {

if ((driver.getTitle().equalsIgnoreCase ("CSP Login Page"))) (

login true;
  } catch (Exception e) (

login false;

logger.info("Issue while login page");

} catch (Exception e) {

logger.info("Issue while login page");

return login;
}


public void attach screenshot (String TCName) throws IOException (

try {

if (sheet Name.contains("ICR")) [

filepath PropertiesFile.icrscreenShotPath;

if (sheet Name,contains ("CD")) {

filepath PropertiesFile.cdscreenShot Path;

File dest;

File source ((TakesScreenshot) driver).getScreenshotAs (Output Type. FILE);

dest new File(

filepath To No TCName System.currentTimeMillis()+".jpg");

FileUtils.copyFile (source, dest);

} catch (Exception e) {

logger.info("Screenshot not takene.getLocalizedMessage());
}

public static void alertScreenshot (String TCName) throws IOException, HeadlessException, AWTException

if (sheet Name.contains("ICR")) (

filepath PropertiesFile.icrscreenshot Path;

if(sheet Name.contains("CD")) {

filepath PropertiesFile.cdscreenshot Path;

BufferedImage image new Robot().createScreenCapture (new Rectangle (Toolkit.getDefaultToolkit().getScreensize()));

ImageIO.write(image, "png", new File(filepath To No TCNAME

System.currentTimeMillis() + ".png"));

public void CloseAllWindows Except Login() {

try {

Set<String> s = driver.getWindowHandles();

for (String Handles) (

driver.switchTo().window (Handle);

String CurrentTitle driver.getTitle();

if (! (CurrentTitle.equalsIgnoreCase ("CSP Login Page"))) {

driver.close();

}

} catch (Exception e) {

driver.switchTo().newWindow(WindowType.WINDOW);

driver.close();

}

}

public void reloginCSP() {

try {

Set<String> s = driver.getWindowHandles();

for (String Handle s) {

driver.switchTo().window (Handle);

String CurrentTitle = driver.getTitle();

if (CurrentTitle.equalsIgnoreCase ("CSP Login Page")) {

driver.navigate().to (prop.Url);

}

} catch (Exception e) {

driver.switchTo().newWindow(WindowType.WINDOW);

driver.close();

}

}


public void verifyValue (By Element, String expectedValue) {

WebElement elementText = driver.findElement (Element);

String actualValue = null;

try {

if (!(elementText.getText().isEmpty())) {

actualValue elementText.getText();

} else {

if (!(elementText.getAttribute("value").isEmpty())) { actualValue elementText.getAttribute("value");

}

if (expectedValue.contains (actualValue)) {

logger.info (expectedValue + "Verification Passed");

} else (

logger.info(actualValue+" Verification failed");

}

1

} catch (Exception e) {

logger.info("Element value not available");





  public void WaitForTextfieldNotEmpty (By Element) (

for (int i=0; i < 10; 1++) {

try (

String textField driver.findElement (Element).getAttribute("Value");

if (!textField.isEmpty()) {

continue;

} catch (Exception e) {

try {

WebElement textField driver.findElement (Element);

WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (30));

wait.until (ExpectedConditions.visibilityof (textField));

} catch (Exception el) (

logger.info(e);

1++;



public static void retryClick (By Element) (

WebElement Element2 driver.findElement (Element);

while (Element2.isDisplayed()) (

try i

Element2.click();

} catch (Exception e) {

FluentWait<WebDriver> wait new FluentWait<WebDriver> (driver);

wait.pollingEvery (Duration.ofMillis (200));

wait.withTimeout (Duration.ofSeconds (10000));

wait.ignoring (NoSuchElementException.class);

WebElement Elementl wait until (ExpectedConditions.elementToBeClickable (Element));

Elementi.click();









  
public static void Element_Status (By Element, String Type, String Elementname) {

WebElement Element2 driver.findElement (Element);

try(

if (Type.equalsIgnoreCase ("Enabled")) {

Boolean Element Value Element2.isEnabled();

if (ElementValue) (

logger.info(Elementname+"is"+ Type);

} else {

logger.info("Element not"+ Type);

}

if (Type.equalsIgnoreCase ("Displayed")) {

Boolean ElementValue Element2.isDisplayed();

if (ElementValue) {

logger.info (Elementname+" is + Type);

} else {

logger.info("Element not + Type);

if (Type.equalsIgnoreCase ("Selected")) {

Boolean ElementValue Element2.isSelected();

if (ElementValue) {

logger.info (Elementname+" is " + Type);

} else {

logger.info (Elementname+" not" + Type);

} catch (Exception e) {

logger.info("Element not available");





public void verifyTextInTableColumn (WebDriver driver, String tableld, int columnIndex, String expectedText) (

// Locate the table element

WebElement table driver.findElement(By.id(tableId));

// Get all rows of the table

List<WebElement> rows table.findElements (By.tagName("tr"));

// Create an ArrayList to store the column texts ArrayList<String> columnTexts new ArrayList<>();

// Iterate through all rows for (WebElement row: rows) 1

// Get all columns of the current row

List<WebElement> columns row.findElements (By.tagName("td"));

// Check if the column index is valid if (columns.size() > columnIndex) (

// Get the text of the specified column and add it to the ArrayList columnTexts.add(columns.get(columnIndex).getText());

// Verify if the expected text is present in the ArrayList if (columnTexts.contains (expectedText)) { logger.info("Expected text found in the table.");

} else (

logger.info("Expected text not found in the table.");




public static void WaitUntilElement (By Element, String actions) {

FluentWait<WebDriver> wait = new FluentWait<WebDriver> (driver);

wait.pollingEvery (Duration.ofMillis(200));

wait.withTimeout (Duration.ofSeconds (10000));

wait.ignoring (NoSuchElement Exception.class);

if (actions.equalsIgnoreCase ("click")) {

WebElement Elementi wait.until (ExpectedConditions.elementToBeClickable (Element));

Elementi.click();

if (actions.equalsIgnoreCase ("display")) {

WebElement Elementl wait.until (ExpectedConditions.presenceOfElementLocated (Element));




*/

public static void waitForWindow (int toWait, int NoOfExpWind) {

FluentWait<WebDriver> wait new FluentWait<WebDriver>(driver);

wait.pollingEvery (Duration.ofMillis (200));

wait.withTimeout (Duration.ofSeconds (toWait));

wait.ignoring (NoSuchWindowException.class);

Function<WebDriver, Boolean> Function new Function<WebDriver, Boolean>() {

@Override

public Boolean apply (WebDriver driver) {

Set<String> handel driver.getWindowHandles();

if (handel.size() NoOfExpWind) {

return true;

} else {

return false;

}

}

1;

wait.until (Function);






public void click (By We) throws AWTException (

UsingExplicitWaitClick(We);

unExpectedAlert Handling();

public void unExpectedAlertHandling () throws AWTException {

try {

Alert alert driver.switchTo().alert();

String Alert Present alert.getText();

if (!AlertPresent.isEmpty() && !AlertPresent.contains ("Please enter value for Amount")) {

try {

alert.accept();

logger.info("UnExpected Alert Appears + AlertPresent);

} catch (Exception Ro) {

Robot robot new Robot();

robot.keyPress (KeyEvent.VK ENTER);

robot.keyRelease (KeyEvent.VK ENTER);

logger.info ("UnExpected Alert Appears AlertPresent);

1

} catch (NoAlert PresentException e) (




public void untilAngularFinishHttpCalls() (

WebDriverWait wait new WebDriverWait (driver, Duration.ofSeconds(30)); // timeout 20 secs

wait.until(angularlsFinished());

public static ExpectedCondition Boolean> angularisFinished() {

return new ExpectedCondition Boolean>()

public Boolean apply(final WebDriver driver) (

Object result = null;

boolean isAngular2Plus = false;

while (result null || result.toString().equals("undefined ")) {

result ((JavascriptExecutor) driver).executeScript ("return typeof angular;");

if (result null || result.toString().equals("undefined")) {

result ((JavascriptExecutor) driver)

executeScript ("return typeof window.getAngularTestability;");

. if (result != null && result.toString().equals("undefined")) {

isAngular2Plus = true;

try

Thread.sleep (2001);

} catch (final InterruptedException ex) {

logger.error("Error while trying to sleep", ex);

1

final String script;

if (isAngular2Plus) (

script

var testability window.getAllAngularTestabilities()[0];\n"

var callback arguments (arguments.length-1];\n"

testability.whenStable (callback);";

} else {

script

var el document.querySelector (\"body\");\n"

var callback arguments (arguments.length-1];\n"

angular.element (el).injector().get('$browser').notifyWhenNoOutstandingRequests (callback);"

} ((JavascriptExecutor) driver).executeAsyncScript (script);

return true;

public String toString() {

return "Wait for AngularJS";








public void insertDataIntoExcel (Boolean[] appr, String LogNo, String MakerNameCSP, String pflocationOrderPage, String W1st OrderType, String Wist FT_OI_Currency, String wtxt_FT_OC_DebitAmount, String Date) (

String fileName = null;

if (sheet_Name.contains("ICR")) {

fileName Properties File.icrscreenShotPath+"AutomationRegression_TC_LogNo_ICR.xlsx";

if (sheet Name.contains("CD")) {

fileName PropertiesFile.cdscreenShotPath+"AutomationRegression_TC_LogNo_CD.xlsx";

// To Write it into Excel File

String[] approval Flags "No", "No", "No", "No");

String[] flagNames "Approval Required", "Branch Approval", "Frontoffice Approval", "CP_Approval");

// Determine approval requirements

if (appr[0] || appr[1] || appr[2]) {

approvalFlags[0] = "Yes";

} if (approvalFlags[0].equalsIgnoreCase ("Yes")) (

approvalFlags [1] appr[0]? "Yes": "No":

approvalFlags [2] (appr[1] && approval Flags[1].equals("No")) ? "Yes": "No";

approval Flags [3] appr[2]? "Yes": "No";

// Create a map to store the data

Map<String, String> map new LinkedHashMap<>();

map.put("LogNo", LogNo);

map.put("LV", pfLocationOrderPage.replaceAll("[^a-zA-Z]", ""));

map.put("Order Type", Wist OrderType);

map.put("ExecDate", Date.replace(".", "/"));

for (int i=0; i < flagNames.length; i++) (

map.put(flagNames[i], approval Flags[i]);

// Convert map values to a list

List<String> data new ArrayList<>(map.values());

// C:\\Users\\AK26722\\Downloads\\LogAutomation.xlsx

appendDataToExcel (fileName, "NLP", data);




public static void appendDataToExcel (String fileName, String sheetName, List<String> data) (

int startColumnIndex = 3;

try (FileInputStream inputStream new FileInputStream(fileName);

Workbook workbook new XSSFWorkbook ( inputStream)) {

Sheet sheet getorCreateSheet (workbook, sheetName);

int lastRowNum findFirst.EmptyRow(sheet, startColumnIndex);

Row row sheet.createRow(lastRowNum);

for (int i=0; i < data.size(); i++) {

Cell cell row.createCell (startColumnIndex + 1);

cell.setCellValue (data.get(i));

try (FileOutputStream outputStream new FileOutputStream(fileName)) {

workbook.write (outputStream);

1

} catch (IOException e) {

private static Sheet getOrCreateSheet (Workbook workbook, String sheetName) {

Sheet sheet workbook.getSheet (sheetName);

if (sheet null) {

sheet workbook.createSheet (sheetName);

return sheet;

private static int findFirstEmptyRow (Sheet sheet, int startColumnIndex) (

int lastRowNum sheet.getLastRowNum();

while (lastRowNum >= 0 && sheet.getRow(last.RowNum) != null

&& sheet.getRow(lastRowNum).getCell(startColumnIndex) != null) {

last.RowNum++;

return last.RowNum;





public String getDisableTextValueForAngular (By Element) (

String copiedText = null;

try

WebElement elementToClick driver.findElement (Element);

Actions actions= new Actions (driver);

actions.doubleClick (elementToClick).perform();

Thread.sleep(5000);

// Use Robot to press the Tab key

Robot robot = new Robot ();

// Use Robot to press Ctrl+C to copy the text

robot.keyPress (KeyEvent.VK_CONTROL);

robot.keyPress (KeyEvent. VK C);

robot.keyRelease (KeyEvent.VK C);

robot.keyRelease (KeyEvent.VK CONTROL);

// Get the copied text from the clipboard

Transferablet Toolkit.getDefaultToolkit().getSystemClipboard().getContents (null); if (t != null && t.isDataFlavorSupported (DataFlavor.stringFlavor)) (

copiedText(String) t.getTransfer Data (DataFlavor.stringFlavor);

logger.info("Copied text: " + copiedText);

}

} catch (Exception e) {

logger.info("not able to get Text due to: "+e.getLocalizedMessage());

1

return copiedText;

}



  
  

  



  
  
  


  


  




  
  
  

