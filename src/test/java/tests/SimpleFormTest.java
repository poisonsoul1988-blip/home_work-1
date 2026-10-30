package tests;

import org.junit.jupiter.api.Test;

import static testdata.SimpleFormTestData.*;


public class SimpleFormTest extends TestBaseSimpleForm {

    @Test
    public void successfulSimpleFormTest() {
        simpleFormPage.openPage()
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkField("name",userName)
                .checkField("email",userEmail);
    }

    @Test
    public void negativeSimpleFormTest() {
        simpleFormPage.openPage()
                .typeUserName(userName)
                .typeEmail("testionnitestcom")
                .submitForm()
                .checkFieldsAreAbsent("name")
                .checkFieldsAreAbsent("email");
    }
}
