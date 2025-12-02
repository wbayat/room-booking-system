package com.group13.roombookingsystem.utilities;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Manual mutation tests for {@link ValidationUtils}. Each mutant mirrors a realistic
 * mistake (e.g. dropping one of the guards) and the assertions demonstrate that the
 * reference implementation would detect those faulty behaviours.
 */
class ValidationUtilsManualMutationTest {

    @Test
    void passwordMutantMissingSpecialCharacterCheckIsKilled() {
        String candidate = "Valid12A";

        assertFalse(ValidationUtils.isValidPassword(candidate),
                "Contro" +
                        "l implementation rejects passwords without special characters.");
        assertTrue(new PasswordWithoutSpecialCharMutant().isValidPassword(candidate),
                "Mutant incorrectly accepts passwords missing a special character.");
    }

    @Test
    void emailMutantSkippingTrimIsKilled() {
        String candidate = " user@example.com ";

        assertTrue(ValidationUtils.isValidEmail(candidate),
                "Control implementation trims input before validation.");
        assertFalse(new EmailWithoutTrimMutant().isValidEmail(candidate),
                "Mutant rejects the same email because it forgot to normalize whitespace.");
    }

    private static final class PasswordWithoutSpecialCharMutant {
        private static final int MIN_PASSWORD_LENGTH = 8;
        private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
        private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
        private static final Pattern DIGIT_PATTERN = Pattern.compile(".*\\d.*");

        boolean isValidPassword(String password) {
            if (password == null) {
                return false;
            }
            if (password.length() < MIN_PASSWORD_LENGTH) {
                return false;
            }
            return UPPERCASE_PATTERN.matcher(password).matches()
                    && LOWERCASE_PATTERN.matcher(password).matches()
                    && DIGIT_PATTERN.matcher(password).matches();
        }
    }

    private static final class EmailWithoutTrimMutant {
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        boolean isValidEmail(String email) {
            if (email == null) {
                return false;
            }
            if (email.isEmpty()) {
                return false;
            }
            return EMAIL_PATTERN.matcher(email).matches();
        }
    }
}


