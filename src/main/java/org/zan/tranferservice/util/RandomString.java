package org.zan.tranferservice.util;

import java.util.UUID;
public class RandomString {
    public static String generateUniqueReferenceId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(0, 13);
    }
}
