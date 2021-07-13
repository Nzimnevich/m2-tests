package ru.m2.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.m2.helpers.DriverUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    String lastName = RandomStringUtils.randomAlphabetic(9).toLowerCase();

    @Test
    @DisplayName("Test ")
    @Description("Test1")
    void generatedTest() {
        step("Open:\"https://m2.ru/\"", () -> {
            open("https://m2.ru/");
        });

        step("Проверка что есть надпись 'Отвечаем за каждый квадратный метр'", () -> {
            $x("(//*[contains(@class,'home-promo2-block-module--title')])[1]").shouldHave(text("Отвечаем за каждый квадратный метр"));
        });
    }

    @Test
    @DisplayName("Test2 ")
    @Description("Test2")
    void titleTest() {
        step("Open:'https://m2.ru/'", () -> {
            open("https://m2.ru/");
        });

        step("Site has the title: ", () -> {
            String expectedTitle = "Метр квадратный - ипотека и рефинансирование, онлайн сделки с недвижимостью - на сайте m2.ru";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Тест на содержание консоли ошибок")
    @Description("Консоль лог не содержит ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть:\"https://m2.ru/\"", () ->
                open("https://m2.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }


    @Test
    @DisplayName("Тест на выбор другого региона")
    @Description("Выбираем \"Санкт-Петербург\"")
    void choiceRegion() {
        step("Открыть:\"https://m2.ru/\"", () ->
                open("https://m2.ru/"));

        step("Нажать \"Нет,другой\"", () -> {
            $x("//*[contains(@class,'detect-region-modal-module--detectRegionModalContent')]").shouldBe(visible);
            $x("//*[contains(@class,'detect-region-modal-module--regionControlsLink')]/button").shouldBe(visible);
            $x("//*[contains(@class,'detect-region-modal-module--regionControlsLink')]/button").click();
        });
        step("Нажать \"Санкт-Петербург\"", () -> {
            $x("//*[contains(@class,'change-region-modal-module--title')]").shouldBe(visible);
            $x("//*[contains(@class,'change-region-modal-module--defaultRegionItem')] [contains(., 'Санкт-Петербург')]/button").shouldBe(visible);
            $x("//*[contains(@class,'change-region-modal-module--defaultRegionItem')] [contains(., 'Санкт-Петербург')]/button").click();
        });
        step("Нажать \"Выбрать\"", () -> {
            $x("//*[contains(@class,'change-region-modal-module--formButton')]/button").shouldBe(visible);
            $x("//*[contains(@class,'change-region-modal-module--formButton')]/button").click();
        });

        step("Проверить, что отображается надпись: \"Все новостройки Санкт-Петербурга и области\"", () -> {
            $x("//*[contains(@class,'new-buildings-block-module--title')]").shouldBe(text("Все новостройки Санкт-Петербурга и области"));

        });

    }

    @Test
    @DisplayName("Тест на поиск в Санкт-Петербурге")
    @Description("Выбираем город \"Санкт-Петербург\" в фильтре и проверяем, что поиск применился")
    void choice() {
        step("Открыть:\"https://m2.ru/\"", () ->
                open("https://m2.ru/"));

        step("Устанавливаем \"Санкт-Петербург\" в фильтре", () -> {
            $x("//*[contains(@class,'FilterSelectButton__text')][contains(., 'Москва')]").shouldHave(visible);
            $x("//*[contains(@class,'FilterSelectButton__text')][contains(., 'Москва')]/following::i").click();
            $x("//*[contains(@class,'select-module--option')][contains(., 'Санкт-Петербург')]").click();

        });

        step("Нажимаем \"Найти\"", () -> {
            $x(" //*[contains(@class,'SubmitButtons__search-button')]").click();
        });

        step("Отображается информация о локации поиска(\"Санкт-Петербурге\")", () -> {
            $x("//*[contains(@class,'Typography')][contains(., 'Санкт-Петербурге')]").shouldHave(visible);
        });

    }

    @Test
    @Description("Тест на поиск через \"Районы\"")
    @DisplayName("")
    void choiceTwoDistrictsForSearch() {
        step("Открыть:\"https://m2.ru/\"", () ->
                open("https://m2.ru/"));

        step("Нажать\"Найти\"", () -> {
            $x(" //*[contains(@class,'SubmitButtons__search-button')]").click();
        });

        step("Нажать \"Районы\"", () -> {
            $x(" //*[contains(@class,'DesktopGeoFiltersView__extra')][contains(., 'Районы')]").click();

        });
        step("Выбрать \"Донской\"", () -> {
            $x("//*[contains(@class,'checkbox-module__checkbox-')][contains(., 'Донской')]").click();
        });

        step("Выбрать \"Донской\"", () -> {
            $x("//*[contains(@class,'checkbox-module__checkbox-')][contains(., 'Лефортово')]").click();
        });

        step("Проверить, что выбрано 2 района для поиска", () -> {
            $(".GeoSelector__selected-tip-label").shouldBe(text("2 района"));
        });

        step("Нажать \"Показать N\"", () -> {
            $(".GeoSelector__submit-button button").click();
        });

        step("Проверяем, что фильтр \"Лефортово\" применился к выдачи", () -> {
            $x("//*[contains(@class,'Typography Typography_noWrap')][contains(., 'Лефортово')]").shouldBe(visible);
        });

        step("Проверяем, что фильтр \"Донской\" применился к выдачи", () -> {
            $x("//*[contains(@class,'Typography Typography_noWrap')][contains(., 'Донской')]").shouldBe(visible);
        });

        step("Проверяем, что есть хотя бы одно объявление по заданому фильтру", () -> {
            $(".OffersSearchList__item").shouldBe(visible);
        });

    }

    @Test
    @DisplayName("Тест на авторизацию")
    @Description("Выполняем авторизацию для уже созданного пользователя")
    void authorizationTest() {
        step("Открыть:\"https://m2.ru/\"", () -> {
            open("https://m2.ru/");
        });
        step("Нажать\"Войти\"", () -> {
            $x(" (//button[contains(., 'Войти')])[1]").click();
        });
        step("Ввести номер телефона \"9251695187\"", () -> {
            $x("//*[contains(@class,'auth_input-module__control')]").sendKeys("9251695187");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Ввести пароль \"Qwerty123\"", () -> {
            $("[data-gtm ='pers-show-login-client-pass']").shouldBe(visible);
            $x(" //*[contains(@class,'auth_input-module__control')]").click();
            $x(" //*[contains(@class,'auth_input-module__control')]").sendKeys("Qwerty123");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Отображается \"Профиль\" внутри ЛК", () -> {
            $("#account").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Тест на вкладку \"Мои объявления\"")
    @Description("Проверерям, что в аккаунте нет объявлений во вкладке \"Мои объявления\"")
    void myAnnouncementsTest() {
        step("Открыть:\"https://m2.ru/\"", () -> {
            open("https://m2.ru/");
        });
        step("Нажать\"Войти\"", () -> {
            $x(" (//button[contains(., 'Войти')])[1]").click();
        });
        step("Ввести номер телефона \"9251695187\"", () -> {
            $x("//*[contains(@class,'auth_input-module__control')]").sendKeys("9251695187");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Ввести пароль \"Qwerty123\"", () -> {
            $("[data-gtm ='pers-show-login-client-pass']").shouldBe(visible);
            $x(" //*[contains(@class,'auth_input-module__control')]").click();
            $x(" //*[contains(@class,'auth_input-module__control')]").sendKeys("Qwerty123");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Нажать \"Мои объявления\" внутри ЛК", () -> {
            $("#offer-placement").click();
        });

        step("У пользователя отображается \" У вас пока нет объявлений. Вы можете добавить новое объявление.\" (вкладка \"Мои объявления\" )", () -> {
            $(".EmptyMessage__text").shouldBe(text("У вас пока нет объявлений.\n" +
                    "Вы можете добавить новое объявление."));
        });
    }

    @Test
    @DisplayName("Тест на редактирование профиля")
    @Description("Изменить \"Фамилия\" на рандомное значение, сохранить, проверить ")
    void noResultSearch() {
        step("Открыть:\"https://m2.ru/\"", () -> {
            open("https://m2.ru/");
        });
        step("Нажать\"Войти\"", () -> {
            $x(" (//button[contains(., 'Войти')])[1]").click();
        });
        step("Ввести номер телефона \"9251695187\"", () -> {
            $x("//*[contains(@class,'auth_input-module__control')]").sendKeys("9251695187");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Ввести пароль \"Qwerty123\"", () -> {
            $("[data-gtm ='pers-show-login-client-pass']").shouldBe(visible);
            $x(" //*[contains(@class,'auth_input-module__control')]").click();
            $x(" //*[contains(@class,'auth_input-module__control')]").sendKeys("Qwerty123");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });

        step("Нажать \"Профиль\"", () -> {
            $("#account").click();
        });

        step("Установить рандомную фамилию длинною в 9 символов в \"Фамилия\"", () -> {
            $("input[name='lastName']").click();
            $("input[name='lastName']").sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
            $("input[name='lastName']").setValue(lastName);
            $("input[name='lastName']").sendKeys(Keys.ENTER);
        });

        step("Нажать \"Сохранить изменения\"", () -> {
            $x("//button[contains(@class,'personal-area_button-module__control')]").click();
        });

        step("Появился popup  с текстом \"Успешно сохранено.\"", () -> {
            $x("//*[contains(@class,'root_toaster-content-module__containe')]/*[contains(@class,'root_toaster-content-module__message')]").shouldBe(visible);
            $x("//*[contains(@class,'root_toaster-content-module__containe')]/*[contains(@class,'root_toaster-content-module__message')]").shouldBe(text("Успешно сохранено."));
        });

        step("Обновить страницу", () -> {
            Selenide.refresh();
        });

        step("Указанная фамилия отображается в поле \"Фамилия\"", () -> {
            $(String.format("input[value='%s']", lastName)).shouldBe(exist, Duration.ofMillis(5));
        });
    }


    @Test
    @DisplayName("Тест на logout")
    @Description("авторизоваться и выполнить \"logout\"")
    void logoutTest() {
        step("Открыть:\"https://m2.ru/\"", () -> {
            open("https://m2.ru/");
        });
        step("Нажать\"Войти\"", () -> {
            $x(" (//button[contains(., 'Войти')])[1]").click();
        });
        step("Ввести номер телефона \"9251695187\"", () -> {
            $x("//*[contains(@class,'auth_input-module__control')]").sendKeys("9251695187");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });
        step("Ввести пароль \"Qwerty123\"", () -> {
            $("[data-gtm ='pers-show-login-client-pass']").shouldBe(visible);
            $x(" //*[contains(@class,'auth_input-module__control')]").click();
            $x(" //*[contains(@class,'auth_input-module__control')]").sendKeys("Qwerty123");
        });
        step("Нажать \"Продолжить\"", () -> {
            $x("(//button[contains(@class,'auth_button-module__control')])[1]").click();
        });

        step("Отображается \"Профиль\" внутри ЛК", () -> {
            $("#account").shouldBe(visible);
        });

        step("Нажать \"Выход\" внутри ЛК", () -> {
            $("button#logout").click();
        });

        step("Отображается кнопка  \"Войти\" ", () -> {
            $x(" (//button[contains(., 'Войти')])[1]").shouldBe(visible);
        });
    }
}