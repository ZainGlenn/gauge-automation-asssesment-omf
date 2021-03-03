package org.gauge.omf.steps.home;

import org.openqa.selenium.By;

class HomeLocators {

    private HomeLocators(){

    }
    private final static String SECTION_BASE = "//*[@id = 'infopans']//*[text() = '%s']";

    public static By sectionByName(String name) {
        return By.xpath(String.format(SECTION_BASE, name));
    }

    public static By bodySectionByName(String name) {
        return By.xpath(String.format(SECTION_BASE +
                "/parent::*/following-sibling::div[contains(@class, 'caption')]", name));
    }

    public static By viewButtonByName(String name) {
        return By.xpath(String.format(SECTION_BASE + "/parent::*/following-sibling::*//a[text() = 'VIEW']", name));
    }

    public static By navBarItem(String name) {
        return By.xpath(String.format("//*[@id = 'navbar']//*[text() = '%s']", name));
    }

}
