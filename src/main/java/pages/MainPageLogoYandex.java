package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageLogoYandex {
    WebDriver driver;
    WebDriverWait wait;

    public MainPageLogoYandex(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    private By logoYandex = By.xpath("//img[@alt='Yandex']");



    public void clickLogoYandex() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoYandex));
        driver.findElement(logoYandex).click();
        // 5 сек пока браузер создаст вторую вкладку
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
    }



public boolean isYandexPageDisplayed() {
    // подождать, чтобы в URL появилось dzen или yandex
    return wait.until(ExpectedConditions.urlContains("dzen.ru")) ||
            wait.until(ExpectedConditions.urlContains("yandex.ru"));
}
}

