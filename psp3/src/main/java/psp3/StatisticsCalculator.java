package psp3;

import java.util.Arrays;

public class StatisticsCalculator {
    public static double calculateMean(double[] values) {
        return Arrays.stream(values).average().orElse(0.0);
    }

    public static double calculateVariance(double[] values, double mean) {
        double sumSquaredDiff = 0.0;
        for (double value : values) {
            double diff = value - mean;
            sumSquaredDiff += diff * diff;
        }
        return sumSquaredDiff / values.length;
    }
}

