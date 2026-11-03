package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static testdata.SimpleFormTestData.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class SimpleFormTest extends TestBaseSimpleForm {

    String userNameRandom;
    String userEmailRandom;
    String wrongValueRandom;

    @BeforeEach
    void prepareRandomDate() {
        wrongValueRandom = getRandomString(10);
    }

    @Test
    public void successfulSimpleFormTest() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();

        simpleFormPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail);
    }

    @Test
    public void negativeSimpleFormTest() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();

        simpleFormPage.openPage()
                .typeUserName(userName)
                .typeEmail(wrongValueRandom)
                .submitForm()
                .checkFieldsAreAbsent("name")
                .checkFieldsAreAbsent("email");
    }
}
