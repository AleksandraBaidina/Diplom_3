package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    //Заголовок Регистрация
    @FindBy(how = How.XPATH, using = ".//*[text()='Регистрация']")
    public SelenideElement registerText;

    //Имя поле
    @FindBy(how = How.XPATH,using = "(//input[@name='name'])[1]")
    public SelenideElement nameField;

    //Email поле
    @FindBy(how = How.XPATH,using = "(//input[@name='name'])[2]")
    public SelenideElement emailField;

    //Пароль поле
    @FindBy(how = How.XPATH,using = "//input[@type='password']")
    public SelenideElement passwordField;

    //Кнопка посмотреть пароль
    @FindBy(how = How.CLASS_NAME,using = ".input__icon.input__icon-action")
    public SelenideElement seePasswordBtn;

    //Кнопка Зарегистрироваться
    @FindBy(how = How.CSS,using = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    public SelenideElement registerBtn;

    //Ссылка Войти
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    public SelenideElement loginLink;

    //Сообщение некорректный пароль
    @FindBy(how = How.XPATH, using = "//*[text()='Некорректный пароль']")
    public SelenideElement errorMsgWrongPassword;



        @Step("Register user")
        public LoginPage signUp(String name, String email,String password) {
            nameField.shouldBe(Condition.exist, Duration.ofMillis(1000)).setValue(name);
            emailField.setValue(email);
            passwordField.setValue(password);
            registerBtn.click();
            return page(LoginPage.class);
        }

        @Step("SignIn through registration page")
        public LoginPage gotoLogin(){
            loginLink.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
            return page(LoginPage.class);
        }

    }

