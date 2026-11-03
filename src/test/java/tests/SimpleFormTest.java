package tests;

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
        userNameRandom = getRandomString(10);
        userEmailRandom = getRandomEmail();
        wrongValueRandom = getRandomString(10);
    }

    @Test
    public void successfulSimpleFormTest() {
        simpleFormPage.openPage()
                .typeUserName(userNameRandom)
                .typeEmail(userEmailRandom)
                .submitForm()
                .checkField("name",userNameRandom)
                .checkField("email",userEmailRandom);
    }

    @Test
    public void negativeSimpleFormTest() {
        simpleFormPage.openPage()
                .typeUserName(userNameRandom)
                .typeEmail(wrongValueRandom)
                .submitForm()
                .checkFieldsAreAbsent("name")
                .checkFieldsAreAbsent("email");
    }
}
