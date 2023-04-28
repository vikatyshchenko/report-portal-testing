package com.report.portal.core.utils.data;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSequenceCreator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_-+={}[]|;:<>,.?/";

    private RandomSequenceCreator() {
    }

    public static int generateRandomInt(int from, int to) {
        int randomInt = ThreadLocalRandom.current().nextInt(from, to);
        return randomInt;
    }

    public static String generateRandomString(int length) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

}
