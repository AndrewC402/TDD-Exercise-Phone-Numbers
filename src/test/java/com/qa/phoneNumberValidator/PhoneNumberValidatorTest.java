package com.qa.phoneNumberValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    @Test
    void happy_data_returns_correct_length () {
        //arrange
        String phoneNumber = "+11234567891";
        int expectedResult = 12;
        PhoneNumberValidator cut = new PhoneNumberValidator(phoneNumber);

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
        String phoneNumber = "12345678910";
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
        String actualResult  =cut.getPhoneNumber();

        //assert
        assertEquals(expectedResult,actualResult);
    }


}