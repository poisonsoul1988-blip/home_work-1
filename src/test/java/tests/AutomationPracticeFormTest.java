package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest extends TestBase{

    @Test
    void successfulFill() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("99999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $(".subjects-auto-complete__input-container").click();
        $(".subjects-auto-complete__input").setValue("E");
        $(byText("English")).click();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("[id=submit]").click();

        $(".modal-open").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("Leon Testionni"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("leon@testionni.com"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("9999999999"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("06 August,1988"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("English"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Sports"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("my-image.png"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Bullet street 7"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void requiredFieldsFill() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("99999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".modal-open").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("Leon Testionni"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("leon@testionni.com"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("9999999999"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("06 August,1988"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(exactText(""));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(exactText(""));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("my-image.png"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Bullet street 7"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(exactText(""));
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void nonNumericPhoneNumber() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("ffffffffffff");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".text-center").shouldBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongEmail() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("rewrerwr");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".text-center").shouldBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyName() {

        open("/automation-practice-form");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".text-center").shouldBe(visible);
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyLastName() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".text-center").shouldBe(visible);
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyPhoneNumber() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("[id=gender-radio-1]").click();
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("[id=submit]").click();

        $(".text-center").shouldBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
