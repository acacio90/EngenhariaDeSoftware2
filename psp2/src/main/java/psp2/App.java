package psp2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        LinkedList dataPairs = new LinkedList();
        dataPairs.insert(new DataPair(10, 5));
        dataPairs.insert(new DataPair(20, 10));
        dataPairs.insert(new DataPair(30, 15));

        Regression regression = new Regression(dataPairs);
        regression.calculateRegressionParameters();

        double xk = 25;
        double yk = regression.makeImprovedPrediction(xk);
        System.out.println("Improved Prediction for xk = " + xk + ": " + yk);
    }
}

