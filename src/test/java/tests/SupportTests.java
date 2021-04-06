package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Feature("Main functional")
@Story("Support tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SupportTests extends TestBase {

    @Test
    @Order(0)
    @DisplayName("Проверка сообщений валидаторов с незаполненными обязательными полями на форме сообщения в поддержку.")
    void unsuccessfulSendSupportMessage() {

        step("Обращение к кнопке \"Поддержка\".", ()-> {
//            $(byText("Поддержка"), 1).click();
            $(byText("Поддержка")).click();
        });
        step("Проверка открытия формы отправки сообщения в Поддрежку.", ()-> {
            $(byText("Если у вас возникли вопросы или пожелания по работе сервиса AliRadar, напишите нам:")).shouldBe(Condition.visible);
        });
        step("Фокусировка на 3-х полях без заполнения.", ()-> {
            $(byText("Email")).preceding(0).click();
            $(byText("Имя пользователя")).preceding(0).click();
            $(byText("Сообщение")).preceding(0).click();
        });
        step("Обращение к кнопке \"Отправить\".", ()-> {
            $(byText("Отправить")).click();
        });
        step("Провекра отображения сообщений валидаторов для 3-х полей.", ()-> {
            $(byText("Введите корректный email")).shouldBe(Condition.visible);
            $(byText("Пожалуйста, введите имя")).shouldBe(Condition.visible);
            $(byText("Пожалуйста, введите сообщение")).shouldBe(Condition.visible);
        });

    }

    @Test
    @Order(1)
    @DisplayName("Проверка отправки сообщения в поддержку.")
    void successfulSendSupportMessage() {

        step("Обращение к кнопке \"Поддержка\".", ()-> {
            $(byText("Поддержка")).click();
        });
        step("Проверка открытия формы отправки сообщения в Поддрежку.", ()-> {
            $(byText("Если у вас возникли вопросы или пожелания по работе сервиса AliRadar, напишите нам:")).shouldBe(Condition.visible);
        });
        step("Заполнение 3-х полей корректными данными.", ()-> {
            $(byText("Email")).preceding(0).sendKeys("test@test.com");
            $(byText("Имя пользователя")).preceding(0).sendKeys("testUser");
            $(byText("Сообщение")).preceding(0).sendKeys("Test message for support.");
        });
        step("Обращение к кнопке \"Отправить\".", ()-> {
            $(byText("Отправить")).click();
        });
        step("Проверка отображения сообщений о том, что запрос отправлен", ()-> {
            $(byText("Ваш запрос отправлен!")).shouldBe(Condition.visible);
            $(byText("Он будет мгновенно просмотрен одним из лучших специалистов и бережно передан в обработку. Мы постараемся ответить и помочь вам как можно скорее.")).shouldBe(Condition.visible);
        });

    }

}
