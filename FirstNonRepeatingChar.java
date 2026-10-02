import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {
    // Returns the first character with frequency 1, or '\0' if none exists
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {      // left-to-right scan, early exit
            if (freq.get(c) == 1) return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') System.out.println("No Non-Repeating Character Found");
        else System.out.println("First Non-Repeating Character: '" + result + "'");
    }
}
