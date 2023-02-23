package de.tum.in.ase;

import java.util.Scanner;

public class SpaceCompetition {
    public static void main(String[] args) {

        //Print the welcome message

        System.out.println("Welcome Martians, We are Eran and Jasper from Earth!");

        //Ask the name of the first choice and print it on the console

        System.out.println("What is your first choice?");
        String input1 = (new Scanner(System.in)).nextLine();
        System.out.println("First choice: " + input1 + ".");

        //Ask the name of the second choice and print it on the console

        System.out.println("What is your second choice?");
        String input2 = (new Scanner(System.in)).nextLine();
        System.out.println("Second choice: " + input2 + ".");

        //Ask the name of the third choice and print it on the console

        System.out.println("What is your third choice?");
        String input3 = (new Scanner(System.in)).nextLine();
        System.out.println("Third choice: " + input3 + ".");

        //Print out the order in which Eran and Jasper will compete for the competition

        System.out.println("Jasper and Eran will start with " + input1 + ", continue with " + input2 + ", and end with " + input3 + ".");

        //Print the goodbye message

        System.out.println( "We were pleased to be part of your Martian competition.\nWe will come again next year!" );
    }
}
