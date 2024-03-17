package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

public class TestDataGeneration {
    private Faker fakerTestData = new Faker(new Locale("en"));

    public String generateFirstName() {
        return fakerTestData.name().firstName();
    }

    public String generateLastName() {
        return fakerTestData.name().lastName();
    }

    public String generateUserEmail() {
        return fakerTestData.internet().emailAddress();
    }

    public String generateUserPhone() {
        return fakerTestData.phoneNumber().subscriberNumber(10);
    }

    public String generateGender() {
        return fakerTestData.options().option("Female", "Male");
    }

    public String generateSubject() {
        return fakerTestData.options().option("Accounting",
                "Arts",
                "Biology",
                "Chemistry",
                "Computer Science",
                "Civics",
                "Commerce",
                "English",
                "Economics",
                "Hindi",
                "History",
                "Maths",
                "Physics",
                "Social Studies");
    }

    public String generateHobby() {
        return fakerTestData.options().option("Sports", "Reading", "Music");
    }

    public String generateFileSelection() {
        return fakerTestData.options().option("images.png", "notpng.jpeg", "ping.jpg");
    }

    public String generateAddress() {
        return fakerTestData.address().fullAddress();
    }

    public String generateYear() {
        return String.valueOf(fakerTestData.number().numberBetween(1920, 2024));
    }

    public String generateMonth() {
        return fakerTestData.options().option("January",
                "February",
                "March",
                "April",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }

    public String generateDay(String month) {
        String dayOfMonth = "";
        if (month.equals("February")) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 28));
        } else if (List.of("January", "March", "May", "July", "August", "October", "December").contains(month)) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 31));
        } else if (List.of("April", "June", "September", "November").contains(month)) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 30));
        }
        return dayOfMonth;
    }

    public String generateState() {
        return fakerTestData.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public String generateCity(String state) {
        String city = "";
        if (state.equals("NCR")) {
            city = fakerTestData.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = fakerTestData.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            city = fakerTestData.options().option("Karnal", "Panipat");
        } else {
            city = fakerTestData.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }


}
