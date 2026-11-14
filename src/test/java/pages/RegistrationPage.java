package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //Elements
    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement formHeader = $(".text-center");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbyContainer = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateCityConteiner = $("#stateCity-wrapper");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement successModal = $(".modal-content");
    private SelenideElement successModalHeader = $(".modal-header");
    private SelenideElement closeSuccessModalButton = $("#closeLargeModal");

    private final TableComponent resultsTable = new TableComponent($(".table-responsive"));

    //Actions

    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Type first name {value}")
    public  RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Type last name {value}")
    public  RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Type first email {value}")
    public  RegistrationPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    @Step("Set gender {value}")
    public  RegistrationPage setGender(String value){
        genderContainer.$(byText(value)).click();
        return this;
    }

    @Step("Type phone number {value}")
    public  RegistrationPage typeNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    @Step("Set date of birth {day} {month} {year}")
    public  RegistrationPage setDateOfBirth(String day, String month, String year){
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Type subject {value}")
    public  RegistrationPage typeSubject(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Set hobby {value}")
    public RegistrationPage setHobby(String value){
        hobbyContainer.$(byText(value)).click();
        return this;
    }

    @Step("Type set picture {value}")
    public RegistrationPage setPicture(String value){
        pictureInput.uploadFromClasspath(value);
        return this;
    }


    @Step("Type current address {value}")
    public  RegistrationPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public  RegistrationPage setState(String value){
        stateSelect.click();
        stateCityConteiner.$(byText(value)).click();
        return this;
    }

    public  RegistrationPage setCity(String value){
        citySelect.click();
        stateCityConteiner.$(byText(value)).click();
        return this;
    }

    @Step("Set state {state} and city {city}")
    public  RegistrationPage setStateAndCity(String state, String city){
        setState(state);
        setCity(city);
        return this;
    }

    @Step("Submit")
    public  RegistrationPage submitForm(){
        submitButton.click();
        return this;
    }

    @Step("Check that modal appeared")
    public RegistrationPage checkSuccessModal(){
        successModal.shouldBe(visible);
        return this;
    }

    @Step("Check modal header text ")
    public RegistrationPage checkSuccessHeader(String message){
        successModalHeader.shouldHave(text(message));
        return this;
    }

    @Step("Check table that table raw {key} has text {value}")
    public RegistrationPage checkTableRow(String key, String value) {
        resultsTable.checkRow(key, value);
        return this;
    }

    @Step("Check full table content")
    public RegistrationPage checkFullTable(Map<String, String> expected) {
        resultsTable.checkFullTable(expected);
        return this;
    }

    @Step("Check empty table raw")
    public RegistrationPage checkEmptyTableRow(String key) {
        resultsTable.checkEmptyRow(key);
        return this;
    }

    @Step("Check close modal button")
    public RegistrationPage checkCloseButton(){
        closeSuccessModalButton.shouldBe(visible);
        return this;
    }

    @Step("Check form header")
    public RegistrationPage checkFormHeader(){
        formHeader.shouldBe(visible);
        return this;
    }

    @Step("Check that field is highlighted in red")
    public RegistrationPage checkFieldIsHighlighted(String key){
        $(byId(key)).shouldHave(cssValue("border-color",
                "rgb(220, 53, 69)"));
        return this;
    }
}
