package org.hepsiburada.Pages;

import com.aventstack.extentreports.Status;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ChromeSearchPage extends BasePage{
    By googleIcon = new By.ByCssSelector("img[alt='Google']");
    By googleSearchBoxTxt = new By.ByXPath("//input[@title='Ara']");
    By searchGoogleBtn = new By.ByXPath("(//input[@name='btnK'])[2]");




    public void chromeKeySearch(String googleSearchKey){
        Boolean icon = isDisplay(googleIcon);
        Assert.assertTrue(icon,"Google açılamadı!");
        ExtentTestManager.getTest().log(Status.PASS, "Google is Opened");
        sendKeys(googleSearchBoxTxt,googleSearchKey, Keys.ENTER);
        ExtentTestManager.getTest().log(Status.PASS, "Keyword Typed and Searched Google");





    }


}
