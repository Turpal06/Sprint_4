package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage{

    private By firstNameInputLocartor = By.xpath("//input[@placeholder = '* Имя']");
    private By secondNameInputLocartor = By.xpath("//input[@placeholder = '* Фамилия']");
    private By addressInputLocartor = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroStationInputLocartor = By.className("select-search__input");
    private By telephoneInputLocartor = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By continueButtonLocartor = By.className("Button_Middle__1CSJM");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderAboutRentPage fillOrderDetails(String name, String secondName, String address, String metro, String telephone){
        driver.findElement(firstNameInputLocartor).sendKeys(name);
        driver.findElement(secondNameInputLocartor).sendKeys(secondName);
        driver.findElement(addressInputLocartor).sendKeys(address);
        metroSelect(metro);
        driver.findElement(telephoneInputLocartor).sendKeys(telephone);
        driver.findElement(continueButtonLocartor).click();
        return new OrderAboutRentPage(driver);
    }
    private void metroSelect(String metro){
        driver.findElement(metroStationInputLocartor)
                .sendKeys(metro, Keys.ARROW_DOWN, Keys.ENTER);
    }
}
//