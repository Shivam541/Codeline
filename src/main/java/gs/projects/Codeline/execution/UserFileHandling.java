package gs.projects.Codeline.execution;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.ServletInputStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandling {

    public static void initFile(ServletInputStream inputStream) {
        try {
            System.out.println(Paths.get(".").toAbsolutePath());
            Path relativePath = Paths.get("userFiles");
            if(Files.notExists(relativePath)) Files.createDirectory(relativePath);
            Path newFilePath=Paths.get("userFiles/abc.java");
            if(Files.notExists(newFilePath)) {
                Files.createFile(newFilePath);
            }
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            List<String> data=new ArrayList<>();
            String s;
            while ((s=br.readLine())!=null){
                data.add(s);
            }
            Files.write(newFilePath,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}