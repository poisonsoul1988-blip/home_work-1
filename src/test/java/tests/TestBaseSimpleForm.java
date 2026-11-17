package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.SimpleFormPage;

public class TestBaseSimpleForm {

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

//        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    SimpleFormPage simpleFormPage = new SimpleFormPage();
}
