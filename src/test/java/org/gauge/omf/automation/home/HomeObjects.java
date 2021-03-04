package org.gauge.omf.automation.home;

import org.gauge.omf.components.Button;
import org.gauge.omf.components.Label;

class HomeObjects {
    private final Label personalLoansCardHeader;
    private final Label personalLoansCardBody;
    private final Button personalLoansCardView;
    private final Label bankingCardHeader;
    private final Label bankingCardBody;
    private final Button bankingCardView;
    private final Label insuranceCardHeader;
    private final Label insuranceCardBody;
    private final Button insuranceCardView;

    public HomeObjects() {
        this.personalLoansCardHeader = new Label(HomeLocators.sectionByName("Personal Loans"));
        this.personalLoansCardBody = new Label(HomeLocators.bodySectionByName("Personal Loans"));
        this.personalLoansCardView = new Button(HomeLocators.viewButtonByName("Personal Loans"));
        this.bankingCardHeader = new Label(HomeLocators.sectionByName("BANKING"));
        this.bankingCardBody = new Label(HomeLocators.bodySectionByName("BANKING"));
        this.bankingCardView = new Button(HomeLocators.viewButtonByName("BANKING"));
        this.insuranceCardHeader = new Label(HomeLocators.sectionByName("Insurance"));
        this.insuranceCardBody = new Label(HomeLocators.bodySectionByName("Insurance"));
        this.insuranceCardView = new Button(HomeLocators.viewButtonByName("Insurance"));
    }

    public Button navigationBarLink(String name){
        return new Button(HomeLocators.navBarItem(name));
    }

    public Label getPersonalLoansCardHeader() {
        return personalLoansCardHeader;
    }

    public Label getPersonalLoansCardBody() {
        return personalLoansCardBody;
    }

    public Button getPersonalLoansCardView() {
        return personalLoansCardView;
    }

    public Label getBankingCardHeader() {
        return bankingCardHeader;
    }

    public Label getBankingCardBody() {
        return bankingCardBody;
    }

    public Button getBankingCardView() {
        return bankingCardView;
    }

    public Label getInsuranceCardHeader() {
        return insuranceCardHeader;
    }

    public Label getInsuranceCardBody() {
        return insuranceCardBody;
    }

    public Button getInsuranceCardView() {
        return insuranceCardView;
    }

}
