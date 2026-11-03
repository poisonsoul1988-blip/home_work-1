package tests;

import com.github.javafaker.Faker;
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

    String genderRandom;
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

        genderRandom = getRandomGender();
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
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        String currentAddress = faker.address().fullAddress();

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderRandom)
                .typeNumber(userNumber)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .typeSubject(subjectRandom)
                .setHobby(hobbyRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(stateRandom,cityRandom)
                .submitForm()
                .checkSuccessModal()
                .checkTableRow("Student Name",firstName + " " + lastName)
                .checkTableRow("Student Email",userEmail)
                .checkTableRow("Gender",genderRandom)
                .checkTableRow("Mobile",userNumber)
                .checkTableRow("Date of Birth",dayRandom + " " + monthRandom + "," + yearRandom)
                .checkTableRow("Subjects",subjectRandom)
                .checkTableRow("Hobbies",hobbyRandom)
                .checkTableRow("Picture","my-image.png")
                .checkTableRow("Address",currentAddress)
                .checkTableRow("State and City", stateRandom + " " + cityRandom)
                .checkCloseButton();
    }

    @Test
    void requiredFieldsFill() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderRandom)
                .typeNumber(userNumber)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkSuccessModal()
                .checkSuccessHeader(successModalHeader)
                .checkTableRow("Student Name",firstName + " " + lastName)
                .checkTableRow("Student Email",userEmail)
                .checkTableRow("Gender",genderRandom)
                .checkTableRow("Mobile",userNumber)
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
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
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
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(wrongValueRandom)
                .setGender(genderRandom)
                .typeNumber(userNumber)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userEmail");
    }

    @Test
    void emptyName() {
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);


        registrationPage
                .openPage()
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderRandom)
                .typeNumber(userNumber)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("firstName");
    }

    @Test
    void emptyLastName() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeEmail(userEmail)
                .setGender(genderRandom)
                .typeNumber(userNumber)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("lastName");
    }

    @Test
    void emptyPhoneNumber() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderRandom)
                .setDateOfBirth(dayRandom,monthRandom,yearRandom)
                .setPicture(fileName)
                .typeCurrentAddress(currentAddressRandom)
                .submitForm()
                .checkFormHeader()
                .checkFieldIsHighlighted("userNumber");
    }
}
