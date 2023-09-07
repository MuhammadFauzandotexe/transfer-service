package org.zan.tranferservice.util;

import java.util.UUID;

/**
 * This utility class provides methods for generating random strings.
 * It includes a method to generate a unique reference ID.
 */
public class RandomString {

    /**
     * Generates a unique reference ID as a random string.
     *
     * @return A unique reference ID as a string.
     */
    public static String generateUniqueReferenceId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(0, 13);
    }
}
