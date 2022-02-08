package com.gismatullin.googlecalculatortest.pageobjects;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getElement;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.loadProperties;

import java.util.List;
import java.util.Properties;

public class CalculatorPage {
    
    private final static String UI_MAP_PATH = "src/test/resources/ui/calculatorUIMap.properties";
    private final Properties uiMapProps = loadProperties(UI_MAP_PATH);

    private CalculatorPage() {}

    public static CalculatorPage create() {
        return new CalculatorPage();
    }

    public String getMemoryLine() {
        return getElement(uiMapProps, "memoryLine").getText();
    }

    public String calculate(List<String> expression) {
        inputExpression(expression);
        getElement(uiMapProps, "equals").click();
        return getElement(uiMapProps, "resultLine").getText();
    }

    private void inputExpression(List<String> expression) {
        expression.stream()
            .map(key -> getElement(uiMapProps, key))
            .forEach(element -> element.click());
    }
}
