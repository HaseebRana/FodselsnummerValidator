public class Main {
    public static void main(String[] args) {
        // Valid Fødselsnummer
        System.out.println(Validator.validateFodselsnummer("27073344560"));
        System.out.println(Validator.validateFodselsnummer("05060446255"));

        // Invalid Fødselsnummer (other cases covered in unit tests)
        System.out.println(Validator.validateFodselsnummer("17073344560"));
        System.out.println(Validator.validateFodselsnummer("00060446255"));

    }
}
