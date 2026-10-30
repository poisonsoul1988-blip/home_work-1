package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

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
    private SelenideElement tableResults= $(".table-responsive");
    private SelenideElement closeSuccessModalButton = $("#closeLargeModal");

    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public  RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public  RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public  RegistrationPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public  RegistrationPage setGender(String value){
        genderContainer.$(byText(value)).click();
        return this;
    }

    public  RegistrationPage typeNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    public  RegistrationPage setDateOfBirth(String day, String month, String year){
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public  RegistrationPage typeSubject(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbyContainer.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value){
        pictureInput.uploadFromClasspath(value);
        return this;
    }


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

    public  RegistrationPage setStateAndCity(String state, String city){
        setState(state);
        setCity(city);
        return this;
    }

    public  RegistrationPage submitForm(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkSuccessModal(){
        successModal.shouldBe(visible);
        return this;
    }

    public RegistrationPage checkSuccessHeader(String message){
        successModalHeader.shouldHave(text(message));
        return this;
    }

    public RegistrationPage checkTableRow(String key, String value){
        tableResults.$(byText(key)).parent().shouldHave(text(value));
        return this;
   }

    public RegistrationPage checkFullTable(Map<String, String> expected) {
        expected.forEach((label, value) ->
                tableResults.$(byText(label)).parent().$$("td").get(1)
                        .shouldHave(exactText(value)));
        return this;
    }

    public RegistrationPage checkEmptyTableRow(String key){
        tableResults.$(byText(key)).sibling(0).shouldBe(empty);
        return this;
    }

    public RegistrationPage checkCloseButton(){
        closeSuccessModalButton.shouldBe(visible);
        return this;
    }

    public RegistrationPage checkFormHeader(){
        formHeader.shouldBe(visible);
        return this;
    }

    public RegistrationPage checkFieldIsHighlighted(String key){
        $(byId(key)).shouldHave(cssValue("border-color",
                "rgb(220, 53, 69)"));
        return this;
    }
}
