package numbers;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumberProcessor {
    public void processNumberArray(String[] array, Property property) {

        InputProcessor.writeMessage("");

        long beginIndex = Long.parseLong(array[0]);
        long increments = Long.parseLong(array[1]);
        long endIndex = beginIndex + increments;

        for (long i = beginIndex; i < endIndex; i++) {
            printProperties(i, property);
        }
        InputProcessor.writeMessage("");
    }

    public void printProperties(Long number, Property property) {
        List<String> properties = new ArrayList<>();
        if (property.isEven(number)) {
            properties.add("even");
        } else {
            properties.add("odd");
        }
        if (property.isBuzz(number)) {
            properties.add("buzz");
        }
        if (property.isDuck(number)) {
            properties.add("duck");
        }
        if (property.isPalindrome(number)) {
            properties.add("palindrome");
        }
        if (property.isGapful(number)) {
            properties.add("gapful");
        }
        if (property.isSpy(number)) {
            properties.add("spy");
        }
        if (property.isSquare(number)) {
            properties.add("square");
        }
        if (property.isSunny(number)) {
            properties.add("sunny");
        }
        if (property.isJumping(number)) {
            properties.add("jumping");
        }
        if (property.isHappy(number)) {
            properties.add("happy");
        } else {
            properties.add("sad");
        }

        String combinedProperties = String.join(", ", properties);
        InputProcessor.writeMessage(number + " is " + combinedProperties);
    }
}
