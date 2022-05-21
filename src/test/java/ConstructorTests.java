import PageObject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.ThreadLocalSelenideDriver;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ConstructorTests {

    @Before
    public void setUp()
    {
        //Для тестирования в браузере Янедкс, раскомментировать код

//        System.setProperty("webdriver.chrome.driver","Drivers/yandexdriver.exe");
//        WebDriver driver =new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);

    }

    @After
    public void tearDown(){// all tests should be fully independent
        WebDriverRunner.driver().close();
    }



    @Test
    @DisplayName("Login through personal account")
    @Description("Check login through personal account")
    public void loginThroughPersonalSetting() throws InterruptedException {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.goToAccountPage();
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.loginBtn.exists());
    }

    @Test
    @DisplayName("Login through account")
    @Description("Check login through account")
    public void loginThroughAccount(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.goToAccount();
        Assert.assertTrue(loginPage.loginBtn.exists());

    }

    @Test
    @DisplayName("Constructor.Go to sauce section")
    @Description("Check sauce section selected")
    public void goToSauceSection() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickSauceSection();
        Assert.assertFalse(mainPage.bunSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertTrue(mainPage.sauceSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertFalse(mainPage.fillingSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Constructor.Go to bun section")
    @Description("Check bun section selected")
    public void goToBunSection() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickSauceSection();
        mainPage.clickBunSection();
        Assert.assertTrue(mainPage.bunSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertFalse(mainPage.sauceSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertFalse(mainPage.fillingSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Constructor.Go to filling section")
    @Description("Check filling section selected")
    public void goToFillingSection(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickFillingSection();
        Assert.assertFalse(mainPage.bunSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertFalse(mainPage.sauceSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assert.assertTrue(mainPage.fillingSection.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Go to personal account from main page")
    @Description("Check clickability from personal account to main page")
    public void goToPersonalAccount() {
        //проверка для уже авторизированного пользователя
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        MainPage mainPage = loginPage.signIn("Polly@mail.ru","PollyPolly");
        mainPage.clickToPersonalAccountBtn();
        AccountPage accountPage = page(AccountPage.class);
        Assert.assertTrue(accountPage.profile.shouldBe(Condition.exist, Duration.ofMillis(1000)).exists());
        }

}
