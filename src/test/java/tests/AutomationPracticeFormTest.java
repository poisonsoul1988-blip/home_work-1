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
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("99999999999");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("[id=uploadPicture]").uploadFromClasspath("my-image.png");
        $("[id=currentAddress]").setValue("Bullet street 7");
        $("#state").click();
        $("#react-select-3-listbox").$(byText("NCR")).click();
        $("#city").click();
        $("#react-select-4-listbox").$(byText("Delhi")).click();
        $("[id=submit]").click();

        $(".modal-open").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Leon Testionni"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("leon@testionni.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9999999999"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 August,1988"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my-image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Bullet street 7"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void requiredFieldsFill() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("#genterWrapper").$(byText("Male")).click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Leon Testionni"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("leon@testionni.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9999999999"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 August,1988"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldBe(empty);
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldBe(empty);
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my-image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Bullet street 7"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldBe(empty);
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void nonNumericPhoneNumber() {

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Leon");
        $("[id=lastName]").setValue("Testionni");
        $("[id=userEmail]").setValue("leon@testionni.com");
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#genterWrapper").$(byText("Male")).click();
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
