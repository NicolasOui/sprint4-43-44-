package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTopOrderButton {
    WebDriver driver;
    WebDriverWait wait;

    public MainPageTopOrderButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }



    private By checkButton = By.className("Button_Button__ra12g");
    private By orderForm = By.xpath(".//input[@placeholder='* Имя']");



    public void clickTopOrderButton() {
        driver.findElement(checkButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
        // driver.navigate().back();
        // wait.until(ExpectedConditions.elementToBeClickable(checkButton));
    }

    public boolean isOrderFormVisible() {
        return driver.findElement(orderForm).isDisplayed();
    }
}
