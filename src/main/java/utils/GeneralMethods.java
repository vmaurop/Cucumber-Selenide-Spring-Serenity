package utils;

import java.security.SecureRandom;

public final class GeneralMethods {

    private GeneralMethods() {
        throw new IllegalStateException("GeneralMethods class");
    }

    private static final int LENGTH = 6;

    public static Integer generateRandomInteger(int minBound, int maxBound) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }

    public static String generateRandomString() {
        return new SecureRandom().ints('a', 'z' + 1)
                .limit(LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
