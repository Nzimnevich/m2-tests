package ru.m2.tests;

import ru.m2.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Проверка надписи на сайте")
    void generatedTest() {
        step("Открыть 'https://m2.ru/'", () -> {
            open("https://m2.ru/");
        });

        step("Проверка что есть надпись 'Отвечаем за каждый квадратный метр'", () -> {
            $x("(//*[contains(@class,'home-promo2-block-module--title')])[1]").shouldHave(text("Отвечаем за каждый квадратный метр"));
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://m2.ru/'", () ->
            open("https://m2.ru/"));

        step("Page title should have text 'Метр квадратный - ипотека и рефинансирование, онлайн сделки с недвижимостью - на сайте m2.ru'", () -> {
            String expectedTitle = "Метр квадратный - ипотека и рефинансирование, онлайн сделки с недвижимостью - на сайте m2.ru";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://m2.ru/'", () ->
            open("https://m2.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}