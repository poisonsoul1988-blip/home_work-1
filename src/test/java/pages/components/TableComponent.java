package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;

public class TableComponent {

    private final SelenideElement root;

    public TableComponent(SelenideElement root) {
        this.root = root;
    }

    public TableComponent checkRow(String key, String value){
        root.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public TableComponent checkFullTable(Map<String, String> expected) {
        expected.forEach((label, value) ->
                root.$(byText(label)).parent().$$("td").get(1)
                        .shouldHave(exactText(value)));
        return this;
    }

    public TableComponent checkEmptyRow(String key){
        root.$(byText(key)).sibling(0).shouldBe(empty);
        return this;
    }

}
