public class Validator {


    public static boolean hasElevenDigits(long number) {
        int length = (int) (Math.log10(number) + 1);
        return length == 11;
    }


    public static boolean validateBirthDate(long number) {
        int[] max = {31, 12, 99};

        boolean isValid = true;
        int j = 0;
        for (int i = 0; i < 6; i += 2, j++) {
            if (!((returnPartOfNumber(i, (i + 2), number)) <= max[j])) {
                isValid = false;
                break;
            }

        }
        return isValid;

    }

    public static int returnPartOfNumber(int startIndex, int endIndex, long number) {
        return Integer.parseInt(Long.toString(number).substring(startIndex, endIndex));
    }


    public static boolean sumModEleven(int sum) {
        return sum % 11 == 0;
    }

    public static int calculateSum(long number, int type) {
        int sum = 0;
        int[] controlArray = returnCorrespondingControlArray(type);
        for (int i = 0; i < (9 + type); i++) {
            sum += returnCorrespondingDigit(number, i) * controlArray[i];
            System.out.println(sum);
        }
        return sum;
    }

    public static int[] returnCorrespondingControlArray(int type) {
        int[] control = type == 1 ? new int[]{3, 7, 6, 1, 8, 9, 4, 5, 2, 1} :
                new int[]{5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 1};
        return control;
    }

    public static int returnCorrespondingDigit(long number, int index) {
        return Integer.parseInt(Long.toString(number).substring(index, index + 1));
    }
}
