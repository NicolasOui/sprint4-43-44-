import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageLogoYandexTest extends BaseUiTest {

    @Test
    public void logoYandexTest() {
        mainPageLogoYandex.clickLogoYandex();


        // Переключиться на последнюю открытую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }


        assertTrue("Переход на Яндекс через логотип не прошёл", mainPageLogoYandex.isYandexPageDisplayed());
    }
}
