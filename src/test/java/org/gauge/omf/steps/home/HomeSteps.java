package org.gauge.omf.steps.home;

import com.thoughtworks.gauge.Step;

public class HomeSteps {
    private final HomeObjects homeObjects;

    public HomeSteps() {
        homeObjects = new HomeObjects();
    }

    @Step("Validate home page is open")
    public void validateHomePage() {
        //validate personal loans card appears
        homeObjects.getPersonalLoansCardHeader()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getPersonalLoansCardBody()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getPersonalLoansCardView()
                .waitForElement().appearedOnPage();
        //validate banking card appears
        homeObjects.getBankingCardHeader()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getBankingCardBody()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getBankingCardView()
                .waitForElement()
                .appearedOnPage();
        //validate insurance card appears
        homeObjects.getInsuranceCardHeader()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getInsuranceCardBody()
                .waitForElement()
                .appearedOnPage();
        homeObjects.getInsuranceCardView()
                .waitForElement()
                .appearedOnPage();
    }

    @Step("Navigate to <name> page via navigation bar")
    public void implementation1(String name) {
        homeObjects.navigationBarLink(name)
                .waitForElement()
                .clickElement();
    }
}
