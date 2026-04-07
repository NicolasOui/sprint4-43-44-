package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;

    private By logoYandex = By.xpath("//img[@alt='Yandex']");
    private By logoSamokat = By.xpath("//img[@alt='Scooter']");
    private By imageScooterBlueprint = By.xpath("//img[@alt='Scooter blueprint']");
    private By cookieButton = By.id("rcc-confirm-button");
    private By topOrderButton = By.className("Button_Button__ra12g");
    private By orderForm = By.xpath(".//input[@placeholder='* Имя']");
    private By continueButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By inputFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By inputSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By inputDateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By inputLeaseTerm = By.className("Dropdown-placeholder");
    private By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    public By errorFirstName = By.xpath("//div[text()='Введите корректное имя']");
    public By errorLastName = By.xpath("//div[text()='Введите корректную фамилию']");
    public By errorAddress = By.xpath("//div[text()='Введите корректный адрес']");
    public By errorSubway = By.xpath("//div[text()='Выберите станцию']");
    public By errorPhone = By.xpath("//div[text()='Введите корректный номер']");
    private String accordeonHeadingId = "accordion__heading-";
    private String accordeonPanelId = "accordion__panel-";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // логотипы
    public void clickLogoYandex() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoYandex)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public boolean isYandexPageDisplayed() {
        return wait.until(ExpectedConditions.urlContains("dzen.ru")) ||
                wait.until(ExpectedConditions.urlContains("yandex.ru"));
    }

    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
    }

    public boolean isMainPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageScooterBlueprint)).isDisplayed();
    }

    public boolean isOrderFormVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm)).isDisplayed();
    }

    // кнопи
    public void cookieConfirmation() {
        driver.findElement(cookieButton).click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    //для аккордеона
    public void clickOnAccordeonQuestion(int index) {
        driver.findElement(By.id(accordeonHeadingId + index)).click();
    }

    public String getActualAccordeonAnswer(int index) {
        By answerLocator = By.id(accordeonPanelId + index);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator)).getText();
    }

    // анкеты позитивный сценарий
    public void fillFirstOrderPage(String name, String lastName, String address, String station, String phone) {
        driver.findElement(inputFirstName).sendKeys(name);
        driver.findElement(inputLastName).sendKeys(lastName);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputSubwayStation).click();

        By stationLocator = By.xpath(".//div[text()='" + station + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(stationLocator)).click();

        driver.findElement(inputPhone).sendKeys(phone);
        clickContinueButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputDateDelivery));
    }

    public void findAndFillDateDelivery(String date) {
        driver.findElement(inputDateDelivery).click();
        driver.findElement(inputDateDelivery).sendKeys(date, Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("react-datepicker__month-container")));
    }

    public void findAndFillLeaseTerm(String period) {
        driver.findElement(inputLeaseTerm).click();
        By leaseTermOption = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='" + period + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaseTermOption)).click();
    }

    public void clickOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finalOrderButton)).click();
    }

    // анкеты негативный
    public void completeFiledsToContinuerAndClick() {
        fillFirstOrderPage("Имя", "Фамилия", "Арбаба д. 34", "Спортивная", "+79112223344");
    }

    public void clearDateDeliveryField() {
        driver.findElement(inputDateDelivery).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
    }

    public boolean isOrderButtonEnabled() {
        return driver.findElement(finalOrderButton).isEnabled();
    }

    public String getErrorMessage(By errorLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).getText();
    }

    public String getErrorMessageForAdressField(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
