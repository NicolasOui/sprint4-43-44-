import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MainPageOrderFormNegativeHistoryTest extends BaseUiTest {

    @Test
    public void orderFormNegativeTest() {
        mainPage.cookieConfirmation();
        mainPage.clickTopOrderButton();
        mainPage.clickContinueButton();

        assertEquals("Ошибка при заполнении поля Имя", "Введите корректное имя",
                mainPage.getErrorMessage(mainPage.errorFirstName));

        assertEquals("Ошибка при заполнении поля Фамилия", "Введите корректную фамилию",
                mainPage.getErrorMessage(mainPage.errorLastName));

        assertEquals("Ошибка при заполнении поля Адрес", "",
                mainPage.getErrorMessageForAdressField(mainPage.errorAddress));

        assertEquals("Ошибка при заполнении поля Станция метро", "Выберите станцию",
                mainPage.getErrorMessage(mainPage.errorSubway));

        assertEquals("Ошибка при заполнении поля Номер телефона", "Введите корректный номер",
                mainPage.getErrorMessage(mainPage.errorPhone));

        mainPage.completeFiledsToContinuerAndClick();

        // Проверки срока аренды: Дата заполняется, срок аренды нет
        mainPage.findAndFillDateDelivery("12.08.2026");
        mainPage.clickOrderButton();
        assertFalse("Кнопка заказа должна быть заблокирована, если срок аренды пуст",
                mainPage.isOrderButtonEnabled());

        // Проверить дату: Срок аренды заполнен, дата нет
        mainPage.clearDateDeliveryField();
        mainPage.findAndFillLeaseTerm("сутки");
        mainPage.clickOrderButton();
        assertFalse("Кнопка заказа должна быть заблокирована, если дата доставки пуста",
                mainPage.isOrderButtonEnabled());
    }
}