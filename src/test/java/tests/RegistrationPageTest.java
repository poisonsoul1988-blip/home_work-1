package tests;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static testdata.RegistrationPageTestData.*;

@Nested
class RegistrationPageTest extends TestBase {

    @Test
    void successfulFill() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill registration form", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .typeNumber(userNumber)
                    .setDateOfBirth(day,month,year)
                    .typeSubject(subject)
                    .setHobby(hobby)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .setStateAndCity(state,city)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkSuccessModal()
                    .checkFullTable(expectedTable())
                    .checkCloseButton();
        });

    }

    @Test
    void requiredFieldsFill() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill required fields", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .typeNumber(userNumber)
                    .setDateOfBirth(day, month, year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkSuccessModal()
                    .checkSuccessHeader(successModalHeader)
                    .checkTableRow("Student Name", firstName + " " + lastName)
                    .checkTableRow("Student Email", userEmail)
                    .checkTableRow("Gender", gender)
                    .checkTableRow("Mobile", userNumber)
                    .checkTableRow("Date of Birth", day + " " + month + "," + year)
                    .checkEmptyTableRow("Subjects")
                    .checkEmptyTableRow("Hobbies")
                    .checkTableRow("Picture", "my-image.png")
                    .checkTableRow("Address", currentAddress)
                    .checkEmptyTableRow("State and City")
                    .checkCloseButton();
        });

    }

    @Test
    void nonNumericPhoneNumber() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill form with invalid phone number", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .typeNumber("ffffffffffff")
                    .setDateOfBirth(day,month,year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkFormHeader()
                    .checkFieldIsHighlighted("userNumber");
        });

    }

    @Test
    void wrongEmail() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill form with invalid email", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail("rewrerwr")
                    .setGender(gender)
                    .typeNumber(userNumber)
                    .setDateOfBirth(day,month,year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkFormHeader()
                    .checkFieldIsHighlighted("userEmail");
        });

    }

    @Test
    void emptyName() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill form without first name", () -> {
            registrationPage
                    .typeLastName(lastName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .typeNumber(userNumber)
                    .setDateOfBirth(day,month,year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkFormHeader()
                    .checkFieldIsHighlighted("firstName");
        });

    }

    @Test
    void emptyLastName() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill form without last name", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .typeNumber(userNumber)
                    .setDateOfBirth(day,month,year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkFormHeader()
                    .checkFieldIsHighlighted("lastName");
        });

    }

    @Test
    void emptyPhoneNumber() {

        step("Open registration form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill form without last name", () -> {
            registrationPage
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(userEmail)
                    .setGender(gender)
                    .setDateOfBirth(day,month,year)
                    .setPicture(fileName)
                    .typeCurrentAddress(currentAddress)
                    .submitForm();
        });

        step("Check result", () -> {
            registrationPage
                    .checkFormHeader()
                    .checkFieldIsHighlighted("userNumber");
        });
    }
}
