package com.gismatullin.googlecalculatortest.pageobjects;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getDriver;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getElement;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.loadProperties;

import java.util.Properties;

public class MainPage {

    private final static String PAGE_URL = "https://google.com";
    private final static String UI_MAP_PATH = "src/test/resources/ui/mainPageUIMap.properties";
    private final static String CALC_QUERY_STRING = "Калькулятор";
    private final Properties uiMapProps = loadProperties(UI_MAP_PATH);

    private MainPage() {}

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
        getElement(uiMapProps, "searchInput").sendKeys(queryString);
        getElement(uiMapProps, "searchButton").click();
    }
}
