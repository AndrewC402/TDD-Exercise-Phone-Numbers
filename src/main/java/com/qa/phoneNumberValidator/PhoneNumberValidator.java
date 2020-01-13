package com.qa.phoneNumberValidator;

public class PhoneNumberValidator {
    private String phoneNumber;

    public PhoneNumberValidator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        phoneNumber = phoneNumber.replaceAll("[^+0-9]", ""); //replaces all special characters apart from "+" with an empty string

        if (!(phoneNumber.length() == 12) || !(phoneNumber.contains("+1")) || !(phoneNumber.indexOf("+") == 0)) { //checks that the phone number is exactly 11 characters and that the "+" is only at the beginning
            phoneNumber = "Invalid";
        }

        return phoneNumber;
    }
}
