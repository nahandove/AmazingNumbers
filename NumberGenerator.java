package numbers;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private List<Long> generatedNumbers;
    Property property = InputProcessor.property;

    public void generateNumber(long start, int size, List<String> queries) {
        InputProcessor.writeMessage("");
        checkValidQueries(queries);
        generatedNumbers = generateNumberByCriteria(start, size, queries);
        printGeneratedNumbers(generatedNumbers);
    }

    private List<Long> generateNumberByCriteria(long start, int size, List<String> queries) {
        List<Long> allNums = new ArrayList<>();
        int count = 0;
        long i = start;
        while (count < size) {
            if (fulfillsAllCriteria(i, queries)) {
                allNums.add(i);
                count++;
            }
            i++;
        }
        return allNums;
    }

    private void printGeneratedNumbers(List<Long> numbers) {
        ConsecutiveNumberProcessor processor = new ConsecutiveNumberProcessor();
        for (Long number: numbers) {
            processor.printProperties(number, property);
        }
        InputProcessor.writeMessage("");
    }

    private void checkValidQueries(List<String> queries) {
        int errorCount = 0;
        List<String> errors = new ArrayList<>();
        for (String query: queries) {
            if (!isValidQuery(query)) {
                errors.add(query);
                errorCount++;
            }
        }

        if (errorCount >= 2) {
            StringBuilder builder = new StringBuilder();
            for (String error: errors) {
                builder.append(error.toUpperCase());
                builder.append(", ");
            }
            String allErrors = builder.toString();
            throw new IllegalArgumentException(String.format("The properties [%s] are wrong.\n" +
                            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n",
                    allErrors.substring(0, allErrors.length() - 2).toUpperCase()));
        } else if (errorCount == 1) {
            throw new IllegalArgumentException(String.format("The property [%s] is wrong.\n" +
                            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n",
                    errors.get(0).toUpperCase()));
        }

        checkMutualExclusivity(queries);
    }

    private boolean fulfillsCriterion(long number, String query) {
        switch(query.toLowerCase()) {
            case "buzz":
                return property.isBuzz(number);
            case "-buzz":
                return !property.isBuzz(number);
            case "duck":
                return property.isDuck(number);
            case "-duck":
                return !property.isDuck(number);
            case "palindromic":
                return property.isPalindrome(number);
            case "-palindromic":
                return !property.isPalindrome(number);
            case "gapful":
                return property.isGapful(number);
            case "-gapful":
                return !property.isGapful(number);
            case "spy":
                return property.isSpy(number);
            case "-spy":
                return !property.isSpy(number);
            case "even":
            case "-odd":
                return property.isEven(number);
            case "-even":
            case "odd":
                return !property.isEven(number);
            case "square":
                return property.isSquare(number);
            case "-square":
                return !property.isSquare(number);
            case "sunny":
                return property.isSunny(number);
            case "-sunny":
                return !property.isSunny(number);
            case "jumping":
                return property.isJumping(number);
            case "-jumping":
                return !property.isJumping(number);
            case "happy":
            case "-sad":
                return property.isHappy(number);
            case "sad":
            case "-happy":
                return !property.isHappy(number);
            default:
                return false;
        }
    }

    private boolean fulfillsAllCriteria(long number, List<String> queries) {
        for (String query: queries) {
            if (!fulfillsCriterion(number, query)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidQuery(String query) {
        return query.equalsIgnoreCase("even") || query.equalsIgnoreCase("odd")
                || query.equalsIgnoreCase("buzz") || query.equalsIgnoreCase("duck")
                || query.equalsIgnoreCase("palindromic") || query.equalsIgnoreCase("gapful")
                || query.equalsIgnoreCase("spy") || query.equalsIgnoreCase("square")
                || query.equalsIgnoreCase("sunny") || query.equalsIgnoreCase("jumping")
                || query.equalsIgnoreCase("happy") || query.equalsIgnoreCase("sad")
                || query.equalsIgnoreCase("-even") || query.equalsIgnoreCase("-odd")
                || query.equalsIgnoreCase("-buzz") || query.equalsIgnoreCase("-duck")
                || query.equalsIgnoreCase("-palindromic") || query.equalsIgnoreCase("-gapful")
                || query.equalsIgnoreCase("-spy") || query.equalsIgnoreCase("-square")
                || query.equalsIgnoreCase("-sunny") || query.equalsIgnoreCase("-jumping")
                || query.equalsIgnoreCase("-happy") || query.equalsIgnoreCase("-sad");
    }

    private void checkMutualExclusivity(List<String> queries) {
        if (queries.contains("odd") && queries.contains("even")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (queries.contains("-odd") && queries.contains("-even")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [-ODD, -EVEN]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (queries.contains("duck") && queries.contains("spy")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (queries.contains("square") && queries.contains("sunny")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (queries.contains("happy") && queries.contains("sad")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                    "There are no numbers with these properties.\n");
        }
        if (queries.contains("-happy") && queries.contains("-sad")) {
            throw new IllegalArgumentException("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                    "There are no numbers with these properties.\n");
        }
        for (int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < queries.size(); j++) {
                if (queries.get(j).equals("-" + queries.get(i))) {
                    throw new IllegalArgumentException(String.format("The request contains mutually exclusive properties: [%s, %s]\n" +
                            "There are no numbers with these properties.\n", queries.get(i).toUpperCase(), queries.get(j).toUpperCase()));
                }
            }
        }
    }
}
