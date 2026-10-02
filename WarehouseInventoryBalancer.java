public class WarehouseInventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Error: arrays must be non-empty and of equal length.");
            return;
        }
        int totalA = 0, totalB = 0;
        int maxVal = sectionA[0];
        String maxSection = "A";
        int maxIndex = 1; // 1-based item number

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
            if (sectionA[i] > maxVal) { maxVal = sectionA[i]; maxSection = "A"; maxIndex = i + 1; }
            if (sectionB[i] > maxVal) { maxVal = sectionB[i]; maxSection = "B"; maxIndex = i + 1; }
        }
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + maxVal
                + " (Section " + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
