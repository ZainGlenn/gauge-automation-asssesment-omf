package org.gauge.omf.utils;

import com.codeborne.selenide.Configuration;
import org.gauge.omf.exception.OMFRuntimeException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class BrowserSettings {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public BrowserSettings() {
        log.info("Setting up chrome browser run configurations");
    }


    public BrowserSettings setChromeOptions() {
        log.info("Setting chrome options");
        Configuration.browser = "chrome";
        TestSettings testSettings = TestSettings.getInstance();
        String prefs = "intl.accept_languages=" + testSettings.getLocale();
        System.setProperty("chromeoptions.prefs", prefs);
        System.setProperty("chromeoptions.args", "--disable-gpu,--no-sandbox,--disable-dev-shm-usage");
        return this;
    }

    public BrowserSettings setFirefoxOptions() {
        Configuration.browser = "firefox";
        return this;
    }

    public BrowserSettings dynamicConfigurations(boolean overrideHeadless) {
        TestSettings testSettings = TestSettings.getInstance();
        if (overrideHeadless) {
            Configuration.headless = false;
        } else {
            Configuration.headless = testSettings.isJenkins();
        }

        log.info("Completed Setting chrome options");
        Configuration.holdBrowserOpen = testSettings.isHolderBrowserOpen();
        return this;
    }

    public void setWindowSize() {
        log.info("Setting browser size");
        TestSettings testSettings = TestSettings.getInstance();
        String windowSize = testSettings.getProperty("window.size");
        if (windowSize != null && !windowSize.isEmpty()) {
            Configuration.browserSize = windowSize;
        }
        log.info("Completed Setting browser size");
    }

    public BrowserSettings setSelenoid() {
        log.info("Checking if selenoid is configured");
        TestSettings testSettings = TestSettings.getInstance();
        if (testSettings.isRemote()) {
            log.info("Selenoid is configured building url");
            Configuration.browser = testSettings.getBrowserType();
            String baseUrl = System.getenv("SELENOID_URL");
            baseUrl = !Objects.isNull(baseUrl) ? baseUrl : testSettings.remoteUrl();
            if (Objects.isNull(baseUrl)) {
                throw new OMFRuntimeException("No Selenoid URL set", new Throwable());
            }
            String urlBuilder = String.format("%s/wd/hub", baseUrl);
            log.info("(ENV) Setting url to {}", urlBuilder);
            Configuration.remote = urlBuilder;
        }
        return this;
    }

    public BrowserSettings setDefaultDesiredCapabilities() {
        log.info("Setting Desired Capabilities");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String vnc = System.getenv("ENABLE_VNC");
        String video = System.getenv("ENABLE_VIDEO");

        if (!Objects.isNull(vnc)) {
            capabilities.setCapability("enableVNC", Boolean.parseBoolean(vnc));
        }

        if (!Objects.isNull(video)) {
            capabilities.setCapability("enableVideo", Boolean.parseBoolean(video));
        }

        Configuration.browserCapabilities = capabilities;
        log.info("Completed Setting Desired Capabilities");
        return this;
    }
}
