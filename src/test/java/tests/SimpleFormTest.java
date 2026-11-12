package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Class2;




public class SimpleFormTest extends TestBaseSimpleForm {

    Class2 data;

    @BeforeEach
    void setUp() {
        // Генерируем свежий набор данных перед каждым тестом
        data = new Class2();
    }

    @Test
    public void successfulSimpleFormTest() {

        simpleFormPage.openPage()
                .typeUserName(data.firstName)
                .typeEmail(data.userEmail)
                .submitForm()
                .checkField("name",data.firstName)
                .checkField("email",data.userEmail);
    }

    @Test
    public void negativeSimpleFormTest() {

        simpleFormPage.openPage()
                .typeUserName(data.firstName)
                .typeEmail(data.wrongValueRandom)
                .submitForm()
                .checkFieldsAreAbsent("name")
                .checkFieldsAreAbsent("email");
    }
}
