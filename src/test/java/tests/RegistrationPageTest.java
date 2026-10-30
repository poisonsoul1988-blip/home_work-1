package tests;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static testdata.RegistrationPageTestData.*;

@Nested
class RegistrationPageTest extends TestBase{

    @Test
    void successfulFill() {

        registrationPage
                .openPage()
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
                .submitForm()
                .checkSuccessModal()
                .checkFullTable(expectedTable())
                .checkCloseButton();
    }

    @Test
    void requiredFieldsFill() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(gender)
                .typeNumber(userNumber)
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkSuccessModal()
                .checkSuccessHeader(successModalHeader)
                .checkTableRow("Student Name",firstName + " " + lastName)
                .checkTableRow("Student Email",userEmail)
                .checkTableRow("Gender",gender)
                .checkTableRow("Mobile",userNumber)
                .checkTableRow("Date of Birth",day + " " + month + "," + year)
                .checkEmptyTableRow("Subjects")
                .checkEmptyTableRow("Hobbies")
                .checkTableRow("Picture","my-image.png")
                .checkTableRow("Address",currentAddress)
                .checkEmptyTableRow("State and City")
                .checkCloseButton();
    }

    @Test
    void nonNumericPhoneNumber() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(gender)
                .typeNumber("ffffffffffff")
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }

    @Test
    void wrongEmail() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail("rewrerwr")
                .setGender(gender)
                .typeNumber(userNumber)
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userEmail");
    }

    @Test
    void emptyName() {

        registrationPage
                .openPage()
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(gender)
                .typeNumber(userNumber)
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("firstName");
    }

    @Test
    void emptyLastName() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeEmail(userEmail)
                .setGender(gender)
                .typeNumber(userNumber)
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("lastName");
    }

    @Test
    void emptyPhoneNumber() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(gender)
                .setDateOfBirth(day,month,year)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }
}
