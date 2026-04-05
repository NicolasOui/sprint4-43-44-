import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageLogoSamokatTest extends BaseUiTest {

    @Test
    public void logoTest() {
        mainPageLogoSamokat.clickTopOrderButton();
        mainPageLogoSamokat.clickLogoSamokat();
        assertTrue("Переход на главную по клику на логотип Самокат не прошёл", mainPageLogoSamokat.isMainPageDisplayed());
    }
}
