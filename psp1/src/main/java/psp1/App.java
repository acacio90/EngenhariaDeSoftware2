package psp1;

import java.io.*;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        Counter locCounter = new Counter();
        File file = new File("/home/acacio/Desktop/EngenhariaDeSoftware2/psp0/src/main/java/psp0");
        locCounter.countLOC(file);
        locCounter.printResults();
        System.out.println("Total Lines of Code per Method:");
        for (Map.Entry<String, Integer> entry : locCounter.getMethodLineCounts().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
