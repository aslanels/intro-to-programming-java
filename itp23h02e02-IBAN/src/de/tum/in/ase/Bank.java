package de.tum.in.ase;

import java.math.BigInteger;

public class Bank {

    /**
     * Prints "Valid!" if isValid is true, else it prints "Invalid!"
     * @param isValid Indicates the result of an IBAN-Validity-Check
     */
    public static void printValidity(boolean isValid) {
        System.out.println(isValid ? "Valid!" : "Invalid!");
    }

    /**
     * Checks the length and sign of an IBAN
     * @param iban IBAN to check for length and sign
     * @return True if the length and sign of the IBAN is correct and if result of the IBAN-Validity-Check is true, else false.
     */
    public static boolean checkLengthAndSignWhenValidating(BigInteger iban) {
        if (iban.compareTo(BigInteger.TEN.pow(20)) >= 0 || iban.compareTo(BigInteger.TEN.pow(19)) < 0) {
            return false;
        } else {
            //What needs to be returned here? Hint: Have a look at what "BigInteger checkLengthAndSignWhenGenerating(BigInteger accountNumber)" returns in a similar situation and check the Javadoc above.
            return validateIBAN(iban);
        }
    }

    /**
     * Checks the length and sign of an account number
     * @param accountNumber Account number to check for length and sign
     * @return IBAN if the length and sign of the account number is correct, else null.
     */
    public static BigInteger checkLengthAndSignWhenGenerating(BigInteger accountNumber) {
        if (accountNumber.compareTo(BigInteger.TEN.pow(18)) >= 0 || accountNumber.compareTo(BigInteger.TEN.pow(17)) < 0) {
            return null;
        } else {
            return generateIBAN(accountNumber);
        }
    }

    public static void main(String[] args) {
        //You can test your implemented functions here.
        BigInteger accountNumber = new BigInteger("123456789012345678");
        BigInteger validIBAN = new BigInteger("43123456789012345678");
        BigInteger invalidIBAN = new BigInteger("973172060428870678");
        BigInteger accNum = new BigInteger("317206404288706788");



        printValidity(validateIBAN(validIBAN));
        printValidity(checkLengthAndSignWhenValidating(invalidIBAN));
        System.out.println(generateIBAN(accountNumber));
        System.out.println(generateIBAN(accNum));

    }

    public static boolean validateIBAN(BigInteger iban) {
        //Hint: first, think about the return type
        //IBAN: DE43123456789012345678
        String ibanStr = iban.toString();
        String i = "DE" + ibanStr;
        //Rearrange: 123456789012345678DE43
        String k = i.substring(4) + i.substring(0,4);
        //Convert characters to numbers by using: A=10, B=11, C=12,…: 123456789012345678131443
        String l = k.replace("DE","1314");
        //Compute remainder for 97: 123456789012345678131443 mod 97 = x
        BigInteger r = new BigInteger(l);
        BigInteger x = r.mod(BigInteger.valueOf(97));
        //If the remainder x is 1 the check passed and the IBAN might be valid
        return  x.equals(BigInteger.valueOf(1)) ;

    }

    public static BigInteger generateIBAN(BigInteger accountNumber) {
        // convert accountNumber to string
        String accNum = accountNumber.toString();
        // string manipulation to convert to desired form
        String q = "DE00" + accNum;
        String w = q.substring(4,22) + q.substring(0,4);
        String e = w.replace("DE", "1314");
        // turn it into bigInteger again
        BigInteger a =new BigInteger(e);
        // calculation of checksum
        BigInteger cs = BigInteger.valueOf(98).subtract(a.mod(BigInteger.valueOf(97)));
        // final form of iban turned to bigInteger
        String iban = cs.toString() + accNum;
        return new BigInteger(iban);

    }

}
