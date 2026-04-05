package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageAccordeon {
    WebDriver driver;


    public MainPageAccordeon(WebDriver driver) {
        this.driver = driver;
    }


    String accordeonListLine = "accordion__heading-";
    By cookieButton = By.id("rcc-confirm-button");


    public void cookieConfirmation() {
        driver.findElement(cookieButton).click();
    }

    public void clickOnAccordeonQuestion(int index) {
        driver.findElement(By.id(accordeonListLine + index)).click();
    }

    public String getActualAccordeonAnswer(int index) {
        By accordeonAnswerLine = By.id("accordion__panel-" + index); //это как-то убрать

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordeonAnswerLine));

        return driver.findElement(accordeonAnswerLine).getText();
    }
}
