package net.htlgkr.hove.pos3.hausuebung4;

import java.util.List;

public class JavaStreamsTester {

    public static void main(String[] args) {

    }


    private static int getCountEmptyStringTester(List<String> strings) {
        return strings.stream().filter(number -> number.equals("")).toList().size();
    }

    private static int getCountLength3(List<String> strings) {
        return strings.stream().filter(number -> number.length() == 3).toList().size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return strings.stream().filter(m -> !m.equals("")).toList();
    }

    private static String getMergedString(List<String> strings, String seperator) {
        return strings.stream().reduce("", (a, b) -> a + seperator + b);
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream().map(m -> (int) m * m).toList();
    }

    private static int getMax(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers.get(numbers.size() - 1);
    }

    private static int getMin(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers.get(0);
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) numbers.stream().mapToDouble(m -> m).average().getAsDouble();
    }
}
