import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageLogoSamokatTest extends BaseUiTest {

    @Test
    public void logoTest() {
        mainPage.cookieConfirmation();
        mainPage.clickTopOrderButton();
        mainPage.clickLogoSamokat();

        assertTrue("Переход на главную по клику на логотип Самокат не прошёл",
                mainPage.isMainPageDisplayed());
    }
}