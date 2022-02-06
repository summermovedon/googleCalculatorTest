package com.gismatullin.googlecalculatortest.tests;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.prepareDriver;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.gismatullin.googlecalculatortest.pageobjects.CalculatorPage;
import com.gismatullin.googlecalculatortest.pageobjects.MainPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalculatorTest {

    @BeforeEach
    public void tearUp() {
        prepareDriver();
    }

    @ParameterizedTest
    @CsvSource(value = {
        // format: expected expression;;expected result;;comma-separated list of buttons to enter expression
        "(1 + 2) × 3 - 40 ÷ 5 =;;1;;(,1,plus,2,),multiply,3,minus,4,0,divide,5",
        "6 ÷ 0 =;;Infinity;;6,divide,0",
        "sin() =;;Error;;sin"
    }, delimiterString = ";;")
    public void expressionCalculation(String expression, String result, String buttonsLine) {
        CalculatorPage calculatorPage = MainPage.open().getCalculator();
        List<String> buttonsList = Arrays.asList(buttonsLine.split(","));
        String actualResult = calculatorPage.calculate(buttonsList);
        String actualExpression = calculatorPage.getMemoryLine();
        assertEquals(expression, actualExpression);
        assertEquals(result, actualResult);
    }

    @AfterEach
    public void tearDown() {
        getDriver().quit();
    }
}
