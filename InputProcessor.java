package numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    static Property property = new Property();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void processRequest() throws IOException {

        System.out.print("Enter a Request: ");
        String numberString = readString();

        if ("0".equals(numberString)) {
            writeMessage("\nGoodbye!");
            System.exit(0);
        }
        if (numberString.isEmpty()) {
            Main.printWelcomeScreen();
        }

        String[] numbers = numberString.trim().split(" ");

        try {
            checkValidInput(numbers);
            chooseProcessor(numbers);
        } catch (IllegalArgumentException e) {
            writeMessage(e.getMessage());
            processRequest();
        }
        processRequest();
    }

    private void chooseProcessor(String[] numbers) {
        if (numbers.length == 1) {
            PropertyPrinter printer = new PropertyPrinter();
            printer.printProperties(Long.parseLong(numbers[0]), property);
        } else if (numbers.length == 2) {
            ConsecutiveNumberProcessor consecutiveProcessor = new ConsecutiveNumberProcessor();
            consecutiveProcessor.processNumberArray(numbers, property);
        } else {
            NumberGenerator generator = new NumberGenerator();
            List<String> queries = new ArrayList<>();
            for (int i = 2; i < numbers.length; i++) {
                queries.add(numbers[i]);
            }
            generator.generateNumber(Long.parseLong(numbers[0]), Integer.parseInt(numbers[1]), queries);
        }
    }

    private void checkValidInput(String[] numbers) throws IllegalArgumentException {
        try {
            Long.parseLong(numbers[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("\nThe first parameter should be a natural number or zero.\n");
        }
        if (Long.parseLong(numbers[0]) < 0) {
            throw new IllegalArgumentException("\nThe first parameter should be a natural number or zero.\n");
        }
        if (numbers.length == 2 && Long.parseLong(numbers[1]) <= 0) {
            throw new IllegalArgumentException("\nThe second parameter should be a natural number.\n");
        }
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }
}
