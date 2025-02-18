package com.ioprogramming.advancedproblems.csvvalidation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final Pattern phonePattern = Pattern.compile(PHONE_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Matcher matcher = phonePattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
