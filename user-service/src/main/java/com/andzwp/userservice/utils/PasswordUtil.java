package com.andzwp.userservice.utils;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {



    //TODO choose the hash algorithm
    public String hashPassword(@NonNull String password) {
        return password;
    }

    public boolean verifyPassword(@NonNull String password, @NonNull String hash) {
        return hash.equals(hashPassword(password));
    }
}
