public class Validator {
    //TODO: potential improvement: add a method which checks if all characters in fødselsnummer are numeric
    //TODO: check if the valid number of days are in the fødselsnummer's, handle leap year

    /**
     * Returns boolean result depending on whether the 'number' argument hase 11 digits (characters) or not
     *
     * @param number the Fødselsnummer in string format
     * @return true/false depending on the Fødselsnummer containing 11 digits or not
     */
    public static boolean hasElevenDigits(String number) {
        return number.length() == 11;
    }

    /**
     * Returns true or false depending on whether the 'sum' argument is fully divisible by 11 or not
     *
     * @param sum the resulting sum of
     * @return true/false dependent on full argument divisibility
     */
    public static boolean sumModEleven(int sum) {
        return sum % 11 == 0;
    }

    /**
     * Returns a slice of the the Fødselsnummer
     *
     * @param startIndex the start index of the slice
     * @param endIndex   the end index of the slice
     * @param number     the Fødselsnummer in string format
     * @return corresponding part of the Fødselsnummer in int format
     */
    public static int returnPartOfNumber(String number, int startIndex, int endIndex) {
        return Integer.parseInt(number.substring(startIndex, endIndex));
    }

    /**
     * Validates the Birthdate in a Fødselsnummer
     *
     * @param number the Fødselsnummer in string format
     * @return true/false depending on whether the birthdate was valid or invalid
     */
    public static boolean validateBirthDate(String number) {
        int[] max = {31, 12, 99};
        boolean isValid = true;
        int j = 0;
        for (int i = 0; i < 6; i += 2, j++) {
            if (!((returnPartOfNumber(number, i, (i + 2))) <= max[j])) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    /**
     * Calculates the combined sum of the product of each digit of the Fødselsnummer against the corresponding control digit in the checksum array
     *
     * @param number the Fødselsnummer in string format
     * @param type   the checksum array
     * @return sum of the calculations against the checksum
     */
    public static int calculateSum(String number, int type) {
        int sum = 0;
        int[] controlArray = returnCorrespondingControlArray(type);
        for (int i = 0; i < (9 + type); i++) {
            sum += returnCorrespondingDigit(number, i) * controlArray[i];
        }
        return sum;
    }

    /**
     * Returns the desired control array which contains the checksums
     * <p>
     * The first type contains the checksums about the first 10 digits in the Fødselsnummer
     * while the second type contains checksums for all 11 Fødselsnummer digits
     *
     * @param type the checksum type, for either the 10, 11 digits checksum
     * @return corresponding checksum array
     */
    public static int[] returnCorrespondingControlArray(int type) {
        return type == 1 ? new int[]{3, 7, 6, 1, 8, 9, 4, 5, 2, 1} :
                new int[]{5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 1};
    }

    /**
     * Returns the digit at a specific index
     *
     * @param number the Fødselsnummer in string format
     * @param index  the index of the desired digit
     * @return int value of the desired digit
     */
    public static int returnCorrespondingDigit(String number, int index) {
        return Integer.parseInt(number.substring(index, index + 1));
    }

    /**
     * Validates the control digits of the Fødselsnummer against the checksum arrays
     * <p>
     * The sum of the calculations against the checksums need to be fully divisible by 11 to be considered valid
     *
     * @param number the Fødselsnummer in string format
     * @return true/false depending on whether the control digits were valid or not
     */
    public static boolean validateControlDigits(String number) {
        boolean digitsAreValid = true;
        for (int type = 1; type <= 2; type++) {
            if (!(sumModEleven(calculateSum(number, type)))) {
                digitsAreValid = false;
                break;
            }
        }
        return digitsAreValid;
    }

    /**
     * Validates a Fødselsnummer by checking for correct number of digits, birthdate and 'control digits'
     *
     * @param fodselsNumber the Fødselsnummer in string format
     * @return whether the Fødselsnummer is valid or not
     */
    public static boolean validateFodselsnummer(String fodselsNumber) {
        if (!hasElevenDigits(fodselsNumber)) {
            return false;
        } else if (!validateBirthDate(fodselsNumber)) {
            return false;
        }
        return validateControlDigits(fodselsNumber);
    }
}
