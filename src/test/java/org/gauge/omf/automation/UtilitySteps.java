package org.gauge.omf.automation;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Step;

public class UtilitySteps {

    @Step("Shutdown browser")
    public void shutdownBrowser() {
        WebDriverRunner.driver().close();
    }

    @Step("Navigate to url <url>")
    public void navigateToUrl(String url) {
        Selenide.open(url);
    }

}
