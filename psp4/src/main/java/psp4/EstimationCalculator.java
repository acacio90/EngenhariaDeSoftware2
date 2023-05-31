package psp4;

public class EstimationCalculator {
    // Função para estimar o tempo de desenvolvimento com base nos coeficientes estimados
    public double estimateTime(double linesAdded, double linesReused, double linesModified) {
        double b0 = 6.7013365364;  // Coeficiente beta0
        double b1 = 0.0783660367;  // Coeficiente beta1
        double b2 = 0.0150413312;  // Coeficiente beta2
        double b3 = 0.2460563326;  // Coeficiente beta3
        
        // Estimativa do tempo de desenvolvimento usando a equação da regressão linear múltipla
        double estimatedTime = b0 + b1 * linesAdded + b2 * linesReused + b3 * linesModified;
        
        return estimatedTime;
    }
}
