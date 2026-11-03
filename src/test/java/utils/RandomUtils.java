package utils;

import java.security.SecureRandom;
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

    public static int getRandomInt(int min, int max) {
       return ThreadLocalRandom.current().nextInt(min, max + 1);
//        SecureRandom rnd = new SecureRandom();
//        return rnd.nextInt(max  + 1);
    }

    public static String getRandomPhone() {
        String phoneTemplate = "+%s (%s) %s - %s - %s";

        return format(phoneTemplate, getRandomInt(1,9), getRandomInt(111,999),
                getRandomInt(111,999), getRandomInt(111,999), getRandomInt(11,99));
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

    public static String getRandomItemStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }


}
