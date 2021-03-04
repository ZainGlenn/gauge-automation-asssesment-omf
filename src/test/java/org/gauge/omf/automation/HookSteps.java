package org.gauge.omf.automation;

import org.gauge.omf.utils.BrowserSettings;
import com.thoughtworks.gauge.BeforeScenario;

public class HookSteps {
    @BeforeScenario
    public void BeforeScenario() {
        new BrowserSettings().setSelenoid()
                .setDefaultDesiredCapabilities()
                .setChromeOptions(false,false)
                .setWindowSize();
    }
}
