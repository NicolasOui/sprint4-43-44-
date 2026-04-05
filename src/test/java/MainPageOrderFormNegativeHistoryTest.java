import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class MainPageOrderFormNegativeHistoryTest extends BaseUiTest {

    @Test
    public void OrderFormNegativeTest() {
    mainPageOrderFormNegativeHistory.cookieConfirmation();
    mainPageOrderFormNegativeHistory.clickTopOrderButton();
    mainPageOrderFormNegativeHistory.clickContiueButton();

    assertEquals("Ошбика при заполнении поля Имя", "Введите корректное имя",
            mainPageOrderFormNegativeHistory.getErrorMessage(mainPageOrderFormNegativeHistory.errorFirstName));
    assertEquals("Ошбика при заполнении поля Фамилия", "Введите корректную фамилию",
            mainPageOrderFormNegativeHistory.getErrorMessage(mainPageOrderFormNegativeHistory.errorLastName));
    assertEquals("Ошбика при заполнении поля Адрес", "",
                mainPageOrderFormNegativeHistory.getErrorMessageForAdressField(mainPageOrderFormNegativeHistory.errorAdress));
    assertEquals("Ошбика при заполнении поля Станция метро", "Выберите станцию",
                mainPageOrderFormNegativeHistory.getErrorMessage(mainPageOrderFormNegativeHistory.errorSubway));
    assertEquals("Ошбика при заполнении поля Номер телефона", "Введите корректный номер",

    mainPageOrderFormNegativeHistory.getErrorMessage(mainPageOrderFormNegativeHistory.errorPhone));
    mainPageOrderFormNegativeHistory.completeFiledsToContinuerAndClick();
    mainPageOrderFormNegativeHistory.findAndFillDateDelivery("12.08.2026");
    mainPageOrderFormNegativeHistory.clickOrderButton();
    assertFalse("Поле Срок аренды не заполнено", mainPageOrderFormNegativeHistory.isOrderButtonEnabled());
    mainPageOrderFormNegativeHistory.clearDateDeliveryField();
    mainPageOrderFormNegativeHistory.findAndFillLeaseTerme("сутки");
    mainPageOrderFormNegativeHistory.clickOrderButton();
    assertFalse("Поле Дата аренды не заполнено", mainPageOrderFormNegativeHistory.isOrderButtonEnabled());
    }
}
