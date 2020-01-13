package com.qa.phoneNumberValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    private String validPhoneNumber = "+11234567891";

    @Test
    void happy_data_returns_correct_length () {
        //arrange
        int expectedResult = 12;
        PhoneNumberValidator cut = new PhoneNumberValidator(validPhoneNumber);

        //act
        int actualResult = cut.getPhoneNumber().length();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void phone_number_of_incorrect_length_returns_invalid () {
        //arrange
        String phoneNumber = "+1234567891011";
        String expectedResult = "Invalid";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void phone_number_not_beginning_with_plus_1_returns_invalid () {
        //arrange
        String phoneNumber = "72345678910";
        String expectedResult = "Invalid";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void special_characters_removed_from_phone_number () {
        //arrange
        String phoneNumber = "+10,5 9!34,34%561";
        String expectedResult = "+10593434561";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void misplaced_plus_returns_invalid () {
        //arrange
        String phoneNumber = "01234+67891";
        String expectedResult = "Invalid";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void area_code_returned_from_valid_phone_number () {
        //arrange
        String expectedResult = "123";
        PhoneNumberValidator cut = new PhoneNumberValidator(validPhoneNumber);

        //act
        String actualResult =cut.getAreaCode();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void exchange_code_returned_from_valid_phone_number () {
        //arrange
        String expectedResult = "456";
        PhoneNumberValidator cut = new PhoneNumberValidator(validPhoneNumber);

        //act
        String actualResult = cut.getExchangeCode();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void subscriber_number_returned_from_valid_phone_number () {
        //arrange
        String expectedResult = "7891";
        PhoneNumberValidator cut = new PhoneNumberValidator(validPhoneNumber);

        //act
        String actualResult = cut.getSubscriberNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void subscriber_number_returns_false_from_invalid_phone_number () {
        //arrange
        String phoneNumber = "01kj7gfjgf0)0";
        String expectedResult = "Phone number invalid";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getSubscriberNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }


}