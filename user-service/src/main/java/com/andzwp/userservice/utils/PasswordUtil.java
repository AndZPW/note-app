package com.andzwp.userservice.utils;

import lombok.NonNull;

public class PasswordUtil {

    private PasswordUtil() {
        throw new RuntimeException();
    }

    //TODO choose the hash algorithm
    public static String hashPassword(@NonNull String password) {
        return password;
    }

    public static boolean verifyPassword(@NonNull String password, @NonNull String hash) {
        return hash.equals(PasswordUtil.hashPassword(password));
    }
}
