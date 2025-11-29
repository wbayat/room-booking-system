package com.group13.roombookingsystem.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationUtilsTest {

    @Nested
    @DisplayName("isValidPassword")
    class IsValidPassword {

        @Test
        void returnsFalseWhenPasswordIsNull() {
            assertFalse(ValidationUtils.isValidPassword(null));
        }

        @Test
        void returnsFalseWhenPasswordIsTooShort() {
            assertFalse(ValidationUtils.isValidPassword("Aa1!aa"));
        }

        @Test
        void returnsFalseWhenMissingUppercase() {
            assertFalse(ValidationUtils.isValidPassword("lower1!a"));
        }

        @Test
        void returnsFalseWhenMissingLowercase() {
            assertFalse(ValidationUtils.isValidPassword("UPPER1!"));
        }

        @Test
        void returnsFalseWhenMissingDigit() {
            assertFalse(ValidationUtils.isValidPassword("NoDigits!"));
        }

        @Test
        void returnsFalseWhenMissingSpecialCharacter() {
            assertFalse(ValidationUtils.isValidPassword("Missing1A"));
        }

        @Test
        void returnsTrueWhenAllRulesPass() {
            assertTrue(ValidationUtils.isValidPassword("Valid1!A"));
        }
    }

    @Nested
    @DisplayName("isValidEmail")
    class IsValidEmail {

        @Test
        void returnsFalseWhenEmailIsNull() {
            assertFalse(ValidationUtils.isValidEmail(null));
        }

        @Test
        void returnsFalseWhenEmailIsBlank() {
            assertFalse(ValidationUtils.isValidEmail("   "));
        }

        @Test
        void returnsFalseWhenEmailDoesNotMatchPattern() {
            assertFalse(ValidationUtils.isValidEmail("invalid-email"));
        }

        @Test
        void returnsTrueForValidEmail() {
            assertTrue(ValidationUtils.isValidEmail("user.name+alias@example.co.uk"));
        }
    }

    @Nested
    @DisplayName("isValidIdentification")
    class IsValidIdentification {

        @Test
        void returnsFalseWhenIdIsNull() {
            assertFalse(ValidationUtils.isValidIdentification(null));
        }

        @Test
        void returnsFalseWhenIdIsBlank() {
            assertFalse(ValidationUtils.isValidIdentification("   "));
        }

        @Test
        void returnsFalseWhenIdIsNotNineDigits() {
            assertFalse(ValidationUtils.isValidIdentification("12345A789"));
        }

        @Test
        void returnsTrueWhenIdIsExactlyNineDigits() {
            assertTrue(ValidationUtils.isValidIdentification("123456789"));
        }
    }
}

