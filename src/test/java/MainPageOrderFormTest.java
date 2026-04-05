import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageOrderFormTest extends BaseUiTest {


    @Test
    public void orderTest() {
        mainPageAccordeon.cookieConfirmation();
        mainPageOrderForm.clickMiddleOrderButton();
        mainPageOrderForm.firstList(
                "Иван", "Уганда", "Москва-Петушки, д 45 кв 18",
                "Бульвар Рокоссовского", "+79210001122");
        mainPageOrderForm.clickContiueButton();
        mainPageOrderForm.secondList("24.04.2026", "сутки", "comment");
        mainPageOrderForm.clickFinalOrderButton();
        mainPageOrderForm.clickCommandButtonYesOnPopup();
        String actualTextConfiramtion = mainPageOrderForm.getTheConfirmationPopup();
        assertTrue("Заказ не оформлен. Результат: " + actualTextConfiramtion, actualTextConfiramtion.contains("Заказ оформлен"));
    }

    @Test
    public void orderTestTwo() {
        mainPageOrderForm.cookieConfirmation();
        mainPageOrderForm.clickMiddleOrderButton();
        mainPageOrderForm.firstList(
                "Олег", "Олегович", "Сыктывкар, ул. Мечты д 1 кв 342",
                "Сокольники", "89990001122");
        mainPageOrderForm.clickContiueButton();
        mainPageOrderForm.secondList("24/04/2027", "трое суток", "комментарий");
        mainPageOrderForm.clickFinalOrderButton();
        mainPageOrderForm.clickCommandButtonYesOnPopup();
        String actualTextConfiramtion = mainPageOrderForm.getTheConfirmationPopup();
        assertTrue("Заказ не оформлен. Результат: " + actualTextConfiramtion, actualTextConfiramtion.contains("Заказ оформлен"));
    }
}
