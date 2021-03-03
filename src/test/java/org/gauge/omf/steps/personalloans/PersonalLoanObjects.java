package org.gauge.omf.steps.personalloans;

import org.gauge.omf.components.Button;
import org.gauge.omf.components.Label;
import org.gauge.omf.components.Section;
import org.gauge.omf.utils.SeleniumUtil;

class PersonalLoanObjects {
    private final Label calculatorTabHeader;
    private final Section calculatorSection;
    private final Label needHelpingHandHeader;
    private final Label personalLoansActiveTab;
    private final Label calculatorSectionHeader;
    private final Label minAmount;
    private final Label maxAmount;
    private final Button viewBreakdown;
    private final Button capitalValue;
    private final Button termValue;
    private final Label totalDeductionHeader;

    public PersonalLoanObjects() {
        this.calculatorTabHeader = new Label(PersonalLoanLocators.calculatorTabHeader);
        this.calculatorSection = new Section(PersonalLoanLocators.calculatorSection);
        this.needHelpingHandHeader = new Label(PersonalLoanLocators.needHelpingHandHeader);
        this.personalLoansActiveTab = new Label(PersonalLoanLocators.personalLoansActiveTab);
        this.calculatorSectionHeader = new Label(PersonalLoanLocators.calculatorSectionHeader);
        this.minAmount = new Label(PersonalLoanLocators.minAmount);
        this.maxAmount = new Label(PersonalLoanLocators.maxAmount);
        this.viewBreakdown = new Button(PersonalLoanLocators.viewBreakdownLink);
        this.capitalValue = new Button(PersonalLoanLocators.capitalValue);
        this.termValue = new Button(PersonalLoanLocators.termValue);
        this.totalDeductionHeader = new Label(PersonalLoanLocators.totalDeductionHeader);
    }

    public Label getTotalDeductionHeader() {
        return totalDeductionHeader;
    }

    public Button getCapitalValue() {
        return capitalValue;
    }

    public Button getTermValue() {
        return termValue;
    }

    public Button getViewBreakdown() {
        return viewBreakdown;
    }

    public Label getMinAmount() {
        return minAmount;
    }

    public Label getMaxAmount() {
        return maxAmount;
    }

    public Button amountByValue(String value){
        return new Button(PersonalLoanLocators.amountByValue(value));
    }

    public Button getMonth(String value){
        return new Button(PersonalLoanLocators.determineMonth(value));
    }

    public void scrollMonthToCenter(String value){
        SeleniumUtil.scrollToCenter(PersonalLoanLocators.determineMonth(value));
    }

    public Label getCalculatorSectionHeader() {
        return calculatorSectionHeader;
    }

    public Label getCalculatorTabHeader() {
        return calculatorTabHeader;
    }

    public Section getCalculatorSection() {
        return calculatorSection;
    }

    public Label getNeedHelpingHandHeader() {
        return needHelpingHandHeader;
    }

    public Label getPersonalLoansActiveTab() {
        return personalLoansActiveTab;
    }
}
