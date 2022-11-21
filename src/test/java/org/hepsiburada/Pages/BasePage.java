package org.hepsiburada.Pages;

import org.hepsiburada.Drivers.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {



    public static WebDriver drivers() {
        return BaseTest.driver;

    }

    public WebElement find(By locator) {
        return drivers().findElement(locator);
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(drivers(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        find(locator).click();
    }

    public void send(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(drivers(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find(locator).sendKeys(text);
    }
    public void sendKeys(By locator, String value, Keys text) {
        WebDriverWait wait = new WebDriverWait(drivers(), 35);

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        find(locator).sendKeys(text, value, text);
    }

    public WebElement getElementLocated(By by) {
        WebDriverWait wait = new WebDriverWait(drivers(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean getElementLocatedControl(By by) {
        WebDriverWait wait = new WebDriverWait(drivers(), 5);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isDisplay(By by) {
        try {
            if (getElementLocated(by).isDisplayed())
                return true;
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }

    public void waitForSecond(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollPageElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) drivers();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
}
