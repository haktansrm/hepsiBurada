package org.hepsiburada.Pages;

import com.aventstack.extentreports.Status;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class YandexSearchPage extends BasePage{
    By yandexIcon = new By.ByXPath("//div[@aria-label='Yandex']");
    By yandexSearchBoxTxt = new By.ById("text");
    By findBtn = new By.ByXPath("//button[@type='submit']");

    public void yandexKeySearch(String yandexKey){
        Boolean icon = isDisplay(yandexIcon);
        Assert.assertTrue(icon,"Yandex açılamadı");
        ExtentTestManager.getTest().log(Status.PASS, "Yandex is Opened");
        send(yandexSearchBoxTxt,yandexKey);
        click(findBtn);
        ExtentTestManager.getTest().log(Status.PASS, "Keyword Typed and Searched Yandex");

    }


}
