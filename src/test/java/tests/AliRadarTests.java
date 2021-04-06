package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Main functional")
@Story("Regression tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AliRadarTests extends TestBase {

//    Вакансия - https://spb.hh.ru/vacancy/41149443
//    Сайт компании - https://aliradar.com/

    @Test
    @Order(0)
    @DisplayName("Открытие главной страницы сайта")
    void openStartPage() {

        step("Проверка отображения текста \"AliRadar – лучший способ выбрать товар в интернете\".", ()-> {
            $(byText("AliRadar – лучший способ выбрать товар в интернете")).shouldBe(Condition.visible);
        });
        step("Проверка отображения текста \"Полезные категории\".", ()-> {
            $(byText("Полезные категории")).shouldBe(Condition.visible);
        });
        step("Проверка отображения текста \"Горящие товары и лучшие скидки\".", ()-> {
            $(byText("Горящие товары и лучшие скидки")).shouldBe(Condition.visible);
        });
        step("Проверка отображения текста \"Установи расширение для браузера\".", ()-> {
            $(byText("Установи расширение для браузера")).shouldBe(Condition.visible);
        });

    }

    @Test
    @Order(1)
    @DisplayName("Проверка перехода на страницу установки приложения и наличия кнопки \"Установить\".")
    void testSetupApp() {

        step("Обращение к кнопке \"Доступно в Google Play\".", ()-> {
            $x("//*[@alt='Google Play badge']").parent().scrollTo().click();
        });
        step("Переход на страницу установки приложения.", ()-> {
            switchTo().window(1);
        });
        step("Проверка отображения на странице текста \"AliRadar - помощник в покупках\".", ()-> {
            $(byText("AliRadar — помощник в покупках")).shouldBe(Condition.visible);
        });
        step("Проверка наличия кнопки \"Установить\" и закрытие страницы.", ()-> {
            $(byText("Установить")).shouldBe(Condition.visible);
//            closeWindow();
        });
    }

    @Test
    @Order(2)
    @DisplayName("Проверка перехода на страницу установки расширения для браузера и наличия кнопки \"Установить\".")
    void testSetupExtension() {

        step("Обращение к кнопке установки расширения для браузера.", ()-> {
            $(byText("Установи расширение для браузера")).parent().$(byText("Установить AliRadar")).click();
        });
        step("Переход на страницу установки расширения.", ()-> {
            switchTo().window(1);
        });
        step("Проверка отображения на странице текста \"AliRadar - помощник в покупках\".", ()-> {
            $(byText("AliRadar - помощник в покупках")).shouldBe(Condition.visible);
        });
        step("Проверка наличия кнопки \"Установить\".", ()-> {
            $(byText("Установить")).shouldBe(Condition.visible);
//            closeWindow();
        });
        
    }

    @Test
    @Order(3)
    @DisplayName("Поиск товара и проверка наличия кнопки \"Перейти в магазин\" для выбранного товара.")
    void testSearchAndBuyProduct() {

        step("Ввод запроса в строку поиска и обращение к Enter.", ()-> {
            $(byName("q")).setValue("readmi airdots").pressEnter();
            sleep(5000);
        });
        step("Выбор товара из списка.", ()-> {
            $("[data-ga-card='page-category']",4).click();
        });
        step("Переход на страницу с описанием товара.", ()-> {
            switchTo().window(1);
            sleep(5000);
        });
        step("Проверка наличия кнопки \"Перейти в магазин\".", ()-> {
            $(byText("Перейти в магазин")).shouldBe(Condition.visible);
//            closeWindow();
        });

    }

    @Test
    @AllureId("2193")
    @Order(4)
    @DisplayName("Проверка отображения на главной странице категорий товаров в разделе \"Полезные категории\".")
    void testCheckCategoryInUsefulCategories() {

        step("Проверка отображения категории \"Наручные часы\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Наручные часы')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Мобильные телефоны и аксессуары\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Мобильные телефоны и аксессуары')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Мужская одежда\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Мужская одежда')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Красота и здоровье\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Красота и здоровье')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Спорт и развлечения\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Спорт и развлечения')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Лампы и освещение\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Лампы и освещение')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Ремонт и обустройство дома\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Ремонт и обустройство дома')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Багаж и сумки\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Багаж и сумки')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Инструменты\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Инструменты')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Бытовая техника\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Бытовая техника')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Авто и мототовары\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Авто и мототовары')]").shouldBe(Condition.visible);
        });
        step("Проверка отображения категории \"Мать и ребенок\" в разделе \"Полезные категории\".", ()-> {
            $x("//h2[contains(text(), 'Полезные категории')]/..//h3[contains(text(), 'Мать и ребенок')]").shouldBe(Condition.visible);
        });
    }
}
