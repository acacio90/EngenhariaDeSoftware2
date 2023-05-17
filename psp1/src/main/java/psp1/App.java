package psp1;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        Counter locCounter = new Counter();
        File file = new File("/home/acacio/Desktop/EngenhariaDeSoftware2/psp1/src/main/java/psp1");
        locCounter.countLOC(file);
        locCounter.printResults();
        System.out.println("Total Lines of Code per Method:");
        for (Map.Entry<String, Integer> entry : locCounter.getMethodLineCounts().entrySet()) {
            String methodName = entry.getKey();
            int lineCount = entry.getValue();
            System.out.println(methodName + ": " + lineCount);
        }
    }
}
