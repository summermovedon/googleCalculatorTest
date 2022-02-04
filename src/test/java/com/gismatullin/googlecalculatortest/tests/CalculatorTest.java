package com.gismatullin.googlecalculatortest.tests;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.clean;
import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.setup;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gismatullin.googlecalculatortest.pageobjects.CalculatorPage;
import com.gismatullin.googlecalculatortest.pageobjects.MainPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalculatorTest {

    @BeforeEach
    public static void tearUp() {
        setup();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "(1 + 2) × 3 - 40 ÷ 5 =;;1",
        "6 ÷ 0;;Infinity",
        "sin(;;Error"
    }, delimiterString = ";;")
    public void expressionCalculation(String expression, String expectedResult) {
        CalculatorPage calculatorPage = MainPage.open().getCalculator();
        String actualResult = calculatorPage.calculate(expression);
        String actualExpression = calculatorPage.getMemoryLine();
        assertEquals(expression, actualExpression);
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    public static void tearDown() {
        clean();
    }
}
