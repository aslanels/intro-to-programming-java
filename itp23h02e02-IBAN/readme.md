# H02E02 - IBAN

An IBAN (International Bank Account Number) is an international standard for bank account identification. In this exercise, you will be part of the Bank development team and implement a module for their new banking management software.

## German IBAN

A German IBAN always consists of 22 symbols.

- 2 letters - "DE"
- 2 digits - Checksum
- 18 digits - Account Number

The checksum exists for example to detect typos (For more information on why the checksum is useful check the [wikipedia article](https://en.wikipedia.org/wiki/International_Bank_Account_Number)).

From this point in the exercise, we will only save the trailing digits in the variables and assume DE be always in front. To show how the structure and algorithm of an IBAN works, we will use this example: DE43123456789012345678

## Explanation: BigInteger

Because we have to deal with numbers of 20 digits, the range for the primitive data types in Java is not enough:

- int up to 2,1E9/2³¹−1 (around 9-10 decimal digits)
- long up to 9,2E18/2⁶³−1 (around 18-19 decimal digits)

An alternative is to use the Class [BigInteger](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html) that allows to store whole numbers with arbitrary precision.

Here are the most important BigInteger methods you might need in this exercise:
```
//Constructor
new BigInteger(String)      - returns BigInteger with value specified in string

//Methods (use like: a.add(b))
add(BigInteger val)         - returns new BigInteger with value (this + val)
subtract(BigInteger val)    - returns new BigInteger with value (this - val)
multiply(BigInteger val)    - returns new BigInteger with value (this * val)
divide(BigInteger val)      - returns new BigInteger with value (this / val) - (rounded down to whole number)
mod(BigInteger val)         - returns new BigInteger with value (this modulo val)
pow(BigInteger val)         - returns new BigInteger with value (this^val) (to the power of)
compareTo(BigInteger val)   - -1, 0 or 1 as this BigInteger is numerically less than, equal to, or greater than val.
intValue()                  - returns value as int. If BigInteger value is too big, only value of lower 32 bit is returned.

//Static Value
BigInteger.TEN              - returns BigInteger with value 10
Project Structure
In the template repository folder src/de/tum/in/ase you can find a file called Bank.java. In this file you will find two empty methods: validateIBAN(BigInteger iban), and generateIBAN(BigInteger accountNumber). Additionally, there is the main method to test your implemented methods as well as helper methods for checking the length and sign of the IBAN or the account number. Your task is to implement the first two methods by replacing the TODO comments (//TODO: ...) with your lines of code.

```

## Your Tasks

**IBAN validation**

When the customers of your bank want to make a transfer, you want to check if the recipient IBAN passes this checksum test, so that we can tell the customer in case of a typo. Complete validateIBAN method that returns true if the check passes, otherwise false.

The checksum follows a specific algorithm to be validated. Let's look at this IBAN that we already introduced above: DE43123456789012345678

1. Inspect boolean checkLengthAndSignWhenValidating(BigInteger iban) and check what needs to be changed.
2. Rearrange: 123456789012345678DE43
3. Convert characters to numbers by using: A=10, B=11, C=12,…: 123456789012345678131443
4. Compute remainder for 97: 123456789012345678131443 mod 97 = x
5. If the remainder x is 1 the check passed and the IBAN is valid 

**Check Sum Generation**

When a new account is created at the bank, the checksum must be calculated from the account number. Complete generateIBAN method that returns the 20-digit number (not including DE) consisting of 2 digit checksum and 18-digit account number. For this, we also have an algorithm:

1. Append checksum 00: DE00123456789012345678
2. Rearrange: 123456789012345678DE00
3. Convert characters to numbers by using: A=10, B=11, C=12,…: 123456789012345678131400
4. Calculate remainder for 97: 123456789012345678131400 mod 97 = x
5. Subtract x from 98 for the checksum: 98 - x = 43
6. Set checksum in IBAN: DE43123456789012345678

### Helpful Questions

- How can you shift the digits of a number to the left to make a space for some other digits?
- In case you have a german bank account, you can try to calculate your IBAN via your program, by combining your bank number (BLZ) with your account number (filled up with zeros from the left side in case it has less than 10 digits). So:
bank number+account number -> DExxbank number+account number 
