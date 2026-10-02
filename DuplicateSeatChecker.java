public class DuplicateSeatChecker {
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip if this value already appeared earlier (so it is reported only once)
            boolean seenBefore = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[j] == seatNumbers[i]) { seenBefore = true; break; }
            }
            if (seenBefore) continue;
            // Check whether it appears again later in the array
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[j] == seatNumbers[i]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
