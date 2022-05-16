import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import PageObject.RestorePasswordPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class SignInSignUpTests {

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
    @DisplayName("User register")
    @Description("User register success")
    public void register() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage =  mainPage.signUp("dsf","sdfsdf@sdf.ru","dsfdfsgsdg");
        Assert.assertTrue(loginPage.loginBtn.isDisplayed()); //check that login page exist.

    }

    @Test
    @DisplayName("Register user with incorrect password")
    @Description("User try to register with less than 6 symbols in password field")
    public void registerWithIncorrectPassword(){ ;
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.signUp("dsf","sdfdf@sdf.ru","sgsdg");
        Assert.assertTrue(registerPage.errorMsgWrongPassword.isDisplayed());

    }

    @Test
    @DisplayName("Login through registration page")
    @Description("Check login through registration page")
    public void loginTroughRegistrationPage(){
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        LoginPage loginPage = registerPage.gotoLogin();
        Assert.assertTrue(loginPage.loginBtn.exists());

    }

    @Test
    @DisplayName("Login through restore password")
    @Description("Check login through restore password")
    public void loginThroughRestorePage(){
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        RestorePasswordPage restorePasswordPage = loginPage.goToRestorePassword();
        Assert.assertTrue(loginPage.loginBtn.exists());
    }


}
