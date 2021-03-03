package org.gauge.omf.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {

    public static void scrollToTop(){
        Selenide.executeJavaScript("window.scrollTo(0, 0);");
    }

    public static void scrollToCenter(By locator){
        WebElement element = WebDriverRunner.getWebDriver().findElement(locator);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript(scrollElementIntoMiddle, element);
    }
}
