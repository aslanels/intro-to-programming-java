package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Logic {
    private final List<String> history = new ArrayList<>();
    private static final Pattern INPUT_VALIDATION_PATTERN = Pattern.compile("^-?(0|[1-9]\\d*)[\\+x÷%-](0|[1-9]\\d*)$");

    public @NonNull String evaluate(@NonNull String input) {
         
        if (!Logic.INPUT_VALIDATION_PATTERN.matcher(input).matches()) {
            return "INVALID INPUT";
        }
        history.add("Input: " + input + System.lineSeparator());
        // TODO Task 1.1 - 1.5: Implement input handling and output calculation.
        long result = 0;
        if (input.contains("+")) {
            String[] nums = input.split("[+]");
            result = sum(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
        } else if (input.contains("-")) {
            String[] nums = input.split("[-]");
            result = sub(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
        } else if (input.contains("x")) {
            String[] nums = input.split("[x]");
            result = mul(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
        } else if (input.contains("÷")) {
            String[] nums = input.split("[÷]");
            if (nums[1].equals("0")) {
                throw new ArithmeticException();
            }
            result = div(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
        } else if (input.contains("%")) {
            String[] nums = input.split("[%]");
            if (nums[1].equals("0")) {
                throw new ArithmeticException();
            }
            result = modulo(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
        }
        history.add("Result: " + String.valueOf(result) + System.lineSeparator());
        return String.valueOf(result);
    }

    private @NonNull long sum(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber + secondNumber;
    }

    private @NonNull long sub(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber - secondNumber;
    }

    private @NonNull long mul(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber * secondNumber;
    }

    private @NonNull long div(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber / secondNumber;
    }

    private @NonNull long modulo(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber % secondNumber;
    }

    public @NonNull List<String> getHistory() {
        return List.copyOf(history);
    }

}
