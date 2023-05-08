package com.report.portal.core.utils.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class RandomSequenceCreator {

    private static final String CHARACTERS = "!@#$%^&*()_-+={}[]|;:<>,.?/";

    private RandomSequenceCreator() {
    }

    public static int generateRandomInt(int from, int to) {
        return new SecureRandom().nextInt(from, to);
    }

    public static String generateRandomString(int length) {
        String randomString = RandomStringUtils.random(length-CHARACTERS.length(), true, true);
        return randomString.concat(CHARACTERS);
    }

}
