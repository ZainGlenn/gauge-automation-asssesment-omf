package org.gauge.omf.steps.personalloans;

import org.openqa.selenium.By;

class PersonalLoanLocators {
    public static By calculatorTabHeader = By.xpath("//*[text() = 'Calculator']/parent::*");
    public static By calculatorSection = By.id("repaymentcalculator");
    public static By needHelpingHandHeader = By.xpath("//*[text() = 'NEED A HELPING HAND?']");
    public static By calculatorSectionHeader = By.xpath("//*[@id = 'calcTermHold']/p[1]");
    public static By totalDeductionHeader = By.xpath("//*[@id = 'calcTotalsRes']/p[1]");
    public static By personalLoansActiveTab = By.xpath("//*[contains(@class, 'resp-tab-active')][text() = 'PERSONAL LOANS']");
    public static By minAmount = By.id("paymin");
    public static By maxAmount = By.id("paymax");
    public static By viewBreakdownLink = By.xpath("//a[text() = 'View Breakdown']");
    public static By capitalValue = By.id("breakdownCapital");
    public static By termValue = By.id("breakdownTerm");

    private PersonalLoanLocators(){
    }

    public static By amountByValue(String value) {
        return By.xpath(String.format("//*[@id = 'repaymentcalculator']//*[text() = '%s']", value));
    }

    public static By determineMonth(String month) {
        return By.xpath(String.format("//*[contains(@class, '%s')]", month));
    }


}
