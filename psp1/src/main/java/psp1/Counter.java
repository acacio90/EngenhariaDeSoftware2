package psp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Counter {

    private int totalLines = 0;
    private int classCount = 0;
    private int methodCount = 0;
    private int classLines = 0;
    private int methodLines = 0;
    private String currentMethod = null;
    private Map<String, Integer> methodLineCounts = new HashMap<>();

    public int getTotalLines() {
        return totalLines;
    }

    public int getClassCount() {
        return classCount;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public int getClassLines() {
        return classLines;
    }

    public int getMethodLines() {
        return methodLines;
    }

    public Map<String, Integer> getMethodLineCounts() {
        return methodLineCounts;
    }

    public void countLOC(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                countLOC(f);
            }
        } else if (file.isFile() && file.getName().endsWith(".java")) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("/*") && !line.startsWith("*")) {
                    totalLines++;

                    if (line.startsWith("public class")) {
                        classCount++;
                        if (methodLines > 0) {
                            classLines += methodLines;
                            methodLines = 0;
                        }
                        classLines++;
                    } else if (line.contains("(") && line.contains(")") && line.contains("{")
                            && !line.contains("if") && !line.contains("else") && !line.contains("for")
                            && !line.contains("while")) {
                        methodCount++;
                        methodLines++;
                        if (currentMethod != null) {
                            methodLineCounts.put(currentMethod, methodLineCounts.getOrDefault(currentMethod, 0) + 1);
                        }
                        String methodName = line.substring(0, line.indexOf('(')).trim();
                        currentMethod = methodName;
                    } else {
                        if (currentMethod != null) {
                            methodLineCounts.put(currentMethod, methodLineCounts.getOrDefault(currentMethod, 0) + 1);
                        }
                        classLines++;
                    }
                }
            }

            if (methodLines > 0) {
                classLines += methodLines;
                methodLines = 0;
            }

            br.close();
        }
    }

    public void printResults() {
        System.out.println("Total Lines: " + totalLines);
        System.out.println("Total Classes: " + classCount);
        System.out.println("Total Methods: " + methodCount);
        System.out.println("Total Lines of Class Code: " + classLines);
        System.out.println("Total Lines of Method Code: " + methodLines);
        System.out.println("Total Lines of Code per Method:");
        for (String methodName : methodLineCounts.keySet()) {
            int lineCount = methodLineCounts.get(methodName);
            System.out.println(methodName + ": " + lineCount);
        }
    }

    public void printMethodLines() {
        System.out.println("Method Lines:");
        for (String method : methodLineCounts.keySet()) {
            String methodName = method.substring(method.lastIndexOf(".") + 1);
            int lineCount = methodLineCounts.get(method);
            System.out.println(methodName + ": " + lineCount);
        }
    }

}
