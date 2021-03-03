package org.gauge.omf.steps;

import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;

public class SampleSteps {
    @Step("Pass step")
    public void passTest() {

    }

    @Step("Fail step")
    public void failTest() {
        Assertions.fail("Failed step");
    }


    @Step("Tear down step")
    public void tearDownStep() {

    }
}
