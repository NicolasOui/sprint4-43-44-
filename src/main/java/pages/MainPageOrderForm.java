package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageOrderForm {
    WebDriver driver;
    WebDriverWait wait;

    public MainPageOrderForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By cookieButton = By.id("rcc-confirm-button");
    By middleOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]//button");
    By placeholderName = By.xpath(".//input[@placeholder='* Имя']");
    By placeholderLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    By placeholderAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    By subwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    By placeholderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    By continuerButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    By dateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    By leaseTerme = By.className("Dropdown-placeholder");
    By color = By.id("black");
    By addComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    By popupConfiramtionYesButton = By.xpath(".//button[text()='Да']");
    By orderSuccessPopup = By.xpath(".//div[contains(@class, 'Order_ModalHeader') and contains(text(), 'Заказ оформлен')]");

    public void cookieConfirmation() {
        driver.findElement(cookieButton).click();
    }

    public void clickMiddleOrderButton() {
        WebElement element = driver.findElement(middleOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        wait.until(ExpectedConditions.elementToBeClickable(middleOrderButton));
        driver.findElement(middleOrderButton).click();
    }


    //первая анкета
    public void findAndFillFirstNameFiled(String firstName) {
        driver.findElement(placeholderName).sendKeys(firstName);
    }

    public void findAndFillLastNameFiled(String lastName) {
        driver.findElement(placeholderLastName).sendKeys(lastName);
    }

    public void findAndFillAdress(String adress) {
        driver.findElement(placeholderAdress).sendKeys(adress);
    }

    public void findAndFillSubwayStation(String subway) {
        driver.findElement(subwayStation).click();
        driver.findElement(subwayStation).sendKeys(subway);
        By SubwayStationFromList = By.xpath(".//div[contains(@class, 'select-search__select')]//*[text()='" + subway + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SubwayStationFromList));
        driver.findElement(SubwayStationFromList).click();
    }

    public void findAndFillPhone(String phone) {
        driver.findElement(placeholderPhone).sendKeys(phone);
    }

    public void clickContiueButton() {
        driver.findElement(continuerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateDelivery));
    }

    public void firstList(String firstName, String lastName, String adress, String subway, String phone) {
        findAndFillFirstNameFiled(firstName);
        findAndFillLastNameFiled(lastName);
        findAndFillAdress(adress);
        findAndFillSubwayStation(subway);
        findAndFillPhone(phone);
    }


    //вторая анкета
    public void findAndFillDateDelivery(String date) {
        driver.findElement(dateDelivery).click();
        driver.findElement(dateDelivery).sendKeys(date);
        driver.findElement(dateDelivery).sendKeys(Keys.ENTER);             // Нажать Enter, закрыть календарь не забыть
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("react-datepicker__month-container")));
    }

    public void findAndFillLeaseTerme(String period) {
        driver.findElement(leaseTerme).click();
        By leaseTermeFromList = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='" + period + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaseTermeFromList));
        driver.findElement(leaseTermeFromList).click();
    }

    public void findAndFillColor() {
        driver.findElement(color).click();
    }

    public void findAndFillComment(String comment) {
        driver.findElement(addComment).sendKeys(comment);
    }

     public void secondList(String date, String period, String comment) {
        findAndFillDateDelivery(date);
        findAndFillLeaseTerme(period);
        findAndFillColor();
        findAndFillComment(comment);
    }

    public void clickFinalOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finalOrderButton));
        driver.findElement(finalOrderButton).click();
    }

    public void clickCommandButtonYesOnPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(popupConfiramtionYesButton));
        driver.findElement(popupConfiramtionYesButton).click();
    }

    public String getTheConfirmationPopup() {

        try {

            new WebDriverWait(driver, Duration.ofSeconds(6))
                    .until(ExpectedConditions.visibilityOfElementLocated(orderSuccessPopup));

            return driver.findElement(orderSuccessPopup).getText();
        } catch (Exception e) {
            return "Истекло время ожидания подтверждения";
        }
    }
}







