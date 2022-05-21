package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //Email поле
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private SelenideElement emailField;

    //Поле Пароль
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordField;

    // Кнопка войти
    @FindBy(how = How.CSS, using = "*[class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginBtn;

    //Кнопка посмотреть пароль
    @FindBy(how = How.CLASS_NAME, using = "input__icon.input__icon-action")
    private SelenideElement seePasswordBtn;

    //Ссылка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[@href='/register']")
    private SelenideElement registerLink;

    //Ссылка Восстановть пароль
    @FindBy(how = How.XPATH, using = "//*[@href='/forgot-password']")
    private SelenideElement restorePasswordLink;

    @Step("User login through restore password")
    public RestorePasswordPage goToRestorePassword() {
        restorePasswordLink.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
        return page(RestorePasswordPage.class);
    }

    @Step("User signIn")
    public MainPage signIn(String email, String password) {

        emailField.shouldBe(Condition.exist, Duration.ofMillis(2000)).setValue(email);
        passwordField.setValue(password);
        loginBtn.click();
        return page(MainPage.class);
    }

}
