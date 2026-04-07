import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class MainPageTopOrderButtonTest extends BaseUiTest {

    @Test
    public void orderTest() {
        mainPage.cookieConfirmation();
        mainPage.clickTopOrderButton();

        assertTrue("Форма заказа не появилась после клика!",
                mainPage.isOrderFormVisible());
    }
}