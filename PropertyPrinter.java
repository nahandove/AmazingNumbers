package numbers;

public class PropertyPrinter {
    public void printProperties(long number, Property property) {
        InputProcessor.writeMessage("\nProperties of " + number + "\n" +
                            "        buzz: " + property.isBuzz(number) + "\n" +
                            "        duck: " + property.isDuck(number) + "\n" +
                            " palindromic: " + property.isPalindrome(number) + "\n" +
                            "      gapful: " + property.isGapful(number) + "\n" +
                            "         spy: " + property.isSpy(number) + "\n" +
                            "      square: " + property.isSquare(number) + "\n" +
                            "       sunny: " + property.isSunny(number) + "\n" +
                            "     jumping: " + property.isJumping(number) + "\n" +
                            "       happy: " + property.isHappy(number) + "\n" +
                            "         sad: " + !property.isHappy(number) + "\n" +
                            "        even: " + property.isEven(number) + "\n" +
                            "         odd: " + !property.isEven(number) + "\n");
    }
}
