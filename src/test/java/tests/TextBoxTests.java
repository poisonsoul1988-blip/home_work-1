package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TextBoxTestData.*;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

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