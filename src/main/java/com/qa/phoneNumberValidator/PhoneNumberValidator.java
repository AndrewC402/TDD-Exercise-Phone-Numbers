package com.qa.phoneNumberValidator;

public class PhoneNumberValidator {
    private String phoneNumber;
    private String areaCode;
    private String exchangeCode;
    private String subscriberNumber;
    private String invalidPhoneNumber = "Phone number invalid";

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

    public String getAreaCode() {
        getPhoneNumber();
        if (!phoneNumber.equals("Invalid") && phoneNumber.substring(2).matches("[2-9]")) {
            areaCode = phoneNumber.substring(2,5);
        } else {
            areaCode = invalidPhoneNumber;
        }

        return areaCode;
    }

    public String getExchangeCode() {
        getPhoneNumber();
        if (!phoneNumber.equals("Invalid")) {
            exchangeCode = phoneNumber.substring(5,8);
        } else {
            exchangeCode = invalidPhoneNumber;
        }

        return exchangeCode;
    }

    public String getSubscriberNumber() {
        getPhoneNumber();
        if (!phoneNumber.equals("Invalid")) {
            subscriberNumber = phoneNumber.substring(8,12);
        } else {
            subscriberNumber = invalidPhoneNumber;
        }

        return subscriberNumber;
    }
}
