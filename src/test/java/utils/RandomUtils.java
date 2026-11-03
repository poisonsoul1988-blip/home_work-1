package utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(111111111, 777777777));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int length) {
        // String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));

        return result.toString();
    }

    public static String getRandomEmail() {
        // return getRandomString(8) + "@" + getRandomString(8) +".com";
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }

    public static String getRandomAddress() {
        // return getRandomString(8) + "@" + getRandomString(8) +".com";
        return format("%s %s", getRandomString(8), getRandomInt(1,999));
    }

    public static int getRandomInt(int min, int max) {
       return ThreadLocalRandom.current().nextInt(min, max + 1);
//        SecureRandom rnd = new SecureRandom();
//        return rnd.nextInt(max  + 1);
    }

    public static String getRandomPhone() {
//        String phoneTemplate = "+%s (%s) %s - %s - %s";
        String phoneTemplate = "%s%s";

//        return format(phoneTemplate, getRandomInt(1,9), getRandomInt(111,999),
//                getRandomInt(111,999), getRandomInt(111,999), getRandomInt(11,99));
        return format(phoneTemplate,getRandomInt(11111,99999),getRandomInt(11111,99999));
    }

//    public static String getRandomGender() {
//        String[] genders = {"Male", "Female", "Other"};
//
//        int randomIndex = getRandomInt(0, 2);
//        return genders[randomIndex];
//    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemStringArray(genders);
    }

    public static LocalDate getRandomDate() {
        int minEpochDay = (int) LocalDate.of(1926, 1, 1).toEpochDay();
        int maxEpochDay = (int) LocalDate.of(2012, 12, 31).toEpochDay();

        return LocalDate.ofEpochDay(getRandomInt(minEpochDay, maxEpochDay));
    }

    public static String getRandomDay(LocalDate date) {
        return String.format("%02d", date.getDayOfMonth());
    }

    public static String getRandomMonth(LocalDate date) {
        return date.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static String getRandomYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    public static String getRandomSubject() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics",
                "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics",
                "Arts", "Social Studies", "History", "Civics"};

        return getRandomItemStringArray(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemStringArray(hobbies);
    }

    private static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public static String getRandomState() {
        String[] states = STATE_CITIES.keySet().toArray(String[]::new);
        return getRandomItemStringArray(states);
    }

    public static String getRandomCity(String state) {
        List<String> cities = STATE_CITIES.get(state);

        if (cities == null) {
            throw new IllegalArgumentException("Неизвестный штат: " + state);
        }

        return getRandomItemStringArray(cities.toArray(String[]::new));
    }

    public static String getRandomItemStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }


}
