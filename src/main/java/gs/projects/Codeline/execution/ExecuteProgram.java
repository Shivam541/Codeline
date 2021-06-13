package gs.projects.Codeline.execution;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExecuteProgram {

    public static void execute(PrintWriter out) {
        try {
            Runtime r;
            String javacPath = "C:\\Program Files\\Java\\jdk-12.0.1\\bin\\javac.exe ";
            String javaPath = "C:\\Program Files\\Java\\jdk-12.0.1\\bin\\java ";
            r = Runtime.getRuntime();
            Path pathToFile = Paths.get("userFiles\\abc.java").toAbsolutePath();
            Process p = r.exec(javacPath + pathToFile);
            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String result = "";
            while (true) {
                String temp = err.readLine();
                if (temp != null) {
                    result += temp;
                    result += "\n";
                } else break;
            }
            if (result.equals("")) {
                out.println("compilation successful \n");
            } else out.println(result);
            p = r.exec(javaPath + pathToFile);
            BufferedReader read = new BufferedReader(new InputStreamReader(p.getInputStream()));
            err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            result = "";
            String result1 = "";
            while (true) {
                String temp = read.readLine();
                if (temp != null) {
                    result1 += temp;
                    result1 += "\n";
                } else break;
            }
            while (true) {
                String temp = err.readLine();
                if (temp != null) {
                    result += temp;
                    result += "\n";
                } else break;
            }
            out.println(result1 + result);
        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace(System.out);
        }
    }

}
