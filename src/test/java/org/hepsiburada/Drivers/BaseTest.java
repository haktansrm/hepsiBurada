package org.hepsiburada.Drivers;

import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    //static String url = "https://rapsodo.com/";



    public void setUp(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        ExtentTestManager.getTest().log(Status.PASS, "Browser Opened");


    }
/*
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

 */
}
