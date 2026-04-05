package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageLogoSamokat {
    WebDriver driver;
    WebDriverWait wait;

    public MainPageLogoSamokat(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    private By topOrderButton = By.className("Button_Button__ra12g");
    private By orderForm = By.xpath(".//input[@placeholder='* Имя']");
    private By logoSamokat = By.xpath("//img[@alt='Scooter']");
    private By imageSamokatOnMainPage = By.xpath("//img[@alt='Scooter blueprint']");




    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }

    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
    }

    public boolean isMainPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageSamokatOnMainPage)).isDisplayed();
    }
}
