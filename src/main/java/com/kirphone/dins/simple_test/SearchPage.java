package com.kirphone.dins.simple_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(css = ".tabs-menu__item_link:nth-child(2)")
    public WebElement habsAndCompanies;

    @FindBy(className = "list-snippet__title-link")
    public WebElement companyLink;

    public void goToCompanies(){
        habsAndCompanies.click();
    }

    public void goToCompanyDins() {
        companyLink.click();
    }

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
