package psp1; 

import java.io.*;

public class Counter {

    private int totalLines = 0;
    private int classCount = 0;
    private int methodCount = 0;
    private int classLines = 0;
    private int methodLines = 0;

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

                    if (line.startsWith("class")) {
                        classCount++;
                        if (methodLines > 0) {
                            classLines += methodLines;
                            methodLines = 0;
                        }
                        classLines++;
                    } else if (line.startsWith("public") || line.startsWith("private") || line.startsWith("protected")) {
                        methodCount++;
                        methodLines++;
                    } else {
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
    }
}
