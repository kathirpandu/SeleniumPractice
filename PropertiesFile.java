package commonUtils

new 30

import java.io.FileNotFoundException:

import java.io.IOException:

import java.util.Properties:

public class PropertiesFile (

public static String browser, ChromeDriverLocation, EdgeDriverLocation, Url, UserId, Password, UserName, reportConfigpath, icrscreenShotPath, cdscreenShotPath, icrsheet Path, cdSheetPath/

@purpose: used to read properties File

@throws IOException, FileNotFoundException

// public static void main(String[] args) throws IOException (

public void propertiesFiles() throws IOException, FileNotFoundException (

Properties Properties new Properties();

Properties.load(getClass().getResourceAsStream("/config.properties"));

browser = Properties.getProperty("Browser"); ChromeDriverLocation Properties.getProperty("ChromeDriverLocation");

EdgeDriverLocation Properties.getProperty("EdgeDriverLocation");

Url Properties.getProperty("Url");

Userld Properties.getProperty("UserID");

Password Properties.getProperty("Password");

UserName Properties.getProperty("UserName");

reportConfigpath Properties.getProperty("reportConfigpath");

icrSheet Path Properties.getProperty("icrSheetPath");

icrscreenShotPath=Properties.getProperty("icrscreenShotPath"):

cdSheetPath=Properties.getProperty("cdSheetPath");

cdscreenshot Path=Properties.getProperty("cdscreenshotPath")/
