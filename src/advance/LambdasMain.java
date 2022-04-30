package udacity;

import java.util.List;
import java.util.function.Predicate;

public class LambdasMain {
    public static long countMatchingStrings(List<String> input, Predicate<String> condition) {
        return input.stream().filter(condition).count();
    };

    public static void main(String[] args) {
        List<String> input = List.of("hello", "\t ", "world", "", "\t", " ", "goodbye", " ");

        long oldNumberOfWhitesSpaceStrings = countMatchingStrings(
                        input,
                        new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.trim().isEmpty();
                            }
                        }
                );

        long numberOfWhitesSpaceStrings1 = countMatchingStrings(
                        input,
                        (String s) -> { return s.trim().isEmpty(); }
                );  // lambda expression

        long numberOfWhitesSpaceStrings = countMatchingStrings(
                        input,
                        s -> s.trim().isEmpty()
                );  // lambda expression

        System.out.println(oldNumberOfWhitesSpaceStrings + " whitespace strings");
        System.out.println(numberOfWhitesSpaceStrings + " whitespace strings");
    }
}
