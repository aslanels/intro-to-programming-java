package de.tum.in.ase;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
 //       You can test your source code here...
        
        try {
            for (Log line : Parser.parseLogFile("logs/sample.log")) {
                System.out.println(line);
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
