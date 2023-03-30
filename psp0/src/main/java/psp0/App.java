package psp0;

public class App {
    public static void main(String[] args) {
        LinkedList horas = new LinkedList();
        LinkedList proxy = new LinkedList();

        horas.insert(160);
        horas.insert(591);
        horas.insert(114);
        horas.insert(229);
        horas.insert(230);
        horas.insert(270);
        horas.insert(128);
        horas.insert(1657);
        horas.insert(624);
        horas.insert(1503);

        proxy.insert(15.0);
        proxy.insert(69.9);
        proxy.insert(6.5);
        proxy.insert(22.4);
        proxy.insert(28.4);
        proxy.insert(65.9);
        proxy.insert(19.4);
        proxy.insert(198.7);
        proxy.insert(38.8);
        proxy.insert(138.2);

        horas.printList();
        proxy.printList();

        double media = Calculator.calcularMedia(horas);
        double desvioPadrao = Calculator.calcularDesvioPadrao(horas);

        System.out.println("Média: " + media);
        System.out.println("Desvio padrão amostral: " + desvioPadrao);

        media = Calculator.calcularMedia(proxy);
        desvioPadrao = Calculator.calcularDesvioPadrao(proxy);

        System.out.println("Média: " + media);
        System.out.println("Desvio padrão amostral: " + desvioPadrao);
    }
}
