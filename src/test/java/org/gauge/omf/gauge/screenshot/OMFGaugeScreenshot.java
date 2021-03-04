package org.gauge.omf.gauge.screenshot;

import com.thoughtworks.gauge.screenshot.CustomScreenshotWriter;
import org.gauge.omf.utils.SeleniumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OMFGaugeScreenshot implements CustomScreenshotWriter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String takeScreenshot() {
        return SeleniumUtil.takeScreenshot();
    }
}