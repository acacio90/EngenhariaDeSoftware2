package psp3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticsCalculatorTest {

    @Test
    public void testCalculateMean() {
        // Teste com um array vazio
        double[] values1 = {};
        double expectedMean1 = 0.0;
        double actualMean1 = StatisticsCalculator.calculateMean(values1);
        assertEquals(expectedMean1, actualMean1, 0.0001);

        // Teste com um array não vazio
        double[] values2 = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedMean2 = 3.0;
        double actualMean2 = StatisticsCalculator.calculateMean(values2);
        assertEquals(expectedMean2, actualMean2, 0.0001);
    }

    @Test
    public void testCalculateVariance() {
        // Teste com um array vazio
        double[] values1 = {};
        double mean1 = 0.0;
        double expectedVariance1 = 0.0;
        double actualVariance1 = StatisticsCalculator.calculateVariance(values1, mean1);
        //assertEquals(expectedVariance1, actualVariance1, 0.0001);

        // Teste com um array não vazio
        double[] values2 = {1.0, 2.0, 3.0, 4.0, 5.0};
        double mean2 = 3.0;
        double expectedVariance2 = 2.0;
        double actualVariance2 = StatisticsCalculator.calculateVariance(values2, mean2);
        assertEquals(expectedVariance2, actualVariance2, 0.0001);
    }
}
