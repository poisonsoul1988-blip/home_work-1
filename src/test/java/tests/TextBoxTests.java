package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TextBoxTestData.*;
import static utils.RandomUtils.*;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    String userNameRandom;
    String userEmailRandom;
    String currentAddressRandom;
    String permanentAddressRandom;

    @BeforeEach
    void prepareRandomDate() {
        userNameRandom = getRandomString(10);
        userEmailRandom =  getRandomEmail();
        currentAddressRandom = getRandomAddress();
        permanentAddressRandom = getRandomAddress();
    }

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail)
                .checkField("currentAddress",currentAddress)
                .checkField("permanentAddress",permanentAddress);
    }

    @Test
    void successfulFillFormTestWithFaker() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .typeCurrentAddress(currentAddress )
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail)
                .checkField("currentAddress",currentAddress)
                .checkField("permanentAddress",permanentAddress);
    }

    @Test
    void successfulFillFormTestWithUtils() {

        textBoxPage.openPage()
                .typeUserName(userNameRandom)
                .typeEmail(userEmailRandom)
                .typeCurrentAddress(currentAddressRandom)
                .typePermanentAddress(permanentAddressRandom)
                .submitForm()
                .checkField("name",userNameRandom)
                .checkField("email",userEmailRandom)
                .checkField("currentAddress",currentAddressRandom)
                .checkField("permanentAddress",permanentAddressRandom);
    }

    @Test
    void successfulFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail);
    }

    @Test
    void successfulFillFormWithoutAddressTestWithUtils() {
        textBoxPage.openPage()
                .typeUserName(userNameRandom)
                .typeEmail(userEmailRandom)
                .submitForm()
                .checkField("name",userNameRandom)
                .checkField("email",userEmailRandom);
    }

    @Test
    void successfulFillFormWithoutAddressTest_chaining() {
        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail);
    }
}