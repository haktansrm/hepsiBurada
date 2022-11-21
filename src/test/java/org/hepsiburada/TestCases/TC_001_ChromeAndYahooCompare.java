package org.hepsiburada.TestCases;

import com.aventstack.extentreports.Status;
import org.hepsiburada.Drivers.BaseTest;
import org.hepsiburada.Pages.*;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.testng.annotations.Test;

import java.util.List;

public class TC_001_ChromeAndYahooCompare {
    BaseTest baseTest = new BaseTest();
    ChromeSearchPage chromeSearchPage = new ChromeSearchPage();
    ChromeResultsPage chromeResultsPage = new ChromeResultsPage();
    YandexSearchPage yandexSearchPage = new YandexSearchPage();
    YandexResultsPage yandexResultsPage = new YandexResultsPage();

    String chromeUrl = "https://www.google.com.tr/";
    String yandexUrl = "https://yandex.com.tr/";
    String key = "Differential Equations";




    @Test
    public void test1() {

        baseTest.setUp(chromeUrl);
        chromeSearchPage.chromeKeySearch(key);
        List googleResult = chromeResultsPage.googleSec();
        BasePage.drivers().quit();
        ExtentTestManager.getTest().log(Status.PASS, "Driver is closed");

        baseTest.setUp(yandexUrl);
        yandexSearchPage.yandexKeySearch(key);
        List yandexResult = yandexResultsPage.valuesYandex();
        yandexResult.retainAll(googleResult);
        System.out.println("ortak :"+ yandexResult);



    }
}
