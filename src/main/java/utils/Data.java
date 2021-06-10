package utils;

import java.security.SecureRandom;

public final class Data {

    private static final int LENGTH = 6;

    private Data() {
        throw new IllegalArgumentException("Data class");
    }


    public static String generateRandomString() {
        return new SecureRandom().ints('a', 'z' + 1)
                .limit(LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }


}
