package com.qa.phoneNumberValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    @Test
    void happy_data_returns_correct_length () {
        //arrange
        String phoneNumber = "+1123456789";
        int expectedResult = 11;
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        int actualResult = cut.getPhoneNumber().length();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void special_characters_removed_from_phone_number () {
        //arrange
        String phoneNumber = "+10,5 9!34,34%56";
        String expectedResult = "+1059343456";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void phone_number_with_more_than_ten_numbers_returns_invalid () {
        //arrange
        String phoneNumber = "1234567891011";
        String expectedResult = "Invalid";
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

        //act
        String actualResult = cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }
}