package numbers;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static InputProcessor inputProcessor = new InputProcessor();
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Amazing Numbers!");
        printWelcomeScreen();
    }

    public static void printWelcomeScreen() throws IOException {
        InputProcessor.writeMessage("\nSupported Requests:\n" +
                        "- enter a natural number to know its properties;\n" +
                        "- enter two natural numbers to obtain the properties of the list:\n" +
                        "  * the first parameter represents a starting number;\n" +
                        "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                        "- two natural numbers and properties to search for;\n" +
                        "- a property preceded by minus must not be present in numbers\n" +
                        "- separate the parameters with one space;\n" +
                        "- enter 0 to exit.\n");

        inputProcessor.processRequest();
    }
}