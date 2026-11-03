package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static testdata.RegistrationPageTestData.*;
import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomAddress;

@Nested
class RegistrationPageTest extends TestBase{

    String firstNameRandom;
    String lastNameRandom;
    String userEmailRandom;
    String genderRandom;
    String userNumberRandom;
    String dayRandom;
    String monthRandom;
    String yearRandom;
    String subjectRandom;
    String hobbyRandom;
    String stateRandom;
    String cityRandom;
    String currentAddressRandom;
    String wrongValueRandom;
    LocalDate randomDate = getRandomDate();

    @BeforeEach
    void prepareRandomDate() {
        firstNameRandom = getRandomString(10);
        lastNameRandom = getRandomString(10);
        userEmailRandom =  getRandomEmail();
        genderRandom = getRandomGender();
        userNumberRandom = getRandomPhone();
        dayRandom = getRandomDay(randomDate);
        monthRandom = getRandomMonth(randomDate);
        yearRandom = getRandomYear(randomDate);
        subjectRandom = getRandomSubject();
        hobbyRandom = getRandomHobby();
        currentAddressRandom = getRandomAddress();
        stateRandom = getRandomState();
        cityRandom = getRandomCity(stateRandom);
        wrongValueRandom = getRandomString(10);
    }

    @Test
    void successfulFill() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeLastName(lastNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .typeNumber(userNumberRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .typeSubject(subjectRandom)
                .setHobby(hobbyRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .setStateAndCity(stateRandom,cityRandom)
                .submitForm()
                .checkSuccessModal()
                .checkTableRow("Student Name",firstNameRandom + " " + lastNameRandom)
                .checkTableRow("Student Email",userEmailRandom)
                .checkTableRow("Gender",genderRandom)
                .checkTableRow("Mobile",userNumberRandom)
                .checkTableRow("Date of Birth",dayRandom + " " + monthRandom + "," + yearRandom)
                .checkTableRow("Subjects",subjectRandom)
                .checkTableRow("Hobbies",hobbyRandom)
                .checkTableRow("Picture","my-image.png")
                .checkTableRow("Address",currentAddressRandom)
                .checkTableRow("State and City", stateRandom + " " + cityRandom)
                .checkCloseButton();
    }

    @Test
    void requiredFieldsFill() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeLastName(lastNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .typeNumber(userNumberRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkSuccessModal()
                .checkSuccessHeader(successModalHeader)
                .checkTableRow("Student Name",firstNameRandom + " " + lastNameRandom)
                .checkTableRow("Student Email",userEmailRandom)
                .checkTableRow("Gender",genderRandom)
                .checkTableRow("Mobile",userNumberRandom)
                .checkTableRow("Date of Birth",dayRandom + " " + monthRandom + "," + yearRandom)
                .checkEmptyTableRow("Subjects")
                .checkEmptyTableRow("Hobbies")
                .checkTableRow("Picture","my-image.png")
                .checkTableRow("Address",currentAddressRandom)
                .checkEmptyTableRow("State and City")
                .checkCloseButton();
    }

    @Test
    void nonNumericPhoneNumber() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeLastName(lastNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .typeNumber(wrongValueRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }

    @Test
    void wrongEmail() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeLastName(lastNameRandom)
                .typeEmail(wrongValueRandom)
                .setGender(genderRandom)
                .typeNumber(userNumberRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userEmail");
    }

    @Test
    void emptyName() {

        registrationPage
                .openPage()
                .typeLastName(lastNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .typeNumber(userNumberRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("firstName");
    }

    @Test
    void emptyLastName() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .typeNumber(userNumberRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("lastName");
    }

    @Test
    void emptyPhoneNumber() {

        registrationPage
                .openPage()
                .typeFirstName(firstNameRandom)
                .typeLastName(lastNameRandom)
                .typeEmail(userEmailRandom)
                .setGender(genderRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }
}
