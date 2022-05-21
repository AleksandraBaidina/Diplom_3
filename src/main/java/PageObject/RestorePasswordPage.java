package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {
    //Текст Восстановление пароля
    @FindBy(how = How.XPATH, using = ".//*[text()='Восстановление пароля']")
    private SelenideElement restorePasswordText;

    //Поле Email
    @FindBy(how = How.CSS, using = ".input.pr-6.pl-6.input_type_text.input_size_default")
    private SelenideElement emailField;

    //Кнопка восстановить
    @FindBy(how = How.CSS, using = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement restoreBtn;

    //Ссылка Войти
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    private SelenideElement loginLink;

}
