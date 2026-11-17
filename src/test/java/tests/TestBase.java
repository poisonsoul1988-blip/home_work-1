package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "151.0";
//        Configuration.timeout = 15000;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = chromeOptions;

        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.addVideo();
////        Attach.attachAsText("Some file","Some content");
//    }

    @AfterEach
    void tearDown() {
        try {
            // Сначала делаем скриншоты и собираем аттачменты, пока браузер открыт
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.addVideo();
        } finally {
            // Браузер закрываем в самом конце и гарантированно (даже если упали аттачменты)
            closeWebDriver();
        }
    }
}


