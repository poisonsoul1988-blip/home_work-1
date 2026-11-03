package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TextBoxTestData.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    String userNameU;
    String userEmailU;

    @BeforeEach
    void prepareRandomDate() {
        userNameU = getRandomString(10);
        userEmailU =  getRandomEmail();
    }

    @Test
    void successfulFillFormTest() {
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
        String userName = getRandomString(10);
        String userEmail = getRandomEmail();
        String currentAddress = "first address 1";
        String permanentAddress = "second address 2";

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
    void successfulFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail);
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