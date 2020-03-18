public class Validator {

    public static boolean hasElevenDigits(long number) {
        int length = (int) (Math.log10(number) + 1);
        if(length == 11){
            return true;
        }
        return false;
    }


/*    public static boolean hasValidBirthDate(long number) {
        if(validateBirthDate(number)){
            return true;
        }
        return false;
    }*/

    public static boolean validateBirthDate(long number){
        int[] max = {31,12,99};

        boolean isValid = true;
        int j = 0;
        for (int i = 0; i < 6; i+=2, j++) {

            int test = (returnPartOfNumber(i,(i+2),number));
            if(!(test <= max[j])){
                isValid = false;
                break;
            }

        }
        return isValid;

    }

    public static int returnPartOfNumber(int startIndex, int endIndex, long number) {
        return Integer.parseInt(Long.toString(number).substring(startIndex,endIndex));
    }
}
