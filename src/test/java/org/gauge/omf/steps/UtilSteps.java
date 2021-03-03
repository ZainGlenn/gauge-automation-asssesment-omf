package org.gauge.omf.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Step;

public class UtilSteps {

    @Step("Shutdown browser")
    public void shutdownBrowser() {
        WebDriverRunner.driver().close();
    }

    @Step("Navigate to url <url>")
    public void navigateToUrl(String url) {
        Configuration.startMaximized=true;
        Selenide.open(url);
    }

    @Step("Navigate to url <url> maximized")
    public void navigateToUrlMaximized(String url) {
        Configuration.startMaximized=true;
        Selenide.open(url);
    }
}
