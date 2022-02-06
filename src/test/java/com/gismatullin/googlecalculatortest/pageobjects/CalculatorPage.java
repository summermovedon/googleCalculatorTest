package com.gismatullin.googlecalculatortest.pageobjects;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getDriver;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.loadProperties;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    
    private final String UI_MAP_PATH = "src/test/resources/ui/calculatorUIMap.properties";
    private Properties uiMapProps = loadProperties(UI_MAP_PATH);;

    private CalculatorPage() {}

    public static CalculatorPage create() {
        return new CalculatorPage();
    }

    public String getMemoryLine() {
        return getElement("memoryLine").getText();
    }

    public String calculate(List<String> expression) {
        inputExpression(expression);
        getElement("equals").click();
        return getElement("resultLine").getText();
    }

    private void inputExpression(List<String> expression) {
        expression.stream()
            .map(key -> getElement(key))
            .forEach(element -> element.click());
    }

    private WebElement getElement(String key) {
        String selector = uiMapProps.getProperty(key);
        By by;
        if (selector.startsWith("//")) {
            by =  By.xpath(selector);
        } else {
            by = By.cssSelector(selector);
        }
        return getDriver().findElement(by);
    }
}
