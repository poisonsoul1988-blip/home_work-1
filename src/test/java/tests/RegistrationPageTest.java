package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Class2;

import static testdata.RegistrationPageTestData.fileName;
import static testdata.RegistrationPageTestData.successModalHeader;

class RegistrationPageTest extends TestBase {

    Class2 data;

    @BeforeEach
    void setUp() {
        // Генерируем свежий набор данных перед каждым тестом
        data = new Class2();
    }

    @Test
    void successfulFill() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .typeNumber(data.userNumber)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .typeSubject(data.subjectRandom)
                .setHobby(data.hobbyRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddress)
                .setStateAndCity(data.stateRandom, data.cityRandom)
                .submitForm()
                .checkSuccessModal()
                .checkTableRow("Student Name", data.firstName + " " + data.lastName)
                .checkTableRow("Student Email", data.userEmail)
                .checkTableRow("Gender", data.genderRandom)
                .checkTableRow("Mobile", data.userNumber)
                .checkTableRow("Date of Birth", data.dayRandom + " " + data.monthRandom + "," + data.yearRandom)
                .checkTableRow("Subjects", data.subjectRandom)
                .checkTableRow("Hobbies", data.hobbyRandom)
                .checkTableRow("Picture", fileName)
                .checkTableRow("Address", data.currentAddress)
                .checkTableRow("State and City", data.stateRandom + " " + data.cityRandom)
                .checkCloseButton();
    }

    @Test
    void requiredFieldsFill() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .typeNumber(data.userNumber)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkSuccessModal()
                .checkSuccessHeader(successModalHeader)
                .checkTableRow("Student Name", data.firstName + " " + data.lastName)
                .checkTableRow("Student Email", data.userEmail)
                .checkTableRow("Gender", data.genderRandom)
                .checkTableRow("Mobile", data.userNumber)
                .checkTableRow("Date of Birth", data.dayRandom + " " + data.monthRandom + "," + data.yearRandom)
                .checkEmptyTableRow("Subjects")
                .checkEmptyTableRow("Hobbies")
                .checkTableRow("Picture", fileName)
                .checkTableRow("Address", data.currentAddressRandom)
                .checkEmptyTableRow("State and City")
                .checkCloseButton();
    }

    @Test
    void nonNumericPhoneNumber() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .typeNumber(data.wrongValueRandom)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }

    @Test
    void wrongEmail() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.wrongValueRandom)
                .setGender(data.genderRandom)
                .typeNumber(data.userNumber)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userEmail");
    }

    @Test
    void emptyName() {
        registrationPage
                .openPage()
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .typeNumber(data.userNumber)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("firstName");
    }

    @Test
    void emptyLastName() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .typeNumber(data.userNumber)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("lastName");
    }

    @Test
    void emptyPhoneNumber() {
        registrationPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderRandom)
                .setDateOfBirth(data.dayRandom, data.monthRandom, data.yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(data.currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }
}