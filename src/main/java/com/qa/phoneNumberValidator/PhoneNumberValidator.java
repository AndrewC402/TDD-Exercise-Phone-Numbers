package com.qa.phoneNumberValidator;

public class PhoneNumberValidator {
    private String phoneNumber;

    public PhoneNumberValidator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        phoneNumber = phoneNumber.replaceAll("[^+0-9]", "");

        if (!(phoneNumber.length() == 11) || !(phoneNumber.startsWith("+1"))) {
            phoneNumber = "Invalid";
        }

        return phoneNumber;
    }
}
