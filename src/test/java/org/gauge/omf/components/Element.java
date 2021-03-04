package org.gauge.omf.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.gauge.omf.utils.TestSettings;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

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
        element.waitUntil(Condition.appear, TimeUnit.SECONDS.toMillis(defaultMaxWaitTimeSeconds));
        log.info("Element appeared - " + element.toString());
        return (T) this;
    }

    public T visibleOnPage() {
        element.waitUntil(Condition.visible, TimeUnit.SECONDS.toMillis(defaultMaxWaitTimeSeconds));
        log.info("Element is visible - " + element.toString());
        return (T) this;
    }

    public T checkAttribute(String attribute, String value) {
        element.shouldBe(Condition.attribute(attribute, value));
        return (T) this;
    }

    public T waitForElement() {
        return waitForElement(defaultMaxWaitTimeSeconds);
    }

    public T waitForElement(int timeoutInSeconds) {
        element.waitUntil(Condition.exist, TimeUnit.SECONDS.toMillis(timeoutInSeconds));
        log.info("Waited for element - " + element.toString());
        return (T) this;
    }

    public T andExactText(String text) {
        element.shouldHave(Condition.exactText(text));
        return (T) this;
    }

}
