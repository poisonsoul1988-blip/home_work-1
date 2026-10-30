package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormPage {
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement submitButton = $("#submit");

    public SimpleFormPage openPage() {
        open("/text-box.html");
        return this;
    }

    public  SimpleFormPage typeUserName(String value){
        userNameInput.setValue(value);
        return this;
    }

    public  SimpleFormPage typeEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public  SimpleFormPage submitForm(){
        submitButton.click();
        return this;
    }

    public SimpleFormPage checkField(String key, String value){
        $(byId(key)).shouldHave(text(value));
        return this;
    }

    public SimpleFormPage checkFieldsAreAbsent(String key){
        $(byId(key)).shouldNot(exist);
        return this;
    }
}
