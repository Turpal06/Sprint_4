package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderAboutRentPage extends BasePage{

    private By rentDateInputLocator = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");
    private By rentTermInputLocator = By.className("Dropdown-arrow");
    private String rentTermDropdown = "document.getElementsByClassName('Dropdown-option')[%d].click()";
    private By commentForCourierInputLocator = By.xpath(".//input[@placeholder ='Комментарий для курьера']");
    private String textForLocatorOfColor = "document.getElementsByClassName('Checkbox_Label__3wxSf')[%d].click()";
    private By orderButtonLocator = By.xpath(".//button[text() = 'Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By acceptButtonLocator = By.xpath(".//button[text() = 'Да']");
    private By orderStatusLocator = By.className("Order_Text__2broi");

    public OrderAboutRentPage(WebDriver driver) {
        super(driver);
    }

    private void selectColorOfScooter(int id){
        ((JavascriptExecutor) driver)
                .executeScript(String.format(textForLocatorOfColor, id));
    }

    private void selectRentTerm(int id){
        driver.findElement(rentTermInputLocator).click();
        ((JavascriptExecutor) driver)
                .executeScript(String.format(rentTermDropdown, id));

    }
    public void order(String rentDate, int rentTermID, int colorID, String courierComment){
        driver.findElement(rentDateInputLocator).sendKeys(rentDate);
        selectRentTerm(rentTermID);
        selectColorOfScooter(colorID);
        driver.findElement(commentForCourierInputLocator).sendKeys(courierComment);
        driver.findElement(orderButtonLocator).click();
        driver.findElement(acceptButtonLocator).click();
    }
    public boolean isOrderProcessed(){
        return driver.findElement(orderStatusLocator).getText().contains("Номер заказа:");
    }
}
//