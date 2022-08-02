package com.andreiromila.csv.dto;

import com.andreiromila.csv.generator.PasswordGenerator;
import lombok.Data;

@Data
public class Supplier {

    private final String company;
    private final String fullName;
    private final String rfc;
    private final String phoneNumber;
    private final String emailAddress;
    private final Long priority;
    private final String buyerArea;
    private final Boolean legalEntity;
    private final Long productType;

    /**
     * Generated password
     */
    private final String password;

    public Supplier(final String[] line) {

        // The line must have the data in the exact order of the dto
        company = orNull(line, 0);
        fullName = orNull(line, 1);
        rfc = orNull(line, 2);
        phoneNumber = orNull(line, 3);
        emailAddress = orNull(line, 4);
        priority = parseLong(orNull(line, 5));
        buyerArea = orNull(line, 6);
        legalEntity = parseLegalEntity(orNull(line, 7));
        productType = parseLong(orNull(line, 8));

        // Generate a new password
        password = PasswordGenerator.generate();
    }

    private static String orNull(String[] line, int index) {

        if (index >= line.length) {
            return null;
        }

        return line[index];
    }

    private static Boolean parseLegalEntity(String str) {
        if ("cierto".equalsIgnoreCase(str) || "true".equalsIgnoreCase(str)) {
            return true;
        }

        return false;
    }

    /**
     * Parses the number in the provided string.
     * If the string is not a number or is less than 0 then
     * null is returned.
     *
     * @param value {@link String} The string to be parsed
     * @return The parsed value or null in case of any error
     */
    private static Long parseLong(String value) {
        try {
            final long result = Long.parseLong(value);

            // Only if the result is greater than 0
            if (result > 0L) {
                return result;
            }

        } catch (NullPointerException | NumberFormatException e) {
            // There are no validations for this field
        }

        // By default we return null
        return null;
    }
}
