package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser ="chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void successfulSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue("Leon");
        $("#userEmail").setValue("testionni@test.com");
        $("#submit").click();

        $("#name").shouldHave(text("Leon"));
        $("#email").shouldHave(text("testionni@test.com"));
    }

    @Test
    public void negativeSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue("Leon");
        $("#userEmail").setValue("testionnitestcom");
        $("#submit").click();

        $("#name").shouldNot(exist);
        $("#email").shouldNot(exist);
    }
}
