package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


import static java.lang.String.format;

public class Class1 {

    private final Faker faker = new Faker();

        public String firstName() {
            return faker.name().firstName();
        }

        public String lastName() {
            return faker.name().lastName();
        }

        public String email() {
            return faker.internet().emailAddress();
        }

        public String phone() {
            return faker.phoneNumber().subscriberNumber(10);
        }

        public String fullAddress() {
        return faker.address().fullAddress();
        }

    public String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));

        return result.toString();
    }

    public String getRandomAddress() {
        return format("%s %s", getRandomString(8), getRandomInt(1,999));
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemStringArray(genders);
    }

    public LocalDate getRandomDate() {
        int minEpochDay = (int) LocalDate.of(1926, 1, 1).toEpochDay();
        int maxEpochDay = (int) LocalDate.of(2012, 12, 31).toEpochDay();

        return LocalDate.ofEpochDay(getRandomInt(minEpochDay, maxEpochDay));
    }

    public String getRandomDay(LocalDate date) {
        return String.format("%02d", date.getDayOfMonth());
    }

    public String getRandomMonth(LocalDate date) {
        return date.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String getRandomYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    public String getRandomSubject() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics",
                "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics",
                "Arts", "Social Studies", "History", "Civics"};

        return getRandomItemStringArray(subjects);
    }

    public String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemStringArray(hobbies);
    }

    private static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public String getRandomState() {
        String[] states = STATE_CITIES.keySet().toArray(String[]::new);
        return getRandomItemStringArray(states);
    }

    public String getRandomCity(String state) {
        List<String> cities = STATE_CITIES.get(state);

        if (cities == null) {
            throw new IllegalArgumentException("Неизвестный штат: " + state);
        }

        return getRandomItemStringArray(cities.toArray(String[]::new));
    }

    public String getRandomItemStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }


}
