package com.example.api.util;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class commonUtilies {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Pick a random index out of the character pool
            int randomIndex = random.nextInt(CHARACTERS.length());
            // Append the character to our string builder
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static int generateRandomNumber(int bound){

        return new Random().nextInt(bound);
    }

    public static int generateRandomNumber(int min, int max){
        Random random = new Random();
        int num = min + random.nextInt(max);
        return num;
    }
    public static String selectRandomValueFromList(String[] array,int size){

        return Arrays.asList(array)
                .get(ThreadLocalRandom.current().nextInt(size));
    }

    public static String getDate(){
        Date currentDate = new Date();

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .withZone(ZoneOffset.UTC);

        return formatter.format(currentDate.toInstant());

    }
}
