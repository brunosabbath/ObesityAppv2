package com.sbbi.obesityappv2.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bsilva on 3/8/17.
 */

public class PasswordHelper {

    public static String securePassword(String oldPassword){

        String password = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();

            md.update(oldPassword.getBytes());
            byte[] bytes = md.digest();

            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            password = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return password;
    }

}
