package psp0;

public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2.5);
        list.insert(3);
        list.insert(4.2);
        list.insert(5);

        list.printList();

        double media = Calculator.calcularMedia(list);
        double desvioPadrao = Calculator.calcularDesvioPadrao(list);

        System.out.println("Média: " + media);
        System.out.println("Desvio padrão amostral: " + desvioPadrao);
    }
}
