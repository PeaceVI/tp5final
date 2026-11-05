package library.util;

/**
 * Demo logic extracted from Book.complexMethodExample (Extract Class / Extract Method).
 * It had nothing to do with a book and was lowering Book's cohesion.
 */
public final class NumberClassifier {
    private NumberClassifier() { }

    /** Extracted method: one decision, one place. */
    public static String classify(int i) {
        if (i % 2 == 0) {
            return "is even";
        }
        if (i % 3 == 0) {
            return "divisible by 3";
        }
        return "something else";
    }

    public static void printSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + classify(i));
        }
    }
}
