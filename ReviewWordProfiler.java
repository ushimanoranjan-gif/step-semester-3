public class ReviewWordProfiler {
    static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;
        String[] words = review.trim().split("\\s+");
        for (String w : words) {
            String clean = w.replaceAll("[^A-Za-z]", ""); // count letters only
            int len = clean.length();
            if (len == 0) continue;
            if (len <= 4) shortCount++;
            else if (len <= 8) mediumCount++;
            else longCount++;
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
