package templates.exceptions;

/**
 * TEMPLATE: try / catch / finally, multiple catches, throws, throw,
 * custom exceptions, the call stack, and assertions.
 */
public class ExceptionTemplate {

    // throws = this method may pass the exception on to its caller
    public static int parsePositive(String text) throws InvalidInputException {
        int value;
        try {
            value = Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("'" + text + "' is not a whole number");
        }
        if (value <= 0) {
            throw new InvalidInputException("Value must be greater than 0");   // throw = raise now
        }
        return value;
    }

    // Unchecked exception raised by our own check
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // Call-stack demo: the exception travels level3 -> level2 -> main
    static void level3() {
        int[] small = new int[2];
        small[5] = 1;                           // ArrayIndexOutOfBoundsException
    }

    static void level2() {
        level3();
    }

    public static void main(String[] args) {
        // 1. Basic try / catch / finally
        try {
            int tickets = Integer.parseInt("abc");
            System.out.println(tickets);
        } catch (NumberFormatException e) {
            System.out.println("Not a number: " + e.getMessage());
        } finally {
            System.out.println("finally always runs");
        }

        // 2. Several catches: specific first, general Exception last
        String[] inputs = {"5", "abc", "-2"};
        for (String input : inputs) {
            try {
                System.out.println("Valid: " + parsePositive(input));
            } catch (InvalidInputException e) {
                System.out.println("Invalid: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected: " + e.getMessage());
            }
        }

        // 3. Unchecked exception from our own throw
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // 4. Tracing through the call stack (top line = where it happened)
        try {
            level2();
        } catch (ArrayIndexOutOfBoundsException e) {
            for (StackTraceElement step : e.getStackTrace()) {
                System.out.println("  at " + step.getMethodName());
            }
        }

        // 5. Assertion - only checked when run with the -ea VM option
        int total = 5;
        assert total > 0 : "Total must be positive";
        System.out.println("Done");
    }
}
