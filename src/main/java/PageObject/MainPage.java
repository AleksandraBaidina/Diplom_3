package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    //Кнопка конструктор
    @FindBy(how = How.XPATH, using = ".//*[text()='Конструктор']")
    private SelenideElement constructorBtn;

    //Кнопка Лента Заказов
    @FindBy(how = How.XPATH, using = ".//*[text()='Лента Заказов']")
    private SelenideElement listOfOrdersBtn;

    //Кнопка Личный Кабинет
    @FindBy(how = How.XPATH, using = "//*[@href='/account']")
    private SelenideElement personalAccountBtn;

    // Текст соберите бургер
    @FindBy(how = How.XPATH, using = ".//*[text()='Соберите бургер']")
    private SelenideElement createBurgerText;

    //Раздел булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunSection;

    //Раздел соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement sauceSection;

    //Раздел начинка
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingSection;

    //Перетяните булочку сюда(верх)
    @FindBy(how = How.CSS, using = ".constructor-element.constructor-element_pos_top")
    private SelenideElement topOfBun;

    //Перетяните булочку сюда(низ)
    @FindBy(how = How.CSS, using = ".constructor-element.constructor-element_pos_bottom")
    private SelenideElement bottomOfBun;

    // Войти в аккаунт
    @FindBy(how = How.CSS, using = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg")
    private SelenideElement intoAccount;

    //Лого кнопка
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBtn;

    @Step("Register user")
    public LoginPage signUp(String name, String email, String password) {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        return registerPage.signUp(name, email, password);
    }

    @Step("User login through private personal account")
    public LoginPage goToAccountPage() {
        personalAccountBtn.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
        return page(LoginPage.class);
    }

    @Step("User login through account")
    public LoginPage goToAccount() {
        intoAccount.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
        return page(LoginPage.class);
    }


    public AccountPage clickToPersonalAccountBtn()
    {
        personalAccountBtn.click();
        return page(AccountPage.class);
    }
    @Step("Go to sauce section")
    public void clickSauceSection()
    {
        sauceSection.click();
    }
    @Step("Go to filling section")
    public void clickFillingSection()
    {
        fillingSection.click();

    }
    @Step("Go to bun section")
    public void clickBunSection()
    {
        bunSection.click();
    }
}
