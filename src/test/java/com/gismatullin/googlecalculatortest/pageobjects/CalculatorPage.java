package com.gismatullin.googlecalculatortest.pageobjects;

import static com.gismatullin.googlecalculatortest.testhelper.TestHelper.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    
    @FindBy(id = "cwos")
    private WebElement inputAndResultLine;
    @FindBy(css = "span.vUGUtc")
    private WebElement memoryLine;
    @FindBy(css = "span[aria-label='calculations history']")
    private WebElement calculationHistoryButton;
    @FindBy(css = "div[aria-label='all clear']")
    private WebElement allClearButton;

    @FindBy(css = "div[aria-label='equals']")
    private WebElement equalsButton;
    @FindBy(css = "div[aria-label='divide']")
    private WebElement divideButton;
    @FindBy(css = "div[aria-label='multiply']")
    private WebElement multiplyButton;
    @FindBy(css = "div[aria-label='minus']")
    private WebElement minusButton;
    @FindBy(css = "div[aria-label='plus']")
    private WebElement plusButton;
    
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='0']")
    private WebElement zeroButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='1']")
    private WebElement oneButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='2']")
    private WebElement twoButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='3']")
    private WebElement threeButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='4']")
    private WebElement fourButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='5']")
    private WebElement fiveButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='6']")
    private WebElement sixButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='7']")
    private WebElement sevenButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='8']")
    private WebElement eightButton;
    @FindBy(xpath = "//div[@class='XRsWPe AOvabd' and text()='9']")
    private WebElement nineButton;
    @FindBy(css = "div[aria-label='point']")
    private WebElement pointButton;
    @FindBy(css = "div[aria-label='left parenthesis']")
    private WebElement leftParenthesisButton;
    @FindBy(css = "div[aria-label='right parenthesis']")
    private WebElement rightParenthesisButton;
    
    @FindBy(css = "div[aria-label='percentage']")
    private WebElement percentageButton;
    @FindBy(css = "div[aria-label='sine']")
    private WebElement sinButton;
    @FindBy(css = "div[aria-label='cosine']")
    private WebElement cosButton;
    @FindBy(css = "div[aria-label='tangent']")
    private WebElement tanButton;
    @FindBy(css = "div[aria-label='exponential']")
    private WebElement expButton;
    @FindBy(css = "div[aria-label='factorial']")
    private WebElement factorialButton;
    @FindBy(css = "div[aria-label='natural logarithm']")
    private WebElement lnButton;
    @FindBy(css = "div[aria-label='logarithm']")
    private WebElement logButton;
    @FindBy(css = "div[aria-label='square root']")
    private WebElement sqrtButton;
    @FindBy(css = "div[aria-label='X to the power of Y']")
    private WebElement powerButton;
    @FindBy(css = "div[aria-label='inverse")
    private WebElement inverseButton;
    @FindBy(css = "div[aria-label='pi']")
    private WebElement piButton;
    @FindBy(css = "div[aria-label='euler's number']")
    private WebElement eulerButton;
    @FindBy(css = "div[aria-label='answer']")
    private WebElement answerButton;
    @FindBy(xpath = "//div[@class='Tqvz7b' and text()='Rad']")
    private WebElement radButton;
    @FindBy(xpath = "//div[@class='SwDSDf' and text()='Deg']")
    private WebElement degButton;    

    private CalculatorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static CalculatorPage create() {
        return new CalculatorPage();
    }

    public String calculate(String expressionString) {
        

        return inputAndResultLine.getText();
    }

    public String getMemoryLine() {
        return memoryLine.getText();
    }
}
