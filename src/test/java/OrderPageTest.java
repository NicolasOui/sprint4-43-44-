import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class OrderPageTest extends BaseUiTest {

    @Test
    public void orderTest() {
        OrderPage.cookieConfirmation();
        OrderPage.clickMiddleOrderButton();
        OrderPage.firstList(
                "Иван", "Иванов", "Москва-Петушки, д 45 кв 18",
                "Бульвар Рокоссовского", "+79210001122");

        OrderPage.clickContiueButton();
        OrderPage.secondList("24.04.2026", "сутки", "comment");
        OrderPage.clickFinalOrderButton();
        OrderPage.clickCommandButtonYesOnPopup();

        String actualText = OrderPage.getTheConfirmationPopup();
        assertTrue("Заказ не оформлен. Результат: " + actualText, actualText.contains("Заказ оформлен"));
    }

    @Test
    public void orderTestTwo() {
        OrderPage.cookieConfirmation();
        OrderPage.clickMiddleOrderButton();
        OrderPage.firstList(
                "Олег", "Олегович", "Сыктывкар, ул. Мечты д 1 кв 342",
                "Сокольники", "89990001122");

        OrderPage.clickContiueButton();
        OrderPage.secondList("24.04.2027", "трое суток", "комментарий");
        OrderPage.clickFinalOrderButton();
        OrderPage.clickCommandButtonYesOnPopup();

        String actualText = OrderPage.getTheConfirmationPopup();
        assertTrue("Заказ не оформлен. Результат: " + actualText, actualText.contains("Заказ оформлен"));
    }
}
