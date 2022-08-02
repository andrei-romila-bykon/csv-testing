package com.andreiromila.csv.generator;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String SPL_CHARS = "!@$";
    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM = "0123456789";

    public static String generate() {
        String password = getUserPassword();
        while (!validatePassword(password)) {
            password = getUserPassword();
        }
        return password;
    }

    /**
     *
     * @method name : getUserPassword
     * @description : Method to generate password for user as required for
     *              password policies.
     * @return : String Type
     */
    private static String getUserPassword() {
        final StringBuilder sbPassword = new StringBuilder("Pa4ss$$Wo0rd");
        final SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < 2; i++) {
            sbPassword.append(SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length())));
        }

        for (int i = 0; i < 1; i++) {
            sbPassword.append(ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length())));
        }

        for (int i = 0; i < 1; i++) {
            sbPassword.append(ALPHA.charAt(rnd.nextInt(ALPHA.length())));
        }

        for (int i = 0; i < 1; i++) {
            sbPassword.append(NUM.charAt(rnd.nextInt(NUM.length())));
        }

        return sbPassword.toString();
    }

    /**
     *
     * @method name : validatePassword
     * @description : Method to validate password with password policies.
     * @param password
     * @return : boolean Type
     */
    private static boolean validatePassword(String password) {
        return true;
    }

}
