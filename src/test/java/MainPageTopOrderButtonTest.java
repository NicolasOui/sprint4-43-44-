import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class MainPageTopOrderButtonTest extends BaseUiTest {

    @Test
    public void orderTest() {
        mainPageAccordeon.cookieConfirmation();
        mainPageTopOrderButton.clickTopOrderButton();
        assertTrue("Форма заказа не появилась после клика!", mainPageTopOrderButton.isOrderFormVisible());  //assertTrue("Форма заказа не появилась после клика!", mainPageTopOrderButton.orderForm.isDisplayed());
    }
}


