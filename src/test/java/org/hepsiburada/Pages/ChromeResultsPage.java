package org.hepsiburada.Pages;

import com.aventstack.extentreports.Status;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChromeResultsPage extends BasePage {


    public List googleSec() {
        waitForSecond(2);
        List<WebElement> list1 = drivers().findElements(By.xpath("//div[@id='rso']/div[@class='MjjYud']//a/h3"));
        int size = list1.size();
        List<String> googleList = new ArrayList<String>();
        for (int i = 1; i < size; i++) {
            String googlelistElement = drivers().findElement(By.xpath("//div[@id='rso']/div[@class='MjjYud']["+i+"]//a/h3")).getText();
            googleList.add(googlelistElement);
        }

        ExtentTestManager.getTest().log(Status.PASS, "Top 10 google titles added to the list");

        return googleList;

    }









}
