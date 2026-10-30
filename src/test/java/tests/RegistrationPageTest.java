package tests;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
                .checkModal()
                .checkSuccessHeader(successModalHeader)
                .checkTable("Student Name",firstName + " " + lastName)
                .checkTable("Student Email",userEmail)
                .checkTable("Gender",gender)
                .checkTable("Mobile",userNumber)
                .checkTable("Date of Birth",day + " " + month + "," + year)
                .checkTable("Subjects",subject)
                .checkTable("Hobbies",hobby)
                .checkTable("Picture","my-image.png")
                .checkTable("Address",currentAddress)
                .checkTable("State and City",state + " " + city)
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
                .checkModal()
                .checkSuccessHeader(successModalHeader)
                .checkTable("Student Name",firstName + " " + lastName)
                .checkTable("Student Email",userEmail)
                .checkTable("Gender",gender)
                .checkTable("Mobile",userNumber)
                .checkTable("Date of Birth",day + " " + month + "," + year)
                .checkEmptyRecord("Subjects")
                .checkEmptyRecord("Hobbies")
                .checkTable("Picture","my-image.png")
                .checkTable("Address",currentAddress)
                .checkEmptyRecord("State and City")
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
