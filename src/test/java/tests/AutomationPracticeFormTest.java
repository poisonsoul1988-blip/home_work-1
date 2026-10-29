package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.AutomationPracticeFormTestData.*;

public class AutomationPracticeFormTest extends TestBase{

    @Test
    void successfulFill() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-listbox").$(byText("NCR")).click();
        $("#city").click();
        $("#react-select-4-listbox").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-open").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 August,1988"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectsInput));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my-image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void requiredFieldsFill() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".modal-open").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 August,1988"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldBe(empty);
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldBe(empty);
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my-image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldBe(empty);
        $("#closeLargeModal").shouldBe(visible);
    }

    @Test
    void nonNumericPhoneNumber() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("ffffffffffff");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".text-center").shouldBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongEmail() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("rewrerwr");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".text-center").shouldBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyName() {

        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".text-center").shouldBe(visible);
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyLastName() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".text-center").shouldBe(visible);
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyPhoneNumber() {

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1988");
        $("div.react-datepicker__day.react-datepicker__day--006").click();
        $("#uploadPicture").uploadFromClasspath("my-image.png");
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $(".text-center").shouldBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
