public class TypingAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: strings must be of equal length.");
            return;
        }
        int total = original.length();
        if (total == 0) {
            System.out.println("Error: passage is empty.");
            return;
        }
        int matched = 0;
        int firstMismatch = -1; // 1-based position
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
            }
        }
        double accuracy = (matched * 100.0) / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, total, accuracy);
        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " + firstMismatch
                    + " ('" + original.charAt(firstMismatch - 1) + "' vs '"
                    + typed.charAt(firstMismatch - 1) + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
