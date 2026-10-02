import java.util.Scanner;

public class PalindromeChecker {
    // Ignore case, spaces and punctuation so phrases like "Never odd or even" work too
    static String normalize(String text) {
        return text.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // 1. Iterative: compare from both ends moving inward
    static boolean isPalindromeIterative(String text) {
        String s = normalize(text);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // 2. Recursive: compare first/last, then shrink the substring
    static boolean isPalindromeRecursive(String text) {
        return recurse(normalize(text));
    }
    private static boolean recurse(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return recurse(s.substring(1, s.length() - 1));
    }

    // 3. Array reversal: reverse a char array and compare with the original
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = normalize(text).toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return java.util.Arrays.equals(original, reversed);
    }

    static String label(boolean b) { return b ? "Palindrome" : "Not Palindrome"; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        boolean a = isPalindromeIterative(text);
        boolean b = isPalindromeRecursive(text);
        boolean c = isPalindromeArrayReversal(text);
        System.out.println("Iterative: " + label(a) + " | Recursive: " + label(b)
                + " | Array Reversal: " + label(c));
        System.out.println(a == b && b == c ? "All three approaches agree." : "MISMATCH — check logic!");
    }
}
