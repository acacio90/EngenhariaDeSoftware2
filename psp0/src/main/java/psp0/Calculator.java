package psp0;

public class Calculator {
    public static double calcularMedia(LinkedList list) {
        double soma = 0;
        int contador = 0;
        LinkedList.Node current = list.getHead();
        while (current != null) {
            if (current.getData() instanceof Integer) {
                soma += (int) current.getData();
                contador++;
            } else if (current.getData() instanceof Double) {
                soma += (double) current.getData();
                contador++;
            }
            current = current.getNext();
        }
        return soma / contador;
    }

    public static double calcularDesvioPadrao(LinkedList list) {
        double media = calcularMedia(list);
        double soma = 0;
        int contador = 0;
        LinkedList.Node current = list.getHead();
        while (current != null) {
            if (current.getData() instanceof Integer) {
                soma += Math.pow((int) current.getData() - media, 2);
                contador++;
            } else if (current.getData() instanceof Double) {
                soma += Math.pow((double) current.getData() - media, 2);
                contador++;
            }
            current = current.getNext();
        }
        double variancia = soma / (contador - 1);
        return Math.sqrt(variancia);
    }
}
