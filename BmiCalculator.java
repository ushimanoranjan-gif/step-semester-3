import java.util.Random;

public class BmiCalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-8s | %-10s | %-11s | %-6s | %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d | %-10.2f | %-11.1f | %-6.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        int team = 10;
        double[] heights = new double[team];
        double[] weights = new double[team];
        Random rand = new Random();
        for (int i = 0; i < team; i++) {
            heights[i] = Math.round((1.50 + rand.nextDouble() * 0.45) * 100) / 100.0; // 1.50–1.95 m
            weights[i] = Math.round((45 + rand.nextDouble() * 65) * 10) / 10.0;       // 45–110 kg
        }
        printWellnessReport(heights, weights);
    }
}
