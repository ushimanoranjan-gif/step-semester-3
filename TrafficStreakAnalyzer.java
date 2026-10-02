public class TrafficStreakAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Signal log is empty.");
            return;
        }
        char bestColor = signalLog.charAt(0);
        int bestLen = 1;
        int curLen = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > bestLen) {   // strictly greater: earliest streak wins ties
                bestLen = curLen;
                bestColor = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLen + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
