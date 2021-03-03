package org.gauge.omf.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.gauge.omf.utils.TestSettings;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@SuppressWarnings("unchecked")
class Element<T> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final int defaultMaxWaitTimeSeconds;
    private final SelenideElement element;

    public Element(By locator) {
        this.defaultMaxWaitTimeSeconds = TestSettings.getInstance().getMaxWaitTimeSeconds();
        element = $(locator);
    }

    public T clickElement() {
        element.should(Condition.appear).click();
        log.info("Clicked element - " + element.toString());
        return (T) this;
    }

    public T appearedOnPage() {
        element.should(Condition.appear, Duration.ofSeconds(defaultMaxWaitTimeSeconds));
        log.info("Element appeared - " + element.toString());
        return (T) this;
    }

    public T visibleOnPage() {
        element.should(Condition.visible, Duration.ofSeconds(defaultMaxWaitTimeSeconds));
        log.info("Element is visible - " + element.toString());
        return (T) this;
    }

    public T waitForElement() {
        return waitForElement(defaultMaxWaitTimeSeconds);
    }

    public T waitForElement(int timeoutInSeconds) {
        element.shouldHave(Condition.exist, Duration.ofSeconds(timeoutInSeconds));
        log.info("Waited for element - " + element.toString());
        return (T) this;
    }

}
