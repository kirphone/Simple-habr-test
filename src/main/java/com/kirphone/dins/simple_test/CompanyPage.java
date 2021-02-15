package com.kirphone.dins.simple_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {


    @FindBy(css=".tabs-menu__item_link:first-child")
    public WebElement profileTab;

    @FindBy(css = ".tabs-menu__item_link:first-child h3")
    public WebElement profileTabHeader;

    @FindBy(css="dt.profile-section__title:first-child > h2")
    public WebElement aboutCompanyHeader;

    @FindBy(css = ".profile-section__about-text > b")
    public WebElement crucialTechnologiesBold;

    @FindBy(css = ".defination-list > li:first-child > span")
    public WebElement foundationYearSpan;

    @FindBy(css = "a.js-show_lang_settings")
    public WebElement languageSettingsLink;

    @FindBy(css = "[for='hl_langs_en']")
    public WebElement interfaceEnglishLabel;

    @FindBy(css = "[for='fl_langs_en']")
    public WebElement publicationEnglishLabel;

    @FindBy(css = "[for='fl_langs_ru']")
    public WebElement publicationRussianLabel;

    @FindBy(css = ".form__footer_lang-settings > button")
    public WebElement saveLanguageSettingsButton;

    public void goToProfile(){
        profileTab.click();
    }

    public String getAboutCompanyHeader(){
        return aboutCompanyHeader.getText();
    }

    public String getCrucialTechnologies(){
        return crucialTechnologiesBold.getText();
    }

    public String getFoundationYear(){
        return foundationYearSpan.getText();
    }

    public void openLanguageSettingMenu(){
        languageSettingsLink.click();
    }

    public void changeLanguage(){
        interfaceEnglishLabel.click();
        publicationRussianLabel.click();
        publicationEnglishLabel.click();
        saveLanguageSettingsButton.click();
    }

    public CompanyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
