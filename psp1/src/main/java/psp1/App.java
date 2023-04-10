package psp1;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        Counter locCounter = new Counter();
        File file = new File("/home/acacio/Desktop/EngenhariaDeSoftware2/psp0/src/main/java/psp0/App.java");
        locCounter.countLOC(file);
        locCounter.printResults();
    }
}
