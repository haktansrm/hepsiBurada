package org.hepsiburada.Pages;

import com.aventstack.extentreports.Status;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class YandexResultsPage extends BasePage{
    ChromeResultsPage chromeResultsPage = new ChromeResultsPage();


    public String yandexResultUrl(){

        List<WebElement> listElement = drivers().findElements(By.xpath("//body[1]/main[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[*]/div[1]/div[2]/div[1]"));
        String subtitle ="";
        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();
            // System.out.println(elementText);
            subtitle+= elementText;
        }
        return subtitle;
    }

    public void printObj(){
        System.out.println(yandexResultUrl());
    }



    public List denemeYandex(){
        List<WebElement> listElement = drivers().findElements(By.xpath("//body[1]/main[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[*]/div[1]/div[2]/div[1]"));
        List<String> yandexList = new ArrayList<String>();
        for (WebElement e : listElement){
            yandexList.add(e.getText());

        }
        return yandexList;
    }


















    public List valuesYandex(){
        List<WebElement> yandexValues = drivers().findElements(By.xpath("//ul[@id='search-result']//li//a/h2/span"));
        int yandexSize = yandexValues.size();
        List<String> yandexList = new ArrayList<String>();
        for (int i = 1; i < yandexSize; i++) {
           String yandex = drivers().findElement(By.xpath("//ul[@id='search-result']//li[@data-cid='"+i+"']//a/h2/span")).getText();
            yandexList.add(yandex);
        }
        ExtentTestManager.getTest().log(Status.PASS, "Top 10 yandex titles added to the list");
        return yandexList;
    }




}
