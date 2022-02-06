package com.gismatullin.googlecalculatortest.pageobjects;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getDriver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final static String PAGE_URL = "https://google.com";
    private final static String CALC_QUERY_STRING = "Калькулятор";

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement searchInput;

    @FindBy(css = "input.gNO89b")
    private WebElement searchButton;

    private MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static MainPage open() {
        MainPage mainPage = new MainPage();
        getDriver().get(PAGE_URL);
        return mainPage;
    }

    public CalculatorPage getCalculator() {
        submitSearchQuery(CALC_QUERY_STRING);
        return CalculatorPage.create(); 
    }

    private void submitSearchQuery(String queryString) {
        searchInput.sendKeys(queryString);
        searchButton.click();
    }
}
