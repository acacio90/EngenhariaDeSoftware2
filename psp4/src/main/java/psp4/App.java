package psp4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        EstimationCalculator estimationCalculator = new EstimationCalculator();
        // Exemplo de utilização da função de estimativa
        double linesAdded = 500;  // Número de linhas adicionadas
        double linesReused = 200;  // Número de linhas reutilizadas
        double linesModified = 100;  // Número de linhas modificadas
            
        double estimatedTime = estimationCalculator.estimateTime(linesAdded, linesReused, linesModified);
        System.out.println("Tempo estimado de desenvolvimento: " + estimatedTime + " horas");
    }
}
