package psp2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    @Test
    public void testProxySizeAndActualSize() {
        LinkedList dataPairs = new LinkedList();
        dataPairs.insert(new DataPair(130, 163));
        dataPairs.insert(new DataPair(650, 765));
        dataPairs.insert(new DataPair(99, 141));
        dataPairs.insert(new DataPair(150, 166));
        dataPairs.insert(new DataPair(128, 137));
        dataPairs.insert(new DataPair(302, 355));
        dataPairs.insert(new DataPair(95, 136));
        dataPairs.insert(new DataPair(945, 1206));
        dataPairs.insert(new DataPair(368, 433));
        dataPairs.insert(new DataPair(961, 1130));

        Regression regression = new Regression(dataPairs);
        regression.calculateRegressionParameters();

        double xk = 386;
        double predictedSize = regression.makeImprovedPrediction(xk);

        assertEquals(0.033, regression.getBeta0(), 0.001);
        assertEquals(1.184, regression.getBeta1(), 0.001);
        assertEquals(0.897, regression.getCorrelationCoefficient(), 0.001);
        assertEquals(0.804, regression.getRSquared(), 0.001);
        assertEquals(477.014, predictedSize, 0.001);
    }

    @Test
    public void testProxySizeAndDevelopmentTime() {
        LinkedList dataPairs = new LinkedList();
        dataPairs.insert(new DataPair(130, 186));
        dataPairs.insert(new DataPair(650, 699));
        dataPairs.insert(new DataPair(99, 132));
        dataPairs.insert(new DataPair(150, 272));
        dataPairs.insert(new DataPair(128, 291));
        dataPairs.insert(new DataPair(302, 331));
        dataPairs.insert(new DataPair(95, 199));
        dataPairs.insert(new DataPair(945, 1890));
        dataPairs.insert(new DataPair(368, 788));
        dataPairs.insert(new DataPair(961, 1601));

        Regression regression = new Regression(dataPairs);
        regression.calculateRegressionParameters();

        double xk = 386;
        double predictedTime = regression.makeImprovedPrediction(xk);

        assertEquals(0.304, regression.getBeta0(), 0.001);
        assertEquals(4.647, regression.getBeta1(), 0.001);
        assertEquals(0.894, regression.getCorrelationCoefficient(), 0.001);
        assertEquals(0.799, regression.getRSquared(), 0.001);
        assertEquals(1799.954, predictedTime, 0.001);
    }

    @Test
    public void testPlannedSizeAndActualSize() {
        LinkedList dataPairs = new LinkedList();
        dataPairs.insert(new DataPair(163, 186));
        dataPairs.insert(new DataPair(765, 699));
        dataPairs.insert(new DataPair(141, 132));
        dataPairs.insert(new DataPair(166, 272));
        dataPairs.insert(new DataPair(137, 291));
        dataPairs.insert(new DataPair(355, 331));
        dataPairs.insert(new DataPair(136, 199));
        dataPairs.insert(new DataPair(1206, 1890));
        dataPairs.insert(new DataPair(433, 788));
        dataPairs.insert(new DataPair(1130, 1601));

        Regression regression = new Regression(dataPairs);
        regression.calculateRegressionParameters();

        double xk = 386;
        double predictedSize = regression.makeImprovedPrediction(xk);

        assertEquals(-9.719, regression.getBeta0(), 0.001);
        assertEquals(1.201, regression.getBeta1(), 0.001);
        assertEquals(0.932, regression.getCorrelationCoefficient(), 0.001);
        assertEquals(0.869, regression.getRSquared(), 0.001);
        assertEquals(468.113, predictedSize, 0.001);
    }

    @Test
    public void testPlannedSizeAndDevelopmentTime() {
        LinkedList dataPairs = new LinkedList();
        dataPairs.insert(new DataPair(163, 15.0));
        dataPairs.insert(new DataPair(765, 69.9));
        dataPairs.insert(new DataPair(141, 6.5));
        dataPairs.insert(new DataPair(166, 22.4));
        dataPairs.insert(new DataPair(137, 28.4));
        dataPairs.insert(new DataPair(355, 65.9));
        dataPairs.insert(new DataPair(136, 19.4));
        dataPairs.insert(new DataPair(1206, 198.7));
        dataPairs.insert(new DataPair(433, 38.8));
        dataPairs.insert(new DataPair(1130, 138.2));

        Regression regression = new Regression(dataPairs);
        regression.calculateRegressionParameters();

        double xk = 386;
        double predictedTime = regression.makeImprovedPrediction(xk);

        assertEquals(-5.310, regression.getBeta0(), 0.001);
        assertEquals(0.221, regression.getBeta1(), 0.001);
        assertEquals(0.673, regression.getCorrelationCoefficient(), 0.001);
        assertEquals(0.453, regression.getRSquared(), 0.001);
        assertEquals(79.620, predictedTime, 0.001);
    }
}
