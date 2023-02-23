package de.tum.in.ase;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bar {

    public Bar(){}

    public static void printCatalog() {
        //Corrected the description values
        System.out.println("Martini: a cocktail made with gin or vodka and dry vermouth, usually served with a green olive or a twist of lemon peel.");
        System.out.println("Mimosa: a mixed drink consisting of champagne and orange juice.");
    }

    public static void robotWaiter() {
        //Robot waiter asks for orders
        System.out.println("What would you like to order?");
        String userInput = (new Scanner(System.in)).nextLine();
        System.out.println("Thank you! You ordered: " + userInput + ".");
    }

    public static void translatedMessage() {
        //Unicode to UTF-8 decoder
        byte[] bytes = {0x0045, 0x0058, 0x005A, 0x0045, 0x004C, 0x004C, 0x0045, 0x004E, 0x0054};
        String str = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str);
        }



    public static void main(String[] args) {
        // You can use this space to run the methods and test your code
        printCatalog();
        robotWaiter();
        translatedMessage();
    }
}
