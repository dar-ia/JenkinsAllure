package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private SelenideElement tableElement = $(".table-responsive");
    public void assertRecord(String key, String value) {
        tableElement.$(byText(key)).parent().shouldHave(text(value));
    }
}
