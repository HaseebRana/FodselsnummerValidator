import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    final long number = 31129966789L;

    @Test
    void hasElevenDigits(){
        boolean actual = Validator.hasElevenDigits(number);
        assertEquals(true, actual);
    }

    @Test
    void doesNotHaveElevenDigits(){
        long number = 1234567890L;
        boolean actual = Validator.hasElevenDigits(number);
        assertEquals(false, actual);

    }

/*    @Test
    void validBirthDate(){
        boolean actual = Validator.hasValidBirthDate(number);
        assertEquals(true, actual);

    }*/

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
        assertEquals(true, actual);

    }
    @Test
    void birthDateIsOver31AndInvalid(){
        boolean actual = Validator.validateBirthDate(32129966789L);
        assertEquals(false, actual);

    }
    @Test
    void birthMonthIsOver12AndInvalid(){
        boolean actual = Validator.validateBirthDate(31139966789L);
        assertEquals(false, actual);

    }






}