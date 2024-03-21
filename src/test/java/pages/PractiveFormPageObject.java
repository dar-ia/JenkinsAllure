package pages;

import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PractiveFormPageObject {

    private SelenideElement firstNameElement = $("#firstName");
    private SelenideElement lastNameElement = $("#lastName");
    private SelenideElement userEmailElement = $("#userEmail");
    private SelenideElement userNumberElement = $("#userNumber");
    private SelenideElement currentAddressElement = $("#currentAddress");
    private SelenideElement subjectElement = $("#subjectsInput");
    private SelenideElement stateElement = $("#react-select-3-input");
    private SelenideElement genderButtonsElement = $("#genterWrapper");
    private SelenideElement hobbiesElement = $("#hobbiesWrapper");

    private SelenideElement uploadFileElement = $(".form-control-file");

    private SelenideElement cityElement = $("#react-select-4-input");

    private SelenideElement tableTitleElement = $("#example-modal-sizes-title-lg");

    private SelenideElement mainTitleElement = $(byText("Student Registration Form"));
    private SelenideElement tableCloseElement = $("#closeLargeModal");
    private SelenideElement submitFormElement = $("#submit");

    CalendarComponent calendar = new CalendarComponent();

    @Step("Open page")
    public PractiveFormPageObject openPage() {
        open("/automation-practice-form");
        return this;
    }
    public  PractiveFormPageObject closeBanners(){
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Set fist name")
    public PractiveFormPageObject setFistName(String firstName) {
        firstNameElement.setValue(firstName);
        return this;
    }

    @Step("Set last name")
    public PractiveFormPageObject setLastName(String lastName) {
        lastNameElement.setValue(lastName);
        return this;
    }

    @Step("Set user email")
    public PractiveFormPageObject setUserEmail(String userEmail) {
        userEmailElement.setValue(userEmail);
        return this;
    }

    @Step("Set phone number")
    public PractiveFormPageObject setUserNumber(String userNumber) {
        userNumberElement.setValue(userNumber);
        return this;
    }

    @Step("Set current address")
    public PractiveFormPageObject setCurrentAddress(String address) {
        currentAddressElement.setValue(address);
        return this;
    }

    @Step("Set subject")
    public PractiveFormPageObject setSubject(String subject) {
        subjectElement.setValue(subject).pressEnter();
        return this;
    }

    @Step("Set state and city")
    public PractiveFormPageObject setStateAndCity(String state, String city) {
        stateElement.setValue(state).pressEnter();
        cityElement.setValue(city).pressEnter();
        return this;
    }

    @Step("Set gender")
    public PractiveFormPageObject setGender(String gender) {
        genderButtonsElement.$(byText(gender)).click();
        return this;

    }

    @Step("Set hobby")
    public PractiveFormPageObject setHobby(String hobby) {
        hobbiesElement.$(byText(hobby)).click();
        return this;
    }

    @Step("Set calendar")
    public PractiveFormPageObject setCalendar(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        calendar.setCalendarDate(day, month, year);
        return this;
    }

    @Step("Upload file")
    public PractiveFormPageObject uploadFie(String filename) {
        uploadFileElement.uploadFromClasspath(filename);
        return this;
    }

    @Step("Assert key {key} is equal to {value} in table result")
    public PractiveFormPageObject assertTableRecord(String key, String value) {
        TableResultComponent result = new TableResultComponent();
        result.assertRecord(key, value);
        return this;
    }

    @Step("Assert table title")
    public PractiveFormPageObject assertTableTitle(String title) {
        tableTitleElement.shouldHave(text(title));
        return this;
    }

    @Step("Assert page title")
    public PractiveFormPageObject assertPageTitle(String title) {
        mainTitleElement.shouldHave(text(title));
        return this;
    }

    @Step("Close table")
    public PractiveFormPageObject closeTable() {
        tableCloseElement.click(usingJavaScript());
        return this;
    }

    @Step("Submit form")

    public PractiveFormPageObject submitForm() {
        submitFormElement.click();
        return this;
    }


}
