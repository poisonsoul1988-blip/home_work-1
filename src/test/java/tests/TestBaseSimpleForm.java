package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.SimpleFormPage;

public class TestBaseSimpleForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser ="chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        Configuration.timeout = 10000;
    }

    SimpleFormPage simpleFormPage = new SimpleFormPage();
}
