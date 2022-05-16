import PageObject.AccountPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AccountTests {

    @Before
    public void setUp()
    {
        //Для тестирования в браузере Янедкс, расскомментировать код

//        System.setProperty("webdriver.chrome.driver","Drivers/yandexdriver.exe");
//        WebDriver driver =new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);

    }

    @After
    public void tearDown(){// all tests should be fully independent
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("User logout")
    @Description("User try to logout")
    public void userLogout() {
        //проверка для уже авторизированного пользователя
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        MainPage mainPage = loginPage.signIn("Polly@mail.ru","PollyPolly");
        mainPage.personalAccountBtn.click();
        AccountPage accountPage = page(AccountPage.class);
        loginPage =  accountPage.logout();
        Assert.assertTrue(loginPage.loginBtn.exists());
    }

    @Test
    @DisplayName("Go to logo from personal account")
    @Description("Check clickability from personal account to logo")
    public void authorizedUserFromPersonalAccountByLogo() throws InterruptedException {
        //проверка для уже авторизированного пользователя
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        MainPage mainPage = loginPage.signIn("Polly@mail.ru","PollyPolly");
        mainPage.personalAccountBtn.click();
        AccountPage accountPage = page(AccountPage.class);
        //проверяем что открылась странца конструктора.
        Assert.assertTrue(accountPage.goToMainPageByLogo().createBurgerText.shouldBe(exist, Duration.ofMillis(1000)).exists());

    }

    @Test
    @DisplayName("Go to constructor from personal account")
    @Description("Check clickability from personal account to main page")
    public void authorizedUserFromPersonalAccountToConstructor() throws InterruptedException {
        //проверка для уже авторизированного пользователя
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        MainPage mainPage = loginPage.signIn("Polly@mail.ru","PollyPolly");
        mainPage.personalAccountBtn.click();
        AccountPage accountPage = page(AccountPage.class);
        //проверяем что открылась странца конструктора.
        Assert.assertTrue(accountPage.goToMainPage().createBurgerText.shouldBe(exist,Duration.ofMillis(1000)).exists());
    }


}
