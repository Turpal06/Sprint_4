package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageFAQ extends BasePage{
    private String textForPanelLocator = "#accordion__heading-%d";
    private String textForTextLocator = "#accordion__panel-%d > p";


    public MainPageFAQ(WebDriver driver) {
        super(driver);
    }



    public String getTextFromAccordion(int accordionNumber){
        By panelLocator = By.cssSelector(String.format(textForPanelLocator, accordionNumber));
        By textLocator = By.cssSelector(String.format(textForTextLocator, accordionNumber));
        WebElement element = driver.findElement(panelLocator);


        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById(\"accordion__heading-"+ accordionNumber +"\").click()");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(textLocator)));
        return driver.findElement(textLocator).getText();
    }
}
//