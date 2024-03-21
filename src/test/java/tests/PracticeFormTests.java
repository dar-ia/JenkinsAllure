package tests;

import org.junit.jupiter.api.*;
import pages.PracticeFormPage;
import utils.TestDataGeneration;

@DisplayName("Set of tests for practice form")
public class PracticeFormTests extends TestBase {

    PracticeFormPage page = new PracticeFormPage();
    TestDataGeneration testData = new TestDataGeneration();
    String firstName,
            lastName,
            userEmail,
            userPhoneNumber,
            userGender,
            userSubject,
            city,
            state,
            userHobby,
            userAddress,
            fileName,
            birthDay,
            birthMonth,
            birthYear;

    @Test
    @DisplayName("Form is filled fully")
    @Tags({
            @Tag("POSITIVE"),
            @Tag("E2E")
    })
    void verifyFullInformationTest() {
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userEmail = testData.generateUserEmail();
        userPhoneNumber = testData.generateUserPhone();
        userSubject = testData.generateSubject();
        userGender = testData.generateGender();
        userHobby = testData.generateHobby();
        userAddress = testData.generateAddress();
        fileName = testData.generateFileSelection();
        birthYear = testData.generateYear();
        birthMonth = testData.generateMonth();
        birthDay = testData.generateDay(birthMonth);
        state = testData.generateState();
        city = testData.generateCity(state);
        page.openPage()
                .closeBanners()
                .assertPageTitle("Student Registration Form")
                .setFistName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userPhoneNumber)
                .setGender(userGender)
                .setCalendar(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .setCurrentAddress(userAddress)
                .uploadFie(fileName)
                .setStateAndCity(state, city)
                .submitForm();

        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", firstName + " " + lastName)
                .assertTableRecord("Student Email", userEmail)
                .assertTableRecord("Gender", userGender)
                .assertTableRecord("Mobile", userPhoneNumber)
                .assertTableRecord("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .assertTableRecord("Subjects", userSubject)
                .assertTableRecord("Hobbies", userHobby)
                .assertTableRecord("Picture", fileName)
                .assertTableRecord("Address", userAddress)
                .assertTableRecord("State and City", state + " " + city)
                .closeTable()
                .assertPageTitle("Student Registration Form");
    }

    @Test
    @DisplayName("Form is filled with minimal required information")
    @Tags({
            @Tag("POSITIVE")
    })
    void verifyMinimalInformationTest() {
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userPhoneNumber = testData.generateUserPhone();
        userGender = testData.generateGender();

        page.openPage()
                .closeBanners()
                .assertPageTitle("Student Registration Form")
                .setFistName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhoneNumber)
                .setGender(userGender)
                .submitForm();

        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", firstName + " " + lastName)
                .assertTableRecord("Gender", userGender)
                .assertTableRecord("Mobile", userPhoneNumber)
                .closeTable()
                .assertPageTitle("Student Registration Form");

    }

    @Test
    @Tag("NEGATIVE")
    @DisplayName("Negative case")
    void verifyNegativeTest() {
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userPhoneNumber = testData.generateUserPhone();

        page.openPage()
                .closeBanners()
                .assertPageTitle("Student Registration Form");

        page.setFistName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhoneNumber)
                .submitForm()
                .assertPageTitle("Student Registration Form");

    }

}
