package numbers;

public class Property {

    public boolean isBuzz(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public boolean isDuck(long number) {
        String numString = String.valueOf(number);
        for (int i = 1; i < numString.length(); i++) {
            if (numString.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(long number) {
        String numString = String.valueOf(number);
        StringBuilder builder = new StringBuilder(numString);
        builder.reverse();
        String reverseNum = builder.toString();
        return numString.equals(reverseNum);
    }

    public boolean isGapful(long number) {
        String numString = String.valueOf(number);
        if (numString.length() < 3) {
            return false;
        }
        String firstAndLast = numString.substring(0, 1) + numString.substring(numString.length() - 1);
        long divisor = Long.parseLong(firstAndLast);
        return number % divisor == 0;
    }

    public boolean isSpy(long number) {
        String numString = String.valueOf(number);
        int sum = 0;
        int product = 1;
        for (int i = 0; i < numString.length(); i++) {
            String digit = numString.substring(i, i + 1);
            sum += Integer.parseInt(digit);
            product *= Integer.parseInt(digit);
        }
        return sum == product;
    }

    public boolean isEven(long number) {
        return number % 2 == 0;
    }

    public boolean isSquare(long number) {
        long squareRoot = (long) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }

    public boolean isSunny(long number) {
        return isSquare(number + 1);
    }

    public boolean isJumping(long number) {
        String numberString = String.valueOf(number);
        char[] digits = numberString.toCharArray();
        boolean isJumping = true;
        for (int i = 1; i < digits.length; i++) {
            if (Math.abs(digits[i] - digits[i - 1]) != 1) {
                isJumping = false;
                break;
            }
        }
        return isJumping;
    }

    public boolean isHappy(long number) {
        String numString = String.valueOf(number);
        int sum = 0;
        while (numString.length() != 1) {
            for (int i = 0; i < numString.length(); i++) {
                sum += Math.pow(Integer.parseInt(numString.substring(i, i + 1)), 2);
            }
            numString = String.valueOf(sum);
            sum = 0;
        }
        return "1".equals(numString) || "7".equals(numString);
    }
}
