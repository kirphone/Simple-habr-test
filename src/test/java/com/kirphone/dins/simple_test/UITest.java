package com.kirphone.dins.simple_test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UITest {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private CompanyPage companyPage;
    private final static String pathToDriver = "/home/kirphone/Programming/Testing/Selenium/chromedriver_linux64/chromedriver";
    private final static String habrUrl = "https://habr.com/ru/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(habrUrl);

        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        companyPage = new CompanyPage(driver);
    }

    @Test
    public void uiTest() throws InterruptedException {
        mainPage.search("Dins");
        searchPage.goToCompanies();
        searchPage.goToCompanyDins();
        companyPage.goToProfile();
        assertEquals(companyPage.getAboutCompanyHeader(), "О компании");
        assertEquals(companyPage.getCrucialTechnologies(), "Ключевые технологии:");
        assertEquals(companyPage.getFoundationYear(), "1998 год");
        companyPage.openLanguageSettingMenu();
        companyPage.changeLanguage();
        Thread.sleep(2000); // Не нашёл другого простого способа в данном случае
        assertEquals(companyPage.profileTabHeader.getAttribute("innerText"), "PROFILE");
        assertEquals(companyPage.getFoundationYear(), "Since 1998");
    }
}
