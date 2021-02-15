package com.kirphone.dins.simple_test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "search-form-btn")
    public WebElement searchButton;

    @FindBy(id = "search-form-field")
    public WebElement searchInput;

    public void search(String searchPhrase){
        searchButton.click();
        searchInput.sendKeys(searchPhrase, Keys.ENTER);
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
