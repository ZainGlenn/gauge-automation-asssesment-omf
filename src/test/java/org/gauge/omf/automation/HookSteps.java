package org.gauge.omf.automation;

import com.thoughtworks.gauge.BeforeScenario;
import org.gauge.omf.exception.OMFRuntimeException;
import org.gauge.omf.utils.BrowserSettings;
import org.gauge.omf.utils.TestSettings;

public class HookSteps {
    @BeforeScenario
    public void BeforeScenario() {

        String browserType = TestSettings.getInstance().getBrowserType();
        BrowserSettings browserSettings = new BrowserSettings();
        browserSettings
                .setSelenoid()
                .setDefaultDesiredCapabilities()
                .dynamicConfigurations(false)
                .setWindowSize();

        if (browserType.equals("chrome")) {
            browserSettings.setChromeOptions();
        } else if (browserType.equals("firefox")) {
            browserSettings.setFirefoxOptions();
        } else {
            throw new OMFRuntimeException("Failed to determine browser - " + browserType, new Throwable());
        }
    }
}
