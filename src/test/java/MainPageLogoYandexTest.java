import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageLogoYandexTest extends BaseUiTest {

    @Test
    public void logoYandexTest() {
        mainPage.cookieConfirmation();
        mainPage.clickLogoYandex();

        // Переключиться на последнюю открытую вкладку (Dzen/Yandex)
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        assertTrue("Переход на Яндекс через логотип не прошёл",
                mainPage.isYandexPageDisplayed());
    }
}