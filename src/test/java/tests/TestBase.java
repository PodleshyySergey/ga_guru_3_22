package tests;

import com.codeborne.selenide.Configuration;
import drivers.CustomWebDriver;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUpAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;

    }

    @BeforeEach
    void setUp() {
        step("Открытие главной страницы вебсайта \"https://aliradar.com/\"", ()-> {
            open("https://aliradar.com/");
        });
    }

    @AfterEach
    public void afterEach(){
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();

        closeWebDriver();
    }
}
