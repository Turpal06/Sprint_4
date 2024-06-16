package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By orderButtonInHeadderLocator = By.cssSelector(".Header_Nav__AGCXC > button.Button_Button__ra12g");

    private By orderButtonInRoadmapLocator = By.className("Button_Middle__1CSJM");
    private By cookieConfirmButton = By.id("rcc-confirm-button");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage clickOnOrderButton(boolean isInHeadderButton){
        if (isInHeadderButton)
            driver.findElement(orderButtonInHeadderLocator).click();
        else {
            driver.findElement(cookieConfirmButton).click();
            driver.findElement(orderButtonInRoadmapLocator).click();

        }
        return new OrderPage(driver);
    }

}

//