package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageOrderFormNegativeHistory {
    WebDriver driver;
    WebDriverWait wait;

    public MainPageOrderFormNegativeHistory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    
    
    private By cookieButton = By.id("rcc-confirm-button");
    private By topOrderButton = By.className("Button_Button__ra12g");
    private By continuerButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By orderForm = By.xpath(".//input[@placeholder='* Имя']");
    public By errorFirstName = By.xpath("//div[text()='Введите корректное имя']");
    public By errorLastName = By.xpath("//div[text()='Введите корректную фамилию']");
    public By errorAdress = By.xpath("//div[text()='Введите корректный адрес']");
    public By errorSubway = By.xpath("//div[text()='Выберите станцию']");
    public By errorPhone = By.xpath("//div[text()='Введите корректный номер']");
    private By placeholderName = By.xpath(".//input[@placeholder='* Имя']");
    private By placeholderLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By placeholderAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By placeholderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By dateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By leaseTerme = By.className("Dropdown-placeholder");
    private By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    public void cookieConfirmation() {
        driver.findElement(cookieButton).click();
    }
    
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }

    public void clickContiueButton() {
        driver.findElement(continuerButton).click();
    }

    // Один метод на чек всех ошибок
    public String getErrorMessage(By errorLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).getText();
    }

    //отдельный метод для поля адрес
    public String getErrorMessageForAdressField(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            return ""; // Если элемента нет, вернёт пустоту без ожидания
        }
    }
    
    public void completeFiledsToContinuerAndClick() {
        driver.findElement(placeholderName).sendKeys("Имя");
        driver.findElement(placeholderLastName).sendKeys("Фамилия");
        driver.findElement(placeholderAdress).sendKeys("Арбаба д. 34");
        driver.findElement(subwayStation).click();
        By SubwayStationFromList = By.xpath(".//div[contains(@class, 'select-search__select')]//*[text()='Спортивная']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SubwayStationFromList));
        driver.findElement(SubwayStationFromList).click();
        driver.findElement(placeholderPhone).sendKeys("+79112223344");
        driver.findElement(continuerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateDelivery));
    }

    //проверка полей со звёздочками второй анкеты
    //проверка поля "Срока аренды". Заполнить поле "Когда привезти", Срок аренды оставить пустым
    public void findAndFillDateDelivery(String date) {
        driver.findElement(dateDelivery).click();
        driver.findElement(dateDelivery).sendKeys(date);
        driver.findElement(dateDelivery).sendKeys(Keys.ENTER);             // Нажать Enter, закрыть календарь
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("react-datepicker__month-container")));
    }

    public void clickOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finalOrderButton));
        driver.findElement(finalOrderButton).click();
    }

    public boolean isOrderButtonEnabled() {
        return driver.findElement(finalOrderButton).isEnabled();
    }


    //очистить поля "Когда привезти"
    public void clearDateDeliveryField() {
        // Выделить текст через Control + A и удалить
        driver.findElement(dateDelivery).sendKeys(Keys.CONTROL + "a");
        driver.findElement(dateDelivery).sendKeys(Keys.BACK_SPACE);
    }

    //проверка поля "Когда привезти". Заполнить поле "Срок аренды", Когда привезти оставить пустым
    public void findAndFillLeaseTerme(String period) {
        driver.findElement(leaseTerme).click();
        By leaseTermeFromList = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='" + period + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaseTermeFromList));
        driver.findElement(leaseTermeFromList).click();
    }
}
