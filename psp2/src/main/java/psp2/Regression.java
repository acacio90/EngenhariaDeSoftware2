package psp2;

public class Regression {
    private LinkedList dataPairs;
    private double beta0;
    private double beta1;
    private double correlationCoefficient;
    private double rSquared;

    public Regression(LinkedList dataPairs) {
        this.dataPairs = dataPairs;
        this.beta0 = 0.0;
        this.beta1 = 0.0;
        this.correlationCoefficient = 0.0;
        this.rSquared = 0.0;
    }

    public void calculateRegressionParameters() {
        int n = dataPairs.size();
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumX2 = 0.0;
        double sumY2 = 0.0;

        LinkedList.Node current = dataPairs.getHead();
        while (current != null) {
            DataPair pair = current.getData();
            double x = pair.getX();
            double y = pair.getY();

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;

            current = current.getNext();
        }

        double meanX = sumX / n;
        double meanY = sumY / n;

        double numerator = (n * sumXY) - (sumX * sumY);
        double denominatorX = (n * sumX2) - (sumX * sumX);
        double denominatorY = (n * sumY2) - (sumY * sumY);

        beta1 = numerator / denominatorX;
        beta0 = meanY - (beta1 * meanX);

        correlationCoefficient = numerator / Math.sqrt(denominatorX * denominatorY);
        rSquared = correlationCoefficient * correlationCoefficient;
    }

    public double makeImprovedPrediction(double xk) {
        return beta0 + (beta1 * xk);
    }

    public double getBeta0() {
        return beta0;
    }

    public double getBeta1() {
        return beta1;
    }

    public double getCorrelationCoefficient() {
        return correlationCoefficient;
    }

    public double getRSquared() {
        return rSquared;
    }
}
