package org.gauge.omf.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.GaugeConstant;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeleniumUtil {
    private static final Logger log = LoggerFactory.getLogger(SeleniumUtil.class);

    public static void scrollToTop() {
        Selenide.executeJavaScript("window.scrollTo(0, 0);");
    }

    public static void scrollToCenter(By locator) {
        WebElement element = WebDriverRunner.getWebDriver().findElement(locator);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript(scrollElementIntoMiddle, element);
    }

    public static String takeScreenshot() {
        try {
            String screenshotPath = Selenide.screenshot(String.format("%d", System.currentTimeMillis()));
            if (screenshotPath == null) {
                return "";
            }
            Gauge.writeMessage("XScreenshotPath: " + screenshotPath);
            File screenshotFile = new File(screenshotPath);
            File gaugeScreenshotFile = gaugeScreenshotFile(screenshotFile.getName());
            IOUtils.copy(new FileInputStream(screenshotFile), new FileOutputStream(gaugeScreenshotFile));
            return screenshotFile.getName();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static File gaugeScreenshotFile(String fileName) {
        Path path = Paths.get(System.getenv(GaugeConstant.SCREENSHOTS_DIR_ENV), fileName);
        return new File(path.toAbsolutePath().toString());
    }


}
