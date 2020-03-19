import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    final long number = 31129966789L;

    @Test
    void hasElevenDigits(){
        boolean actual = Validator.hasElevenDigits(number);
        assertTrue(actual);
    }

    @Test
    void doesNotHaveElevenDigits(){
        long number = 1234567890L;
        boolean actual = Validator.hasElevenDigits(number);
        assertFalse(actual);

    }


    @Test
    void returnCorrectPartOfNumberFromIndex0to2(){
        int expected = 31;
        int actual = Validator.returnPartOfNumber(0,2, number);
        assertEquals(expected, actual);

    }

    @Test
    void returnCorrectPartOfNumberFromIndex2to4(){
        int expected = 12;
        int actual = Validator.returnPartOfNumber(2,4, number);
        assertEquals(expected, actual);

    }

    @Test
    void returnCorrectPartOfNumberFromIndex0to6(){

        int expected = 311299;
        int actual = Validator.returnPartOfNumber(0,6, number);
        assertEquals(expected, actual);
    }

    @Test
    void birthDateIsUnder32AndValid(){
        boolean actual = Validator.validateBirthDate(number);
        assertTrue(actual);

    }
    @Test
    void birthDateIsOver31AndInvalid(){
        boolean actual = Validator.validateBirthDate(32129966789L);
        assertFalse(actual);

    }
    @Test
    void birthMonthIsOver12AndInvalid(){
        boolean actual = Validator.validateBirthDate(31139966789L);
        assertFalse(actual);

    }

    @Test
    void resultOfTheSumMod11IsValid(){
        int sum = 99;
        boolean actual = Validator.sumModEleven(sum);
        assertTrue(actual);
    }

    @Test
    void resultOfTheSumMod11IsInvalid(){
        int sum = 100;
        boolean actual = Validator.sumModEleven(sum);
        assertFalse(actual);
    }

    @Test
    void correctResultOfSumForType1(){
        int expected = 253;
        int actual = Validator.calculateSum(number, 1);
        assertEquals(expected, actual);
    }

    @Test
    void correctResultOfSumForType2(){
        int expected = 243;
        int actual = Validator.calculateSum(number, 2);
        assertEquals(expected, actual);
    }


    @Test
    void returnArrayForType1(){
        int[] expected = {3, 7, 6, 1, 8, 9, 4, 5, 2, 1};
        int[] actual = Validator.returnCorrespondingControlArray(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void returnArrayForType2(){
        int[] expected = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 1};
        int[] actual = Validator.returnCorrespondingControlArray(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void return0DigitsValue(){
        int expected = 3;
        int actual = Validator.returnCorrespondingDigit(number, 0);
        assertEquals(expected, actual);

    }
    @Test
    void return10DigitsValue(){
        int expected = 8;
        int actual = Validator.returnCorrespondingDigit(number, 9);
        assertEquals(expected, actual);

    }
    @Test
    void return11DigitsValue(){
        int expected = 9;
        int actual = Validator.returnCorrespondingDigit(number, 10);
        assertEquals(expected, actual);

    }

    @Test
    void validControlDigits(){
        long validFodselsnummer = 30045129140L;
        boolean actual = Validator.validateControlDigits(validFodselsnummer);
        assertTrue(actual);
    }

    @Test
    void invalidControlDigits(){
        boolean actual = Validator.validateControlDigits(number);
        assertFalse(actual);
    }



    @ParameterizedTest
    @ValueSource(longs = {25113426678L,20025014481L,14098338714L})
    void validateFodselsnummer(long fodselsNummer){
        boolean actual = Validator.validateFodselsnummer(fodselsNummer);
        assertTrue(actual);
    }





}