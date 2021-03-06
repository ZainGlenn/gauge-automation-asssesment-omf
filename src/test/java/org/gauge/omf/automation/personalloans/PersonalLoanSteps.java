package org.gauge.omf.automation.personalloans;

import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.interactions.Actions;

public class PersonalLoanSteps {
    private final PersonalLoanObjects personalLoanObjects;

    public PersonalLoanSteps() {
        this.personalLoanObjects = new PersonalLoanObjects();
    }

    @Step("Validate personal loans page is open")
    public void validatePersonalLoanPageIsShown() {
        personalLoanObjects.getPersonalLoansActiveTab()
                .waitForElement()
                .appearedOnPage();
        personalLoanObjects.getNeedHelpingHandHeader()
                .waitForElement()
                .appearedOnPage();
        personalLoanObjects.getCalculatorTabHeader()
                .waitForElement()
                .appearedOnPage();
        personalLoanObjects.getCalculatorSection()
                .waitForElement()
                .appearedOnPage();

        Gauge.captureScreenshot();
    }

    @Step("Validate Calculator tab is selected by default")
    public void validateCalculatorTabActiveByDefault() {
        personalLoanObjects.getCalculatorTabHeader()
                .waitForElement()
                .checkAttribute("class", "active");
    }

    @Step("Select amount R<value> on calculator")
    public void selectAmount(String value) {
        personalLoanObjects.amountByValue(value)
                .waitForElement()
                .clickElement();
    }

    @Step("Validate <name> is displayed in calculator section")
    public void validateLabelAppearsOnCalculator(String name) {
        personalLoanObjects.getCalculatorSectionHeader()
                .waitForElement()
                .andExactText(name);
        Gauge.captureScreenshot();
    }


    @Step("Validate <name> is displayed on cost breakdown in calculator section")
    public void validateTotalDeductionHeader(String name) {
        personalLoanObjects.getTotalDeductionHeader()
                .waitForElement()
                .andExactText(name);
    }

    @Step("Select loan term <month> months")
    public void selectLoanTerm(String month) {
        personalLoanObjects.scrollMonthToCenter(month);
        personalLoanObjects.getMonth(month)
                .waitForElement()
                .scroll()
                .clickElement();
    }

    @Step("Validate installment is between <min> and <max> per month is displayed in calculator section")
    public void validateInstallmentRange(String min, String max) {
        personalLoanObjects.getMinAmount()
                .waitForElement()
                .andExactText(min);
        personalLoanObjects.getMaxAmount()
                .waitForElement()
                .andExactText(max);
        Gauge.captureScreenshot();
    }

    @Step("Select View Breakdown link in calculator section")
    public void selectViewBreakdownLink() {
        personalLoanObjects.getViewBreakdown()
                .waitForElement()
                .clickElement();
    }

    @Step("Validate Capital value is <value> on calculator section")
    public void validateCapitalValue(String value) {
        personalLoanObjects.getCapitalValue()
                .waitForElement()
                .andExactText(value);
        Gauge.captureScreenshot();
    }

    @Step("Validate Term value is <84 months> on calculator section")
    public void validateTermValue(String value) {
        personalLoanObjects.getTermValue()
                .waitForElement()
                .andExactText(value);
        Gauge.captureScreenshot();
    }
}
