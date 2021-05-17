/**
 * The <code>PhoneNumber<code> class is a representation of a phone number.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
 class PhoneNumber {
    private final long PHONE_NUMBER;
    long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    /**
     * This is a constructor for the phone number.
     * @param phone
     * The phone number to be utilized.
     */
    PhoneNumber(long phone) {
        // This converts the long to a string.
        String check = Long.toString(phone);
        //  If the string is not 10 digits, it throws a runtime exception.
        if(check.length() != 10) {
            throw new java.lang.IllegalArgumentException("The phone number is not 10 digits!");
        }
        // If the string does not contain a digit in any of one of its characters, throw a runtime exception.
        for(int i = 0; i < check.length(); i++) {
            if(!Character.isDigit(check.charAt(i))){
                throw new java.lang.IllegalArgumentException("The phone number contains an invalid character!");
            }
        }
        // If there are no errors, assigns the phone number to the correct value and exits the program.
        PHONE_NUMBER = phone;
    }
    /**
     * This is a constructor for the phone number, but only if a string is passed.
     * @param check
     * For when a string is passed.
     */
    PhoneNumber(String check) {
        for(int i = 0; i < check.length(); i++) {
            if(!Character.isDigit(check.charAt(i))){
                throw new java.lang.IllegalArgumentException("The phone number contains an invalid character!");
            }
        }
        if(check.length() != 10) {
            throw new java.lang.IllegalArgumentException("The phone number is not 10 digits!");
        }
        else {
            PHONE_NUMBER = Long.parseLong(check);
        }
    }
}
