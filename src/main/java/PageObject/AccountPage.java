package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


import static com.codeborne.selenide.Selenide.page;

public class AccountPage {
    //Кнопка конструктор
    @FindBy(how = How.XPATH, using = ".//*[text()='Конструктор']")
    public SelenideElement constructorBtn;

    //Лого кнопка
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBtn;

    //Профиль
    @FindBy(how = How.XPATH, using = "//*[@href='/account/profile']")
    public SelenideElement profile;

    //История заказов
    @FindBy(how = How.XPATH, using = "//*[@href='/account/order-history']")
    public SelenideElement orderHistory;

    //Выход
    @FindBy(how = How.XPATH, using = ".//*[text()='Выход']")
    public SelenideElement logoutBtn;

    // Текст В этом разделе вы можете изменить свои персональные данные
    @FindBy(how = How.CSS, using = ".Account_text__fZAIn.text.text_type_main-default")
    public SelenideElement changeYourDataText;

    //Редактировать поле имя
    @FindBy(how = How.XPATH, using = "//div[@class='input__icon input__icon-action'])[1]")
    public SelenideElement editNameField;

    // Редактировать поле логин
    @FindBy(how = How.XPATH, using = "//div[@class='input__icon input__icon-action'])[2]")
    public SelenideElement editLoginField;

    //Редактировать поле пароль
    @FindBy(how = How.XPATH, using = "//div[@class='input__icon input__icon-action'])[3]")
    public SelenideElement editPasswordField;

    //Кнопка отмена
    @FindBy(how = How.XPATH, using = ".//*[text()='Отмена']")
    public SelenideElement cancelBtn;

    //Кнопка сохранить
    @FindBy(how = How.XPATH, using = ".//*[text()='Сохранить']")
    public SelenideElement saveBtn;

    @Step("User logout")
    public LoginPage logout(){
      //
//        try {
//        //check if it's account page indeed.
//        // we can't just use Element.exist(), since the time is need to the page have been loaded.
//        // We can't use just selenide shouldBe(), since in case if element is not present, I was unable to catch exception.
//
//            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 2);
//            wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath(".//*[text()='Выход']")));
//
            logoutBtn.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
            return page(LoginPage.class);
//        }
//        catch (org.openqa.selenium.TimeoutException e) {
//            return open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
//        }
    }

    @Step("Go to main page")
    //переход на страницу коструктора.
    public MainPage goToMainPage()
    {
        constructorBtn.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
        return page(MainPage.class);
    }

    //переход на страницу коструктора.
    @Step("Go to logo main page")
    public MainPage goToMainPageByLogo()
    {
        logoBtn.shouldBe(Condition.exist, Duration.ofMillis(1000)).click();
        return page(MainPage.class);
    }
}
